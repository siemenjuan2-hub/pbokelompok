package menu;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

public BackgroundPanel() {
        // load image from assets/Menu folder
        backgroundImage = new ImageIcon("assets/Menu/mainmenu.jpeg").getImage();
        this.setLayout(null); // so buttons can use setBounds
    }

@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    
    // Getter for background image
    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
