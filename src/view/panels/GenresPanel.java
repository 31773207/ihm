//see Book categories browsing page 
package view.panels;
import java.awt.*;
import javax.swing.*;

public class GenresPanel extends JPanel {
    public GenresPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.ORANGE);
        add(new JLabel("Genres Panel"));
    }
}
