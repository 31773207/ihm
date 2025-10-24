//login section
package ecommerce.view;

import javax.swing.*;

public class LoginCard extends JPanel {

    public LoginCard() {
        setBorder(BorderFactory.createTitledBorder("🔑 Login"));
        add(new JLabel("Username:"));
        add(new JTextField(10));
        add(new JLabel("Password:"));
        add(new JPasswordField(10));
        add(new JButton("Login"));
    }
}
