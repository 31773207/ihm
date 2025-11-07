package view.panels;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {

    public HomePanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(212, 162, 112));
        setLayout(new GridLayout(1, 2)); // 2 colonnes : left / right

        // ===== Left Panel =====
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(247, 234, 224));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(120, 50, 50, 40));

        // Title
        JLabel title = new JLabel("<html>Discover Literary <br> Treasures</html>");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setForeground(new Color(110, 60, 16));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Description
        JLabel desc = new JLabel("<html>Immerse yourself in a curated collection of timeless classics and contemporary masterpieces. "
                + "Every book opens a door to new worlds of knowledge and imagination. "
                + "Join thousands of readers who have found their literary sanctuary with us.</html>");
        desc.setFont(new Font("SansSerif", Font.PLAIN, 20));
        desc.setForeground(new Color(110, 60, 16));
        desc.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        buttonPanel.setOpaque(false);

        JButton startReading = new JButton("Start Reading");
                startReading.setFont(new Font("SansSerif", Font.BOLD, 20));
        startReading.setBackground(new Color(110, 60, 16));
        startReading.setForeground(Color.WHITE);
        startReading.setFocusPainted(false);
        startReading.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton freeClassics = new JButton("Free Classics");
            freeClassics.setFont(new Font("SansSerif", Font.BOLD, 20));
        freeClassics.setBackground(new Color(222, 198, 180));
        freeClassics.setForeground(new Color(110, 60, 16));
        freeClassics.setFocusPainted(false);
        freeClassics.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(246, 211, 185), 1),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
        ));

        buttonPanel.add(startReading);
        buttonPanel.add(freeClassics);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Stats panel (compact)
         JPanel statsPanel = new JPanel(new GridLayout(1, 3, 10, 15)); // 1 ligne, 3 colonnes 
         statsPanel.setOpaque(false); 
         statsPanel.add(createStat("📚 10,000+", "Books Available")); 
         statsPanel.add(createStat("😊 25,000+", "Happy Readers")); 
         statsPanel.add(createStat("📖 50+", "Genres")); 
         statsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ============================= Add components to left panel===========================
        leftPanel.add(title);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(desc);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(Box.createVerticalGlue()); // Ce glue va prendre tout l’espace restant
        leftPanel.add(buttonPanel); // Ajouter les boutons **en bas**
        //leftPanel.add(Box.createVerticalStrut(40));
        leftPanel.add(statsPanel);


        // ============================================================= Right Panel ===============================================================
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(245, 245, 245));

        JLabel bookPlaceholder = new JLabel("📚 Book Collection Image", SwingConstants.CENTER);
        bookPlaceholder.setFont(new Font("SansSerif", Font.PLAIN, 16));
        bookPlaceholder.setForeground(new Color(189, 195, 199));
        rightPanel.add(bookPlaceholder, BorderLayout.CENTER);

        // Add left and right panels to main panel
        add(leftPanel);
        add(rightPanel);
    }

    // Compact method to create a stat panel
    private JPanel createStat(String value, String label) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setOpaque(false);

        JLabel v = new JLabel(value);
        v.setFont(new Font("SansSerif", Font.BOLD, 35));
        v.setForeground(new Color(110, 60, 16));
        v.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel l = new JLabel(label);
        l.setFont(new Font("SansSerif", Font.PLAIN, 20));
        l.setForeground(new Color(110, 60, 16));
        l.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(v);
        p.add(Box.createVerticalStrut(5));
        p.add(l);

        return p;
    }
}




