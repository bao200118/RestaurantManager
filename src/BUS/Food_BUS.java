
package BUS;

import DAO.Food_DAO;
import Utils.ImageUtils;
import DTO.Food_DTO;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbookpro
 */
public class Food_BUS {
    public static void getAllFoods(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        ArrayList<Food_DTO> foodList = Food_DAO.getAllFoods();
        for (Food_DTO food : foodList) {
            ImageIcon icon = ImageUtils.convertByteArrayToImageIcon(food.getImage());
            tableModel.addRow(new Object[]{food.getId(), food.getFoodGroupName(),food.getName(), food.getUnit(), food.getPrice(), icon});
        }
    }
    
    public static Food_DTO getFoodByName(String foodName) {
        return Food_DAO.getFoodByName(foodName);
    }
    
    public static Food_DTO getFoodById(int id) {
        return Food_DAO.getFoodById(id);
    }
    
    public static void addFood(String foodGroupName, String name, String unit, String priceText, File imageFile) {
        
        int price = "".equals(priceText) ? 0 : Integer.valueOf(priceText);
        if (!"".equals(foodGroupName) && !"".equals(name) && !"".equals(unit) && price != 0 && imageFile != null) {
            Food_DTO foodCheckDTO = getFoodByName(name);  
            System.out.println(foodCheckDTO);
            if (foodCheckDTO == null) {
                
                if (Food_DAO.addFood(foodGroupName, name, unit, price, imageFile)) {
                    JOptionPane.showMessageDialog(null, "Thao tác thành công", "Thêm món ăn",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Thêm món ăn",
                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Món ăn đã tồn tại", "Thêm món ăn",
                    JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thêm món ăn",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public static void updateFood(int id, String foodGroupName, String name, String unit, String priceText, byte[] imageFile) {
        
        int price = "".equals(priceText) ? 0 : Integer.valueOf(priceText);
        
        if (!"".equals(foodGroupName) && !"".equals(name) && !"".equals(unit) && price != 0 && imageFile != null) {
            Food_DTO foodCheckDTO = getFoodByName(foodGroupName);

            if (foodCheckDTO == null) {
                if (Food_DAO.updateFood(id, foodGroupName, name, unit, price, imageFile)) {
                    JOptionPane.showMessageDialog(null, "Thao tác thành công", "Cập nhật nhóm món ăn",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Cập nhật nhóm món ăn",
                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nhóm món ăn đã tồn tại", "Cập nhật nhóm món ăn",
                    JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Cập nhật nhóm món ăn",
                    JOptionPane.WARNING_MESSAGE);
        }     
    }
    
    public static void deleteFood(int foodId) {

        if (foodId != -1) {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa món ăn", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
            
                if (Food_DAO.deleteFood(foodId)) {
                    JOptionPane.showMessageDialog(null, "Thao tác thành công", "Xóa món ăn",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Xóa món ăn",
                        JOptionPane.ERROR_MESSAGE);
                }
            } else if (result == JOptionPane.NO_OPTION) {
                System.err.println("No");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn món ăn cần xoá", "Xóa món ăn",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public static void findFoodsByName(DefaultTableModel tableModel, String name) {
        tableModel.setRowCount(0);
        ArrayList<Food_DTO> foodList = Food_DAO.findFoodsByName(name);
        for (Food_DTO food : foodList) {
            ImageIcon icon = ImageUtils.convertByteArrayToImageIcon(food.getImage());
            tableModel.addRow(new Object[]{food.getId(), food.getFoodGroupName(),food.getName(), food.getUnit(), food.getPrice(), icon});
        }
    }
    
    public static void findFoodsByGroupName(DefaultTableModel tableModel, String groupName) {
        tableModel.setRowCount(0);
        ArrayList<Food_DTO> foodList = Food_DAO.findFoodsByGroupName(groupName);
        for (Food_DTO food : foodList) {
            ImageIcon icon = ImageUtils.convertByteArrayToImageIcon(food.getImage());
            tableModel.addRow(new Object[]{food.getId(), food.getFoodGroupName(),food.getName(), food.getUnit(), food.getPrice(), icon});
        }
    }
}
