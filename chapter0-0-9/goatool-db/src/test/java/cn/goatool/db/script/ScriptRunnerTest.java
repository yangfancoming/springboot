package cn.goatool.db.script;

import cn.goatool.db.BaseDataTest;
import cn.goatool.db.runner.ScriptRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2020/1/4.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/4---18:14
 */
public class ScriptRunnerTest extends BaseDataTest {

    @Test
    public void shouldRunScriptsUsingConnection() throws Exception {
        DataSource ds = createUnpooledDataSource(JPETSTORE_PROPERTIES);
        try (Connection conn = ds.getConnection()) {
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setAutoCommit(true);
            runner.setStopOnError(false);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            runJPetStoreScripts(runner);

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ZOO");
            System.out.println(resultSet);
        }
    }



}
