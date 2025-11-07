package view.components;

import java.awt.*;
import javax.swing.*;

public class NavigationBar extends JPanel {
    public JButton homeBtn, catalogueBtn, genreBtn, authorsBtn, featuredBtn, cartBtn, loginBtn, searchBtn;
    public JTextField searchField;

    public NavigationBar() {
        setBackground(new Color(247, 234, 224));
        setPreferredSize(new Dimension(1200, 60));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); //object to control each component’s position, spacing, size in the GridBagLayout.
        gbc.gridy = 0; //all components are on row 0.
        gbc.fill = GridBagConstraints.NONE; //components keep their natural size, don’t stretch.
        gbc.insets = new Insets(0, 5, 0, 5); //space around each component (top, left, bottom, right) = 5px.

        // --- Logo ---
        JLabel logo = new JLabel("📚 Bookify");
        logo.setFont(new Font("Arial", Font.BOLD, 26));
        logo.setForeground(new Color(110, 60, 16));
        gbc.gridx = 0; //first column
        gbc.anchor = GridBagConstraints.WEST; //stick it to the left of its cell
        gbc.weightx = 0;
        add(logo, gbc); //add it to panel.

        // --- Left spacer to push menu to center ---
        JPanel leftSpacer = new JPanel(); //Empty transparent panel acts as a flexible space.
        leftSpacer.setOpaque(false);
        gbc.gridx = 1;
        gbc.weightx = 1.0; // takes all extra space on the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // "spacer" stretches horizontally 
        add(leftSpacer, gbc);

        // --- Main buttons (centered) ---
        homeBtn = new JButton("Home");
        catalogueBtn = new JButton("Catalogue");
        genreBtn = new JButton("Genre");
        authorsBtn = new JButton("Authors");
        featuredBtn = new JButton("Featured");

        JButton[] mainBtns = {homeBtn, catalogueBtn, genreBtn, authorsBtn, featuredBtn};
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        centerPanel.setOpaque(false);
        for (JButton btn : mainBtns) styleButton(btn);
        for (JButton btn : mainBtns) centerPanel.add(btn); //Add each button to the centerPanel.

        gbc.gridx = 2; //Add the center buttons panel in column 2.
        gbc.weightx = 0; //panel takes only needed space, not stretched.
        gbc.fill = GridBagConstraints.NONE;
        add(centerPanel, gbc);

        // --- Right spacer to push right buttons to the right edge ---
        JPanel rightSpacer = new JPanel(); //Another flexible space to push right panel elements to the extreme right.
        rightSpacer.setOpaque(false);
        gbc.gridx = 3;
        gbc.weightx = 1.0; // takes all extra space on the right
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(rightSpacer, gbc);

        // --- Right buttons: search, cart, login ---
        searchField = new JTextField(12);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createLineBorder(new Color(151, 67, 36), 2)); //LineBorder: adds visible border color

        searchBtn = new JButton("Search");
         styleButton(searchBtn);


        cartBtn = new JButton("Cart");
        loginBtn = new JButton("Login");
        styleButton(cartBtn);
        loginBtn.setBorderPainted(true);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        loginBtn.setBackground(new Color(222, 198, 180));
        loginBtn.setForeground(new Color(110, 60, 16));

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setOpaque(false);
        rightPanel.add(searchField);
        rightPanel.add(searchBtn);
        rightPanel.add(cartBtn);
        rightPanel.add(loginBtn);

        gbc.gridx = 4; //right section added 
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(rightPanel, gbc);
    }
 private void styleButton(JButton btn) {
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setForeground(new Color(110, 60, 16));
        btn.setFont(new Font("Arial", Font.BOLD, 16));
    }
    // --- Getters ---
    public JButton getHomeButton() { return homeBtn; }
    public JButton getCatalogueButton() { return catalogueBtn; }
    public JButton getGenreButton() { return genreBtn; }
    public JButton getAuthorsButton() { return authorsBtn; }
    public JButton getFeaturedButton() { return featuredBtn; }
    public JButton getCartButton() { return cartBtn; }
    public JButton getLoginButton() { return loginBtn; }
}

