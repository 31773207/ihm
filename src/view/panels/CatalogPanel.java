package view.panels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.MatteBorder;        // ← add this
import model.Book;
import model.BookStore;

public class CatalogPanel extends JPanel {

    public CatalogPanel() {
        setBackground(new Color(218, 168, 131));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

//==================================== Title =============================================
        JLabel title = new JLabel("Books Catalogue", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        title.setForeground(new Color(110, 60, 16)); // dark brown example

        add(title);

        List<Book> books = BookStore.getAllBooks(); //to bring book from bookstor
        int booksPerRow = 4; //4 books per row.

        //Loop through books and create rows
        for (int i = 0; i < books.size(); i += booksPerRow) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20)); //put books in center 
         row.setBackground(new Color(218, 168, 131));

        for (int j = i; j < i + booksPerRow && j < books.size(); j++) {
        Book book = books.get(j);

//============================= Book Card Panel ===============================================
        JPanel bookCard = new JPanel();
        bookCard.setLayout(new BoxLayout(bookCard, BoxLayout.Y_AXIS)); //tous les composants (image, titre, auteur...) f vertical
        bookCard.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));
        bookCard.setBackground(new Color(238, 195, 162));
        bookCard.setPreferredSize(new Dimension(300, 520));
        bookCard.setOpaque(true);

// ======================== Image ===================================
        JLabel bookImage = new JLabel();
bookImage.setAlignmentX(Component.CENTER_ALIGNMENT);
            bookImage.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));

java.net.URL imgURL = getClass().getResource(book.getImagePath());
if (imgURL != null) {
    ImageIcon icon = new ImageIcon(imgURL);

    // fill most of the card height
    int imgWidth = 250;
    int imgHeight = 300;
    Image img = icon.getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
    bookImage.setIcon(new ImageIcon(img));
    bookImage.setPreferredSize(new Dimension(imgWidth, imgHeight));
} else {
    bookImage.setText("No Image");
    bookImage.setHorizontalAlignment(SwingConstants.CENTER);
    bookImage.setPreferredSize(new Dimension(250,400));

}

// ===================Title=================
            JLabel bookTitle = new JLabel(book.getTitle());
            bookTitle.setFont(new Font("Arial", Font.BOLD, 18));
            bookTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // top, left, bottom, right
            bookTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

// =====================Author===================
            JLabel author = new JLabel(book.getAuthor());
            author.setFont(new Font("Arial", Font.ITALIC, 15));
            author.setAlignmentX(Component.CENTER_ALIGNMENT);

// =========================Price=========================
            JLabel price = new JLabel("$" + book.getPrice());
            price.setFont(new Font("Arial", Font.BOLD, 20));
            price.setAlignmentX(Component.CENTER_ALIGNMENT);

//==================================== Description ===========================
            JTextArea description = new JTextArea(book.getDescription());
            description.setLineWrap(true) ;
            description.setWrapStyleWord(true);
            description.setEditable(false);
            description.setFont(new Font("Arial", Font.PLAIN, 15));
            description.setBackground(new Color(218, 168, 131));
            description.setAlignmentX(Component.CENTER_ALIGNMENT);
description.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // top, left, bottom, right

            description.setOpaque(false); 
description.setBackground(new Color(0,0,0,0)); // transparent


// ===========================Button=============================
            JButton addToCart = new JButton("Add to Cart");
            addToCart.setAlignmentX(Component.CENTER_ALIGNMENT);
            addToCart.setFont(new Font("SansSerif", Font.BOLD, 16));
        addToCart.setBackground(new Color(110, 60, 16));
        addToCart.setForeground(Color.WHITE);
        addToCart.setFocusPainted(false);
        addToCart.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addToCart.setPreferredSize(new Dimension(200, 40)); // width = 180px, height = 40px


//=========================== Add all components once =================================
                bookCard.add(bookImage);
                bookCard.add(Box.createRigidArea(new Dimension(0,10)));
                bookCard.add(bookTitle);
                bookCard.add(Box.createRigidArea(new Dimension(0,5)));
                bookCard.add(author);
                 bookCard.add(Box.createRigidArea(new Dimension(0,5)));
                bookCard.add(description);
                bookCard.add(price);
                bookCard.add(Box.createRigidArea(new Dimension(0,5)));
                bookCard.add(addToCart);

                //Add Card to Row
                row.add(bookCard);
            }

            add(row);
        }
    }
}


