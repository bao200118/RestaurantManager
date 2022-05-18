    package GUI;

import GUI.Component.Dashboard.DashboardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DashboardJFrame extends JFrame {
    
    public DashboardJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();


    private void initComponents() {
        int width = (int) (size.width * 0.8);
        int height = (int) (size.height * 0.8);

        setPreferredSize(new Dimension(width, height));

        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dashboardLayout = new DashboardLayout(new Dimension(width, height));

        getContentPane().add(dashboardLayout);

        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TEST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TEST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TEST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TEST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new DashboardJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private GUI.Component.Dashboard.DashboardLayout dashboardLayout;
    // End of variables declaration      
}
