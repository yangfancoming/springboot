package cn.goatool.db;

import cn.goatool.core.io.Resources;
import cn.goatool.db.datasource.UnpooledDataSource;
import cn.goatool.db.runner.ScriptRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2020/1/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/4---19:46
 */
public class BaseDataTest {

    public static final String JPETSTORE_PROPERTIES = "test-hsqldb.properties";
    public static final String JPETSTORE_DDL = "CreateDB.sql";
    public static final String JPETSTORE_DATA = "InsertData.sql";

    public static UnpooledDataSource createUnpooledDataSource(String resource) throws IOException {
        Properties props = Resources.getResourceAsProperties(resource);
        UnpooledDataSource ds = new UnpooledDataSource();
        ds.setDriver(props.getProperty("driver"));
        ds.setUrl(props.getProperty("url"));
        ds.setUsername(props.getProperty("username"));
        ds.setPassword(props.getProperty("password"));
        return ds;
    }

    protected void runJPetStoreScripts(ScriptRunner runner) throws IOException, SQLException {
        runScript(runner, JPETSTORE_DDL);
        runScript(runner, JPETSTORE_DATA);
    }

    public static void runScript(ScriptRunner runner, String resource) throws IOException {
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            runner.runScript(reader);
        }
    }

    public static void runScript(DataSource ds, String resource) throws IOException, SQLException {
        try (Connection connection = ds.getConnection()) {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setAutoCommit(true);
            runner.setStopOnError(false);
            runner.setLogWriter(null);
            runner.setErrorLogWriter(null);
            runScript(runner, resource);
        }
    }

}
