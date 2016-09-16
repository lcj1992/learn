package jdk;


import java.sql.*;

/**
 * Created by lcj on 15-8-16.
 */
public class DbTest {

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
            String sql = "insert into  name values(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"lcj");
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();

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