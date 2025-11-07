//Purchase and payment process
package view.panels;
import java.awt.*;
import javax.swing.*;

public class CheckoutPanel extends JPanel {
    public CheckoutPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(Color.GRAY);
        add(new JLabel("Checkout Panel"));
    }
}

