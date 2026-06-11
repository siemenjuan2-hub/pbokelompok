package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
        // screen settings
        final int originalTileSize = 64;
        final int scale = 2;

        public final int tileSize = originalTileSize * scale; // 64x2 = 128 (1 tile)
        final public int maxScreenCol = 29; // 29 tile kesamping
        final public int maxScreenRow = 20; // 20 tile kebawah
        public final int screenWidth = tileSize * maxScreenCol; // 3712 pixels kesamping
        public final int screenHeight = tileSize * maxScreenRow; // 2560 pixels kebawah

        //World Settings
        public final int maxWorldCol = 50; //Tergantung nanti ukuran map kita seberapa
        public final int maxWorldRow = 50; //Tergantung nanti ukuran map kita seberapa
        public final int worldWidth = tileSize * maxWorldCol;
        public final int worldHeight = tileSize * maxWorldRow;

        int FPS = 60;

        KeyHandler keyH = new KeyHandler();
        Thread gameThread;


        public CollisonChecker cCheker = new CollisonChecker(this);

        public Player player = new Player(this, keyH);
        TileManager tileM = new TileManager(this);
        
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
            tileM.draw(g2);
            player.draw(g2);
            g2.dispose();
        }
}
