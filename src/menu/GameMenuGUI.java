package menu;

import javax.swing.*;
import java.awt.*;

public class GameMenuGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Game Menu");

        BackgroundPanel panel = new BackgroundPanel();
        
        // Get background image dimensions
        Image bgImage = panel.getBackgroundImage();
        int imgWidth = bgImage.getWidth(null);
        int imgHeight = bgImage.getHeight(null);
        
        // Use image dimensions for frame size (or minimum 800x600)
        int frameWidth = Math.max(imgWidth, 800);
        int frameHeight = Math.max(imgHeight, 600);

        JButton startButton = new JButton("Start Game");
        JButton optionsButton = new JButton("Options");
        JButton exitButton = new JButton("Exit");

        // Center buttons in the panel
        int buttonWidth = 200;
        int buttonHeight = 40;
        int centerX = (frameWidth - buttonWidth) / 2;
        
        startButton.setBounds(centerX, 100, buttonWidth, buttonHeight);
        optionsButton.setBounds(centerX, 160, buttonWidth, buttonHeight);
        exitButton.setBounds(centerX, 220, buttonWidth, buttonHeight);

        // Style buttons
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        optionsButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(startButton);
        panel.add(optionsButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setResizable(false);
        frame.setVisible(true);

        // Button actions
        startButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Game Starting...");
        });

        optionsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Options Menu");
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}