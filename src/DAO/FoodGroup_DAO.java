/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FoodGroup_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phạm Văn Chánh
 */
public class FoodGroup_DAO {
     static Connection conn;

    /**
     * Get all food groups in database
     *
     * @return A list of food group
     */
    public static ArrayList<FoodGroup_DTO> getAllFoodGroups() {

        ArrayList<FoodGroup_DTO> foodGroups = new ArrayList<>();

        String sqlStatement = "Select * From NhomMon";
        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                FoodGroup_DTO foodGroup = new FoodGroup_DTO(rs.getInt("MaNhom"),
                        rs.getString("TenNhom"));
                foodGroups.add(foodGroup);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecutor.closeConnection(conn);
        return foodGroups;
    }
    
    /**
     * Get a food group according to food group name
     *
     * @param name food group name
     * @return A int representing food group 's id
     */
    public static FoodGroup_DTO getFoodGroupByName(String name) {
        FoodGroup_DTO foodGroup = null;

        String sqlStatement = "Select * from NhomMon where TenNhom = ?";
        conn = SQLiteDBExecutor.connect();

        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, name);
        try {
            if (rs.next()) {
                foodGroup = new FoodGroup_DTO(rs.getInt("MaNhom"),
                        rs.getString("TenNhom"));
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return foodGroup;
    }
    
    /**
     * Get a food group according to food group id
     *
     * @param id food group id
     * @return A food record representing food group 's id
     */
    public static FoodGroup_DTO getFoodGroupById(int id) {
        FoodGroup_DTO foodGroup = null;

        String sqlStatement = "Select * from NhomMon where MaNhom = ?";
        conn = SQLiteDBExecutor.connect();

        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, id);
        try {
            if (rs.next()) {
                foodGroup = new FoodGroup_DTO(rs.getInt("MaNhom"),
                        rs.getString("TenNhom"));
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return foodGroup;
    }

    /**
     * Find food groups
     *
     * @param name food group name
     * @return A list of food group found
     */
    public static ArrayList<FoodGroup_DTO> findFoodGroups(String name) {
        ArrayList<FoodGroup_DTO> foodGroups = new ArrayList<>();

        String sqlStatement = "Select * From NhomMon where TenNhom like '%" +name+ "%'";

        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                FoodGroup_DTO foodGroup = new FoodGroup_DTO(rs.getInt("MaNhom"),
                        rs.getString("TenNhom"));
                foodGroups.add(foodGroup);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return foodGroups;
    }
    
     /**
     * Add food group
     *
     * @param name food group name
     * @return A Boolean representing success or fail
     */
    public static Boolean addFoodGroup(String name) {
        String sqlStatement = "insert into NhomMon(TenNhom) values(?)";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn,
                name);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
    
    /**
     * Update food group
     *
     * @param id food group id
     * @param name food group name
     * @return A Boolean representing success or fail
     */
    public static Boolean updateFoodGroup(int id,String name) {
        String sqlStatement = "Update NhomMon Set TenNhom = ? Where MaNhom = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn,
                name, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
    
     /**
     * Delete food group
     *
     * @param id food group id
     * @return A Boolean representing success or fail
     */
    public static Boolean deleteTable(int id) {
        String sqlStatement = "Delete from NhomMon Where MaNhom = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
}
