// FooterPanel.java
package view.panels;

import java.awt.*;
import javax.swing.*;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        setBackground(new Color(110, 60, 16));
        setPreferredSize(new Dimension(900, 120));
        setLayout(new BorderLayout());

        // ===== Left: Brand + Social =====
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JLabel brand = new JLabel("Bookify");
        brand.setForeground(Color.WHITE);
        brand.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel social = new JLabel("🐦 Twitter  |  📱 WhatsApp  |  📘 Instagram");
        social.setForeground(Color.WHITE);
        social.setFont(new Font("Arial", Font.PLAIN, 14));
                left.add(Box.createRigidArea(new Dimension(0,30)));
        left.add(brand);
        left.add(Box.createRigidArea(new Dimension(0,5)));
        left.add(social);

        // ===== Center: Navigation =====
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JLabel navTitle = new JLabel("Navigation");
        navTitle.setForeground(Color.WHITE);
        navTitle.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel links = new JLabel("Home  |  Featured  |  Catalog  |  Authors  |  Genres");
        links.setForeground(Color.WHITE);
        links.setFont(new Font("Arial", Font.PLAIN, 14));
                        center.add(Box.createRigidArea(new Dimension(0,30)));
        center.add(navTitle);
        center.add(Box.createRigidArea(new Dimension(0,5)));
        center.add(links);

        // ===== Right: Contact =====
        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        JLabel contactTitle = new JLabel("Contact");
        contactTitle.setForeground(Color.WHITE);
        contactTitle.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel contactInfo = new JLabel("Email: info@bookify.com | Phone: 0123456789");
        contactInfo.setForeground(Color.WHITE);
        contactInfo.setFont(new Font("Arial", Font.PLAIN, 14));
                        right.add(Box.createRigidArea(new Dimension(0,30)));
        right.add(contactTitle);
        right.add(Box.createRigidArea(new Dimension(0,5)));
        right.add(contactInfo);

        // Add to footer
        add(left, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);

        // ===== Bottom part: Legal text =====
        JLabel legalText = new JLabel("Cultivating the love of reading together | © 2025 Bookify - All Rights Reserved.", SwingConstants.CENTER);
        legalText.setForeground(Color.WHITE);
        legalText.setFont(new Font("Arial", Font.PLAIN, 14));
        legalText.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        //add(topPanel, BorderLayout.CENTER);
        add(legalText, BorderLayout.SOUTH);
    }
}


