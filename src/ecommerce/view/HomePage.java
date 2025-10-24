package ecommerce.view;

import javax.swing.*;

public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Book Shop");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Add panels
        content.add(new CartCard());
        content.add(new LoginCard());

        JScrollPane scrollPane = new JScrollPane(content);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}

//هنا كينادي على كل “card” باش يتعرض واحد بعد الآخر (بحال scroll في الكونسول).