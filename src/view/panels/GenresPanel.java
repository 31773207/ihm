//see Book categories browsing page 
package view.panels;
import java.awt.*;
import javax.swing.*;

public class GenresPanel extends JPanel {
    public GenresPanel() {
        setPreferredSize(new Dimension(800, 750));
        setBackground(new Color(245 , 205 , 175));
        add(new JLabel("Genres Panel"));
           setLayout(new GridLayout(2, 3, 20, 20));

        add(createGenreCard("Romance", new Color(255, 200, 210)));
        add(createGenreCard("Mystery", new Color(200, 220, 255)));
        add(createGenreCard("Fantasy", new Color(220, 255, 220)));
        add(createGenreCard("Sci-Fi", new Color(255, 240, 200)));
        add(createGenreCard("Thriller", new Color(245, 210, 255)));
        add(createGenreCard("History", new Color(230, 230, 230)));
    }

    private JPanel createGenreCard(String name, Color color) {
        JPanel card = new JPanel();
        card.setBackground(color);
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.add(new JLabel(name));
        return card;
    }
    }

