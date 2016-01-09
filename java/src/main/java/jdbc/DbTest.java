package jdbc;

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
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "root");
            int id = 1;
            String name = String.format("lcj' or 1=1");
            String sql = String.format("select * from account where id=%d and name='%s", id, name);
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                LOGGER.info("query id = {},name = {}", rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
            LOGGER.error("sql exception", e);

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}