//see Book categories browsing page 
package view.panels;
import java.awt.*;
import javax.swing.*;

public class GenresPanel extends JPanel {
    public GenresPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(245 , 205 , 175));
        add(new JLabel("Genres Panel"));
    }
}
