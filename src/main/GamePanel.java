package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import entity.Entity;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    // screen settings
    final int originalTileSize = 64;
    final int scale = 2;
    public final int tileSize = originalTileSize * scale; // 16x3 = 48 x 48 (1 tile)
    
    public int maxScreenCol = 10;
    public int maxScreenRow = 8;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels kesamping
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels kebawah
    public int screenWidth2;
    public int screenHeight2;
    
    //World Settings
    public final int maxWorldCol = 50; //Tergantung nanti ukuran map kita seberapa
    public final int maxWorldRow = 50; //Tergantung nanti ukuran map kita seberapa
    // public final int worldWidth = tileSize * maxWorldCol;
    // public final int worldHeight = tileSize * maxWorldRow;
    public final int maxMap = 10;
    public int currentMap = 0;
    
    //FPS
    int FPS = 60;

    // SYSTEM
    public KeyHandler keyH = new KeyHandler(this);
    public CollisonChecker cCheker = new CollisonChecker(this);
    // PERBAIKAN: Memisahkan Sound menjadi music dan se
    public Sound music = new Sound();
    public Sound se = new Sound();
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    TileManager tileM = new TileManager(this);
    Config config = new Config(this);
    Thread gameThread;

    // ENTITY & OBJECT
    public Player player = new Player(this, keyH);
    public Entity obj[][] = new Entity[maxMap][100];
    public Entity npc[][] =  new Entity[maxMap][30];
    public Entity monster[][] = new Entity[maxMap][100];
    ArrayList<Entity> entityList = new ArrayList<>();
    public EventHandler eHandler = new EventHandler(this);
    public boolean fullScreenOn = false;


    //===============================================================================================================================================
    //  NOTE: KARENA SEKARANG OBJ, MONSTER, DAN NPC MENJADI ARRAY 2 DIMENSI MAKA TERJADI PERUBAHAN BESAR DALAM PEMANGGILANNYA :V
    //  PENJELASAN: ARRAY PERTAMA UNTUK INISIALISASI MAP (DI MAP APA NPC, MONSTER ATAU OBJEK TERSEBUT DI BUAT) DAN ARRAY KEDUA SEPERTI BIASA (INDEX)
    //===============================================================================================================================================

    
    //game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogState = 3;
    public final int characterState = 4;
    public final int optionState = 5;
    public final int gameOverState = 6;
    public final int transitionState = 7; // belum dibuat video part #39 soalnya method teleportnya beda (class: EventHandler)
    public final int tradeState = 8;

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
        // playMusic(0);
        aSetter.setNpc();
        aSetter.setMonster();
        gameState = titleState;

        if(fullScreenOn){
            setFullScreen();
        }
    }

    public void retry(){
        player.restoredLifeAndMan();
        player.setDefaultPosition();
        aSetter.setNpc();
        aSetter.setMonster();
    }

    public void restart(){
        player.setDefaultPosition();
        player.setDefaultValues();
        player.restoredLifeAndMan();
        player.setItems();
        aSetter.setObject();
        aSetter.setNpc();
        aSetter.setMonster();
    }

    public void setFullScreen(){
        // GTE LOCAL SCREEN DEVICE
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        // GET FULL SCREEN WIDHT AND HEIGHT
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
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
            for(int i = 0 ; i < npc[1].length ; i++){
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].update();
                }
            }
            // MONSTER
            for(int i = 0; i < monster[1].length; i++) {
                if(monster[currentMap][i] == null) {
                    continue;
                }

                if(monster[currentMap][i].alive && !monster[currentMap][i].dying) {
                    monster[currentMap][i].update();
                }

                if(!monster[currentMap][i].alive) {
                    monster[currentMap][i].checkDrop();
                    monster[currentMap][i] = null;
                }
            }
        }
        else if(gameState == pauseState){
            // nothing
        }
        else if(gameState == characterState){

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
        
        //TITLE SCREEN
        if(gameState == titleState) {
            ui.draw(g2);
        } 
        else {
            // TILE
            tileM.draw(g2);

            //DEBUG TILE
            drawTileGrid(g2);
            
            //add entitty to list
            entityList.add(player);
            for(int i = 0 ; i < npc[1].length ; i++){
                if(npc[currentMap][i] != null){
                    entityList.add(npc[currentMap][i]);
                }
            }
            
            //object
            for(int i = 0 ; i < obj[1].length ; i++){
                if(obj[currentMap][i] != null){
                    entityList.add(obj[currentMap][i]);
                }
            }
            // monster
            for(int i = 0 ; i < monster[1].length ; i++){
                if(monster[currentMap][i] != null){
                    entityList.add(monster[currentMap][i]);
                }
            }
            //sort
            Collections.sort(entityList, new Comparator<Entity>(){
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.WorldY, e2.WorldY);
                    return result;
                }
            });
        
            //draw entity
            for(int i = 0; i < entityList.size();i++){
                entityList.get(i).draw(g2);
            }
            
            //empty list
            entityList.clear();
            
            //UI
            ui.draw(g2);
            eHandler.drawDebug(g2);
            g2.setColor(Color.RED);
        }
        
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

    // PERBAIKAN: Method suara menggunakan objek music dan se yang baru
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }
    
    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }

    public void drawTileGrid(Graphics2D g2){
        g2.setColor(Color.RED);

        for(int row = 0; row < maxWorldRow; row++){
            for(int col = 0; col < maxWorldCol; col++){

                int worldX = col * tileSize;
                int worldY = row * tileSize;

                int screenX = worldX - player.WorldX + player.ScreenX;
                int screenY = worldY - player.WorldY + player.ScreenY;

                // hanya gambar yang terlihat di layar
                if (
                    worldX + tileSize > player.WorldX - player.ScreenX &&
                    worldX - tileSize < player.WorldX - player.ScreenX + getWidth() &&
                    worldY + tileSize > player.WorldY - player.ScreenY &&
                    worldY - tileSize < player.WorldY - player.ScreenY + getHeight()
                ) {
                    g2.drawRect(
                        screenX,
                        screenY,
                        tileSize,
                        tileSize
                    );

                    g2.drawString(
                        col + "," + row,
                        screenX + 5,
                        screenY + 15
                    );
                }
            }
        }
    }
}