package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    boolean spawn1 = false;
    boolean spawn2 = false;
    boolean spawn3 = false;
    boolean spawn4 = false;


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
                break;
            case 2:
                eventMap3();
                break;
            case 3:
                eventMap4();
                break;
            case 4:
                eventMap5();
                break;
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
            gp.gameState = gp.dungeonOption;
        }
    }

    // EVENT MAP 2
    public void eventMap2(){
        // event 1: Teleport OverWolrd
        if(hit(24, 28) && gp.player.direction == "down") {
            TeleportOverWorldRumah(gp.dialogState);
        }
    }

    public void eventMap3(){
        if(hit(24, 9) && gp.player.direction == "up" && gp.aSetter.monsterCounterDungeon == 0){
            if(!gp.ui.InfiniteMode){
                if(gp.player.getDungeonStage() == 1 && gp.player.getDungeonLevel() == 1){
                    TeleportDungeonBoss(gp.dialogState);
                }else{
                    if(gp.player.getDungeonLevel() == 10){
                        gp.player.setDungeonLevel(1);
                    }else{
                        TeleportNextLevel(gp.dialogState);
                    }
                }
            }else{
                TeleportNextLevel(gp.dialogState);
            }
        }
        if(hit(24, 39) && gp.player.direction == "down"){
            if(gp.ui.InfiniteMode){
                gp.player.setDungeonInfiniteHighest(Math.max(gp.player.getDungeonInfiniteLevel(), gp.player.getDungeonInfiniteHighest()));
            }
            TeleportOverWorldDungeon(gp.dialogState);
        }
    }


    public void eventMap4(){
        
        if(gp.monster[3][0] == null){
            TeleportFase2(gp.dialogState);
        }else{
            if(gp.monster[3][0].getMaxHp() * 25 / 100 > gp.monster[3][0].getHp() && !spawn3){
                System.out.println("SPAWN SLIME MERAH");
                gp.aSetter.SpawnMonsterBoss();
                spawn3 = true;
            }
            else if(gp.monster[3][0].getMaxHp() * 50 / 100 > gp.monster[3][0].getHp() && !spawn2){
                System.out.println("SPAWN SLIME BIRU");
                gp.aSetter.SpawnMonsterBoss();
                spawn2 = true;
            }
            else if(gp.monster[3][0].getMaxHp() * 75 / 100 > gp.monster[3][0].getHp() && !spawn1){
                System.out.println("SPAWN SLIME HIJAU");
                gp.aSetter.SpawnMonsterBoss();
                spawn1 = true;
            }else{
                System.out.println("Tidak Terdeteksi");
            }
        }
    }


    public void eventMap5(){
        if(gp.aSetter.monsterCounterDungeon == 0){
            TeleportOverWorldDungeon(gp.dialogState);
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
        if(gp.ui.InfiniteMode){
            gp.player.setDungeonInfiniteLevel(1);
            gp.ui.currentDialogue = "You Entered Infinite Mode!!";
        }else{
            gp.ui.currentDialogue = "You Entered Story Mode!!";
        }
        gp.currentMap = 2;
        gp.tileM.loadMap("/assets/Maps/Maps3", gp.currentMap);
        gp.aSetter.setMonsterDungeon();

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 23 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 37 + gp.tileSize / 2;
        gp.player.direction = "up";
    }

    // Teleport Fase 2
    public void TeleportFase2(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "FASE 2!!";
        gp.currentMap = 4;
        gp.tileM.loadMap("/assets/Maps/Maps5", gp.currentMap);
        gp.aSetter.setBossFase2();

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 22 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 37 + gp.tileSize / 2;
        gp.player.direction = "up";
    }


    public void TeleportNextLevel(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported To Next Level";
        gp.tileM.loadMap("/assets/Maps/Maps3", gp.currentMap);
        gp.aSetter.setMonsterDungeon();

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 23 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 38 + gp.tileSize / 2;
        gp.player.direction = "up";
        if(!gp.ui.InfiniteMode){
            gp.player.setDungeonLevel(gp.player.getDungeonLevel()+1);
        }
        gp.player.setDungeonInfiniteLevel(gp.player.getDungeonInfiniteLevel()+1);
    }

    public void TeleportDungeonBoss(int gameState){
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported To Boss Level!!";
        gp.currentMap = 3;
        gp.tileM.loadMap("/assets/Maps/Maps4", gp.currentMap);
        gp.aSetter.setMonsterDungeonBoss();

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 22 + gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 37 + gp.tileSize / 2;
        gp.player.direction = "up";
    }

    // teleport OverWorld
    public void TeleportOverWorldRumah(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported!!";
        // pindah map
        gp.currentMap = 0;
        gp.tileM.loadMap("/assets/Maps/Maps1", gp.currentMap);

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 37 - gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 22 - gp.tileSize / 2;
        gp.player.direction = "down";
        gp.aSetter.setNpc();
    }

    public void TeleportOverWorldDungeon(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDialogue = "You Teleported to OverWorld!!";
        // pindah map
        gp.currentMap = 0;
        gp.tileM.loadMap("/assets/Maps/Maps1", gp.currentMap);

        // atur lokasi player setelah teleport
        gp.player.WorldX = gp.tileSize * 20 - gp.tileSize / 2;
        gp.player.WorldY = gp.tileSize * 21 - gp.tileSize / 2;
        gp.player.direction = "down";
        gp.aSetter.setNpc();
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
        drawEventRect(g2, 24, 39); // Teleport balik overworld
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
