package main;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            FullScreenToggle window = new FullScreenToggle();

            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);

            gamePanel.setupGame();
            gamePanel.startGameThread();

            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        });
    }
}