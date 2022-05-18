
package GUI.Component.StaffManager;

import GUI.Component.RoundedButton;
import GUI.Component.RoundedTextField;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class StaffInfoListLayout extends JPanel{
    private final Dimension dimension;
    String[][] staffs = {
        { "NV001", "Nguyễn Văn A", "12/05/1999", "Nam", "0123456789", "Nhân viên bán hàng", "10000000", "abcdef" },
        { "NV002", "Nguyễn Văn B", "12/05/1999", "Nam", "0123456789", "Nhân viên bán hàng", "10000000", "abcdef" }
    };
    String[] properties = { "Mã nhân viên ", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Chức vụ", "Lương", "Địa chỉ"};

    public StaffInfoListLayout(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
        setOpaque(false);
    }
    
    private void initComponents() {
        int bodyWidth = dimension.width;
        int bodyHeight = dimension.height - dimension.height / 22 - 10;
        
        tfFullName = new RoundedTextField();
        cbPositionType = new JComboBox<>();
        dtpDateOfBirth = new JDateChooser();
        tfPosition = new RoundedTextField();
        tfPhoneNumber = new RoundedTextField();
        tfWage = new RoundedTextField();
        rbMaleGender = new JRadioButton();
        rbFemaleGender = new JRadioButton();
        taAddress = new JTextArea();
        tfSearch = new RoundedTextField();
        btnAddStaff = new RoundedButton();
        btnUpdateStaff = new RoundedButton();
        btnDeleteStaff = new RoundedButton();
        tbStaffInfo = new JTable(staffs, properties);
        
        /**
         * info Staff Form Layout
         */
        JPanel infoStaffFormLayout = new JPanel() {
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
        infoStaffFormLayout.setOpaque(false);
        infoStaffFormLayout.setBorder(BorderFactory.createTitledBorder(null, "Thông tin nhân viên", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, new Font("Helvetica Neue", 1, 22), new Color(65, 72, 204))); // NOI18N
        infoStaffFormLayout.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight / 2)));
        infoStaffFormLayout.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(20, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;        
        JLabel lbTextFullName = new JLabel("Họ và tên");
        lbTextFullName.setFont(new Font("sansserif", 0, 15));
        lbTextFullName.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextFullName, gbc);
       
        // textfield Họ và tên
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 25, 30);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfFullName.setBorderColor(new java.awt.Color(204, 204, 204));
        tfFullName.setBorderWidth(1);
        tfFullName.setHintText("");
        tfFullName.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfFullName.setRound(20);
        tfFullName.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));
        
        infoStaffFormLayout.add(tfFullName, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        JLabel lbTextPositionType = new JLabel("Loại chức vụ");
        lbTextPositionType.setFont(new Font("sansserif", 0, 15));
        lbTextPositionType.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextPositionType, gbc);
       
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 25, 0);
        gbc.anchor = GridBagConstraints.WEST;

        cbPositionType.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPositionType.setFocusable(false);
        cbPositionType.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));
        cbPositionType.setFont(new java.awt.Font("sansserif", 0, 14));
        
        infoStaffFormLayout.add(cbPositionType, gbc);
        
        // label Ngày sinh
        gbc.gridx = 0;
        gbc.gridy = 1;      
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextDateOfBirth = new JLabel("Ngày sinh");
        lbTextDateOfBirth.setFont(new Font("sansserif", 0, 15));
        lbTextDateOfBirth.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextDateOfBirth, gbc);
        
        // date time picker ngày sinh
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 25, 30);
        gbc.anchor = GridBagConstraints.WEST;

        dtpDateOfBirth.setFocusable(false);
        dtpDateOfBirth.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));
        dtpDateOfBirth.setFont(new java.awt.Font("sansserif", 0, 14));
        infoStaffFormLayout.add(dtpDateOfBirth, gbc);
        
        
        // label Chức vụ cụ thể
        gbc.gridx = 2;
        gbc.gridy = 1;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextPosition = new JLabel("Chức vụ");
        lbTextPosition.setFont(new Font("sansserif", 0, 15));
        lbTextPosition.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextPosition, gbc);
        
        // textfield chức vụ cụ thể
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 25, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfPosition.setBorderColor(new java.awt.Color(204, 204, 204));
        tfPosition.setBorderWidth(1);
        tfPosition.setHintText("");
        tfPosition.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfPosition.setRound(20);
        tfPosition.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));      
        infoStaffFormLayout.add(tfPosition, gbc);
        
        // label số điện thoại
        gbc.gridx = 0;
        gbc.gridy = 2;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextPhoneNumber = new JLabel("Số điện thoại");
        lbTextPhoneNumber.setFont(new Font("sansserif", 0, 15));
        lbTextPhoneNumber.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextPhoneNumber, gbc);
        
        // textfield số điện thoại
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 25, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfPhoneNumber.setBorderColor(new java.awt.Color(204, 204, 204));
        tfPhoneNumber.setBorderWidth(1);
        tfPhoneNumber.setHintText("");
        tfPhoneNumber.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfPhoneNumber.setRound(20);
        tfPhoneNumber.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));      
        infoStaffFormLayout.add(tfPhoneNumber, gbc);
        
        // label lương
        gbc.gridx = 2;
        gbc.gridy = 2;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextWage = new JLabel("Lương");
        lbTextWage.setFont(new Font("sansserif", 0, 15));
        lbTextWage.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextWage, gbc);
        
        // textfield lương
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 25, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        tfWage.setBorderColor(new java.awt.Color(204, 204, 204));
        tfWage.setBorderWidth(1);
        tfWage.setHintText("");
        tfWage.setMargin(new java.awt.Insets(2, 10, 2, 6));
        tfWage.setRound(20);
        tfWage.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));      
        infoStaffFormLayout.add(tfWage, gbc);
        
        // label Giới tính
        gbc.gridx = 0;
        gbc.gridy = 3;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextSex = new JLabel("Giới tính");
        lbTextSex.setFont(new Font("sansserif", 0, 15));
        lbTextSex.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextSex, gbc);
        
        
        // group radio button giới tính
        gbc.gridx = 1;
        gbc.gridy = 3;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        JPanel sexLayout = new JPanel();
        GridBagLayout gridBagSexLayout = new GridBagLayout();
        GridBagConstraints gbcSex = new GridBagConstraints();
        sexLayout.setLayout(gridBagSexLayout);
        sexLayout.setBackground(new Color(245, 245, 245));
        ButtonGroup btnGroupSex = new ButtonGroup();
        
        rbMaleGender.setText("Nam");
        rbMaleGender.setFont(new Font("sansserif", 0, 15));
        rbMaleGender.setForeground(Color.BLACK);
        gbcSex.gridx = 0;
        gbcSex.gridy = 0;   
        gbcSex.insets = new Insets(0, 0, 0, 40);
        
        rbFemaleGender.setText("Nữ");
        rbFemaleGender.setFont(new Font("sansserif", 0, 15));
        rbFemaleGender.setForeground(Color.BLACK);
        
        sexLayout.add(rbMaleGender, gbcSex);
        
        gbcSex.gridx = 1;
        gbcSex.gridy = 0;
        gbcSex.insets = new Insets(0, 0, 0, 0);
        sexLayout.add(rbFemaleGender, gbcSex);
        
        btnGroupSex.add(rbMaleGender);
        btnGroupSex.add(rbFemaleGender);
        
        sexLayout.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 50));
        
        infoStaffFormLayout.add(sexLayout, gbc);
        
        // label địa chỉ
        gbc.gridx = 2;
        gbc.gridy = 3;    
        gbc.insets = new Insets(0, 0, 25, 10);
        gbc.anchor = GridBagConstraints.EAST;
        
        JLabel lbTextAddress = new JLabel("Địa chỉ");
        lbTextAddress.setFont(new Font("sansserif", 0, 15));
        lbTextAddress.setForeground(Color.BLACK);
        infoStaffFormLayout.add(lbTextAddress, gbc);
        
        // textarea địa chỉ
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 25, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        taAddress.setFont(new Font("sansserif", 0, 15));
        taAddress.setForeground(Color.BLACK);
        taAddress.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 60));      
        infoStaffFormLayout.add(taAddress, gbc);
        
        
        
        /**
         * Business Layout
         */
        JPanel businessLayout = new JPanel();
        businessLayout.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight / 10)));
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
        tfSearch.setPreferredSize(new Dimension((int) (bodyWidth / 3.5) , 35));
        
        businessLayout.add(tfSearch, gbcBusiness);
        
        
        // button thêm nhân viên
        gbcBusiness.gridx = 2;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 15);
        gbcBusiness.anchor = GridBagConstraints.WEST;
        
        btnAddStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStaff.setText("THÊM");
        btnAddStaff.setColor(new java.awt.Color(6, 208, 214));
        btnAddStaff.setColorOver(new java.awt.Color(51, 153, 255));
        btnAddStaff.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAddStaff.setRadius(20);
        btnAddStaff.setBorderPainted(false);
        btnAddStaff.setFocusPainted(false);     
        btnAddStaff.setPreferredSize(new Dimension(bodyWidth / 6, (int) (bodyHeight / 14)));
        btnAddStaff.setBorderColor(Color.red);
        ImageIcon iconAddPerson = new ImageIcon(getClass().getResource("/assets/ic_add_person.png"));
        Image imgAddPerson = iconAddPerson.getImage();
        Image newimgAddPerson = imgAddPerson.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconAddPerson = new ImageIcon(newimgAddPerson); 
        btnAddStaff.setIcon(iconAddPerson);
        btnAddStaff.addActionListener((ActionEvent evt) -> {
           btnAddStaffActionPerformed(evt);
        });
        
        businessLayout.add(btnAddStaff, gbcBusiness);

        
        // button cập nhật nhân viên
        gbcBusiness.gridx = 3;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 15);
        gbcBusiness.anchor = GridBagConstraints.WEST;
        
        btnUpdateStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStaff.setText("CẬP NHẬT");
        btnUpdateStaff.setColor(new java.awt.Color(235, 147, 33));
        btnUpdateStaff.setColorOver(new java.awt.Color(51, 153, 255));
        btnUpdateStaff.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnUpdateStaff.setRadius(20);
        btnUpdateStaff.setBorderPainted(false);
        btnUpdateStaff.setFocusPainted(false);     
        btnUpdateStaff.setPreferredSize(new Dimension(bodyWidth / 6, (int) (bodyHeight / 14)));
        btnUpdateStaff.setBorderColor(Color.red);
        ImageIcon iconUpdate = new ImageIcon(getClass().getResource("/assets/ic_update.png"));
        Image imgUpdate = iconUpdate.getImage();
        Image newimgUpdate = imgUpdate.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconUpdate = new ImageIcon(newimgUpdate); 
        btnUpdateStaff.setIcon(iconUpdate);
        btnUpdateStaff.addActionListener((ActionEvent evt) -> {
            btnUpdateStaffActionPerformed(evt);
        });
        
        businessLayout.add(btnUpdateStaff, gbcBusiness);
        
        
        // button xoá nhân viên
        gbcBusiness.gridx = 4;
        gbcBusiness.gridy = 0;
        gbcBusiness.insets = new Insets(0, 0, 0, 0);
        gbcBusiness.anchor = GridBagConstraints.WEST;
        
        btnDeleteStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteStaff.setText("XOÁ");
        btnDeleteStaff.setColor(new java.awt.Color(227, 14, 42));
        btnDeleteStaff.setColorOver(new java.awt.Color(51, 153, 255));
        btnDeleteStaff.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnDeleteStaff.setRadius(20);
        btnDeleteStaff.setBorderPainted(false);
        btnDeleteStaff.setFocusPainted(false);     
        btnDeleteStaff.setPreferredSize(new Dimension(bodyWidth / 6, (int) (bodyHeight / 14)));
        btnDeleteStaff.setBorderColor(Color.red);
        ImageIcon iconDelete = new ImageIcon(getClass().getResource("/assets/ic_delete.png"));
        Image imgDelete = iconDelete.getImage();
        Image newimgDelete = imgDelete.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconDelete = new ImageIcon(newimgDelete); 
        btnDeleteStaff.setIcon(iconDelete);
        btnDeleteStaff.addActionListener((ActionEvent evt) -> {
            btnDeleteStaffActionPerformed(evt);
        });
        
        businessLayout.add(btnDeleteStaff, gbcBusiness);
        
        /**
         * Table Staff Layout
         */
        JPanel tableLayout = new JPanel();
        tableLayout.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight - bodyHeight / 2 - bodyHeight / 10)));
        tableLayout.setLayout(new BorderLayout());
         
        tbStaffInfo.setPreferredSize(new Dimension(bodyWidth, (int) (bodyHeight - bodyHeight / 2 - bodyHeight / 10)));
        tbStaffInfo.setFocusable(false);
        tbStaffInfo.setIntercellSpacing(new Dimension(0, 0));
        tbStaffInfo.setRowHeight(33);
        tbStaffInfo.setSelectionBackground(Color.lightGray);
        tbStaffInfo.setShowVerticalLines(true);
        tbStaffInfo.setFont(new Font("Segoe UI", 0, 13));

        
        tbStaffInfo.getTableHeader().setOpaque(false);
        tbStaffInfo.getTableHeader().setReorderingAllowed(false);
        tbStaffInfo.getTableHeader().setForeground(Color.BLACK);
        tbStaffInfo.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbStaffInfo.getTableHeader().setPreferredSize(new Dimension(bodyWidth, 30));
        tbStaffInfo.getTableHeader().setBackground(Color.red);
       
        // set column size
        tbStaffInfo.getColumnModel().getColumn(3).setPreferredWidth(35);
        tbStaffInfo.getColumnModel().getColumn(6).setPreferredWidth(40);
       
        JScrollPane jsp = new JScrollPane(tbStaffInfo);
        tableLayout.setLayout(new BorderLayout());
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tableLayout.add(jsp, BorderLayout.CENTER);
               
        setPreferredSize(new Dimension(bodyWidth, bodyHeight));
        setLayout(new BorderLayout());
        add(infoStaffFormLayout, BorderLayout.NORTH);
        add(businessLayout, BorderLayout.CENTER);
        add(tableLayout, BorderLayout.SOUTH);   
    }
    
    private void btnAddStaffActionPerformed(ActionEvent evt) {  

    } 
    
    private void btnUpdateStaffActionPerformed(ActionEvent evt) {  

    } 
    
    private void btnDeleteStaffActionPerformed(ActionEvent evt) {  

    } 
    
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#FFFFFF"), 0, getHeight(), Color.decode("#A7BFE8"));
        g2.setPaint(gradientPaint);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(graphics); 
    }
    
    // Variables declaration - do not modify   
    private GUI.Component.RoundedTextField tfFullName;
    private javax.swing.JComboBox<String> cbPositionType;
    private com.toedter.calendar.JDateChooser dtpDateOfBirth;
    private GUI.Component.RoundedTextField tfPosition;
    private GUI.Component.RoundedTextField tfPhoneNumber;
    private GUI.Component.RoundedTextField tfWage;
    private javax.swing.JRadioButton rbMaleGender;
    private javax.swing.JRadioButton rbFemaleGender;
    private javax.swing.JTextArea taAddress;
    private GUI.Component.RoundedTextField tfSearch;
    private GUI.Component.RoundedButton btnAddStaff;
    private GUI.Component.RoundedButton btnUpdateStaff;
    private GUI.Component.RoundedButton btnDeleteStaff;
    private javax.swing.JTable tbStaffInfo;
    // nd of variables declaration 
}
