
package view.panels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Book;
import model.BookStore;
import view.components.BookCard;

public class CatalogPanel extends JPanel {

    public CatalogPanel() {
        setBackground(new Color(218, 168, 131));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ==================================== Title =============================================
        JLabel title = new JLabel("Books Catalogue", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        title.setForeground(new Color(110, 60, 16));
        add(title);

        List<Book> books = BookStore.getAllBooks(); // bring books from BookStore
        int booksPerRow = 4;

        // Loop through books and create rows
        for (int i = 0; i < books.size(); i += booksPerRow) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
            row.setBackground(new Color(218, 168, 131));

            for (int j = i; j < i + booksPerRow && j < books.size(); j++) {
                Book book = books.get(j);

                // Use reusable BookCard
                BookCard bookCard = new BookCard(book);
                row.add(bookCard);
            }

            add(row);
        }
    }
}
