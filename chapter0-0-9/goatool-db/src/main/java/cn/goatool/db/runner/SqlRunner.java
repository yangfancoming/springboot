
package cn.goatool.db.runner;

import cn.goatool.core.io.Resources;
import cn.goatool.db.type.Null;
import cn.goatool.db.type.TypeHandler;
import cn.goatool.db.type.TypeHandlerRegistry;


import java.sql.*;
import java.util.*;


public class SqlRunner {

  public static final int NO_GENERATED_KEY = Integer.MIN_VALUE + 1001;

  private final Connection connection;
  private final TypeHandlerRegistry typeHandlerRegistry;
  private boolean useGeneratedKeySupport;

  public SqlRunner(Connection connection) {
    this.connection = connection;
    this.typeHandlerRegistry = new TypeHandlerRegistry();
  }

  public void setUseGeneratedKeySupport(boolean useGeneratedKeySupport) {
    this.useGeneratedKeySupport = useGeneratedKeySupport;
  }

  /**
   * Executes a SELECT statement that returns one row.
   * @param sql  The SQL
   * @param args The arguments to be set on the statement.
   * @return The row expected.
   * @throws SQLException If less or more than one row is returned
   * 执行SELECT语句， SQL语句中可以使用占位符， 如果SQL中包含占位符， 则可变参数用于为参数占位符赋值，
   *  该方法只 返回一条记录。 若查询结果行数不等于一， 则会抛出SQLException异常
   */
  public Map<String, Object> selectOne(String sql, Object... args) throws SQLException {
    List<Map<String, Object>> results = selectAll(sql, args);
    if (results.size() != 1) {
      throw new SQLException("Statement returned " + results.size() + " results where exactly one (1) was expected.");
    }
    return results.get(0);
  }

  /**
   * Executes a SELECT statement that returns multiple rows.
   * @param sql  The SQL
   * @param args The arguments to be set on the statement.
   * @return The list of rows expected.
   * @throws SQLException If statement preparation or execution fails
   * 该方法和selectOne()方法的作用相同， 只不过该方法可以返回多条记录， 方法返回值是一个List对象，
   * List中包含多个Map对象， 每个Map对象对应数据库中的一行记录。
   */
  public List<Map<String, Object>> selectAll(String sql, Object... args) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(sql);
    try {
        // 1.为SQL中的参数占位符赋值
      setParameters(ps, args);
      // 2.执行查询操作
      ResultSet rs = ps.executeQuery();
      // 3.将查询结果转换为List
      return getResults(rs);
    } finally {
      try {
        ps.close();
      } catch (SQLException e) {
        //ignore
      }
    }
  }

  /**
   * Executes an INSERT statement.
   * @param sql  The SQL
   * @param args The arguments to be set on the statement.
   * @return The number of rows impacted or BATCHED_RESULTS if the statements are being batched.
   * @throws SQLException If statement preparation or execution fails
   */
  public int insert(String sql, Object... args) throws SQLException {
    PreparedStatement ps;
    if (useGeneratedKeySupport) {
      ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    } else {
      ps = connection.prepareStatement(sql);
    }

    try {
      setParameters(ps, args);
      ps.executeUpdate();
      if (useGeneratedKeySupport) {
        List<Map<String, Object>> keys = getResults(ps.getGeneratedKeys());
        if (keys.size() == 1) {
          Map<String, Object> key = keys.get(0);
          Iterator<Object> i = key.values().iterator();
          if (i.hasNext()) {
            Object genkey = i.next();
            if (genkey != null) {
              try {
                return Integer.parseInt(genkey.toString());
              } catch (NumberFormatException e) {
                //ignore, no numeric key support
              }
            }
          }
        }
      }
      return NO_GENERATED_KEY;
    } finally {
      try {
        ps.close();
      } catch (SQLException e) {
        //ignore
      }
    }
  }

  /**
   * Executes an UPDATE statement.
   * @param sql  The SQL
   * @param args The arguments to be set on the statement.
   * @return The number of rows impacted or BATCHED_RESULTS if the statements are being batched.
   * @throws SQLException If statement preparation or execution fails
   */
  public int update(String sql, Object... args) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(sql);
    try {
      setParameters(ps, args);
      return ps.executeUpdate();
    } finally {
      try {
        ps.close();
      } catch (SQLException e) {
        //ignore
      }
    }
  }

  /**
   * Executes a DELETE statement.
   * @param sql  The SQL
   * @param args The arguments to be set on the statement.
   * @return The number of rows impacted or BATCHED_RESULTS if the statements are being batched.
   * @throws SQLException If statement preparation or execution fails
   */
  public int delete(String sql, Object... args) throws SQLException {
    return update(sql, args);
  }

  /**
   * Executes any string as a JDBC Statement. Good for DDL
   * 执行任意一条SQL语句， 最好为DDL语句
   * @param sql The SQL
   * @throws SQLException If statement preparation or execution fails
   */
  public void run(String sql) throws SQLException {
    Statement stmt = connection.createStatement();
    try {
      stmt.execute(sql);
    } finally {
      try {
        stmt.close();
      } catch (SQLException e) {
        //ignore
      }
    }
  }
  //  用于关闭Connection对象
  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      //ignore
    }
  }

  private void setParameters(PreparedStatement ps, Object... args) throws SQLException {
    for (int i = 0, n = args.length; i < n; i++) {
      if (args[i] == null) {
        throw new SQLException("SqlRunner requires an instance of Null to represent typed null values for JDBC compatibility");
      } else if (args[i] instanceof Null) {
        ((Null) args[i]).getTypeHandler().setParameter(ps, i + 1, null, ((Null) args[i]).getJdbcType());
      } else {
          // 根据参数类型获取对应的 TypeHandler
        TypeHandler typeHandler = typeHandlerRegistry.getTypeHandler(args[i].getClass());
        if (typeHandler == null) {
          throw new SQLException("SqlRunner could not find a TypeHandler instance for " + args[i].getClass());
        } else {
            // 调用 typeHandler 的 setParameter 方法为参数占位符赋值
          typeHandler.setParameter(ps, i + 1, args[i], null);
        }
      }
    }
  }

  private List<Map<String, Object>> getResults(ResultSet rs) throws SQLException {
    try {
      List<Map<String, Object>> list = new ArrayList<>();
      List<String> columns = new ArrayList<>();
      List<TypeHandler<?>> typeHandlers = new ArrayList<>();
      // 1.获取 ResultSetMetaData 对应，再通过 ResultSetMetaData对象获取所有列名
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 0, n = rsmd.getColumnCount(); i < n; i++) {
        columns.add(rsmd.getColumnLabel(i + 1));
        try {
            // 2.获取列的JDBC类型，根据类型获取 TypeHandler 对象
          Class<?> type = Resources.classForName(rsmd.getColumnClassName(i + 1));
          TypeHandler<?> typeHandler = typeHandlerRegistry.getTypeHandler(type);
          if (typeHandler == null) {
            typeHandler = typeHandlerRegistry.getTypeHandler(Object.class);
          }
          typeHandlers.add(typeHandler);
        } catch (Exception e) {
          typeHandlers.add(typeHandlerRegistry.getTypeHandler(Object.class));
        }
      }
      // 3.遍历 ResultSet 对象，将其中的记录行转换为Map对象
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        for (int i = 0, n = columns.size(); i < n; i++) {
          String name = columns.get(i);
          TypeHandler<?> handler = typeHandlers.get(i);
          // 通过 TypeHandler 对象的 getResult 方法将JDBC类型转化为 Java类型
          row.put(name.toUpperCase(Locale.ENGLISH), handler.getResult(rs, name));
        }
        list.add(row);
      }
      return list;
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (Exception e) {
          // ignore
        }
      }
    }
  }

}
