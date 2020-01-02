package cn.goatool.db;

import cn.goatool.db.sql.SQL;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/1/2.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/2---17:03
 */
public class SQLTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 测试 混合 风格
    @Test
    public void demonstrateMixedStyle() {
        final String sql = new SQL() {{
            SELECT("id, name");
            FROM("PERSON A");
            WHERE("name like ?").WHERE("id = ?");
        }}.toString();
        assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?)", sql);
    }

    // 测试 流式 风格
    @Test
    public void demonstrateFluentStyle() {
        final String sql = new SQL().SELECT("id, name").FROM("PERSON A") .WHERE("name like ?").WHERE("id = ?").toString();
        assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?)", sql);
    }

    // 测试 所有参数都 不满足条件的情况
    @Test
    public void missingAllParams() {
        final String expected = "SELECT P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME\nFROM PERSON P\nORDER BY P.LAST_NAME";
        assertEquals(expected, example2(null, null, null));
    }

    // 测试 前两个参数 不满足条件的情况
    @Test
    public void missingFirstTwoParams() {
        final String expected =
                "SELECT P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME\n" +
                        "FROM PERSON P\n" +
                        "WHERE (P.LAST_NAME like #lastName#)\n" +
                        "ORDER BY P.LAST_NAME";
        assertEquals(expected, example2(null, null, "c"));
    }

    // 测试 第一个参数 不满足条件的情况
    @Test
    public void missingFirstParam() {
        final String expected =
                "SELECT P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME\n" +
                        "FROM PERSON P\n" +
                        "WHERE (P.FIRST_NAME like #firstName# AND P.LAST_NAME like #lastName#)\n" +
                        "ORDER BY P.LAST_NAME";
        assertEquals(expected, example2(null, "b", "c"));
    }

    // 测试  所有参数都 满足条件的情况
    @Test
    public void withAllParams() {
        final String expected =
                "SELECT P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME\n" +
                        "FROM PERSON P\n" +
                        "WHERE (P.ID like #id# AND P.FIRST_NAME like #firstName# AND P.LAST_NAME like #lastName#)\n" +
                        "ORDER BY P.LAST_NAME";
        assertEquals(expected, example2("a", "b", "c"));
    }


    private static String example2(final String id, final String firstName, final String lastName) {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
            FROM("PERSON P");
            if (id != null) {
                WHERE("P.ID like #id#");
            }
            if (firstName != null) {
                WHERE("P.FIRST_NAME like #firstName#");
            }
            if (lastName != null) {
                WHERE("P.LAST_NAME like #lastName#");
            }
            ORDER_BY("P.LAST_NAME");
        }}.toString();
    }



    // 测试 select语句的 可变长参数
    @Test
    public void variableLengthArgumentOnSelect() {
        final String sql = new SQL() {{ SELECT("P.ID", "P.USERNAME"); }}.toString();
        assertEquals("SELECT P.ID, P.USERNAME", sql);
    }

    // 测试 select语句的 可变长参数 + distinct
    @Test
    public void variableLengthArgumentOnSelectDistinct() {
        final String sql = new SQL() {{ SELECT_DISTINCT("P.ID", "P.USERNAME"); }}.toString();
        assertEquals("SELECT DISTINCT P.ID, P.USERNAME", sql);
    }

    // 测试 from 语句的 可变长参数
    @Test
    public void variableLengthArgumentOnFrom() {
        final String sql = new SQL() {{  SELECT().FROM("TABLE_A a", "TABLE_B b"); }}.toString();
        assertEquals("FROM TABLE_A a, TABLE_B b", sql);
    }

    // 测试 join 语句的 可变长参数
    @Test
    public void variableLengthArgumentOnJoin() {
        final String sql = new SQL() {{ SELECT().JOIN("TABLE_A b ON b.id = a.id", "TABLE_C c ON c.id = a.id"); }}.toString();
        assertEquals("JOIN TABLE_A b ON b.id = a.id\nJOIN TABLE_C c ON c.id = a.id", sql);
    }


    /**
     *  测试  Where  GroupBy  Having  OrderBy  语句的变长参数
    */
    @Test
    public void variableLengthArgumentOnWhere() {
        final String sql = new SQL() {{  SELECT().WHERE("a = #{a}", "b = #{b}"); }}.toString();
        assertEquals("WHERE (a = #{a} AND b = #{b})", sql);
    }

    @Test
    public void variableLengthArgumentOnGroupBy() {
        final String sql = new SQL() {{ SELECT().GROUP_BY("a", "b"); }}.toString();
        assertEquals("GROUP BY a, b", sql);
    }

    @Test
    public void variableLengthArgumentOnHaving() {
        final String sql = new SQL() {{ SELECT().HAVING("a = #{a}", "b = #{b}"); }}.toString();
        assertEquals("HAVING (a = #{a} AND b = #{b})", sql);
    }

    @Test
    public void variableLengthArgumentOnOrderBy() {
        final String sql = new SQL() {{ SELECT().ORDER_BY("a", "b");}}.toString();
        assertEquals("ORDER BY a, b", sql);
    }




    @Test
    public void deleteUsingLimit() {
        final String sql = new SQL() {{ DELETE_FROM("test").WHERE("status = #{status}").LIMIT(20); }}.toString();
        assertEquals("DELETE FROM test\nWHERE (status = #{status}) LIMIT 20", sql);
    }

}
