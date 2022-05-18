package GUI.Component.FoodManager;

import GUI.Component.RoundedButton;
import GUI.Component.RoundedTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FoodInfoListLayout extends JPanel{
    private final Dimension dimension;
    String[][] foods = {
        { "001", "Hải sản", "Lẩu chay", "Nồi", "120000", "" },
        { "002", "Lẩu", "Cá chiên bột", "Đĩa", "200000", "" }
    };
    String[] properties = { "ID", "Tên nhóm món", "Tên món", "Đơn vị tính", "Giá", "Ảnh"};


    public FoodInfoListLayout(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
        setOpaque(false);
    }
    
    private void initComponents() {
        int width = dimension.width;
        int height = dimension.height - dimension.height / 22 - 10;
       
        cbFoodGroup = new JComboBox<>();
        tfFoodName = new RoundedTextField();
        tfUnit = new RoundedTextField();
        tfPrice = new RoundedTextField();
        btnImageChoose = new RoundedButton();
        lbFoodImage = new JLabel();
        btnAddFood = new RoundedButton();
        btnUpdateFood = new RoundedButton();
        btnDeleteFood = new RoundedButton();
        tfFilterFoodName = new RoundedTextField();
        cbFilterFoodGroup = new JComboBox<>();   
        tbFoodInfoList = new JTable(foods, properties);
        
        JPanel infoLayout = new JPanel();
        infoLayout.setPreferredSize(new Dimension(width, (int) (height / 2)));
        infoLayout.setLayout(new BorderLayout());
        /**
         * info Staff Form Layout
         */
        JPanel foodInfoFormLayout = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D g2 = (Graphics2D) graphics;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#FFFFFF"), 0, getHeight(), Color.decode("#A7BFE8"));
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(graphics); 
            }
        };
        foodInfoFormLayout.setOpaque(false);
        foodInfoFormLayout.setBorder(BorderFactory.createTitledBorder(null, "Thông tin món ăn", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font("Helvetica Neue", 1, 22), new Color(65, 72, 204))); // NOI18N
        foodInfoFormLayout.setPreferredSize(new Dimension((int) (width / 1.2), (int) (height / 2)));
        foodInfoFormLayout.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
       
        // lable nhóm món
        gbc.insets = new Insets(0, 0, 35, 10);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;        
        JLabel lbTextFoodGroup = new JLabel("Nhóm món");
        lbTextFoodGroup.setFont(new Font("sansserif", 0, 15));
        lbTextFoodGroup.setForeground(Color.BLACK);
        foodInfoFormLayout.add(lbTextFoodGroup, gbc);
       
        // combobox nhóm món
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 80);
        gbc.anchor = GridBagConstraints.WEST;

        cbFoodGroup.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFoodGroup.setFocusable(false);
        cbFoodGroup.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        cbFoodGroup.setFont(new java.awt.Font("sansserif", 0, 14));
        
        foodInfoFormLayout.add(cbFoodGroup, gbc);
        
        
        // label Tên món ăn
        gbc.gridx = 0;
        gbc.gridy = 1;      
        gbc.insets = new Insets(0, 0, 35, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextFoodName = new JLabel("Tên món ăn");
        lbTextFoodName.setFont(new Font("sansserif", 0, 15));
        lbTextFoodName.setForeground(Color.BLACK);
        foodInfoFormLayout.add(lbTextFoodName, gbc);
              
        // textfield tên món ăn
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 80);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfFoodName.setBorderColor(new java.awt.Color(204, 204, 204));
        tfFoodName.setBorderWidth(1);
        tfFoodName.setHintText("");
        tfFoodName.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfFoodName.setRound(20);
        tfFoodName.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        foodInfoFormLayout.add(tfFoodName, gbc);
        
        // label đơn vị tính
        gbc.gridx = 0;
        gbc.gridy = 2;      
        gbc.insets = new Insets(0, 0, 35, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextUnit = new JLabel("Đơn vị tính");
        lbTextUnit.setFont(new Font("sansserif", 0, 15));
        lbTextUnit.setForeground(Color.BLACK);
        foodInfoFormLayout.add(lbTextUnit, gbc);
              
        // textfield đơn vị tính
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 30, 80);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfUnit.setBorderColor(new java.awt.Color(204, 204, 204));
        tfUnit.setBorderWidth(1);
        tfUnit.setHintText("");
        tfUnit.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfUnit.setRound(20);
        tfUnit.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        foodInfoFormLayout.add(tfUnit, gbc);
        
        // label giá
        gbc.gridx = 0;
        gbc.gridy = 3;      
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextPrice = new JLabel("Giá");
        lbTextPrice.setFont(new Font("sansserif", 0, 15));
        lbTextPrice.setForeground(Color.BLACK);
        foodInfoFormLayout.add(lbTextPrice, gbc);
              
        // textfield giá
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 80);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfPrice.setBorderColor(new java.awt.Color(204, 204, 204));
        tfPrice.setBorderWidth(1);
        tfPrice.setHintText("");
        tfPrice.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfPrice.setRound(20);
        tfPrice.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        foodInfoFormLayout.add(tfPrice, gbc);
        
        
        // image view ảnh món ăn
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        lbFoodImage.setOpaque(true);
        lbFoodImage.setBackground(Color.GRAY);
        lbFoodImage.setPreferredSize(new Dimension((int) (width / 7) , (int) (width / 7)));
        
        foodInfoFormLayout.add(lbFoodImage, gbc);
        
        
        // button chọn ảnh từ thiết bị
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        
        btnImageChoose.setForeground(new java.awt.Color(255, 255, 255));
        btnImageChoose.setText("Chọn ảnh");
        btnImageChoose.setColor(new java.awt.Color(40, 116, 237));
        btnImageChoose.setColorOver(new java.awt.Color(51, 153, 255));
        btnImageChoose.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnImageChoose.setRadius(20);
        btnImageChoose.setBorderPainted(false);
        btnImageChoose.setFocusPainted(false);     
        btnImageChoose.setPreferredSize(new Dimension((int) (width / 7) , 25));
        btnImageChoose.setBorderColor(Color.red);
        btnImageChoose.addActionListener((ActionEvent evt) -> {
            btnImageChooseActionPerformed(evt);
        });
        
        foodInfoFormLayout.add(btnImageChoose, gbc);
        
        /**
         * business Layout
         */
        JPanel businessLayout = new JPanel(new GridBagLayout());
        int businessLayoutWidth = (int) (width - width / 1.2);
        int businessLayoutHeight = (int) (height / 2);
        businessLayout.setBackground(new Color(245, 247, 250));
        businessLayout.setPreferredSize(new Dimension(businessLayoutWidth, businessLayoutHeight));
        GridBagConstraints gbcBusiness = new GridBagConstraints();
        
        // button thêm món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 0);
        
        btnAddFood.setForeground(new java.awt.Color(255, 255, 255));
        btnAddFood.setColor(new java.awt.Color(15, 166, 58));
        btnAddFood.setColorOver(new java.awt.Color(51, 153, 255));
        btnAddFood.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAddFood.setRadius(20);
        btnAddFood.setBorderPainted(false);
        btnAddFood.setFocusPainted(false);     
        btnAddFood.setPreferredSize(new Dimension(businessLayoutWidth / 2 ,businessLayoutWidth / 2));
        btnAddFood.setBorderColor(Color.red);
        ImageIcon iconAddFood = new ImageIcon(getClass().getResource("/assets/ic_add_food.png"));
        Image imgDelete = iconAddFood.getImage();
        Image newimgAdd = imgDelete.getScaledInstance((int) (businessLayoutWidth / 3.2), (int) (businessLayoutWidth / 3.2), java.awt.Image.SCALE_SMOOTH);
        iconAddFood = new ImageIcon(newimgAdd); 
        btnAddFood.setIcon(iconAddFood);
        btnAddFood.addActionListener((ActionEvent evt) -> {
            btnAddFoodActionPerformed(evt);
        });
        
        businessLayout.add(btnAddFood, gbcBusiness);
        
        // label thêm món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 1;      
        gbcBusiness.insets = new Insets(8, 0, 15, 0);
        
        JLabel lbTextAddFood = new JLabel("THÊM");
        lbTextAddFood.setFont(new Font("sansserif", 1, 14));
        lbTextAddFood.setForeground(Color.BLACK);
        businessLayout.add(lbTextAddFood, gbcBusiness);
        
        
        // button cập nhật món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 2;
        gbcBusiness.insets = new Insets(0, 0, 0, 0);
        
        btnUpdateFood.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateFood.setColor(new java.awt.Color(85, 113, 237));
        btnUpdateFood.setColorOver(new java.awt.Color(51, 153, 255));
        btnUpdateFood.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnUpdateFood.setRadius(20);
        btnUpdateFood.setBorderPainted(false);
        btnUpdateFood.setFocusPainted(false);     
        btnUpdateFood.setPreferredSize(new Dimension(businessLayoutWidth / 2 ,businessLayoutWidth / 2));
        btnUpdateFood.setBorderColor(Color.red);
        ImageIcon iconUpdateFood = new ImageIcon(getClass().getResource("/assets/ic_update_food.png"));
        Image imgUpdateFood = iconUpdateFood.getImage();
        Image newimgDelete = imgUpdateFood.getScaledInstance((int) (businessLayoutWidth / 3.2), (int) (businessLayoutWidth / 3.2), java.awt.Image.SCALE_SMOOTH);
        iconUpdateFood = new ImageIcon(newimgDelete); 
        btnUpdateFood.setIcon(iconUpdateFood);
        btnUpdateFood.addActionListener((ActionEvent evt) -> {
            btnUpdateFoodActionPerformed(evt);
        });
        
        businessLayout.add(btnUpdateFood, gbcBusiness);
        
        // label cập nhật món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 3;      
        gbcBusiness.insets = new Insets(8, 0, 15, 0);
        
        JLabel lbTextUpdateFood = new JLabel("CẬP NHẬT");
        lbTextUpdateFood.setFont(new Font("sansserif", 1, 14));
        lbTextUpdateFood.setForeground(Color.BLACK);
        businessLayout.add(lbTextUpdateFood, gbcBusiness);
        
        
        // button xoá món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 4;
        gbcBusiness.insets = new Insets(0, 0, 0, 0);
        
        btnDeleteFood.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteFood.setColor(new java.awt.Color(242, 10, 25));
        btnDeleteFood.setColorOver(new java.awt.Color(51, 153, 255));
        btnDeleteFood.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnDeleteFood.setRadius(20);
        btnDeleteFood.setBorderPainted(false);
        btnDeleteFood.setFocusPainted(false);     
        btnDeleteFood.setPreferredSize(new Dimension(businessLayoutWidth / 2 ,businessLayoutWidth / 2));
        btnDeleteFood.setBorderColor(Color.red);
        ImageIcon iconDeleteFood = new ImageIcon(getClass().getResource("/assets/ic_delete_food.png"));
        Image imgDeleteFood = iconDeleteFood.getImage();
        Image newimgDeleteFood = imgDeleteFood.getScaledInstance((int) (businessLayoutWidth / 3.2), (int) (businessLayoutWidth / 3.2), java.awt.Image.SCALE_SMOOTH);
        iconDeleteFood = new ImageIcon(newimgDeleteFood); 
        btnDeleteFood.setIcon(iconDeleteFood);
        btnDeleteFood.addActionListener((ActionEvent evt) -> {
            btnDeleteFoodActionPerformed(evt);
        });
        
        businessLayout.add(btnDeleteFood, gbcBusiness);
        
        // label xoá món ăn
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 5;      
        gbcBusiness.insets = new Insets(8, 0, 0, 0);
        
        JLabel lbTextDeleteFood = new JLabel("XOÁ");
        lbTextDeleteFood.setFont(new Font("sansserif", 1, 14));
        lbTextDeleteFood.setForeground(Color.BLACK);
        businessLayout.add(lbTextDeleteFood, gbcBusiness);
        
        infoLayout.add(foodInfoFormLayout, BorderLayout.WEST);
        infoLayout.add(businessLayout, BorderLayout.EAST);
        
        /**
         * Filter layout
         */
        JPanel filterLayout = new JPanel(new GridBagLayout());
        int filterLayoutWidth = width;
        int filterLayoutHeight = (int) (height / 10);
        filterLayout.setBackground(new Color(240, 244, 247));
        filterLayout.setPreferredSize(new Dimension(filterLayoutWidth, filterLayoutHeight));
        GridBagConstraints gbcFilter = new GridBagConstraints();
        
        // lable lọc theo nhóm
        gbcFilter.insets = new Insets(0, 0, 0, 10);
        gbcFilter.gridx = 0;
        gbcFilter.gridy = 0;        
        JLabel lbTextFilterFoodGroup = new JLabel("Lọc theo nhóm");
        lbTextFilterFoodGroup.setFont(new Font("sansserif", 0, 15));
        lbTextFilterFoodGroup.setForeground(Color.BLACK);
        filterLayout.add(lbTextFilterFoodGroup, gbcFilter);
        
        // combobox nhóm món
        gbcFilter.gridx = 1;
        gbcFilter.gridy = 0;
        gbcFilter.insets = new Insets(0, 0, 0, 60);
        gbcFilter.anchor = GridBagConstraints.WEST;

        cbFilterFoodGroup.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFilterFoodGroup.setFocusable(false);
        cbFilterFoodGroup.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        cbFilterFoodGroup.setFont(new java.awt.Font("sansserif", 0, 14));
        
        filterLayout.add(cbFilterFoodGroup, gbcFilter);
        
        // lable lọc theo tên
        gbcFilter.insets = new Insets(0, 0, 0, 10);
        gbcFilter.gridx = 2;
        gbcFilter.gridy = 0;        
        JLabel lbTextFilterFoodName = new JLabel("Lọc theo tên");
        lbTextFilterFoodName.setFont(new Font("sansserif", 0, 15));
        lbTextFilterFoodName.setForeground(Color.BLACK);
        filterLayout.add(lbTextFilterFoodName, gbcFilter);
        
        
        // textfield lọc theo tên
        gbcFilter.gridx = 3;
        gbcFilter.gridy = 0;
        gbcFilter.insets = new Insets(0, 0, 0, 0);
        gbcFilter.anchor = GridBagConstraints.WEST;
        
        tfFilterFoodName.setBorderColor(new java.awt.Color(204, 204, 204));
        tfFilterFoodName.setBorderWidth(1);
        tfFilterFoodName.setHintText("Nhập tên cần tìm ...");
        tfFilterFoodName.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfFilterFoodName.setRound(20);
        tfFilterFoodName.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        filterLayout.add(tfFilterFoodName, gbcFilter);
        
        
        /**
         * Table Staff Layout
         */
        JPanel tableLayout = new JPanel();
        tableLayout.setPreferredSize(new Dimension(width, (int) (height - height/2 - height / 10)));
        tableLayout.setLayout(new BorderLayout());
         
//        tbFoodInfoList.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight - bodyHeight / 2 - bodyHeight / 10)));
        tbFoodInfoList.setFocusable(false);
        tbFoodInfoList.setIntercellSpacing(new Dimension(0, 0));
        tbFoodInfoList.setRowHeight(33);
        tbFoodInfoList.setSelectionBackground(Color.lightGray);
        tbFoodInfoList.setShowVerticalLines(true);
        tbFoodInfoList.setFont(new Font("Segoe UI", 0, 13));

        
        tbFoodInfoList.getTableHeader().setOpaque(false);
        tbFoodInfoList.getTableHeader().setReorderingAllowed(false);
        tbFoodInfoList.getTableHeader().setForeground(Color.BLACK);
        tbFoodInfoList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbFoodInfoList.getTableHeader().setPreferredSize(new Dimension(width, 30));
        tbFoodInfoList.getTableHeader().setBackground(Color.red);
       
        // set column size
        // tbFoodInfoList.getColumnModel().getColumn(3).setPreferredWidth(35);

       
        JScrollPane jsp = new JScrollPane(tbFoodInfoList);
        tableLayout.setLayout(new BorderLayout());
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tableLayout.add(jsp, BorderLayout.CENTER);
        
        setPreferredSize(new Dimension(width, height));
        add(infoLayout);
        add(filterLayout);
        add(tableLayout);
    }
    
    private void btnImageChooseActionPerformed(ActionEvent evt) {  
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("files", ImageIO.getReaderFileSuffixes());
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        try{
            BufferedImage bffimg  = null;
            bffimg = ImageIO.read(new File(f.getAbsolutePath()));
            Image img = bffimg.getScaledInstance(lbFoodImage.getWidth(), lbFoodImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img);
            lbFoodImage.setIcon(format);
        } catch(Exception e) {
            // JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    private void btnAddFoodActionPerformed(ActionEvent evt) { 
        
    }
    
    private void btnUpdateFoodActionPerformed(ActionEvent evt) { 
        
    }
    
    private void btnDeleteFoodActionPerformed(ActionEvent evt) { 
        
    }
   
    // Variables declaration - do not modify    
    private javax.swing.JComboBox<String> cbFoodGroup;
    private GUI.Component.RoundedTextField tfFoodName;
    private GUI.Component.RoundedTextField tfUnit;
    private GUI.Component.RoundedTextField tfPrice;
    private javax.swing.JLabel lbFoodImage;
    private GUI.Component.RoundedButton btnImageChoose;
    private GUI.Component.RoundedButton btnAddFood;
    private GUI.Component.RoundedButton btnUpdateFood;
    private GUI.Component.RoundedButton btnDeleteFood;
    private GUI.Component.RoundedTextField tfFilterFoodName;
    private javax.swing.JComboBox<String> cbFilterFoodGroup;
    private javax.swing.JTable tbFoodInfoList;
    // nd of variables declaration 
}
