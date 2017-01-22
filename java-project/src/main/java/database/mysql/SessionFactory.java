package database.mysql;

import java.sql.*;

/**
 * Created by SF on 2017/1/22.
 */
public class SessionFactory {
    private static final String URL = "jdbc:mysql:localhost:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection createConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行静态语句
     */
    public void staticQuery(String query) {
        try {
            Statement statement = createConnect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                System.out.println(id);
            }
//            resultSet.getString(1);
//            boolean flag = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "select * from product_detail;";
        new SessionFactory().staticQuery(sql);
    }
}
