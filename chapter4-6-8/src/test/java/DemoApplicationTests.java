import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
//
//    @Test
//    public void contextLoads() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        String url = "jdbc:sqlserver://localhost:1434;databaseName=student";
//        String username = "sa";
//        String password = "123456";
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//        Connection   conn = DriverManager.getConnection(url, username, password);
//        String sql = "select * from student where id = ?";
//        PreparedStatement pre = conn.prepareStatement(sql);
//        pre.setInt(1, 1);
//        ResultSet rs = pre.executeQuery();
//        System.out.println(rs.first());
//    }


    @Test
    public void contextLoads() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // sqlserver 默认端口 1433
        String url = "jdbc:sqlserver://localhost:1433;databaseName=tianjincollect";
        String username = "sa";
        String password = "0987";
        // 驱动jar 类名
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from shui_opc ";
        PreparedStatement pre = conn.prepareStatement(sql);
        //
        ResultSet rs = pre.executeQuery();
        System.out.println(rs.first());
        //
    }

}
