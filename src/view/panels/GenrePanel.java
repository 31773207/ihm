package view.panels;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Genre;
import model.GenreStore;
import view.components.GenreCard;

public class GenrePanel extends JPanel {

    public GenrePanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(new Color(245 , 205 , 175));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ===== TITLE =====
        JLabel mainTitle = new JLabel("📚 Popular Genres", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.BOLD, 40));
        mainTitle.setForeground(new Color(110, 60, 16));
        mainTitle.setAlignmentX(CENTER_ALIGNMENT);
        mainTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(mainTitle);

        // ===== SUBTITLE =====
        JLabel subtitle = new JLabel("Explore books by your favorite categories", SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
        subtitle.setForeground(new Color(110, 60, 16));
        subtitle.setAlignmentX(CENTER_ALIGNMENT);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        add(subtitle);

        // ===== ROW OF CARDS =====
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // center horizontally
                    row.setBackground(new Color(245 , 205 , 175));
row.setOpaque(true); // show parent background

        List<Genre> genres = GenreStore.getAllGenres();
        int maxGenres = Math.min(4, genres.size());

        for (int i = 0; i < maxGenres; i++) {
            GenreCard card = new GenreCard(genres.get(i));
            row.add(card);
        }

        // ===== SCROLL PANE =====
        JScrollPane scrollPane = new JScrollPane(row);
        scrollPane.setPreferredSize(new Dimension(780, 250));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(233, 204, 181)); // match parent background

        add(scrollPane);
    }
}


