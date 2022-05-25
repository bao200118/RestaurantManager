
package BUS;

import DAO.FoodGroup_DAO;
import DTO.FoodGroup_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Phạm Văn Chánh
 */
public class FoodGroup_BUS {
    
    public static void getAllFoodGroups(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        ArrayList<FoodGroup_DTO> foodGroupList = FoodGroup_DAO.getAllFoodGroups();
        for (FoodGroup_DTO foodGroup : foodGroupList) {
            tableModel.addRow(new Object[]{foodGroup.getId(), foodGroup.getName()});
        }
    }
    
    public static void getAllFoodGroupNames(DefaultComboBoxModel cbModel) {
       
        ArrayList<FoodGroup_DTO> foodGroupList = FoodGroup_DAO.getAllFoodGroups();
        for (FoodGroup_DTO foodGroup : foodGroupList) {
            cbModel.addElement(foodGroup.getName());
        }
    }
    
    public static void addFoodGroup(String foodGroupName) {
        
        if (!"".equals(foodGroupName)) {
            FoodGroup_DTO foodGroupCheckDTO = FoodGroup_DAO.getFoodGroupByName(foodGroupName);
            if (foodGroupCheckDTO == null) {
                if (FoodGroup_DAO.addFoodGroup(foodGroupName)) {
                    JOptionPane.showMessageDialog(null, "Thao tác thành công", "Thêm nhóm món ăn",
                        JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Thêm nhóm món ăn",
                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nhóm món ăn đã tồn tại", "Thêm nhóm món ăn",
                    JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin cần thêm", "Thêm nhóm món ăn",
                    JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public static void updateFoodGroup(int foodGroupId, String foodGroupName) {
        
        FoodGroup_DTO foodGroupCheckDTO = FoodGroup_DAO.getFoodGroupByName(foodGroupName);

        if (foodGroupCheckDTO == null) {
            if (FoodGroup_DAO.updateFoodGroup(foodGroupId, foodGroupName)) {
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
    }
    
    public static void deleteFoodGroup(int foodGroupId) {

        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa nhóm món ăn", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            
            if (FoodGroup_DAO.deleteTable(foodGroupId)) {
                JOptionPane.showMessageDialog(null, "Thao tác thành công", "Xóa nhóm món ăn",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Xóa nhóm món ăn",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (result == JOptionPane.NO_OPTION) {
            System.err.println("No");
        }
    }
    
    public static void findFoodGroups(DefaultTableModel tableModel, String name) {
        tableModel.setRowCount(0);
        ArrayList<FoodGroup_DTO> foodGroupList = FoodGroup_DAO.findFoodGroups(name);
        for (FoodGroup_DTO foodGroup : foodGroupList) {
            tableModel.addRow(new Object[]{foodGroup.getId(), foodGroup.getName()});
        }
    }
}
