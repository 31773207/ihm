//Author profiles and their books
package view.panels;
import java.awt.*;
import javax.swing.*;

public class AuthorsPanel extends JPanel {
    public AuthorsPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(238 , 175 , 127));
        add(new JLabel("Authors Panel"));
        setLayout(new GridLayout(2, 2, 15, 15));

        add(createAuthorCard("J.K. Rowling", "resources/icons/rowling.jpg"));
        add(createAuthorCard("Stephen King", "resources/icons/king.jpg"));
        add(createAuthorCard("Agatha Christie", "resources/icons/agatha.jpg"));
        add(createAuthorCard("George Orwell", "resources/icons/orwell.jpg"));
    }

    private JPanel createAuthorCard(String name, String imgPath) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel img = new JLabel(new ImageIcon(imgPath));
        JLabel info = new JLabel(name, SwingConstants.CENTER);
        info.setFont(new Font("SansSerif", Font.BOLD, 14));

        card.add(img, BorderLayout.CENTER);
        card.add(info, BorderLayout.SOUTH);
        return card;
    
    }
}
