package cn.goatool.db.script;

import cn.goatool.core.io.Resources;
import cn.goatool.db.datasource.UnpooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2020/1/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/4---18:14
 */
public class ScriptRunnerTest {

    public static final String JPETSTORE_PROPERTIES = "test-hsqldb.properties";
    public static final String JPETSTORE_DDL = "CreateDB.sql";
    public static final String JPETSTORE_DATA = "InsertData.sql";

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

    public static UnpooledDataSource createUnpooledDataSource(String resource) throws IOException {
        Properties props = Resources.getResourceAsProperties(resource);
        UnpooledDataSource ds = new UnpooledDataSource();
        ds.setDriver(props.getProperty("driver"));
        ds.setUrl(props.getProperty("url"));
        ds.setUsername(props.getProperty("username"));
        ds.setPassword(props.getProperty("password"));
        return ds;
    }

    private void runJPetStoreScripts(ScriptRunner runner) throws IOException, SQLException {
        runScript(runner, JPETSTORE_DDL);
        runScript(runner, JPETSTORE_DATA);
    }

    public static void runScript(ScriptRunner runner, String resource) throws IOException {
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            runner.runScript(reader);
        }
    }

}
