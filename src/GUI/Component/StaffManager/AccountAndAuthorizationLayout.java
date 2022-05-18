package GUI.Component.StaffManager;

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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class AccountAndAuthorizationLayout extends JPanel{
    private final Dimension dimension;
    
    String[][] foodGroups = {
        { "NV001", "123456", "Quản lý" },
        { "NV002", "234567", "Nhân viên" }
    };
    String[] properties = { "Tài khoản ", "Mật khẩu", "Quyền đăng nhập"};


    public AccountAndAuthorizationLayout(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
        setOpaque(false);
    }
    
    private void initComponents() {
       int width = dimension.width;
       int height = dimension.height - dimension.height / 22 - 10;
           
       
       tfUserName = new RoundedTextField();
       tfPassword = new RoundedTextField();
       tfSearch = new RoundedTextField();
       btnUpdateAccount = new RoundedButton();
       tbAccount = new JTable(foodGroups, properties);
       cbAuthorization = new JComboBox<>();
       
        /**
         * info Staff Form Layout
         */
        JPanel infoAccountFormLayout = new JPanel() {
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
        infoAccountFormLayout.setOpaque(false);
        infoAccountFormLayout.setBorder(BorderFactory.createTitledBorder(null, "Thông tin tài khoản", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font("Helvetica Neue", 1, 22), new Color(65, 72, 204))); // NOI18N
        infoAccountFormLayout.setPreferredSize(new Dimension(width, height / 3));
        infoAccountFormLayout.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // label tên tài khoản
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.insets = new Insets(0, 0, 35, 20);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextFoodGroupID = new JLabel("Tài khoản");
        lbTextFoodGroupID.setFont(new Font("sansserif", 0, 15));
        lbTextFoodGroupID.setForeground(Color.BLACK);
        infoAccountFormLayout.add(lbTextFoodGroupID, gbc);
              
        // textfield tên tài khoản
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfUserName.setBorderColor(new java.awt.Color(204, 204, 204));
        tfUserName.setBorderWidth(1);
        tfUserName.setHintText("");
        tfUserName.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfUserName.setRound(20);
        tfUserName.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        infoAccountFormLayout.add(tfUserName, gbc);
        
        // label mật khẩu
        gbc.gridx = 0;
        gbc.gridy = 1;      
        gbc.insets = new Insets(0, 0, 35, 20);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextFoodGroupName = new JLabel("Mật khẩu");
        lbTextFoodGroupName.setFont(new Font("sansserif", 0, 15));
        lbTextFoodGroupName.setForeground(Color.BLACK);
        infoAccountFormLayout.add(lbTextFoodGroupName, gbc);
              
        // textfield mật khẩu
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfPassword.setBorderColor(new java.awt.Color(204, 204, 204));
        tfPassword.setBorderWidth(1);
        tfPassword.setHintText("");
        tfPassword.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfPassword.setRound(20);
        tfPassword.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        infoAccountFormLayout.add(tfPassword, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 20);
        gbc.anchor = GridBagConstraints.EAST;
        JLabel lbTextPositionType = new JLabel("Loại chức vụ");
        lbTextPositionType.setFont(new Font("sansserif", 0, 15));
        lbTextPositionType.setForeground(Color.BLACK);
        infoAccountFormLayout.add(lbTextPositionType, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;

        cbAuthorization.setModel(new DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        cbAuthorization.setFocusable(false);
        cbAuthorization.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        cbAuthorization.setFont(new java.awt.Font("sansserif", 0, 14));
        
        infoAccountFormLayout.add(cbAuthorization, gbc);
        
        /**
         * Business Layout
         */
        JPanel businessLayout = new JPanel();
        businessLayout.setPreferredSize(new Dimension(width, (int) (height / 10)));
        businessLayout.setLayout(new GridBagLayout());
        GridBagConstraints gbcBusiness = new GridBagConstraints();
        
        // label tìm kiếm
        gbcBusiness.gridx = 0;
        gbcBusiness.gridy = 0;    
        gbcBusiness.insets = new Insets(0, 0, 0, 10);
        gbcBusiness.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextSearch = new JLabel("Tìm kiếm");
        lbTextSearch.setFont(new Font("sansserif", 0, 15));
        lbTextSearch.setForeground(Color.BLACK);
        businessLayout.add(lbTextSearch, gbcBusiness);
        
        // textfield tìm kiếm
        gbcBusiness.gridx = 1;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 40);
        gbcBusiness.anchor = GridBagConstraints.WEST;
        
        tfSearch.setBorderColor(new java.awt.Color(204, 204, 204));
        tfSearch.setBorderWidth(1);
        tfSearch.setHintText("Nhập tên cần tìm ...");
        tfSearch.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfSearch.setRound(20);
        tfSearch.setPreferredSize(new Dimension((int) (width / 3.5) , 35));
        
        businessLayout.add(tfSearch, gbcBusiness);
        
        
        // button thêm nhân viên
        gbcBusiness.gridx = 2;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 15);
        gbcBusiness.anchor = GridBagConstraints.WEST;
        
        btnUpdateAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateAccount.setText("CẬP NHẬT");
        btnUpdateAccount.setColor(new java.awt.Color(235, 147, 33));
        btnUpdateAccount.setColorOver(new java.awt.Color(51, 153, 255));
        btnUpdateAccount.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnUpdateAccount.setRadius(20);
        btnUpdateAccount.setBorderPainted(false);
        btnUpdateAccount.setFocusPainted(false);     
        btnUpdateAccount.setPreferredSize(new Dimension(width / 6, (int) (width / 15)));
        btnUpdateAccount.setBorderColor(Color.red);
        ImageIcon iconUpdate = new ImageIcon(getClass().getResource("/assets/ic_update.png"));
        Image imgUpdate = iconUpdate.getImage();
        Image newimgUpdate = imgUpdate.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconUpdate = new ImageIcon(newimgUpdate); 
        btnUpdateAccount.setIcon(iconUpdate);
        btnUpdateAccount.addActionListener((ActionEvent evt) -> {
            btnUpdateAccountActionPerformed(evt);
        });
        
        businessLayout.add(btnUpdateAccount, gbcBusiness);
        
        
        /**
         * Table Staff Layout
         */
        JPanel tableLayout = new JPanel();
        tableLayout.setPreferredSize(new Dimension(width, (int) (height - height/3 - height / 10)));
        tableLayout.setLayout(new BorderLayout());
         
//        tbFoodInfoList.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight - bodyHeight / 2 - bodyHeight / 10)));
        tbAccount.setFocusable(false);
        tbAccount.setIntercellSpacing(new Dimension(0, 0));
        tbAccount.setRowHeight(33);
        tbAccount.setSelectionBackground(Color.lightGray);
        tbAccount.setShowVerticalLines(true);
        tbAccount.setFont(new Font("Segoe UI", 0, 13));

        
        tbAccount.getTableHeader().setOpaque(false);
        tbAccount.getTableHeader().setReorderingAllowed(false);
        tbAccount.getTableHeader().setForeground(Color.BLACK);
        tbAccount.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbAccount.getTableHeader().setPreferredSize(new Dimension(width, 30));
        tbAccount.getTableHeader().setBackground(Color.red);
       
        // set column size
        // tbFoodInfoList.getColumnModel().getColumn(3).setPreferredWidth(35);

       
        JScrollPane jsp = new JScrollPane(tbAccount);
        tableLayout.setLayout(new BorderLayout());
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tableLayout.add(jsp, BorderLayout.CENTER);
       
        setPreferredSize(new Dimension(width, height));     
        add(infoAccountFormLayout);
        add(businessLayout);
        add(tableLayout);
    }
    
    private void btnUpdateAccountActionPerformed(ActionEvent evt) {  

    } 
   
    // Variables declaration - do not modify 
    private GUI.Component.RoundedTextField tfUserName;    
    private GUI.Component.RoundedTextField tfPassword; 
    private GUI.Component.RoundedTextField tfSearch;
    private GUI.Component.RoundedButton btnUpdateAccount;
    private javax.swing.JTable tbAccount;
    private javax.swing.JComboBox<String> cbAuthorization;
    // nd of variables declaration 
}
