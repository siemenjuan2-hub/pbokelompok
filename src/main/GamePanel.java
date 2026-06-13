package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
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

        //FPS
        int FPS = 60;

        // SYSTEM
        KeyHandler keyH = new KeyHandler(this);
        Thread gameThread;
        public CollisonChecker cCheker = new CollisonChecker(this);
        public AssetSetter aSetter = new AssetSetter(this);
        public UI ui = new UI(this);
        TileManager tileM = new TileManager(this);
        
        // ENTITY & OBJECT
        public Player player = new Player(this, keyH);
        public SuperObject obj[] = new SuperObject[20];
        public Entity npc[] =  new Entity[10];
        
        //game state
        public int gameState;
        public final int playState = 1;
        public final int pauseState = 2;        

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
            aSetter.setNpc();
            gameState = playState;
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
            if(gameState == playState){
                // PLAYER
                player.update();

                // NPC
                for(int i = 0 ; i < npc.length ; i++){
                    if(npc[i] != null){
                        npc[i].update();
                    }
                }
            }
            else if(gameState == pauseState){
                // nothing
            }

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g; // ada beberapa function yang tidak ada di graphic biasa, jadi pakai 2d

            //Debug buat Liat Cetak Berapa Tile dalam nano seccond
            long drawStart = 0;
            if (keyH.checkDrawTime == true) {
                drawStart = System.nanoTime();    
            }

            // Tile
            tileM.draw(g2);
            System.out.println("PLAYER DRAW");

            // NPC 
            for(int i = 0 ; i < npc.length ; i++){
                if(npc[i] != null){
                    npc[i].draw(g2);
                }
            }

            // Player
            player.draw(g2);

            // Objek 
            for(int i=0; i<obj.length; i++)
            {
                if(obj[i] != null)
                {
                    obj[i].draw(g2, this);
                }
            }
            
            // UI
            ui.draw(g2);
            
            
            //Debug buat Liat Cetak Berapa Tile dalam nano seccond
            if (keyH.checkDrawTime == true) {
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;
                g2.setColor(Color.white);
                g2.drawString("Draw Time: " + passed , 10 , 400);
                System.out.println("Draw Time: " + passed);       
            }
            g2.dispose();

        
        }
}
