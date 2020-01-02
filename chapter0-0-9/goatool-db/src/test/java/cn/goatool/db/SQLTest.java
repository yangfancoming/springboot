package cn.goatool.db;

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



    @Test
    public void deleteUsingLimit() {

        final String sql = new SQL() {{
            DELETE_FROM("test").WHERE("status = #{status}").LIMIT(20);
        }}.toString();

        assertEquals("DELETE FROM test\nWHERE (status = #{status}) LIMIT 20", sql);
    }

}
