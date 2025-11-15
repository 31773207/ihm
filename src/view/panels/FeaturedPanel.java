package view.panels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Book;
import model.BookStore;
import view.components.BookCard;

public class FeaturedPanel extends JPanel {

    public FeaturedPanel() {

        setPreferredSize(new Dimension(800, 750));

        Color bg = new Color(233, 204, 181);
        setBackground(bg);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ================= TITLE ==================
        JLabel mainTitle = new JLabel("✨ Featured Books ✨", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.BOLD, 40));
        mainTitle.setForeground(new Color(110, 60, 16));
        mainTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(mainTitle);

        // ================= SUBTITLE ==================
        JLabel subtitle = new JLabel("Handpicked selection from our curators");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
        subtitle.setForeground(new Color(110, 60, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        add(subtitle);

        // ================= ONE SINGLE ROW ==================
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row.setOpaque(false); // keep background of parent

        List<Book> books = BookStore.getAllBooks();

        int maxBooks = Math.min(4, books.size()); // 1 row = max 4 books

        for (int i = 0; i < maxBooks; i++) {
            BookCard card = new BookCard(books.get(i));
            row.add(card);
        }

        add(row);
    }
}
