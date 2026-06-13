package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
        // screen settings
        final int originalTileSize = 64;
        final int scale = 2;

        public final int tileSize = originalTileSize * scale; // 16x3 = 48 x 48 (1 tile)
        final public int maxScreenCol = 16;
        final public int maxScreenRow = 12;
        public final int screenWidth = tileSize * maxScreenCol; // 768 pixels kesamping
        public final int screenHeight = tileSize * maxScreenRow; // 576 pixels kebawah

        //World Settings
        public final int maxWorldCol = 50; //Tergantung nanti ukuran map kita seberapa
        public final int maxWorldRow = 50; //Tergantung nanti ukuran map kita seberapa
        public final int worldWidth = tileSize * maxWorldCol;
        public final int worldHeight = tileSize * maxWorldRow;

        int FPS = 60;

        KeyHandler keyH = new KeyHandler();
        Thread gameThread;


        public CollisonChecker cCheker = new CollisonChecker(this);
        public AssetSetter aSetter = new AssetSetter(this);
        public UI ui = new UI(this);

        public Player player = new Player(this, keyH);
        TileManager tileM = new TileManager(this);
        public SuperObject obj[] = new SuperObject[20];
        
        public GamePanel() {
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }

        public void setupGame()
        {
            aSetter.setObject();
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

            // Tile
            tileM.draw(g2);
            System.out.println("PLAYER DRAW");

            // Objek 
            for(int i=0; i<obj.length; i++)
            {
                if(obj[i] != null)
                {
                    obj[i].draw(g2, this);
                }
            }

            // Player
            player.draw(g2);

            // UI
            ui.draw(g2);
            g2.dispose();
        }
}
