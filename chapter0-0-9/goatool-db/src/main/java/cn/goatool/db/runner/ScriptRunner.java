
package cn.goatool.db.runner;


import cn.goatool.core.exception.RuntimeSqlException;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提供了用于控制执行SQL脚本的一些行为
 *
*/
public class ScriptRunner {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

  private static final String DEFAULT_DELIMITER = ";";

  private static final Pattern DELIMITER_PATTERN = Pattern.compile("^\\s*((--)|(//))?\\s*(//)?\\s*@DELIMITER\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE);

  private final Connection connection;

  // SQL 异常是否中断程序执行
  private boolean stopOnError;
  // 是否抛出 SQLWarning 警告
  private boolean throwWarning;
  // 是否自动提交
  private boolean autoCommit;
  // true 批量执行文件中的sql语句 false 逐条执行，默认情况下 SQL语句以分号为分割
  private boolean sendFullScript;
  // 是否去除 windows 系统换行符中的  \r
  private boolean removeCRs;
  // 设置 Statement 属性会否支持转义处理
  private boolean escapeProcessing = true;

  // 日志输出位置，默认控制台
  private PrintWriter logWriter = new PrintWriter(System.out);
    // 错误日志输出位置，默认控制台
  private PrintWriter errorLogWriter = new PrintWriter(System.err);

  // 脚本文件中  SQL语句的分隔符，默认为 ;
  private String delimiter = DEFAULT_DELIMITER;
  // 是否支持SQL语句分割符，单独占一行
  private boolean fullLineDelimiter;

  public ScriptRunner(Connection connection) {
    this.connection = connection;
  }

  public void setStopOnError(boolean stopOnError) {
    this.stopOnError = stopOnError;
  }

  public void setThrowWarning(boolean throwWarning) {
    this.throwWarning = throwWarning;
  }

  public void setAutoCommit(boolean autoCommit) {
    this.autoCommit = autoCommit;
  }

  public void setSendFullScript(boolean sendFullScript) {
    this.sendFullScript = sendFullScript;
  }

  public void setRemoveCRs(boolean removeCRs) {
    this.removeCRs = removeCRs;
  }

  public void setEscapeProcessing(boolean escapeProcessing) {
    this.escapeProcessing = escapeProcessing;
  }

  public void setLogWriter(PrintWriter logWriter) {
    this.logWriter = logWriter;
  }

  public void setErrorLogWriter(PrintWriter errorLogWriter) {
    this.errorLogWriter = errorLogWriter;
  }

  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  public void setFullLineDelimiter(boolean fullLineDelimiter) {
    this.fullLineDelimiter = fullLineDelimiter;
  }


  public void runScript(Reader reader) {
      // 设置事务是否自动提交
    setAutoCommit();

    try {
      if (sendFullScript) {
          // 一次性 执行脚本文件中的所有SQL语句
        executeFullScript(reader);
      } else {
          // 逐条 执行脚本文件中的所有SQL语句
        executeLineByLine(reader);
      }
    } finally {
      rollbackConnection();
    }
  }

  private void executeFullScript(Reader reader) {
    StringBuilder script = new StringBuilder();
    try {
      BufferedReader lineReader = new BufferedReader(reader);
      String line;
      while ((line = lineReader.readLine()) != null) {
        script.append(line);
        script.append(LINE_SEPARATOR);
      }
      String command = script.toString();
      println(command);
      executeStatement(command);
      commitConnection();
    } catch (Exception e) {
      String message = "Error executing: " + script + ".  Cause: " + e;
      printlnError(message);
      throw new RuntimeSqlException(message, e);
    }
  }

  private void executeLineByLine(Reader reader) {
    StringBuilder command = new StringBuilder();
    try {
      BufferedReader lineReader = new BufferedReader(reader);
      String line;
      while ((line = lineReader.readLine()) != null) {
          //逐行读取  处理每行内容
        handleLine(command, line);
      }
      commitConnection();
      checkForMissingLineTerminator(command);
    } catch (Exception e) {
      String message = "Error executing: " + command + ".  Cause: " + e;
      printlnError(message);
      throw new RuntimeSqlException(message, e);
    }
  }

  public void closeConnection() {
    try {
      connection.close();
    } catch (Exception e) {
      // ignore
    }
  }

  //设置 自动是否自动提交
  private void setAutoCommit() {
    try {
        // 自由当我们设置的是否自动提交 与 当前数据库不相同时 才设置，如果是一致的 就不必设置！
      if (autoCommit != connection.getAutoCommit()) {
        connection.setAutoCommit(autoCommit);
      }
    } catch (Throwable t) {
      throw new RuntimeSqlException("Could not set AutoCommit to " + autoCommit + ". Cause: " + t, t);
    }
  }

  private void commitConnection() {
    try {
      if (!connection.getAutoCommit()) {
        connection.commit();
      }
    } catch (Throwable t) {
      throw new RuntimeSqlException("Could not commit transaction. Cause: " + t, t);
    }
  }

  private void rollbackConnection() {
    try {
      if (!connection.getAutoCommit()) {
        connection.rollback();
      }
    } catch (Throwable t) {
      // ignore
    }
  }

  private void checkForMissingLineTerminator(StringBuilder command) {
    if (command != null && command.toString().trim().length() > 0) {
      throw new RuntimeSqlException("Line missing end-of-line terminator (" + delimiter + ") => " + command);
    }
  }

  private void handleLine(StringBuilder command, String line) throws SQLException {
    String trimmedLine = line.trim();
    // 1.判断该行是否是SQL注释
    if (lineIsComment(trimmedLine)) {

      Matcher matcher = DELIMITER_PATTERN.matcher(trimmedLine);
      if (matcher.find()) {
        delimiter = matcher.group(5);
      }
      println(trimmedLine);
        // 2.判断该行是否包含分号
    } else if (commandReadyToExecute(trimmedLine)) {
        // 获取该行中分号之前的内容
      command.append(line, 0, line.lastIndexOf(delimiter));
      command.append(LINE_SEPARATOR);
      println(command);
      // 执行该条完整的SQL语句
      executeStatement(command.toString());
      command.setLength(0);
      // 4.该行中不包含分号，说明这条SQL语句为结束，追加本行内容到之前读取的内容中
    } else if (trimmedLine.length() > 0) {
      command.append(line);
      command.append(LINE_SEPARATOR);
    }
  }

  private boolean lineIsComment(String trimmedLine) {
    return trimmedLine.startsWith("//") || trimmedLine.startsWith("--");
  }

  private boolean commandReadyToExecute(String trimmedLine) {
    // issue #561 remove anything after the delimiter
    return !fullLineDelimiter && trimmedLine.contains(delimiter) || fullLineDelimiter && trimmedLine.equals(delimiter);
  }

  private void executeStatement(String command) throws SQLException {
    Statement statement = connection.createStatement();
    try {
      statement.setEscapeProcessing(escapeProcessing);
      String sql = command;
      if (removeCRs) {
        sql = sql.replaceAll("\r\n", "\n");
      }
      try {
        boolean hasResults = statement.execute(sql);
        while (!(!hasResults && statement.getUpdateCount() == -1)) {
          checkWarnings(statement);
          printResults(statement, hasResults);
          hasResults = statement.getMoreResults();
        }
      } catch (SQLWarning e) {
        throw e;
      } catch (SQLException e) {
        if (stopOnError) {
          throw e;
        } else {
          String message = "Error executing: " + command + ".  Cause: " + e;
          printlnError(message);
        }
      }
    } finally {
      try {
        statement.close();
      } catch (Exception e) {
        // Ignore to workaround a bug in some connection pools
        // (Does anyone know the details of the bug?)
      }
    }
  }

  private void checkWarnings(Statement statement) throws SQLException {
    if (!throwWarning) {
      return;
    }
    // In Oracle, CREATE PROCEDURE, FUNCTION, etc. returns warning
    // instead of throwing exception if there is compilation error.
    SQLWarning warning = statement.getWarnings();
    if (warning != null) {
      throw warning;
    }
  }

  private void printResults(Statement statement, boolean hasResults) {
    if (!hasResults) {
      return;
    }
    try (ResultSet rs = statement.getResultSet()) {
      ResultSetMetaData md = rs.getMetaData();
      int cols = md.getColumnCount();
      for (int i = 0; i < cols; i++) {
        String name = md.getColumnLabel(i + 1);
        print(name + "\t");
      }
      println("");
      while (rs.next()) {
        for (int i = 0; i < cols; i++) {
          String value = rs.getString(i + 1);
          print(value + "\t");
        }
        println("");
      }
    } catch (SQLException e) {
      printlnError("Error printing results: " + e.getMessage());
    }
  }

  private void print(Object o) {
    if (logWriter != null) {
      logWriter.print(o);
      logWriter.flush();
    }
  }

  private void println(Object o) {
    if (logWriter != null) {
      logWriter.println(o);
      logWriter.flush();
    }
  }

  private void printlnError(Object o) {
    if (errorLogWriter != null) {
      errorLogWriter.println(o);
      errorLogWriter.flush();
    }
  }

}
