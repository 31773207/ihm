package view.panels;
import java.awt.*;
import javax.swing.*;

public class FeaturedPanel extends JPanel {
    public FeaturedPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.PINK);
        add(new JLabel("Featured Panel"));
    }
}




