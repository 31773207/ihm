package view.components; // ou panels selon structure dyalek

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import model.Book;

public class BookCard extends JPanel {

    public BookCard(Book book) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new MatteBorder(2, 2, 2, 2, Color.white));
        setBackground(new Color(238, 195, 162));
        setPreferredSize(new Dimension(300, 520));
        setOpaque(true);

        // ======================== Image ===================================
        JLabel bookImage = new JLabel();
        bookImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookImage.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));

        java.net.URL imgURL = getClass().getResource(book.getImagePath());
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
            bookImage.setIcon(new ImageIcon(img));
            bookImage.setPreferredSize(new Dimension(250, 300));
        } else {
            bookImage.setText("No Image");
            bookImage.setHorizontalAlignment(SwingConstants.CENTER);
            bookImage.setPreferredSize(new Dimension(250, 300));
        }

        // =================== Title ==================
        JLabel bookTitle = new JLabel(book.getTitle());
        bookTitle.setFont(new Font("Arial", Font.BOLD, 18));
        bookTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bookTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===================== Author ===================
        JLabel author = new JLabel(book.getAuthor());
        author.setFont(new Font("Arial", Font.ITALIC, 15));
        author.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ========================= Price =========================
        JLabel price = new JLabel("$" + book.getPrice());
        price.setFont(new Font("Arial", Font.BOLD, 20));
        price.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ==================== Description ======================
        JTextArea description = new JTextArea(book.getDescription());
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setFont(new Font("Arial", Font.PLAIN, 15));
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        description.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        description.setOpaque(false);
        description.setBackground(new Color(0,0,0,0));

        // =========================== Button =============================
        JButton addToCart = new JButton("Add to Cart");
        addToCart.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCart.setFont(new Font("SansSerif", Font.BOLD, 16));
        addToCart.setBackground(new Color(110, 60, 16));
        addToCart.setForeground(Color.WHITE);
        addToCart.setFocusPainted(false);
        addToCart.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addToCart.setPreferredSize(new Dimension(200, 40));

        // ============================ Add all components ===================
        add(bookImage);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(bookTitle);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(author);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(description);
        add(price);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(addToCart);
    }
}
