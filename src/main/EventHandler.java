package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = gp.tileSize / 4;
        eventRect.y = gp.tileSize / 4;
        eventRect.width = gp.tileSize / 2;
        eventRect.height = gp.tileSize / 2;
    }

    public void checkEvent() {
        //jika ingin menampilkan objek buat di AssetSetter dengan cordinat yang sama dengan event

        switch (gp.currentMap) {

            case 0:
                eventMap1();
                break;
            case 1:
                eventMap2();
            case 2:
                eventMap3();
        }

        
    }

    // EVENT MAP 1
    public void eventMap1(){
        // event 1: Burned Tree
        if(hit(25, 21)) {
            damagePit(gp.dialogState);
        }

        // event 2: Teleport (Masuk Rumah Trader)
        if(hit(37, 21) && gp.player.direction == "up") {
            TeleportRumahTrader(gp.dialogState);
        }

        if(hit(20, 21) && gp.player.direction == "up") {
            TeleportDungeon(gp.dialogState);
        }
    }

    // EVENT MAP 2
    public void eventMap2(){
        // event 1: Teleport OverWolrd
        if(hit(24, 28) && gp.player.direction == "down") {
            TeleportOverWorld(gp.dialogState);
        }
    }

    public void eventMap3(){
        if(hit(24, 40) && gp.player.direction == "down"){
            TeleportOverWorld(gp.dialogState);
        }
    }

    public boolean hit(int eventCol, int eventRow) {

        // hitbox player
        Rectangle playerArea = new Rectangle(
            gp.player.WorldX + gp.player.solidArea.x,
            gp.player.WorldY + gp.player.solidArea.y,
            gp.player.solidArea.width,
            gp.player.solidArea.height
        );

        // hitbox event
        Rectangle eventArea = new Rectangle(
            eventCol * gp.tileSize + eventRect.x,
            eventRow * gp.tileSize + eventRect.y,
            eventRect.width,
            eventRect.height
        );

        // jika playerArea berinteraksi dengan eventArea
        if(playerArea.intersects(eventArea)) {
                return true;
        }

        return false;
    }



    // EVENT: BURNED TREE
    public void damagePit(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Burned By A BurnedTree!!";
        gp.player.setHp(gp.player.getHp() - 10);
        
        gp.saveLoad.save();
    }

    // EVENT: TELEPORT

    // teleport rumah trader
    public void TeleportRumahTrader(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        // pindah map
        gp.currentMap = 1;
        gp.tileM.loadMap("/assets/Maps/Maps2", gp.currentMap);

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 23 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 26 + gp.tileSize / 2;
        gp.player.direction = "up";
    }

    // teleport dungeon
    public void TeleportDungeon(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        gp.currentMap = 2;
        gp.tileM.loadMap("/assets/Maps/Maps3", gp.currentMap);

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 23 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 38 + gp.tileSize / 2;
        gp.player.direction = "up";
    }

    // teleport OverWorld
    public void TeleportOverWorld(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        // pindah map
        gp.currentMap = 0;
        gp.tileM.loadMap("/assets/Maps/Maps1", gp.currentMap);

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 37 - gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 22 - gp.tileSize / 2;
        gp.player.direction = "down";
    }




    public void drawDebugMap1(Graphics2D g2) {
        drawEventRect(g2, 25, 21); // Burned Tree
        drawEventRect(g2, 37, 21); // Teleport Rumah Trader
        drawEventRect(g2, 20, 21); // Teleport Dungeon
    }

    public void drawDebugMap2(Graphics2D g2){
        drawEventRect(g2, 24, 28); // Teleport Over Wolrd
    }

    public void drawDebugMap3(Graphics2D g2){
        drawEventRect(g2, 24, 40); // Teleport balik overworld
    }

    private void drawEventRect(Graphics2D g2, int col, int row) {

        int screenX =
                col * gp.tileSize
                - gp.player.WorldX
                + gp.player.ScreenX
                + eventRect.x;

        int screenY =
                row * gp.tileSize
                - gp.player.WorldY
                + gp.player.ScreenY
                + eventRect.y;

        g2.setColor(Color.YELLOW);

        g2.drawRect(
                screenX,
                screenY,
                eventRect.width,
                eventRect.height
        );
    }
}
