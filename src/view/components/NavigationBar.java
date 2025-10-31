//Top menu (consistent across all screens)
package view.components;  // This is a reusable UI component

import java.awt.*;  // For Swing components (JPanel, JButton, etc.)
import java.awt.event.ActionListener;     // For colors, layouts, and dimensions
import javax.swing.*;  // For handling button clicks

public class NavigationBar extends JPanel {  // Extends JPanel to create a custom panel
    
    // Declare instance variables for all navigation elements
    private JTextField searchField;  // Input field for search queries
    private JButton homeBtn, catalogueBtn, genreBtn, authorsBtn, featuredBtn, contactBtn, cartBtn, loginBtn;

    // Constructor - called when NavigationBar is created
    public NavigationBar(ActionListener navigationListener) {
        // Set background color to light pink
        setBackground(new Color(255, 182, 193));
        // Use FlowLayout to arrange components left to right
        setLayout(new FlowLayout(FlowLayout.LEFT));
        // Set preferred size for the navigation bar
        setPreferredSize(new Dimension(800, 60));

        // Call methods to set up the navigation bar
        initializeComponents();
        addComponents();
    }

    private void initializeComponents() {
        // Create and style the logo
        JLabel logo = new JLabel("📚 Bookify");
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        add(logo);  // Add logo directly to the panel

        // Create all navigation buttons using helper method
        homeBtn = createNavButton("Home");
        catalogueBtn = createNavButton("Catalogue");
        genreBtn = createNavButton("Genres");
        authorsBtn = createNavButton("Authors");
        featuredBtn = createNavButton("Featured");
        contactBtn = createNavButton("Contact");
        cartBtn = createNavButton("Cart");
        loginBtn = createNavButton("Login");

        // Create search components
        searchField = new JTextField(15);  // Text field that fits ~15 characters
        JButton searchBtn = new JButton("Search");
        // Add action listener to handle search button clicks
        searchBtn.addActionListener(e -> performSearch());
        add(searchField);   // Add search field to panel
        add(searchBtn);     // Add search button to panel
    }

    // Helper method to create consistent navigation buttons
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);  // Create button with given text
        // Add action listener that fires navigation event when clicked
        button.addActionListener(e -> fireNavigationEvent(text.toUpperCase()));
        return button;  // Return the created button
    }

    private void addComponents() {
        // Add all buttons to the navigation bar in order
        add(homeBtn);
        add(catalogueBtn);
        add(genreBtn);
        add(authorsBtn);
        add(featuredBtn);
        add(contactBtn);
        add(cartBtn);
        add(loginBtn);
    }

    private void fireNavigationEvent(String panelName) {
        // Temporary implementation - shows a message when navigation occurs
        // In full implementation, this would communicate with the controller
        JOptionPane.showMessageDialog(this, "Navigating to: " + panelName);
    }

    private void performSearch() {
        // Get search text and remove extra spaces
        String query = searchField.getText().trim();
        // Check if search field is empty
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;  // Exit method early if no search term
        }
        // Temporary search implementation
        // In full app, this would call a search service
        JOptionPane.showMessageDialog(this, "Searching for: " + query);
    }

    // GETTER METHODS - Allow controllers to access these components
    // These are used by NavigationController to attach proper event handlers
    public JButton getHomeBtn() { return homeBtn; }
    public JButton getCatalogueBtn() { return catalogueBtn; }
    public JButton getGenreBtn() { return genreBtn; }
    public JButton getAuthorsBtn() { return authorsBtn; }
    public JButton getFeaturedBtn() { return featuredBtn; }
    public JButton getContactBtn() { return contactBtn; }
    public JButton getCartBtn() { return cartBtn; }
    public JButton getLoginBtn() { return loginBtn; }
    public JTextField getSearchField() { return searchField; }
}

