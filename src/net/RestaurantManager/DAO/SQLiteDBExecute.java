package net.RestaurantManager.DAO;

import java.sql.*;

/**
 * @author bao20
 * @version 1.0
 * @since 1.0
 */
public class SQLiteDBExecute {
    /**
     * Connect to database
     *
     * @return A Connection to database
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

    /**
     * Close connection database
     *
     * @param conn Connection to database
     */
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Execute query to database with parameter
     *
     * @param sqlStatement A sql statement to execute
     * @param conn         A connection to database
     * @param parameter    List of parameter to fill in query string
     * @return A ResultSet representing a database result set data
     */
    public static ResultSet executeQuery(String sqlStatement, Connection conn, Object... parameter) {
        ResultSet data = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);

            for (int i = 0; i < parameter.length; i++) {
                fillPrepareStatement(statement, i + 1, parameter[i]);
            }

            data = statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    /**
     * Execute query to database with no parameter
     *
     * @see SQLiteDBExecute#executeQuery(String, Connection, Object...)
     */
    public static ResultSet executeQuery(String sqlStatement, Connection conn) {
        ResultSet data = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            data = statement.executeQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    /**
     * Execute non query to database with parameter
     *
     * @param sqlStatement A sql statement to execute
     * @param conn         A connection to database
     * @param parameter    List of parameter to fill in query string
     * @return A boolean representing success or fail of execute sql statement
     */
    public static boolean executeNonQuery(String sqlStatement, Connection conn, Object... parameter) {
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);

            for (int i = 0; i < parameter.length; i++) {
                fillPrepareStatement(statement, i + 1, parameter[i]);
            }

            statement.executeUpdate(sqlStatement);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Execute non query to database with no parameter
     *
     * @see SQLiteDBExecute#executeNonQuery(String, Connection, Object...)
     */
    public static boolean executeNonQuery(String sqlStatement, Connection conn) {
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.executeUpdate(sqlStatement);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Fill in sql statement with parameter
     *
     * @param preparedStatement sql statement to fill in
     * @param index             index of parameter (start by 1)
     * @param parameter         parameter to fill in
     * @throws SQLException
     */
    private static void fillPrepareStatement(PreparedStatement preparedStatement,
                                             int index,
                                             Object parameter) throws SQLException {
        if (preparedStatement == null) return;
        if (Integer.class.equals(parameter.getClass())) preparedStatement.setInt(index, (Integer) parameter);
        else if (String.class.equals(parameter.getClass())) preparedStatement.setString(index, (String) parameter);
    }
}
