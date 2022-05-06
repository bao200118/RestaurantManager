package net.RestaurantManager.DAO;

import net.RestaurantManager.DTO.DinnerTable_DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        conn = SQLiteDBExecute.connect();
        ResultSet rs = SQLiteDBExecute.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                DinnerTable_DTO dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
                dinnerTables.add(dinnerTable);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecute.closeConnection(conn);
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
        conn = SQLiteDBExecute.connect();

        ResultSet rs = SQLiteDBExecute.executeQuery(sqlStatement, conn, name);
        try {
            if (rs.next()) {
                dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecute.closeConnection(conn);
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

        String sqlStatement = "Select * From BanAn where TenBan like CONCAT( '%',?,'%')";

        conn = SQLiteDBExecute.connect();
        ResultSet rs = SQLiteDBExecute.executeQuery(sqlStatement, conn, name);

        try {
            while (rs.next()) {
                DinnerTable_DTO dinnerTable = new DinnerTable_DTO(rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("TrangThai"));
                dinnerTables.add(dinnerTable);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecute.closeConnection(conn);
        return dinnerTables;
    }

    /**
     * Set status of table to occupied
     *
     * @param id dinner table id
     * @return A boolean representing success or fail
     */
    public static boolean setStatusOccupied(int id) {
        String sqlStatement = "Update BanAn Set TrangThai = 'Có Người' Where ID = ?";
        conn = SQLiteDBExecute.connect();

        boolean isSuccess = SQLiteDBExecute.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecute.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Set status of table to empty
     *
     * @param id dinner table id
     * @return A boolean representing success or fail
     */
    public static Boolean setStatusEmpty(int id) {
        String sqlStatement = "Update BanAn Set TrangThai = 'Trống' Where ID = ?";
        conn = SQLiteDBExecute.connect();

        boolean isSuccess = SQLiteDBExecute.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecute.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Add table
     *
     * @param dinnerTable dinner table data
     * @return A boolean representing success or fail
     */
    public static Boolean addTable(DinnerTable_DTO dinnerTable) {
        String sqlStatement = "insert into BanAn(TenBan,TrangThai) values(?,?)";
        conn = SQLiteDBExecute.connect();

        boolean isSuccess = SQLiteDBExecute.executeNonQuery(sqlStatement, conn,
                dinnerTable.getName(), dinnerTable.getStatus());

        SQLiteDBExecute.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Update table
     *
     * @param dinnerTable dinner table data
     * @return A boolean representing success or fail
     */
    public static Boolean updateTable(DinnerTable_DTO dinnerTable) {
        String sqlStatement = "Update BanAn Set TenBan = ? Where ID = ?";
        conn = SQLiteDBExecute.connect();

        boolean isSuccess = SQLiteDBExecute.executeNonQuery(sqlStatement, conn,
                dinnerTable.getName(), dinnerTable.getId());

        SQLiteDBExecute.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Update table
     *
     * @param id dinner table id
     * @return A boolean representing success or fail
     */
    public static Boolean deleteTable(int id) {
        String sqlStatement = "Delete from BanAn Where ID = ?";
        conn = SQLiteDBExecute.connect();

        boolean isSuccess = SQLiteDBExecute.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecute.closeConnection(conn);

        return isSuccess;
    }

}