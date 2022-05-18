package GUI.Component.TableManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class TableMapLayout extends JPanel {
    private final Dimension dimension;

    public TableMapLayout(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
//        setOpaque(false);
    }
    
    private void initComponents() {
       int width = dimension.width;
       int height = dimension.height;
       
       billByTable = new BillByTable(new Dimension(width / 3, height));
       gridviewTableItem = new GridviewTableItem(new Dimension(width - width / 3 - 5, height));
       
       BorderLayout borderLayout = new BorderLayout();
       setLayout(borderLayout);
       setPreferredSize(new Dimension(width, height - height / 22 - 10));
       
       add(billByTable, BorderLayout.EAST);
       add(gridviewTableItem, BorderLayout.WEST);
    }
    
    // Variables declaration - do not modify   
    private GUI.Component.TableManager.BillByTable billByTable;
    private GUI.Component.TableManager.GridviewTableItem gridviewTableItem;
    // nd of variables declaration 
}

