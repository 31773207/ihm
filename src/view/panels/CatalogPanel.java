package view.panels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Book;
import view.components.BookCard;

public class CatalogPanel extends JPanel {

    private JComboBox<String> genreBox; // dropdown to filter by genre

    public CatalogPanel() {
        setBackground(new Color(218, 168, 131));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ===================== TITLE =====================
        JLabel title = new JLabel("Books Catalogue", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        title.setForeground(new Color(110, 60, 16));
        add(title);

        // ===================== DROPDOWN FILTER =====================
        genreBox = new JComboBox<>(new String[]{"All", "Romance", "Fantasy", "Drama", "Sci-Fi", "Horror"});
       

        JPanel filterPanel = new JPanel();
        filterPanel.setBackground(new Color(218, 168, 131));
        filterPanel.add(new JLabel("Filter by Genre:"));
        filterPanel.add(genreBox);
        add(filterPanel);
    }

    // ==================== DISPLAY BOOKS (for controller) =====================
    public void displayBooks(List<Book> books) {
        // Remove previous book rows but keep title + filter panel
        Component[] components = getComponents();
        for (int i = components.length - 1; i >= 2; i--) { // 0=title, 1=filter panel
            remove(components[i]);
        }

        int booksPerRow = 4; // 4 cards per row
        for (int i = 0; i < books.size(); i += booksPerRow) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
            row.setBackground(new Color(218, 168, 131));
            for (int j = i; j < i + booksPerRow && j < books.size(); j++) {
                BookCard card = new BookCard(books.get(j));
                row.add(card);
            }
            add(row);
        }

        revalidate();
        repaint();
    }

    // Getter for controller
    public JComboBox<String> getGenreBox() {
        return genreBox;
    }
}

