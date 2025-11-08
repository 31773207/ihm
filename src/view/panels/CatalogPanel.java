//Complete book catalog with filters
package view.panels;
import java.awt.*;
import javax.swing.*;

public class CatalogPanel extends JPanel {
    public CatalogPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(218 , 168 , 131));
        add(new JLabel("Catalog Panel"));
        setLayout(new GridLayout(3, 3, 15, 15));

        for (int i = 1; i <= 9; i++) {
            JLabel book = new JLabel("Book " + i, SwingConstants.CENTER);
            book.setOpaque(true);
            book.setBackground(Color.WHITE);
            book.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            add(book);
        }
    }
}
