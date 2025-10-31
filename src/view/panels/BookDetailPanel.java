package view.panels;
import java.awt.*;
import javax.swing.*;

public class BookDetailPanel extends JPanel {
    public BookDetailPanel() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.BLUE);
        add(new JLabel("Book Detail Panel"));
    }
}

