//Complete book catalog with filters
package view.panels;
import java.awt.*;
import javax.swing.*;

public class CatalogPanel extends JPanel {
    public CatalogPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.CYAN);
        add(new JLabel("Catalog Panel"));
    }
}
