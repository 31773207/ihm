package view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;
import model.Genre;

public class GenreCard extends JPanel {

    public GenreCard(Genre genre) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150, 200));
        setBackground(new Color(230, 230, 250));
        setBorder(BorderFactory.createLineBorder(new Color(110, 60, 16), 2));

        // ===== IMAGE =====
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);

        java.net.URL imgURL = getClass().getResource(genre.getImagePath());
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaled = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        } else {
            imageLabel.setText("No Image");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(120, 120));
        }

        // ===== NAME =====
        JLabel nameLabel = new JLabel(genre.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(imageLabel);
        add(Box.createVerticalStrut(10));
        add(nameLabel);
    }
}
