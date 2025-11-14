package view.panels;
import java.awt.*;
import javax.swing.*;

public class FeaturedPanel extends JPanel {
    public FeaturedPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(233, 204, 181));
        add(new JLabel("Featured Panel"));
         // Example: create some books
          JLabel title = new JLabel("✨ Featured Books ✨", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setForeground(new Color(110, 60, 16));

        add(title, BorderLayout.NORTH);
/* 
        // Create example book data
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Paulo Coelho", "Fiction", 12.99));
        books.add(new Book("Clean Code", "Robert C. Martin", "Programming", 29.99));
        books.add(new Book("Atomic Habits", "James Clear", "Self-help", 18.50));
        books.add(new Book("Dune", "Frank Herbert", "Sci-Fi", 24.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Classic", 10.99));

        // Add BookListPanel to show them
        BookListPanel listPanel = new BookListPanel(books);
        add(listPanel, BorderLayout.CENTER);
    */}
}




