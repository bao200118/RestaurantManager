/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.DinnerTable_DTO;
import DAO.DinnerTable_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bao20
 */
public class DinnerTable_BUS {

    public static void getAllTableInfo(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        ArrayList<DinnerTable_DTO> dinnerTableList = DinnerTable_DAO.getAllTable();
        for (DinnerTable_DTO dinnerTable : dinnerTableList) {
            tableModel.addRow(new Object[]{dinnerTable.getId(),
                dinnerTable.getName(), dinnerTable.getStatus()});
        }
    }

    public static void addTableInfo(String dinnerTableName) {
        DinnerTable_DTO dinnerTableCheckDTO = DinnerTable_DAO.getDinnerTable(dinnerTableName);
        if (dinnerTableCheckDTO == null) {
            if (DinnerTable_DAO.addTable(dinnerTableName)) {
                JOptionPane.showMessageDialog(null, "Thao tác thành công", "Thêm bàn ăn",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Thêm bàn ăn",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bàn ăn đã tồn tại", "Thêm bàn ăn",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateTableInfo(int dinnerTableId, String dinnerTableName) {
        
        DinnerTable_DTO dinnerTableCheckDTO = DinnerTable_DAO.getDinnerTable(dinnerTableName);

        if (dinnerTableCheckDTO == null) {
            if (DinnerTable_DAO.updateTable(dinnerTableId, dinnerTableName)) {
                JOptionPane.showMessageDialog(null, "Thao tác thành công", "Cập nhật bàn ăn",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Cập nhật bàn ăn",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bàn ăn đã tồn tại", "Cập nhật bàn ăn",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void deleteTableInfo(int dinnerTableId) {

        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa bàn ăn", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            
            if (DinnerTable_DAO.deleteTable(dinnerTableId)) {
                JOptionPane.showMessageDialog(null, "Thao tác thành công", "Xóa bàn ăn",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác thất bại", "Xóa bàn ăn",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (result == JOptionPane.NO_OPTION) {
            System.err.println("No");
        }
    }
    
    public static void findTableInfos(DefaultTableModel tableModel, String name) {
        tableModel.setRowCount(0);
        ArrayList<DinnerTable_DTO> dinnerTableList = DinnerTable_DAO.findTables(name);
        for (DinnerTable_DTO dinnerTable : dinnerTableList) {
            tableModel.addRow(new Object[]{dinnerTable.getId(),
                dinnerTable.getName(), dinnerTable.getStatus()});
        }
    }
}
