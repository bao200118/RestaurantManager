
package BUS;

import DAO.BillDetail_DAO;
import DTO.BillDetail_DTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbookpro
 */
public class BillDetail_BUS {
    public static ArrayList<BillDetail_DTO> loadBillDetailByTableId(DefaultTableModel tableModel, int tableId) {
        tableModel.setRowCount(0);
        ArrayList<BillDetail_DTO> billDetailList = BillDetail_DAO.loadBillDetailByTableId(tableId);
        for (BillDetail_DTO billDetail : billDetailList) {
            tableModel.addRow(new Object[]{billDetail.getFoodName(),billDetail.getQuantity(), billDetail.getPrice(), billDetail.getTotalMoney()});
        }
        return billDetailList;
    }
}
