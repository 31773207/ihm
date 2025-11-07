//Author profiles and their books
package view.panels;
import java.awt.*;
import javax.swing.*;

public class AuthorsPanel extends JPanel {
    public AuthorsPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(238 , 175 , 127));
        add(new JLabel("Authors Panel"));
    }
}
