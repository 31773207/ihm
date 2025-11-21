package view.components;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import controller.CartController;
import model.Book;
import service.CartService;

public class CartItemCard extends JPanel {

    public CartItemCard(Book book, CartController controller) {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // Left: thumbnail
        JLabel thumb = new JLabel();
        thumb.setPreferredSize(new Dimension(70, 70));
        ImageIcon icon = loadImage(book.getImagePath(), 70, 70, book.getTitle());
        if (icon != null) thumb.setIcon(icon);
        thumb.setBorder(BorderFactory.createLineBorder(new Color(230, 220, 210), 1));

        // Center: title, unit price, quantity controls
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(book.getTitle());
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        title.setForeground(new Color(60, 30, 30));

        JLabel unit = new JLabel(String.format("$%.2f each", book.getPrice()));
        unit.setFont(new Font("SansSerif", Font.PLAIN, 12));
        unit.setForeground(new Color(130, 100, 100));

        // quantity controls
        JPanel qtyRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        qtyRow.setOpaque(false);
        JButton minus = makeCircleButton("-");
        JLabel qtyLabel = new JLabel(String.valueOf(getQuantity(book)));
        qtyLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        qtyLabel.setBorder(BorderFactory.createEmptyBorder(0,8,0,8));
        JButton plus = makeCircleButton("+");

        minus.addActionListener(e -> {
            controller.removeBook(book);
        });
        plus.addActionListener(e -> {
            controller.addBook(book);
        });

        qtyRow.add(minus);
        qtyRow.add(qtyLabel);
        qtyRow.add(plus);

        center.add(title);
        center.add(Box.createRigidArea(new Dimension(0,6)));
        center.add(unit);
        center.add(Box.createRigidArea(new Dimension(0,8)));
        center.add(qtyRow);

        // Right: subtotal + remove
        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        double subtotal = book.getPrice() * getQuantity(book);
        JLabel subtotalLabel = new JLabel(String.format("$%.2f", subtotal));
        subtotalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        subtotalLabel.setForeground(new Color(90, 40, 20));

        JButton remove = new JButton("Remove");
        remove.setBorderPainted(false);
        remove.setContentAreaFilled(false);
        remove.setForeground(new Color(170, 60, 60));
        remove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        remove.addActionListener(e -> {
            controller.removeAll(book);
        });

        right.add(subtotalLabel);
        right.add(Box.createVerticalStrut(8));
        right.add(remove);

        add(thumb, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);

        setPreferredSize(new Dimension(340, 100));
        setMaximumSize(new Dimension(340, 120));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(240, 230, 225)));
    }

    private int getQuantity(Book book) {
        return (int) CartService.getInstance().getCartItems().stream()
                .filter(b -> b.getTitle().equals(book.getTitle()))
                .count();
    }

    private JButton makeCircleButton(String text) {
        JButton b = new JButton(text);
        b.setPreferredSize(new Dimension(28, 28));
        b.setBackground(new Color(255, 243, 210));
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(new Color(230, 200, 150)));
        return b;
    }

    private ImageIcon loadImage(String path, int w, int h, String title) {
        try {
            Image img = null;
            if (path != null && !path.trim().isEmpty()) {
                String resPath = path.startsWith("/") ? path : "/" + path;
                java.net.URL res = getClass().getResource(resPath);
                if (res != null) img = new ImageIcon(res).getImage();
                else {
                    java.io.File f = new java.io.File(path);
                    if (f.exists()) img = new ImageIcon(path).getImage();
                }
            }
            if (img == null) {
                // generate placeholder
                java.awt.image.BufferedImage place = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_RGB);
                Graphics2D g = place.createGraphics();
                g.setColor(new Color(250, 245, 240));
                g.fillRect(0,0,w,h);
                g.setColor(new Color(200, 180, 160));
                g.setFont(new Font("SansSerif", Font.BOLD, Math.max(12, w/6)));
                String s = "";
                if (title != null && !title.trim().isEmpty()) {
                    // create initials from title words
                    String plain = title.replaceAll("<.*?>","");
                    String[] parts = plain.trim().split("\\s+");
                    if (parts.length == 1) s = parts[0].substring(0, Math.min(2, parts[0].length())).toUpperCase();
                    else s = ("" + parts[0].charAt(0) + parts[Math.min(1, parts.length-1)].charAt(0)).toUpperCase();
                }
                int tw = g.getFontMetrics().stringWidth(s);
                g.drawString(s, Math.max(8, (w-tw)/2), h/2 + 6);
                g.dispose();
                img = place;
            }
            Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (Exception ex) {
            return null;
        }
    }
}
