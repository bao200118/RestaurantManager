
package DAO;

import DTO.Bill_DTO;
import DAO.Interface.IBill_DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author macbookpro
 */
public class Bill_DAO implements IBill_DAO{
    static Connection conn;

    /**
     * Get all bill in database
     *
     * @return A list of bill
     */
    @Override
    public ArrayList<Bill_DTO> getAll() {
        ArrayList<Bill_DTO> bills = new ArrayList<>();

        String sqlStatement = "select HoaDon.ID,BanAn.TenBan,HoaDon.NgayThanhToan,HoaDon.SoTien from HoaDon,BanAn where HoaDon.IDBan = BanAn.ID AND TinhTrang = 1";
        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
               
                Bill_DTO bill = new Bill_DTO(
                        rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("NgayThanhToan"),
                        rs.getString("SoTien")                       
                );
                
                bills.add(bill);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecutor.closeConnection(conn);
        return bills;
    }
    
    /**
     * Get all bill in database between fromDay and ToDay
     *
     * @param fromDay 
     * @param toDay
     * @return A list of bill
     */
    @Override
    public ArrayList<Bill_DTO> getAllBillsBetweenFromDayAndToDay(String fromDay, String toDay) {

        ArrayList<Bill_DTO> bills = new ArrayList<>();

        String sqlStatement = "select HoaDon.ID,BanAn.TenBan,HoaDon.NgayThanhToan,HoaDon.SoTien from HoaDon,BanAn where HoaDon.IDBan = BanAn.ID AND TinhTrang = 1 AND NgayThanhToan >= '" + fromDay + "' AND NgayThanhToan <= '" + toDay + "'";
        conn = SQLiteDBExecutor.connect();
        ResultSet rs = SQLiteDBExecutor.executeQuery(sqlStatement, conn);

        try {
            while (rs.next()) {
               
                Bill_DTO bill = new Bill_DTO(
                        rs.getInt("ID"),
                        rs.getString("TenBan"),
                        rs.getString("NgayThanhToan"),
                        rs.getString("SoTien")                       
                );
                
                bills.add(bill);
            }
            rs.close();
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLiteDBExecutor.closeConnection(conn);
        return bills;
    }

    @Override
    public boolean add(Bill_DTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(Bill_DTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(String uniqueProp) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
