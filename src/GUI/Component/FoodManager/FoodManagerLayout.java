package GUI.Component.FoodManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FoodManagerLayout extends JPanel{
    private final Dimension dimension;

    public FoodManagerLayout(Dimension dimension) {
        this.dimension = dimension;
        initComponents();
        setOpaque(false);
    }
    
    private void initComponents() {
        int bodyWidth = dimension.width;
        int bodyHeight = dimension.height;
        
        foodInfoListLayout = new FoodInfoListLayout(dimension);
        
        setPreferredSize(new Dimension(bodyWidth, bodyHeight - bodyHeight / 22 - 10));  
        setBackground(new Color(0, 0, 0, 0));
        setLayout(new BorderLayout());
        
        show(foodInfoListLayout);
        
    }
      
//    @Override
//    protected void paintComponent(Graphics graphics) {
//        Graphics2D g2 = (Graphics2D) graphics;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#6190E8"), 0, getHeight(), Color.decode("#A7BFE8"));
//        g2.setPaint(gradientPaint);
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
//        super.paintComponent(graphics); 
//    }
    
    public void show(Component com) {
        removeAll();
        add(com);
        repaint();
        revalidate();
    }
    
    private GUI.Component.FoodManager.FoodInfoListLayout foodInfoListLayout;
}
