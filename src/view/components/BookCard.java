package view.components; // ou panels selon structure dyalek

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import model.Book;

public class BookCard extends JPanel {

    public BookCard(Book book) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new MatteBorder(2, 2, 2, 2, Color.white));
        setBackground(new Color(238, 195, 162));
        setPreferredSize(new Dimension(300, 520));
        setMaximumSize(new Dimension(300, 520));
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
            bookImage.setMaximumSize(new Dimension(250, 300));
        } else {
            bookImage.setText("No Image");
            bookImage.setHorizontalAlignment(SwingConstants.CENTER);
            bookImage.setPreferredSize(new Dimension(250, 300));
            bookImage.setMaximumSize(new Dimension(250, 300));
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
        // limit description so it doesn't push the button out of the visible area
        description.setMaximumSize(new Dimension(260, 96));
        description.setPreferredSize(new Dimension(260, 96));

        // Use a JLayeredPane so the favorite heart is absolutely positioned
        // over the image without affecting the layout or preferred sizes.
        JLayeredPane imageLayer = new JLayeredPane();
        imageLayer.setPreferredSize(new Dimension(250, 300));
        imageLayer.setMaximumSize(new Dimension(250, 300));
        imageLayer.setAlignmentX(Component.CENTER_ALIGNMENT);

        // place the image at 0,0 inside the layered pane
        bookImage.setBounds(0, 0, 250, 300);
        imageLayer.add(bookImage, JLayeredPane.DEFAULT_LAYER);

        // no favorites overlay (feature removed) — only the image is added to the layered pane

        // =========================== Button =============================
        JButton addToCart = new JButton("Add to Cart");
        addToCart.setAlignmentX(Component.CENTER_ALIGNMENT);
        addToCart.setFont(new Font("SansSerif", Font.BOLD, 16));
        addToCart.setBackground(new Color(110, 60, 16));
        addToCart.setForeground(Color.WHITE);
        addToCart.setFocusPainted(false);
        addToCart.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addToCart.setPreferredSize(new Dimension(200, 40));
        addToCart.setMaximumSize(new Dimension(220, 40));
        addToCart.addActionListener(e -> {
            controller.CartController.getInstance().addBook(book);
            Window owner = SwingUtilities.getWindowAncestor(this);
            showAddToCartToast(owner, book.getTitle() + " added to cart!");
        });


        // ============================ Add all components ===================
        add(imageLayer);
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

    private void showAddToCartToast(Window owner, String message) {
        if (owner == null) owner = JOptionPane.getRootFrame();

        final JWindow toast = new JWindow(owner);

        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(34, 197, 94));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        content.setOpaque(false);
        content.setLayout(new BorderLayout(10, 0));
        content.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 18));

        // create a simple white check icon
        int iconSize = 18;
        BufferedImage iconImg = new BufferedImage(iconSize, iconSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D ig = iconImg.createGraphics();
        ig.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ig.setColor(Color.white);
        ig.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        ig.drawLine(4, iconSize/2, iconSize/2 - 1, iconSize - 5);
        ig.drawLine(iconSize/2 - 1, iconSize - 5, iconSize - 3, 5);
        ig.dispose();

        JLabel iconLabel = new JLabel(new ImageIcon(iconImg));
        iconLabel.setOpaque(false);

        JLabel text = new JLabel(message);
        text.setForeground(Color.white);
        text.setFont(new Font("SansSerif", Font.BOLD, 14));

        content.add(iconLabel, BorderLayout.WEST);
        content.add(text, BorderLayout.CENTER);

        toast.getContentPane().add(content);
        toast.pack();

        int toastW = toast.getWidth();
        int toastH = toast.getHeight();
        Point ownerLoc = owner.getLocationOnScreen();
        int x = ownerLoc.x + owner.getWidth() - toastW - 20;
        int y = ownerLoc.y + 60;
        toast.setLocation(x, y);
        toast.setAlwaysOnTop(true);
        toast.setVisible(true);

        // auto-hide after 2 seconds
        new javax.swing.Timer(2000, ev -> {
            toast.setVisible(false);
            toast.dispose();
        }) {{ setRepeats(false); }}.start();
    }
}
