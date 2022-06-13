
package BUS;

import DAO.Account_DAO;
import DAO.Interface.IAccount_DAO;
import DTO.Account_DTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbookpro
 */
public class Account_BUS {
    static IAccount_DAO account_DAO = new Account_DAO();
    
    public static void getAllAccount(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        ArrayList<Account_DTO> accountList = account_DAO.getAll();
        for (Account_DTO account : accountList) {
            tableModel.addRow(new Object[]{account.getUsername(), account.getPassword(), account.getAccountType()});
        }
    }
    
    
}
