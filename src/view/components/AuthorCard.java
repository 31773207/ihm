package view.components;

import java.awt.*;
import javax.swing.*;
import model.Author;

public class AuthorCard extends JPanel {
    public AuthorCard(Author author) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150, 200));
        setBackground(new Color(230, 230, 250));
        setBorder(BorderFactory.createLineBorder(new Color(110, 60, 16), 2));

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        java.net.URL imgURL = getClass().getResource(author.getImagePath());
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaled = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        } else {
            imageLabel.setText("No Image");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(120, 120));
        }

        JLabel nameLabel = new JLabel(author.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(imageLabel);
        add(Box.createVerticalStrut(10));
        add(nameLabel);
    }
}
