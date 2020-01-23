package cn.goatool.db.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/2---18:39
 */
public class SQLStatement extends BaseSQL {

    StatementType statementType;
    List<String> sets = new ArrayList<>();
    List<String> select = new ArrayList<>();
    List<String> tables = new ArrayList<>();
    List<String> join = new ArrayList<>();
    List<String> innerJoin = new ArrayList<>();
    List<String> outerJoin = new ArrayList<>();
    List<String> leftOuterJoin = new ArrayList<>();
    List<String> rightOuterJoin = new ArrayList<>();
    List<String> where = new ArrayList<>();
    List<String> having = new ArrayList<>();
    List<String> groupBy = new ArrayList<>();
    List<String> orderBy = new ArrayList<>();
    List<String> lastList = new ArrayList<>();
    List<String> columns = new ArrayList<>();
    List<List<String>> valuesList = new ArrayList<>();
    // 是否包含 distinct 关键字
    boolean distinct;
    String offset;
    String limit;
    LimitingRowsStrategy limitingRowsStrategy = LimitingRowsStrategy.NOP;

    public SQLStatement() {
        // Prevent Synthetic Access
        valuesList.add(new ArrayList<>());
    }

    /**
     * @Description: SQL 语句拼接
     * @author fan.yang
     * @date 2020年1月2日18:54:42
     * @param builder  SQL 字符串构建对象
     * @param keyword  SQL 关键字
     * @param parts     SQL关键字 子句内容
     * @param open      SQL关键字后开始字符
     * @param close     SQL关键字后结束字符
     * @param conjunction 连接关键字，通常为 AND/OR
     * @return
     */
    private void sqlClause(SafeAppendable builder, String keyword, List<String> parts, String open, String close, String conjunction) {

        if (!parts.isEmpty()) {
            if (!builder.isEmpty()) {
                builder.append("\n");
            }
            // 拼接SQL关键字
            builder.append(keyword);
            builder.append(" ");
            // 拼接关键字后 开始字符
            builder.append(open);
            String last = "________";
            for (int i = 0, n = parts.size(); i < n; i++) {
                String part = parts.get(i);
                // 如果SQL关键字对应的子句不为AND/OR 则追加连接关键字
                if (i > 0 && !part.equals(AND) && !part.equals(OR) && !last.equals(AND) && !last.equals(OR)) {
                    builder.append(conjunction);
                }
                // 追加子句内容
                builder.append(part);
                last = part;
            }
            // 追加关键字后结束字符
            builder.append(close);
        }
    }

    private String selectSQL(SafeAppendable builder) {
        if (distinct) {
            sqlClause(builder, "SELECT DISTINCT", select, "", "", ", ");
        } else {
            sqlClause(builder, "SELECT", select, "", "", ", ");
        }

        sqlClause(builder, "FROM", tables, "", "", ", ");
        joins(builder);
        sqlClause(builder, "WHERE", where, "(", ")", " AND ");
        sqlClause(builder, "GROUP BY", groupBy, "", "", ", ");
        sqlClause(builder, "HAVING", having, "(", ")", " AND ");
        sqlClause(builder, "ORDER BY", orderBy, "", "", ", ");
        limitingRowsStrategy.appendClause(builder, offset, limit);
        return builder.toString();
    }

    private void joins(SafeAppendable builder) {
        sqlClause(builder, "JOIN", join, "", "", "\nJOIN ");
        sqlClause(builder, "INNER JOIN", innerJoin, "", "", "\nINNER JOIN ");
        sqlClause(builder, "OUTER JOIN", outerJoin, "", "", "\nOUTER JOIN ");
        sqlClause(builder, "LEFT OUTER JOIN", leftOuterJoin, "", "", "\nLEFT OUTER JOIN ");
        sqlClause(builder, "RIGHT OUTER JOIN", rightOuterJoin, "", "", "\nRIGHT OUTER JOIN ");
    }

    private String insertSQL(SafeAppendable builder) {
        sqlClause(builder, "INSERT INTO", tables, "", "", "");
        sqlClause(builder, "", columns, "(", ")", ", ");
        for (int i = 0; i < valuesList.size(); i++) {
            sqlClause(builder, i > 0 ? "," : "VALUES", valuesList.get(i), "(", ")", ", ");
        }
        return builder.toString();
    }

    private String deleteSQL(SafeAppendable builder) {
        sqlClause(builder, "DELETE FROM", tables, "", "", "");
        sqlClause(builder, "WHERE", where, "(", ")", " AND ");
        limitingRowsStrategy.appendClause(builder, null, limit);
        return builder.toString();
    }

    private String updateSQL(SafeAppendable builder) {
        sqlClause(builder, "UPDATE", tables, "", "", "");
        joins(builder);
        sqlClause(builder, "SET", sets, "", "", ", ");
        sqlClause(builder, "WHERE", where, "(", ")", " AND ");
        limitingRowsStrategy.appendClause(builder, null, limit);
        return builder.toString();
    }

    public String sql(Appendable a) {
        SafeAppendable builder = new SafeAppendable(a);
        if (statementType == null) {
            return null;
        }

        String answer;

        switch (statementType) {
            case DELETE:
                answer = deleteSQL(builder);
                break;
            case INSERT:
                answer = insertSQL(builder);
                break;
            case SELECT:
                answer = selectSQL(builder);
                break;
            case UPDATE:
                answer = updateSQL(builder);
                break;
            default:
                answer = null;
        }
        return answer;
    }
    
}
