package view.panels;
import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(Color.LIGHT_GRAY);
        //setLayout(new BorderLayout()); // simple, one column layout
        setLayout(new GridLayout(1, 2)); // 🟩 Divide screen into 2 equal columns

        // Container panel for left-aligned content
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));//makes components stack vertically, like a column.Perfect for headings and paragraphs.
        content.setBackground(Color.BLUE);
        content.setBorder(BorderFactory.createEmptyBorder(60, 40, 60, 40)); // add padding (top, left, bottom, right)

        // Heading
        JLabel heading = new JLabel("<html>Discover Literary Tresures </html>");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setForeground(new Color(139, 69, 19)); // brown
        heading.setAlignmentX(Component.LEFT_ALIGNMENT); //Aligns the heading to the left inside the BoxLayout.

        // Paragraph
        JLabel paragraph1 = new JLabel("<html>Immerse yourself in a curated collection of timeless classics<br>and contemporary masterpieces. Every book opens<br>a door to new worlds of knowledge and imagination.</html>");
        paragraph1.setFont(new Font("Arial", Font.PLAIN, 18));
        paragraph1.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel paragraph2 = new JLabel("<html>Join thousands of readers who have found<br>their literary sanctuary with us.</html>");
        paragraph2.setFont(new Font("Arial", Font.PLAIN, 18));
        paragraph2.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add everything to content panel
        content.add(heading);
        content.add(Box.createRigidArea(new Dimension(0, 20))); // space after heading Basically, it’s like adding margin or padding in HTML.
        content.add(paragraph1);
        content.add(Box.createRigidArea(new Dimension(0, 5)));
        content.add(paragraph2);

         // 🟧 RIGHT SIDE - Image placeholder
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(new JLabel("📘 Image here later"));

        // Add both panels to HomePanel
        add(content);
        add(imagePanel);
    }
}
