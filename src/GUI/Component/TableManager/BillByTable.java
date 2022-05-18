package GUI.Component.TableManager;

import GUI.Component.RoundedButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class BillByTable extends JPanel{
 
    private final Dimension dimension;
    String[][] billDetailItem = {
         { "Bia 333", "3", "12000", "36000" },
    };
    String[] properties = { "Tên món", "SL", "Đơn giá", "Thành tiền"};

    public BillByTable(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
//        setOpaque(false);


    }
    
    private void initComponents() {
       int width = dimension.width;
       int height = dimension.height;
       
       BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
       setLayout(boxLayout);
       setPreferredSize(new Dimension(width, height - height / 22 - 10));
       
       tbBillDetails = new JTable(billDetailItem, properties);
       lbTitle = new JLabel("HOÁ ĐƠN THEO BÀN");
       billDetailsLayout = new JPanel();
       adjustNumberOfFoodsLayout = new JPanel();
       btnDecreaseAmountFood = new JButton();       
       btnIncreaseAmountFood = new JButton();    
       btnDeleteFood = new JButton();
       totalPayableLayout = new JPanel();
       JLabel lbTextProvisionalAmount = new JLabel("Tổng tiền");
       tfProvisionalAmount = new JTextField();
       JLabel lbTextUnit1 = new JLabel("Đồng");
       JLabel lbTextUnit2 = new JLabel("Đồng");
       JLabel lbTextUnit3 = new JLabel("%");
       JLabel lbTextPromotion1 = new JLabel("Khuyến mãi (đồng)");
       JLabel lbTextPromotion2 = new JLabel("Khuyến mãi (%)");
       tfPromotionDongUnit = new JTextField();
       tfPromotionPercentUnit = new JTextField();
       JLabel lbTextTotalPayable = new JLabel("Thành tiền:");
       lbTotalPayable = new JLabel("250.000");
       JLabel lbTextTotalPayableUnit = new JLabel("Đồng");
       paymentLayout = new JPanel();
       btnPayment = new RoundedButton();
       
       // title container 
       titleLayout = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D g2 = (Graphics2D) graphics;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#a8c0ff"), 0, getHeight(), Color.decode("#3f2b96"));
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(graphics);     
            };
       };
       
       titleLayout.setLayout(new BorderLayout());
       titleLayout.setOpaque(false);
       titleLayout.setPreferredSize(new Dimension(width, (int)(0.15 * height)));      
       
       lbTitle.setHorizontalAlignment(JLabel.CENTER);
       lbTitle.setFont(new Font("sansserif", 1, 16));
       lbTitle.setForeground(Color.WHITE);

       titleLayout.add(lbTitle, BorderLayout.CENTER);
       
           
       /**
        view bill detail by table   
        */      
       
       tbBillDetails.setPreferredSize(new Dimension(width / 2, height - height / 8));
       tbBillDetails.setFocusable(false);
       tbBillDetails.setIntercellSpacing(new Dimension(0, 0));
       tbBillDetails.setRowHeight(33);
       tbBillDetails.setSelectionBackground(Color.lightGray);
       tbBillDetails.setShowVerticalLines(false);
       tbBillDetails.setFont(new Font("Segoe UI", 0, 12));

        
       tbBillDetails.getTableHeader().setOpaque(false);
       tbBillDetails.getTableHeader().setReorderingAllowed(false);
       tbBillDetails.getTableHeader().setForeground(Color.BLACK);
       tbBillDetails.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
       tbBillDetails.getTableHeader().setPreferredSize(new Dimension(width, 30));
       tbBillDetails.getTableHeader().setBackground(Color.red);
       
  
       // set column size
       tbBillDetails.getColumnModel().getColumn(1).setPreferredWidth(30);
       
       JScrollPane jsp = new JScrollPane(tbBillDetails);
       billDetailsLayout.setLayout(new BorderLayout());
       billDetailsLayout.setPreferredSize(new Dimension(width, (int) (0.4 * height)));
       jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

       billDetailsLayout.add(jsp, BorderLayout.CENTER);
       
       /**
        * set layout adjust the number of foods
        */ 
       //set properties for button decrease amount food
       btnDecreaseAmountFood.setBackground(new Color(0, 0, 0, 0));
       btnDecreaseAmountFood.setBorderPainted(false);
       btnDecreaseAmountFood.setFocusable(false);
       ImageIcon iconMinus = new ImageIcon(getClass().getResource("/assets/ic_minus.png"));
       Image imgMinus = iconMinus.getImage();
       Image newimgMinus = imgMinus.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
       iconMinus = new ImageIcon(newimgMinus);  
       btnDecreaseAmountFood.setIcon(iconMinus);
       btnDecreaseAmountFood.setPreferredSize(new Dimension(30 ,30));
       
       //set properties for button increase amount food
       btnIncreaseAmountFood.setBackground(new Color(0, 0, 0, 0));
       btnIncreaseAmountFood.setBorderPainted(false);
       btnIncreaseAmountFood.setFocusable(false);
       ImageIcon iconPlus = new ImageIcon(getClass().getResource("/assets/ic_plus.png"));
       Image imgPlus = iconPlus.getImage();
       Image newimgPlus = imgPlus.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
       iconPlus = new ImageIcon(newimgPlus);  
       btnIncreaseAmountFood.setIcon(iconPlus);
       btnIncreaseAmountFood.setPreferredSize(new Dimension(30 ,30));
       
       //set properties for button delete food
       btnDeleteFood.setBackground(new Color(0, 0, 0, 0));
       btnDeleteFood.setBorderPainted(false);
       btnDeleteFood.setFocusable(false);
       ImageIcon iconDelete = new ImageIcon(getClass().getResource("/assets/ic_delete.png"));
       Image imgDetete = iconDelete.getImage();
       Image newimgDelete = imgDetete.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
       iconDelete = new ImageIcon(newimgDelete);  
       btnDeleteFood.setIcon(iconDelete);
       btnDeleteFood.setPreferredSize(new Dimension(30 ,30));
       
       FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
       adjustNumberOfFoodsLayout.setLayout(flowLayout);
       adjustNumberOfFoodsLayout.setPreferredSize(new Dimension(width, (int) (0.06 * height)));
       adjustNumberOfFoodsLayout.add(btnIncreaseAmountFood);
       adjustNumberOfFoodsLayout.add(btnDecreaseAmountFood);
       adjustNumberOfFoodsLayout.add(btnDeleteFood);
       
       /**
        * set layout provisional Amount
        */
       provisionalAmountLayout = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                Graphics2D g2 = (Graphics2D) graphics;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#485563"), 0, getHeight(), Color.decode("#29323c"));
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
                super.paintComponent(graphics);     
            };
       }; 
       
       // row 1 of provisional Amount Layout
       lbTextProvisionalAmount.setFont(new Font("Segoe UI", 0, 14));
       lbTextProvisionalAmount.setForeground(Color.WHITE);
       lbTextProvisionalAmount.setPreferredSize(new Dimension((int) (0.5 * width), 20));
       
       tfProvisionalAmount.setPreferredSize(new Dimension((int) (0.3 * width), 20));
       tfProvisionalAmount.setEditable(false);
       
       lbTextUnit1.setFont(new Font("Segoe UI", 0, 14));
       lbTextUnit1.setForeground(Color.WHITE);
       lbTextUnit1.setPreferredSize(new Dimension((int) (0.2 * width), 20));
       
       JPanel jPanel1 = new JPanel();
       BoxLayout boxLayout1 = new BoxLayout(jPanel1, BoxLayout.X_AXIS);    
       jPanel1.setLayout(boxLayout1);
       jPanel1.setBackground(new Color(51, 51, 51));
       
       jPanel1.add(lbTextProvisionalAmount);
       jPanel1.add(tfProvisionalAmount);
       jPanel1.add(lbTextUnit1);
       
       // row 2 of provisional Amount Layout
       lbTextPromotion1.setFont(new Font("Segoe UI", 0, 14));
       lbTextPromotion1.setForeground(Color.WHITE);
       lbTextPromotion1.setPreferredSize(new Dimension((int) (0.5 * width), 20));
       
       tfPromotionDongUnit.setPreferredSize(new Dimension((int) (0.3 * width), 20));
       
       lbTextUnit2.setFont(new Font("Segoe UI", 0, 14));
       lbTextUnit2.setForeground(Color.WHITE);
       lbTextUnit2.setPreferredSize(new Dimension((int) (0.2 * width), 20));
       
       JPanel jPanel2 = new JPanel();
       BoxLayout boxLayout2 = new BoxLayout(jPanel2, BoxLayout.X_AXIS);    
       jPanel2.setLayout(boxLayout2);
       jPanel2.setBackground(new Color(51, 51, 51));
       
       jPanel2.add(lbTextPromotion1);
       jPanel2.add(tfPromotionDongUnit);
       jPanel2.add(lbTextUnit2);
       
        // row 3 of provisional Amount Layout
       lbTextPromotion2.setFont(new Font("Segoe UI", 0, 14));
       lbTextPromotion2.setForeground(Color.WHITE);
       lbTextPromotion2.setPreferredSize(new Dimension((int) (0.5 * width), 20));
       
       lbTextUnit3.setFont(new Font("Segoe UI", 0, 14));
       lbTextUnit3.setForeground(Color.WHITE);
       lbTextUnit3.setPreferredSize(new Dimension((int) (0.2 * width), 20));
       
       tfPromotionPercentUnit.setPreferredSize(new Dimension((int) (0.3 * width), 20));

       
       JPanel jPanel3 = new JPanel();
       BoxLayout boxLayout3 = new BoxLayout(jPanel3, BoxLayout.X_AXIS);    
       jPanel3.setLayout(boxLayout3);
       jPanel3.setBackground(new Color(51, 51, 51));
       
       jPanel3.add(lbTextPromotion2);
       jPanel3.add(tfPromotionPercentUnit);
       jPanel3.add(lbTextUnit3);
       
       provisionalAmountLayout.add(jPanel1);
       provisionalAmountLayout.add(jPanel2);
       provisionalAmountLayout.add(jPanel3);

       provisionalAmountLayout.setLayout(new BoxLayout(provisionalAmountLayout, BoxLayout.Y_AXIS));
       provisionalAmountLayout.setPreferredSize(new Dimension(width, (int) (0.15 * height)));
       provisionalAmountLayout.setOpaque(false);
       
       /**
        * layout provisional Amount
        */
       totalPayableLayout.setLayout(new BorderLayout());
       
       lbTextTotalPayable.setHorizontalAlignment(JLabel.CENTER);
       lbTextTotalPayable.setFont(new Font("sansserif", 1, 18));
       lbTextTotalPayable.setForeground(Color.WHITE);
       lbTextTotalPayable.setPreferredSize(new Dimension((int) (0.45 * width), 10));
       
       lbTotalPayable.setHorizontalAlignment(JLabel.CENTER);
       lbTotalPayable.setFont(new Font("sansserif", 1, 14));
       lbTotalPayable.setForeground(Color.BLUE);
       lbTotalPayable.setPreferredSize(new Dimension((int) (0.3 * width), 10));
     
       lbTextTotalPayableUnit.setHorizontalAlignment(JLabel.CENTER);
       lbTextTotalPayableUnit.setFont(new Font("sansserif", 1, 14));
       lbTextTotalPayableUnit.setForeground(Color.BLUE);
       lbTextTotalPayableUnit.setPreferredSize(new Dimension((int) (0.25 * width), 10));

       totalPayableLayout.add(lbTextTotalPayable, BorderLayout.WEST);
       totalPayableLayout.add(lbTotalPayable, BorderLayout.CENTER);
       totalPayableLayout.add(lbTextTotalPayableUnit, BorderLayout.EAST);
       
       
       totalPayableLayout.setPreferredSize(new Dimension(width, (int) (0.12 * height)));
       totalPayableLayout.setBackground(Color.GRAY);
       
       /**
        * set payment Layout
        */
       
              // set properties for btnTableManagerTab
       btnPayment.setForeground(new java.awt.Color(255, 255, 255));
       btnPayment.setText("THANH TOÁN");
       btnPayment.setColor(new Color(0, 204, 204));
       btnPayment.setColorOver(new java.awt.Color(0, 153, 153));
       btnPayment.setFont(new java.awt.Font("Helvetica Neue", Font.BOLD, 20)); // NOI18N
       btnPayment.setRadius(10);
       btnPayment.setBorderPainted(false);
       btnPayment.setFocusPainted(false);
       btnPayment.setPreferredSize(new Dimension(width , (int) (0.08 * height)));
       btnPayment.setBorderColor(Color.red);
       btnPayment.addActionListener((ActionEvent evt) -> {
           btnPaymentActionPerformed(evt);
       });

       paymentLayout.setPreferredSize(new Dimension(width, (int) (0.09 * height)));
       paymentLayout.add(btnPayment);
       
       add(titleLayout);
       add(billDetailsLayout);
       add(adjustNumberOfFoodsLayout);
       add(provisionalAmountLayout);
       add(totalPayableLayout);
       add(paymentLayout);
    }
    
    private void btnPaymentActionPerformed(ActionEvent evt) {  
    } 
    
    // Variables declaration - do not modify     
    private javax.swing.JPanel titleLayout;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTable tbBillDetails;
    private javax.swing.JPanel billDetailsLayout;
    private javax.swing.JPanel adjustNumberOfFoodsLayout;
    private javax.swing.JButton btnIncreaseAmountFood;
    private javax.swing.JButton btnDecreaseAmountFood;
    private javax.swing.JButton btnDeleteFood;
    private javax.swing.JPanel provisionalAmountLayout;
    private javax.swing.JPanel totalPayableLayout;
    private javax.swing.JTextField tfProvisionalAmount;
    private javax.swing.JTextField tfPromotionDongUnit;
    private javax.swing.JTextField tfPromotionPercentUnit;
    private javax.swing.JLabel lbTotalPayable;
    private javax.swing.JPanel paymentLayout;
    private GUI.Component.RoundedButton btnPayment;
    
    // nd of variables declaration 
}

