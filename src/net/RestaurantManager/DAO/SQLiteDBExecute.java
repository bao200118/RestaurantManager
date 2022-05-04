package net.RestaurantManager.DAO;

import java.sql.*;

public class SQLiteDBExecute {
    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:db/NHAHANG.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet query(String queryString, Connection conn) {
        ResultSet data = null;
        try {
            Statement statement = conn.createStatement();
            data=statement.executeQuery(queryString);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static boolean nonQuery(String queryString, Connection conn) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryString);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
