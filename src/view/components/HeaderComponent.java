package view.components;

import javax.swing.*;
import java.awt.*;

public class HeaderComponent extends JPanel {
    public HeaderComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setAlignmentX(Component.LEFT_ALIGNMENT);

        // Main title
        JLabel mainTitle = new JLabel("Bookify");
        mainTitle.setFont(new Font("Serif", Font.BOLD, 42));
        mainTitle.setForeground(new Color(30, 30, 30));
        mainTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Subtitle
        JLabel subTitle = new JLabel("Literary Excellence");
        subTitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subTitle.setForeground(new Color(100, 100, 100));
        subTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(mainTitle);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(subTitle);
    }
}