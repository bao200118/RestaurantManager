
package BUS;

import DAO.DinnerTable_DAO;
import DTO.TableModelItemUI;
import DTO.DinnerTable_DTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbookpro
 */
public class TableItemUI {
    
    public static List<TableModelItemUI> getAllTableDinnerUI() {
        List<DinnerTable_DTO> dinnerTableInfoList = DinnerTable_DAO.getAllTable();
        List<TableModelItemUI> tableUIList = new ArrayList<>();
        for (DinnerTable_DTO dinnerTableInfo : dinnerTableInfoList) {
            tableUIList.add(new TableModelItemUI(dinnerTableInfo.getId(), dinnerTableInfo.getName(), dinnerTableInfo.getStatus()));
        }
        return tableUIList;
    }
}
