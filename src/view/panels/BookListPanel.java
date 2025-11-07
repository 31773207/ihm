package view.panels;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Book;

public class BookListPanel extends JPanel {

    public BookListPanel(List<Book> books) {
        setBackground(new Color(247, 234, 224));  // soft beige background
        setLayout(new GridLayout(0, 3, 20, 20));  // auto rows, 3 columns, gaps

        // add a small margin
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add each book as a card
        for (Book b : books) {
            add(createBookCard(b));
        }
    }

    // Create a small card for each book
    private JPanel createBookCard(Book book) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(200, 250));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(151, 67, 36), 2)); // brown border

        // --- Title ---
        JLabel titleLabel = new JLabel("<html><center>" + book.getTitle() + "</center></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(110, 60, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // --- Author ---
        JLabel authorLabel = new JLabel(book.getAuthor(), SwingConstants.CENTER);
        authorLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));

        // --- Genre ---
        JLabel genreLabel = new JLabel(book.getGenre(), SwingConstants.CENTER);
        genreLabel.setForeground(new Color(120, 100, 80));

        // --- Price ---
        JLabel priceLabel = new JLabel(String.format("$%.2f", book.getPrice()), SwingConstants.CENTER);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        priceLabel.setForeground(new Color(151, 67, 36));

        // Add elements to card
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(authorLabel, BorderLayout.CENTER);
        card.add(genreLabel, BorderLayout.SOUTH);
        card.add(priceLabel, BorderLayout.PAGE_END);

        return card;
    }
}


