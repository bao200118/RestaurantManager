package DAO;

import DTO.DinnerTable_DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DinnerTable_DAO {

    static Connection conn;

    /**
     * Get all dinner table in database
     *
     * @return A list of dinner table
     */
    public static ArrayList<DinnerTable_DTO> getAllTable() {

        ArrayList<DinnerTable_DTO> dinnerTables = new ArrayList<>();

        String sqlStatement = "Select * From BanAn";
        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                DinnerTable_DTO dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
                dinnerTables.add(dinnerTable);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecutor.closeConnection(conn);
        return dinnerTables;
    }

    /**
     * Get a table according to table name
     *
     * @param name dinner table name
     * @return A int representing dinner table 's id
     */
    public static DinnerTable_DTO getDinnerTable(String name) {
        DinnerTable_DTO dinnerTable = null;

        String sqlStatement = "Select * from BanAn where TenBan = ?";
        conn = SQLiteDBExecutor.connect();

        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, name);
        try {
            if (rs.next()) {
                dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return dinnerTable;
    }

    /**
     * Find tables
     *
     * @param name dinner table name
     * @return A list of dinner table found
     */
    public static ArrayList<DinnerTable_DTO> findTables(String name) {
        ArrayList<DinnerTable_DTO> dinnerTables = new ArrayList<>();

        String sqlStatement = "Select * From BanAn where TenBan like '%" +name+ "%'";

        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                DinnerTable_DTO dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
                dinnerTables.add(dinnerTable);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return dinnerTables;
    }

    /**
     * Set status of table to occupied
     *
     * @param id dinner table id
     * @return A Boolean representing success or fail
     */
    public static boolean setStatusOccupied(int id) {
        String sqlStatement = "Update BanAn Set TrangThai = 'Có Người' Where ID = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Set status of table to empty
     *
     * @param id dinner table id
     * @return A Boolean representing success or fail
     */
    public static Boolean setStatusEmpty(int id) {
        String sqlStatement = "Update BanAn Set TrangThai = 'Trống' Where ID = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Add table
     *
     * @param name dinner table name
     * @return A Boolean representing success or fail
     */
    public static Boolean addTable(String name) {
        String sqlStatement = "insert into BanAn(TenBan,TrangThai) values(?,'Trống')";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn,
                name);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Update table
     *
     * @param id dinner table id
     * @param name dinner table name
     * @return A Boolean representing success or fail
     */
    public static Boolean updateTable(int id,String name) {
        String sqlStatement = "Update BanAn Set TenBan = ? Where ID = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn,
                name, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Delete table
     *
     * @param id dinner table id
     * @return A Boolean representing success or fail
     */
    public static Boolean deleteTable(int id) {
        String sqlStatement = "Delete from BanAn Where ID = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
}
