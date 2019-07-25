package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/25---11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class App {

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws SQLException {
        // class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        // HikariProxyConnection@1406324738 wrapping com.mysql.jdbc.JDBC4Connection@5b39a3e6
        System.out.println(connection);
        connection.close();
    }
}
