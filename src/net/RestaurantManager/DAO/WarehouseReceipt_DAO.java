package net.RestaurantManager.DAO;

import net.RestaurantManager.DTO.WarehouseReceipt_DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarehouseReceipt_DAO {
    static Connection conn;

    /**
     * Get all warehouse receipt
     * @return A list of warehouse receipt
     */
    public static ArrayList<WarehouseReceipt_DTO> getAllWarehouseReceipt()
    {
        ArrayList<WarehouseReceipt_DTO> warehouseReceipts=new ArrayList<>();

        String sqlStatement = "Select * from PhieuNhap";

        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
                WarehouseReceipt_DTO warehouseReceipt = new WarehouseReceipt_DTO(
                        rs.getInt("MaPN"),
                        rs.getInt("MaNL"),
                        rs.getString("TenNL"),
                        rs.getString("DonVi"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia"),
                        rs.getString("NgayNhap"),
                        rs.getString("CungCap"),
                        rs.getString("ThuKho")
                        );
                warehouseReceipts.add(warehouseReceipt);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SQLiteDBExecutor.closeConnection(conn);
        return warehouseReceipts;
    }

    /**
     * Add warehouse receipt
     * @param warehouseReceipt warehouse receipt data
     * @return true if add success, otherwise false
     */
    public static boolean addWarehouseReceipt(WarehouseReceipt_DTO warehouseReceipt)
    {
        String sqlStatement = "Insert into PhieuNhap(MaNL,TenNL,DonVi,SoLuong,DonGia,NgayNhap,CungCap,ThuKho) values(?,?,?,?,?,?,?,)";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn,
                warehouseReceipt.getIdIngredient(),
                warehouseReceipt.getNameIngredient(),
                warehouseReceipt.getCalUnit(),
                warehouseReceipt.getAmount(),
                warehouseReceipt.getUnitPrice(),
                warehouseReceipt.getImportDate(),
                warehouseReceipt.getSupplier(),
                warehouseReceipt.getStorekeeper()
                );

        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }

    /**
     * Delete warehouse receipt
     * @param id warehouse receipt 's id
     * @return true if execute success, otherwise fail
     */
    public static boolean deleteWarehouseReceipt(int id)
    {
        String sqlStatement = "Delete from PhieuNhap Where MaPN = ?";
        conn = SQLiteDBExecutor.connect();

        boolean isSuccess = SQLiteDBExecutor.executeNonQuery(sqlStatement, conn, id);
        SQLiteDBExecutor.closeConnection(conn);

        return isSuccess;
    }
}
