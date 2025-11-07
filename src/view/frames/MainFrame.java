// main window 
package view.frames;

import controller.NavigationController;
import java.awt.*; // for colors .BorderLayou
import javax.swing.*;
import view.components.NavigationBar;
import view.panels.*;
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
        NavigationBar navBar = new NavigationBar();
        add(navBar, BorderLayout.NORTH);

        //====================== Main Panel ====================================
//here is where we scrolle and see the pages    
        mainPanel = new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //make section one under the other
       mainPanel.setLayout(new GridLayout(0, 1, 0, 1)); // vertical panels spaced out

        // ... initialize nav bar and buttons
          homePanel = new HomePanel();
                  featuredPanel = new FeaturedPanel();
        catalogPanel = new CatalogPanel();
        genresPanel = new GenresPanel();
        authorsPanel = new AuthorsPanel();
       // loginPanel = new LoginPanel();
        //cartPanel = new CartPanel();
       // bookDetailPanel = new BookDetailPanel();
        //checkoutPanel = new CheckoutPanel();


        mainPanel.add(homePanel);
                mainPanel.add(featuredPanel);
        mainPanel.add(genresPanel);
        mainPanel.add(authorsPanel);
                mainPanel.add(catalogPanel);
        //mainPanel.add(loginPanel);
        //mainPanel.add(cartPanel);
// Show home panel by default
        //cardLayout.show(mainPanel, "HOME");
    

//jscrollpane for scroling 
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add(scrollPane, BorderLayout.CENTER);
                scrollPane.setBorder(null);

add(scrollPane);

   // link the buttons with Controller
new NavigationController(this, navBar);

        setVisible(true);
    }

    // this method takes a specific panel and scrolls the page to make it visible.
    
      public void scrollToPanel(JPanel targetPanel) {
    SwingUtilities.invokeLater(() -> { //This tells Swing to run the code inside later, after the current UI updates finish.
        Rectangle rect = targetPanel.getBounds(); //rect tells us exactly where that panel is located on the page.(getBounds() gets the position and size of the target panel inside its container (mainPanel).)
        mainPanel.scrollRectToVisible(rect);
    });
}

    
// 🟢 Getters for panels
public JPanel getHomePanel() { return homePanel; }
public JPanel getFeaturedPanel() { return featuredPanel; }
public JPanel getCatalogPanel() { return catalogPanel; }
public JPanel getGenresPanel() { return genresPanel; }
public JPanel getAuthorsPanel() { return authorsPanel; }
public JPanel getLoginPanel() { return loginPanel; }
public JPanel getCartPanel() { return cartPanel; }

   /*  public static void main(String[] args) {
        new MainFrame();
    }*/
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainFrame());
}
}