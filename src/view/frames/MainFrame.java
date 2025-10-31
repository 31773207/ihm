// main window 
package view.frames;

import java.awt.*;
import javax.swing.*; // for colors .BorderLayou
import view.panels.AuthorsPanel;
import view.panels.CartPanel;
import view.panels.CatalogPanel;
import view.panels.FeaturedPanel;
import view.panels.GenresPanel;
import view.panels.HomePanel;
import view.panels.LoginPanel;
//import view.panels.HomePanel;
//the class in the main window
public class MainFrame extends JFrame {
    private JPanel mainPanel;  
     // Panels
      private HomePanel homePanel;
    private FeaturedPanel featuredPanel;
    private CatalogPanel catalogPanel;
    private GenresPanel genresPanel;
    private AuthorsPanel authorsPanel;
    private LoginPanel loginPanel;
    private CartPanel cartPanel;    // Custom navigation bar component
 



    // Constructor 
    public MainFrame() {
        setTitle("Bookify");         // title
        setSize(800, 600);         // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // for close 
        setLocationRelativeTo(null);        // open in center 
        setLayout(new BorderLayout()); // navebar is in the head of the panneles 
     
        // ========================== Navigation Bar =======================
                JPanel navBar = new JPanel();
        navBar.setBackground(new Color(255, 182, 193)); 
        //navBar.setLayout(new FlowLayout());       
        navBar.setPreferredSize(new Dimension(800, 60));

        // Use BorderLayout so we can control position
         //navBar.setLayout(new BorderLayout());
        JLabel logo = new JLabel("📚 Bookify");
        logo.setFont(new Font("Arial", Font.BOLD, 40));
logo.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0)); // small padding from left
navBar.add(logo, BorderLayout.WEST);
        // Optional: remove any inner padding

       // navBar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // or (0,0,0,0)


        //=========================== Buttons ==============================
        // === Right: Navigation Buttons ===

JButton homeBtn = new JButton("Home");
        JButton catalogueBtn = new JButton("Catalogue");
        JButton genreBtn = new JButton("Genre");
        JButton authorsBtn = new JButton("Authers");
        JButton featuredBtn = new JButton("Featured");
        JButton contactBtn = new JButton("Contact");
        JButton cartBtn = new JButton("Cart");
        JButton loginBtn = new JButton("Login");


        //add buttons 
        navBar.add(homeBtn);
        navBar.add(catalogueBtn);
        navBar.add(genreBtn);
        navBar.add(authorsBtn);
        navBar.add(featuredBtn);
        navBar.add(contactBtn);
        navBar.add(cartBtn);
         
        // Search bar
        JTextField searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Search: " + searchField.getText()));
        navBar.add(searchField);
        navBar.add(searchBtn);
                navBar.add(cartBtn);
                navBar.add(loginBtn);

        //add nave bar to the top of the frame
        add(navBar, BorderLayout.NORTH);
        //====================== Main Panel ====================================
//here is where we scrolle and see the pages    
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //make section one under the other
       
        // ... initialize nav bar and buttons
          homePanel = new HomePanel();
        catalogPanel = new CatalogPanel();
        genresPanel = new GenresPanel();
        authorsPanel = new AuthorsPanel();
        featuredPanel = new FeaturedPanel();
        loginPanel = new LoginPanel();
        cartPanel = new CartPanel();
       // bookDetailPanel = new BookDetailPanel();
        //checkoutPanel = new CheckoutPanel();


          mainPanel.add(homePanel);
        mainPanel.add(catalogPanel);
        mainPanel.add(genresPanel);
        mainPanel.add(authorsPanel);
        mainPanel.add(featuredPanel);
        mainPanel.add(loginPanel);
        mainPanel.add(cartPanel);
// Show home panel by default
        //cardLayout.show(mainPanel, "HOME");
    

//jscrollpane for scroling 
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Button Actions: scroll to section =====
homeBtn.addActionListener(e -> homePanel.scrollRectToVisible(homePanel.getBounds()));
        catalogueBtn.addActionListener(e -> catalogPanel.scrollRectToVisible(catalogPanel.getBounds()));
        genreBtn.addActionListener(e -> genresPanel.scrollRectToVisible(genresPanel.getBounds()));
        authorsBtn.addActionListener(e -> authorsPanel.scrollRectToVisible(authorsPanel.getBounds()));
        featuredBtn.addActionListener(e -> featuredPanel.scrollRectToVisible(featuredPanel.getBounds()));
        loginBtn.addActionListener(e -> loginPanel.scrollRectToVisible(loginPanel.getBounds()));
        cartBtn.addActionListener(e -> cartPanel.scrollRectToVisible(cartPanel.getBounds()));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}