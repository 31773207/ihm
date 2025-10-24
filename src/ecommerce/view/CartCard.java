//the user’s shopping cart
package ecommerce.view;

import javax.swing.*;

public class CartCard extends JPanel {

    public CartCard() {
        setBorder(BorderFactory.createTitledBorder("🛒 My Cart"));
        add(new JLabel("Your cart is empty!"));
    }
}
