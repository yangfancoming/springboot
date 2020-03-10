package cn.goatool.db.script;

import cn.goatool.db.BaseDataTest;
import cn.goatool.db.runner.SqlRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/1/4.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/4---19:23
 */
public class SqlRunnerTest extends BaseDataTest {

    @Test
    public void shouldSelectOne() throws Exception {
        DataSource ds = createUnpooledDataSource(JPETSTORE_PROPERTIES);
        runScript(ds, JPETSTORE_DDL);
        runScript(ds, JPETSTORE_DATA);
        try (Connection connection = ds.getConnection()) {
            SqlRunner exec = new SqlRunner(connection);
            Map<String, Object> row = exec.selectOne("SELECT * FROM foo WHERE firstname = ?", "222");
            assertEquals("222", row.get("FIRSTNAME"));
        }
    }
}
