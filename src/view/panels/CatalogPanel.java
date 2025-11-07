//Complete book catalog with filters
package view.panels;
import java.awt.*;
import javax.swing.*;

public class CatalogPanel extends JPanel {
    public CatalogPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(218 , 168 , 131));
        add(new JLabel("Catalog Panel"));
    }
}
