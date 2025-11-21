package view.components;

import java.awt.*;
import javax.swing.*;
import controller.CartController;
import model.Book;

public class CartItemCard extends JPanel {

    public CartItemCard(Book book, CartController controller) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(500, 80));

        JLabel title = new JLabel(book.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel price = new JLabel("$" + book.getPrice());

        JButton deleteBtn = new JButton("Remove");
        deleteBtn.addActionListener(e -> {
            controller.removeBook(book);
        });

        add(title, BorderLayout.WEST);
        add(price, BorderLayout.CENTER);
        add(deleteBtn, BorderLayout.EAST);
    }
}
