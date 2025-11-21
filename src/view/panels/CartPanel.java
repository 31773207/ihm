package view.panels;

import javax.swing.*;
import java.awt.*;

import controller.CartController;
import model.Book;
import service.CartService;
import view.components.CartItemCard;

public class CartPanel extends JPanel {

    private final CartController controller;
    private JPanel itemsPanel;
    private JLabel totalLabel;
    private JButton checkoutBtn;

    public CartPanel(CartController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        initUI();
    }

    private void initUI() {
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(Color.WHITE);
        itemsPanel.setAlignmentX(LEFT_ALIGNMENT);

        JScrollPane scroll = new JScrollPane(itemsPanel);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll, BorderLayout.CENTER);

        // Bottom Bar
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setBackground(Color.WHITE);

        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));

        checkoutBtn = new JButton("Checkout");
        checkoutBtn.setFont(new Font("Arial", Font.BOLD, 18));
        checkoutBtn.setBackground(new Color(110, 60, 16));
        checkoutBtn.setForeground(Color.WHITE);

        checkoutBtn.addActionListener(e -> handleCheckout());

        bottom.add(totalLabel);
        bottom.add(checkoutBtn);

        add(bottom, BorderLayout.SOUTH);
    }

    private void handleCheckout() {
        if (CartService.getInstance().getCartItems().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Cart is empty!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Thank you! Your order has been placed.",
                "Order Complete",
                JOptionPane.INFORMATION_MESSAGE);

        CartService.getInstance().clearCart();
        refreshCart();
        controller.updateCartIcon();
    }

    public void refreshCart() {
        itemsPanel.removeAll();

        // Build a map of unique books (by title) to quantity, preserving insertion order
        java.util.List<Book> list = CartService.getInstance().getCartItems();
        java.util.LinkedHashMap<String, Integer> qtyMap = new java.util.LinkedHashMap<>();
        java.util.LinkedHashMap<String, Book> bookMap = new java.util.LinkedHashMap<>();
        for (Book b : list) {
            String key = b.getTitle();
            qtyMap.put(key, qtyMap.getOrDefault(key, 0) + 1);
            if (!bookMap.containsKey(key)) bookMap.put(key, b);
        }

        for (String key : bookMap.keySet()) {
            Book b = bookMap.get(key);
            CartItemCard card = new CartItemCard(b, controller);
            card.setAlignmentX(LEFT_ALIGNMENT);
            card.setMaximumSize(new Dimension(340, 120));
            itemsPanel.add(card);
            itemsPanel.add(Box.createVerticalStrut(10));
        }

        double total = CartService.getInstance().getTotalPrice();
        totalLabel.setText(String.format("Total: $%.2f", total));

        checkoutBtn.setEnabled(total > 0);

        itemsPanel.revalidate();
        itemsPanel.repaint();
    }
}
