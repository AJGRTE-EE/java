package sample;

import java.sql.*;

public class MySql {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/isp?useUnicode=true&serverTimezone=UTC";
    private static final String user = "#сюды юзера пишем";
    private static final String password = "#сюды пароль";

    // JDBC variables for opening and managing connection
    private static Connection con;
    public static Statement stmt;

    public static void Connection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement();
    }
    public static void Shutdown() throws SQLException {
        con.close();
        stmt.close();
    }

}
