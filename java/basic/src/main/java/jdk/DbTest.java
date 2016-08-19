package jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by lcj on 15-8-16.
 */
public class DbTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbTest.class);

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "root");
//            int id = 1;
//            String name = "lcj' or 1=1";
//            String sql = String.format("select * from account where id=%d and name='%s", id, name);
//            Statement statement = con.createStatement();
//            // 推荐使用PreparedStatement,防sql注入,使用mybatis和hibernate等orm框架,天然防sql注入
//            rs = statement.executeQuery(sql);
//
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            con.setAutoCommit(false);
            String sql = "insert into  name values(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"lcj");
            preparedStatement.execute();
            con.rollback();
        } catch (Exception e) {
            LOGGER.error("sql exception", e);

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}