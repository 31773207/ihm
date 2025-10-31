//Author profiles and their books
package view.panels;
import java.awt.*;
import javax.swing.*;

public class AuthorsPanel extends JPanel {
    public AuthorsPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.MAGENTA);
        add(new JLabel("Authors Panel"));
    }
}
