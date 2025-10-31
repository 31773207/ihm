//shows the shopping cart with all items.
package view.panels;
import java.awt.*;
import javax.swing.*;

public class CartPanel extends JPanel {
    public CartPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.GREEN);
        add(new JLabel("Cart Panel"));
    }
}

