
package DAO;

import Utils.ImageUtils;
import DTO.FoodGroup_DTO;
import BUS.FoodGroup_BUS;
import static DAO.DinnerTable_DAO.conn;
import static DAO.FoodGroup_DAO.conn;
import DTO.Food_DTO;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author macbookpro
 */
public class Food_DAO {
    static Connection conn;

    /**
     * Get all food in database
     *
     * @return A list of food
     */
    public static ArrayList<Food_DTO> getAllFoods() {

        ArrayList<Food_DTO> foods = new ArrayList<>();

        String sqlStatement = "Select ID, Image, TenMonAn, DonViTinh, Gia, TenNhom From MonAn, NhomMon where MaNhomMon = MaNhom order by ID ASC";
        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
               
                Food_DTO food = new Food_DTO(
                        rs.getInt("ID"),
                        rs.getBytes("Image"),
                        rs.getString("TenNhom"),
                        rs.getString("TenMonAn"),
                        rs.getString("DonViTinh"),
                        rs.getInt("Gia")                       
                );
                
                foods.add(food);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecutor.closeConnection(conn);
        return foods;
    }
    
    /**
     * Get a food according to food name
     *
     * @param name food name
     * @return A int representing food 's id
     */
    public static Food_DTO getFoodByName(String name) {
        Food_DTO food = null;

        String sqlStatement = "Select * from MonAn where TenMonAn = ?";
        conn = SQLiteDBExecutor.connect();

        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, name);
        try {
            if (rs.next()) {
                food = new Food_DTO(
                        rs.getInt("ID"),
                        rs.getBytes("Image"),
                        FoodGroup_BUS.getFoodGroupById(rs.getInt("MaNhomMon")).getName(),
                        rs.getString("TenMonAn"),
                        rs.getString("DonViTinh"),
                        rs.getInt("Gia")                       
                );
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return food;
    }
    
    /**
     * Get a food according to food id
     *
     * @param id food id
     * @return A food representing food 's id
     */
    public static Food_DTO getFoodById(int id) {
        Food_DTO food = null;

        String sqlStatement = "Select * from MonAn where ID = ?";
        conn = SQLiteDBExecutor.connect();

        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, id);
        try {
            if (rs.next()) {
                food = new Food_DTO(
                        rs.getInt("ID"),
                        rs.getBytes("Image"),
                        FoodGroup_BUS.getFoodGroupById(rs.getInt("MaNhomMon")).getName(),
                        rs.getString("TenMonAn"),
                        rs.getString("DonViTinh"),
                        rs.getInt("Gia")                       
                );
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return food;
    }
    
    /**
     * Add food
     *
     * @param name food name
     * @param foodGroupName  food 's foodGroupName
     * @param imageFile   food 's imageFile
     * @param unit   food 's unit
     * @param price  food 's price
     * @return A Boolean representing success or fail
     */
    public static Boolean addFood(String foodGroupName, String name, String unit, int price, File imageFile) {
        String sqlStatement = "insert into MonAn(MaNhomMon,TenMonAn,DonViTinh,Gia,Image) values(?,?,?,?,?)";
        conn = SQLiteDBExecutor.connect();
        FoodGroup_DTO foodGroup = FoodGroup_BUS.getFoodGroupByName(foodGroupName);
        byte[] image = ImageUtils.convertFileToByteArray(imageFile);
        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, foodGroup.getId(), name, unit, price, image);
        SQLiteDBExecutor.closeConnection(conn);     
        return isSuccess;
    }
    
    /**
     * Update food
     * 
     * @param id food id
     * @param name food name
     * @param foodGroupName  food 's foodGroupName
     * @param imageFile   food 's imageFile
     * @param unit   food 's unit
     * @param price  food 's price
     * @return A Boolean representing success or fail
     */
    public static Boolean updateFood(int id, String foodGroupName, String name, String unit, int price, byte[] imageFile) {
        String sqlStatement = "UPDATE MonAn SET MaNhomMon = ?, TenMonAn = ?, DonViTinh = ?, Gia = ?, Image = ? WHERE ID = ?";
        conn = SQLiteDBExecutor.connect();

        FoodGroup_DTO foodGroup = FoodGroup_BUS.getFoodGroupByName(foodGroupName);
        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, foodGroup.getId(), name, unit, price, imageFile, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
    
    /**
     * Delete food
     *
     * @param id food id
     * @return A Boolean representing success or fail
     */
    public static Boolean deleteFood(int id) {
        String sqlStatement = "Delete from MonAn Where ID = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
    
    /**
     * Find foods by food name
     *
     * @param name food name
     * @return A list of food found
     */
    public static ArrayList<Food_DTO> findFoodsByName(String name) {
        ArrayList<Food_DTO> foods = new ArrayList<>();

        String sqlStatement = "Select * From MonAn where TenMonAn like '%" +name+ "%'";

        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                Food_DTO food = new Food_DTO(
                        rs.getInt("ID"),
                        rs.getBytes("Image"),
                        FoodGroup_BUS.getFoodGroupById(rs.getInt("MaNhomMon")).getName(),
                        rs.getString("TenMonAn"),
                        rs.getString("DonViTinh"),
                        rs.getInt("Gia")
                );
                foods.add(food);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return foods;
    }
    
    /**
     * Find foods by group name
     *
     * @param groupName food group Name
     * @return A list of food found
     */
    public static ArrayList<Food_DTO> findFoodsByGroupName(String groupName) {
        ArrayList<Food_DTO> foods = new ArrayList<>();

        String sqlStatement = "Select * From MonAn where MaNhomMon = ?";

        conn = SQLiteDBExecutor.connect();
        FoodGroup_DTO foodGroup = FoodGroup_BUS.getFoodGroupByName(groupName);
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn, foodGroup.getId());

        try {
            while (rs.next()) {
                Food_DTO food = new Food_DTO(
                        rs.getInt("ID"),
                        rs.getBytes("Image"),
                        FoodGroup_BUS.getFoodGroupById(rs.getInt("MaNhomMon")).getName(),
                        rs.getString("TenMonAn"),
                        rs.getString("DonViTinh"),
                        rs.getInt("Gia")
                );
                foods.add(food);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return foods;
    }
}
