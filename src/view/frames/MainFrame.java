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

   // 🟢 نربط الأزرار بـ Controller
new NavigationController(this, navBar);

        setVisible(true);
    }

    // 🔵 ميثود باش Controller يستعملها
    public void scrollToPanel(JPanel panel) {
        panel.scrollRectToVisible(panel.getBounds());
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