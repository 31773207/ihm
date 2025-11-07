//Handles menu clicks and screen changes
package controller;

import javax.swing.*;
import view.frames.MainFrame;
import view.components.NavigationBar;

public class NavigationController {

    private MainFrame frame;
    private NavigationBar navBar;

    public NavigationController(MainFrame frame, NavigationBar navBar) {
        this.frame = frame;
        this.navBar = navBar;

        // add listeners
        addListeners();
    }

    private void addListeners() {
        navBar.getHomeButton().addActionListener(e -> frame.scrollToPanel(frame.getHomePanel()));
        navBar.getFeaturedButton().addActionListener(e -> frame.scrollToPanel(frame.getFeaturedPanel()));
        navBar.getCatalogueButton().addActionListener(e -> frame.scrollToPanel(frame.getCatalogPanel()));
        navBar.getGenreButton().addActionListener(e -> frame.scrollToPanel(frame.getGenresPanel()));
        navBar.getAuthorsButton().addActionListener(e -> frame.scrollToPanel(frame.getAuthorsPanel()));
        //navBar.getLoginButton().addActionListener(e -> frame.scrollToPanel(frame.getLoginPanel()));
        //navBar.getCartButton().addActionListener(e -> frame.scrollToPanel(frame.getCartPanel()));
    }
}
