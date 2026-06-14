package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = gp.tileSize/2;
        eventRect.y = gp.tileSize/2;
        eventRect.width = gp.tileSize/4;
        eventRect.height = gp.tileSize/4;
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
        gp.player.WorldX = gp.tileSize * 37;
        gp.player.WorldY = gp.tileSize * 41;
    }

    // event 3: Teleport
    public void Teleport2(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        gp.player.WorldX = gp.tileSize * 30;
        gp.player.WorldY = gp.tileSize * 21;
    }
}
