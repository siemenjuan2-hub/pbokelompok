package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {
        // screen settings
        final int originalTileSize = 64;
        final int scale = 3;

        public final int tileSize = originalTileSize * scale; // 48x48 tile
        final int maxScreenCol = 29;
        final int maxScreenRow = 20;
        final int screenWidth = tileSize * maxScreenCol; // 768 pixels
        final int screenHeight = tileSize * maxScreenRow; // 576 pixels

        int FPS = 60;

        KeyHandler keyH = new KeyHandler();
        Thread gameThread;
        Player player = new Player(this, keyH);

        int playerX = 100;
        int playerY = 100;
        int playerSpeed = 3;

        public GamePanel() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }

        public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public void run() {
            double drawInterval = 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;

            while(gameThread != null){

                update();

                repaint();

                
                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime = remainingTime/1000000;

                    if(remainingTime < 0){
                        remainingTime = 0;
                    }
                    Thread.sleep((long) remainingTime);

                    nextDrawTime += drawInterval;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void update(){
            player.update();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g; // ada beberapa function yang tidak ada di graphic biasa, jadi pakai 2d
            player.draw(g2);
            g2.dispose();
        }
}
