package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = gp.tileSize / 4;
        eventRect.y = gp.tileSize / 4;
        eventRect.width = gp.tileSize / 2;
        eventRect.height = gp.tileSize / 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {
        //jika ingin menampilkan objek buat di AssetSetter dengan cordinat yang sama dengan event

        // event 1: Burned Tree
        if(hit(25, 21)) {
            damagePit(gp.dialogState);
        }

        // event 2: Teleport (kanan bawah)
        if(hit(30, 21)) {
            if(gp.keyH.enterPressed) {
                Teleport1(gp.dialogState);
            }
        }

        // event 3: Teleport (kanan atas)
        if(hit(37, 41)) {
            if(gp.keyH.enterPressed) {
                Teleport2(gp.dialogState);
            }
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
            eventCol * gp.tileSize + eventRectDefaultX,
            eventRow * gp.tileSize + eventRectDefaultY,
            eventRect.width,
            eventRect.height
        );

        // jika playerArea berinteraksi dengan eventArea
        if(playerArea.intersects(eventArea)) {
                return true;
        }

        return false;
    }

    // event 1: Burned Tree
    public void damagePit(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Burned By A BurnedTree!!";
        gp.player.setHp(gp.player.getHp() - 10);
    }

    // event 2: Teleport
    public void Teleport1(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";

        if(gp.currentMap == 0){
            gp.currentMap = 1;
        }else if(gp.currentMap == 1){
            gp.currentMap = 0;
        }
        
        gp.tileM.loadMap("/assets/Maps/Maps2", gp.currentMap);
        // gp.player.WorldX = gp.tileSize * 37;
        // gp.player.WorldY = gp.tileSize * 41;
    }

    // event 3: Teleport
    public void Teleport2(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        gp.player.WorldX = gp.tileSize * 30;
        gp.player.WorldY = gp.tileSize * 21;
    }

    public void drawDebug(Graphics2D g2) {
        drawEventRect(g2, 25, 21); // Burned Tree
        drawEventRect(g2, 30, 21); // Teleport 1
        drawEventRect(g2, 37, 41); // Teleport 2
    }

    private void drawEventRect(Graphics2D g2, int col, int row) {

    int screenX =
            col * gp.tileSize
            - gp.player.WorldX
            + gp.player.ScreenX
            + eventRectDefaultX;

    int screenY =
            row * gp.tileSize
            - gp.player.WorldY
            + gp.player.ScreenY
            + eventRectDefaultY;

    g2.setColor(Color.YELLOW);

    g2.drawRect(
            screenX,
            screenY,
            eventRect.width,
            eventRect.height
    );
}
}
