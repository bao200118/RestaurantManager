    package GUI.Component.TableManager;

import DTO.TableModelItem;
import GUI.Component.RoundedButton;
import GUI.Component.TableManager.FoodCard.FoodCard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GridviewTableItem extends JPanel{
    private final Dimension dimension;
    List<TableModelItem> tables = new ArrayList<>();

    public GridviewTableItem(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
        setOpaque(false);
    }
     
    private void initComponents() {
       int width = dimension.width;
       int height = dimension.height;
       
       btnOpenTable = new RoundedButton();
       btnMoveTable = new RoundedButton();
       btnBack = new RoundedButton();
       lbDateOpenTable = new JLabel("12/12/2022");
       lbTableName = new JLabel("Chưa chọn");
       lbTableStatus = new JLabel("Không có");
      
       setLayout(new BorderLayout());
       setPreferredSize(new Dimension(width, height - height / 22 - 10));       
        /**
        * set header layout
        */
       int heightHeaderLayout =  (int) (height - height / 1.4 - height / 22 - 20);
       JPanel headerLayout = new JPanel(new BorderLayout());
       headerLayout.setPreferredSize(new Dimension(width, heightHeaderLayout));

       //left layout
       JPanel leftLayout = new JPanel();
       GridBagLayout gridBagLayout = new GridBagLayout();
       GridBagConstraints gbc = new GridBagConstraints();  
       gbc.insets = new Insets(3,3,3,3);
       
       leftLayout.setLayout(gridBagLayout);
       leftLayout.setPreferredSize(new Dimension(width / 2, heightHeaderLayout));
       
       gbc.insets = new Insets(5,5,5,5);
       gbc.anchor = GridBagConstraints.EAST;
       gbc.gridx = 0;
       gbc.gridy = 0; 
       btnOpenTable.setForeground(new java.awt.Color(255, 255, 255));
       btnOpenTable.setText("Mở bàn");
       btnOpenTable.setColor(new java.awt.Color(71, 209, 71));
       btnOpenTable.setColorOver(new java.awt.Color(51, 153, 255));
       btnOpenTable.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
       btnOpenTable.setRadius(10);
       btnOpenTable.setBorderPainted(false);
       btnOpenTable.setFocusPainted(false);
       btnOpenTable.setPreferredSize(new Dimension(width / 4, height / 22));
       btnOpenTable.setBorderColor(Color.red);
       btnOpenTable.addActionListener((ActionEvent evt) -> {
           btnOpenTableActionPerformed(evt);
       });
        leftLayout.add(btnOpenTable, gbc);
       
       gbc.insets = new Insets(5,5,5,5);
       gbc.anchor = GridBagConstraints.EAST;
       gbc.gridx = 1;
       gbc.gridy = 0; 
       btnMoveTable.setForeground(new java.awt.Color(255, 255, 255));
       btnMoveTable.setText("Chuyển bàn");
       btnMoveTable.setColor(new java.awt.Color(77, 148, 255));
       btnMoveTable.setColorOver(new java.awt.Color(51, 153, 255));
       btnMoveTable.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
       btnMoveTable.setRadius(10);
       btnMoveTable.setBorderPainted(false);
       btnMoveTable.setFocusPainted(false);
       btnMoveTable.setPreferredSize(new Dimension(width / 4, height / 22));
       btnMoveTable.setBorderColor(Color.red);
       btnMoveTable.addActionListener((ActionEvent evt) -> {
          btnMoveTableActionPerformed(evt);
       });
       
       leftLayout.add(btnMoveTable, gbc);
       
       gbc.insets = new Insets(30,0,0,0);
       gbc.anchor = GridBagConstraints.NORTH;
       gbc.gridx = 0;
       gbc.gridy = 1; 
       
       btnBack.setForeground(new java.awt.Color(255, 255, 255));
       btnBack.setText("Quay lại");
       btnBack.setColor(Color.GRAY);
       btnBack.setColorOver(Color.GRAY);
       btnBack.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
       btnBack.setRadius(10);
       btnBack.setBorderPainted(false);
       btnBack.setFocusPainted(false);
       btnBack.setPreferredSize(new Dimension(width / 4, height / 24));
       btnBack.setBorderColor(Color.red);
       btnBack.addActionListener((ActionEvent evt) -> {
          btnBackActionPerformed(evt);
       });
             
       btnBack.setVisible(false);
       leftLayout.add(btnBack, gbc);
       
       //right layout
       JPanel rightLayout = new JPanel();
       rightLayout.setPreferredSize(new Dimension(width / 2, heightHeaderLayout));
        
       rightLayout.setLayout(new GridBagLayout());
       GridBagConstraints gbc1 = new GridBagConstraints();
       gbc1.insets = new Insets(5,5,5,5);
       gbc1.anchor = GridBagConstraints.EAST;
       gbc1.gridx = 0;
       gbc1.gridy = 0;        
       JLabel lbTextDate = new JLabel("Ngày:");
       lbTextDate.setFont(new Font("sansserif", 1, 15));
       lbTextDate.setForeground(Color.BLACK);
       rightLayout.add(lbTextDate, gbc1);
       
       gbc1.gridx = 1;
       gbc1.gridy = 0;
       gbc1.anchor = GridBagConstraints.WEST;
       rightLayout.add(lbDateOpenTable, gbc1);
       
       gbc1.gridx = 0;
       gbc1.gridy = 1;
       gbc1.anchor = GridBagConstraints.EAST;
       JLabel lbTextTable = new JLabel("Bàn:");
       lbTextTable.setFont(new Font("sansserif", 1, 15));
       lbTextTable.setForeground(Color.BLACK);
       rightLayout.add(lbTextTable, gbc1);
       
       gbc1.gridx = 1;
       gbc1.gridy = 1;
       gbc1.anchor = GridBagConstraints.WEST;
       lbTableName.setFont(new Font("sansserif", 1, 15));
       lbTableName.setForeground(Color.RED);
       rightLayout.add(lbTableName, gbc1);
       
       gbc1.gridx = 0;
       gbc1.gridy = 2;
       gbc1.anchor = GridBagConstraints.EAST;
       JLabel lbTextTableStatus = new JLabel("Trạng thái:");
       lbTextTableStatus.setFont(new Font("sansserif", 1, 15));
       lbTextTableStatus.setForeground(Color.BLACK);
       rightLayout.add(lbTextTableStatus, gbc1);
       
       gbc1.gridx = 1;
       gbc1.gridy = 2;
       gbc1.anchor = GridBagConstraints.WEST;
       lbTableStatus.setFont(new Font("sansserif", 1, 15));
       lbTableStatus.setForeground(Color.RED);
       rightLayout.add(lbTableStatus, gbc1);
       
       headerLayout.add(leftLayout, BorderLayout.WEST);
       headerLayout.add(rightLayout, BorderLayout.EAST);
       /**
        * set body layout
        */
       JPanel bodyLayout = new JPanel() {               
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D g2 = (Graphics2D) graphics;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#d7d2cc"), 0, getHeight(), Color.decode("#d7d2cc"));
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
                super.paintComponent(graphics); 
            }
       };
       
       bodyLayout.setOpaque(false);
       
       tables.add(new TableModelItem(1, "Bàn 1", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 2", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 3", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 4", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 5", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 6", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 7", "Chưa mở"));
       tables.add(new TableModelItem(1, "Bàn 8", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 9", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 10", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 11", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 12", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 13", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 14", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 15", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 16", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 17", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 18", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 19", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 20", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 21", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 22", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 23", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 24", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 25", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 26", "Chưa mở"));
       tables.add(new TableModelItem(2, "Bàn 27", "Chưa mở"));
       tables.add(new TableModelItem(3, "Bàn 28", "Chưa mở"));
       
       for (int i = 0; i <= tables.size() - 1; i++) {
           TableItem tableItem = new TableItem(new ImageIcon(getClass().getResource("/assets/ic_tableware.png")), tables.get(i).getName());
           tableItem.setPreferredSize(new Dimension((int) (width / 5.4), (int) (width / 5)));
           tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tableItemMouseClicked(evt);
                }
            });

           bodyLayout.add(tableItem);
       }
       
       bodyLayout.setPreferredSize(new Dimension(width, getNumberRowTableMap(tables) * (int) (width / 4.7)));

       scrollPane = new JScrollPane(bodyLayout, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       scrollPane.setPreferredSize(new Dimension(width, (int) (height / 1.4)));
       JScrollBar bar = scrollPane.getVerticalScrollBar();
       bar.setPreferredSize(new Dimension(10, 0));
       
       /**
        * set food Chooser layout
        */
       foodChooserLayout = new JPanel() {               
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D g2 = (Graphics2D) graphics;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#d7d2cc"), 0, getHeight(), Color.decode("#d7d2cc"));
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
                super.paintComponent(graphics); 
            }
       };
       
       foodChooserLayout.setOpaque(false);
       foodChooserLayout.setPreferredSize(new Dimension(width, (int) (height / 1.4)));
       
       // filter Food Group Layout
       JPanel filterFoodGroupLayout = new JPanel();
       filterFoodGroupLayout.setBackground(new Color(235, 240, 236));
       
       for (int i = 0; i <= 10; i++) {
           RoundedButton btnButton = btnFoodGroupItem("Hải sản");
           btnButton.setRadius(5);
           btnButton.setColor(new Color(109, 213, 247));
           btnButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14));
           btnButton.setForeground(Color.WHITE);
           filterFoodGroupLayout.add(btnButton);
       }
       
       JScrollPane scrollPaneFilterFoodGroup = new JScrollPane(filterFoodGroupLayout, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       scrollPaneFilterFoodGroup.setPreferredSize(new Dimension(width, (int) (height / 14)));
       JScrollBar barFilterFoodGroup = scrollPaneFilterFoodGroup.getHorizontalScrollBar();
       barFilterFoodGroup.setPreferredSize(new Dimension(0, 5));
       
       // food list card
       int foodCardListLayoutHeigth = (int) (height / 1.4 - height / 14);
       JPanel foodCardListLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
       foodCardListLayout.setPreferredSize(new Dimension(width, getNumberRowFoodCard(10) * (int) (foodCardListLayoutHeigth / 2.8)));
       foodCardListLayout.setBackground(new Color(240, 244, 245));
           
       for (int i = 0; i <= 10; i++) {
            FoodCard foodCard = new FoodCard("Lẩu Thập cẩm", "200000", new ImageIcon(getClass().getResource("/assets/img_lauthapcam.jpeg")), new Dimension(width, foodCardListLayoutHeigth));         
                       foodCardListLayout.add(foodCard);
       }
       
       JScrollPane scrollPaneFoodCardList = new JScrollPane(foodCardListLayout, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       scrollPaneFoodCardList.setPreferredSize(new Dimension(width, (int) (height / 1.4 - height / 14)));
       JScrollBar barFoodCardList = scrollPaneFoodCardList.getVerticalScrollBar();
       barFoodCardList.setPreferredSize(new Dimension(7, 0));
       
       foodChooserLayout.add(scrollPaneFilterFoodGroup);
       foodChooserLayout.add(scrollPaneFoodCardList);
       
       foodChooserLayout.setVisible(false);
       add(headerLayout, BorderLayout.NORTH); 
       add(scrollPane, BorderLayout.CENTER);  
       add(foodChooserLayout, BorderLayout.SOUTH); 
    }
    
    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (evt.getClickCount() == 2) {
            foodChooserLayout.setVisible(true);
            scrollPane.setVisible(false);
            btnBack.setVisible(true);
        }
    }  
    
    private void btnOpenTableActionPerformed(ActionEvent evt) {  

    } 
    
    private void btnMoveTableActionPerformed(ActionEvent evt) {  

    } 
       
    private void btnBackActionPerformed(ActionEvent evt) {  
        foodChooserLayout.setVisible(false);
        scrollPane.setVisible(true);
        btnBack.setVisible(false);
    }
            
    private int getNumberRowTableMap(List<TableModelItem> tables) {
        if (tables.size() % 5 == 0) {
            return tables.size() / 5;
        }
        return tables.size() / 5 + 1;
    }
    
    private int getNumberRowFoodCard(int length) {
        if (length % 4 == 0) {
            return length / 5;
        }
        return length / 4 + 1;
    }
    
    private RoundedButton btnFoodGroupItem(String foodGroupName) {
        RoundedButton btnFoodGroup = new RoundedButton();
        btnFoodGroup.setText(foodGroupName);
        return btnFoodGroup;
    }
    
    // Variables declaration - do not modify     
    private GUI.Component.RoundedButton btnOpenTable;
    private GUI.Component.RoundedButton btnMoveTable;
    private GUI.Component.RoundedButton btnBack;
    private javax.swing.JLabel lbDateOpenTable;
    private javax.swing.JLabel lbTableName;
    private javax.swing.JLabel lbTableStatus;
    private javax.swing.JPanel foodChooserLayout;
    private javax.swing.JScrollPane scrollPane;
    // nd of variables declaration 
}
