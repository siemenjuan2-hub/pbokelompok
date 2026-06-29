package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.*;

import entity.Entity;
import object.OBJ_Potion_Health;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    private Image titleBackground;
    public boolean massageOn = false;
    // public String massage = "";
    // int massageCounter = 0; // waktu notifikasi terlihat
    ArrayList<String>message = new ArrayList<>();
    ArrayList<Integer>messageCounter = new ArrayList<>();
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0"); // formating playtime
    public String currentDialogue = "";
    public int commandNum = 0; // menu
    public int playerSlotCol=0;
    public int playerSlotRow=0;

    public boolean saveGameOn = false; // Ini default nda save
    public boolean InfiniteMode = false;

    // BufferedImage coin;
    // // for icon (NGEBUG ND JELAS)
    // Entity iconcoin = new OBJ_Coin(gp);
    // coin = iconcoin.down1;

    // slot npc
    public int npcSlotCol=0;
    public int npcSlotRow=0;

    int subState = 0;

    public Entity npc;

    // BufferedImage heart_full, heart_half, heart_blank;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        titleBackground = new ImageIcon("src/assets/MainMenu/mainmenu.png").getImage();
    }

    public void showMassage(String text){

        message.add(text);
        messageCounter.add(0);
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        //TITLE STATE
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        // play state
        if(gp.gameState == gp.playState){
            if(gp.currentMap == 2){
                if(InfiniteMode){
                    g2.drawString("Infinite Mode", gp.getWidth() / 2, gp.tileSize / 2);
                    g2.drawString("Highest Level: " + gp.player.getDungeonInfiniteHighest(), gp.tileSize/8, gp.tileSize / 2);
                    g2.drawString("Current Level: " + gp.player.getDungeonInfiniteLevel(), gp.tileSize/8, gp.tileSize);
                }else{
                    g2.drawString("Story Mode", gp.getWidth() / 2, gp.tileSize / 2);
                    g2.drawString("DungeonStage: " + gp.player.getDungeonStage(), gp.tileSize/8, gp.tileSize / 2);
                    g2.drawString("DungeonLevel: " + gp.player.getDungeonLevel(), gp.tileSize/8, gp.tileSize);
                }
            }
            if(gp.currentMap == 3){
                g2.drawString("BOSS FIGHT", gp.getWidth() / 2, gp.tileSize / 2);
                g2.drawString("Current Monster: " + gp.aSetter.monsterCounterDungeon, gp.tileSize/8, gp.tileSize / 2);
            }
            if(gp.currentMap == 4){
                g2.drawString("BOSS FIGHT FASE 2", gp.getWidth() / 2, gp.tileSize / 2);
                g2.drawString("Current Monster: " + gp.aSetter.monsterCounterDungeon, gp.tileSize/8, gp.tileSize / 2);
            }
            g2.drawString("HP: " + gp.player.getHp() + "/" + gp.player.getMaxHp(), gp.tileSize/8, gp.getHeight() - gp.tileSize / 2);
            g2.drawString("AGI: " + dFormat.format(gp.player.stamina) + "/" + gp.player.maxStamina, gp.tileSize*2, gp.getHeight() - gp.tileSize / 2);
            // g2.drawString("Potion: " + gp.player.hasPotion, gp.tileSize*4, gp.tileSize*8);
            showMassage();
        }

        // pause state
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        // dialog state
        if(gp.gameState == gp.dialogState){
            drawDialogScreen();
        }
        // character state
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory(gp.player, true);
        }
        // option state
        if(gp.gameState == gp.optionState){
            drawOptionScreen();
        }
        if(gp.gameState == gp.gameOverState){
            drawGameOverScreen();
        }
        // trade state
        if(gp.gameState == gp.tradeState){
            drawTradeScreen();
        }
        // Dungeon Option
        if(gp.gameState == gp.dungeonOption){
            drawDungeonOption();
        }

    }

    public void drawDungeonOption(){
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(32F));

        int frameWidth = gp.tileSize * 5;
        int frameHeight = gp.tileSize * 6;
        int frameX = gp.getWidth() / 2 - frameWidth / 2;
        int frameY = gp.getHeight() / 2 - frameHeight / 2;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        optionDungeon(frameX, frameY);

        gp.keyH.enterPressed = false;
    }

    public void optionDungeon(int frameX, int frameY){

        int textX;
        int textY;

        // TITLE
        String text = "Enter Dungeon";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize / 2;
        g2.drawString(text, textX, textY);

        // END GAME
        textY+=gp.tileSize/2;
        g2.drawString("Choose Mode", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX - 35, textY);
            if (gp.keyH.enterPressed == true) {
                gp.eHandler.TeleportDungeon(gp.dialogState);
            }
        }

        // BACK
        textY+=gp.tileSize*2;
        g2.drawString("Back", textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX - 35, textY);
            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }

        // Story / Infinite
        textY += (gp.tileSize / 2) * 2 + gp.tileSize / 4;
        
        String toggleText = "";
        if(commandNum == 0){
            if (InfiniteMode == false) {
                toggleText = "Story Mode";
            } else {
                toggleText = "Infinite Mode";
            }
            g2.drawString("< " + toggleText + " >", textX - 35, textY);
        }else {
            g2.drawString(toggleText, textX - 35, textY);
        }
    }


    public void drawGameOverScreen() {
        g2.setColor(new Color (0,0,0,150));
        if(!gp.fullScreenOn){
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        }else{
            g2.fillRect(0, 0, gp.screenWidth2, gp.screenHeight2);
        }

        int x;
        int y;
        String text;

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

        text = "Game Over";

        //SHADOW
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize * 2;
        g2.drawString(text, x, y);

        //MAIN
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);

        //RETRY
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y = gp.tileSize * 5;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x-40, y);
        }

        //QUIT
        text = "Quit";
        x = getXforCenteredText(text);
        y = gp.tileSize * 6;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x-40, y);
        }

    }

    public void drawOptionScreen(){
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(32F));

        int frameWidth = gp.tileSize * 5;
        int frameHeight = gp.tileSize * 6;
        int frameX = gp.getWidth() / 2 - frameWidth / 2;
        int frameY = gp.getHeight() / 2 - frameHeight / 2;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        
        switch(subState){
            case 0: option_top(frameX, frameY);break;
            case 1: options_fullScreenNotification(frameX, frameY);break;
            case 2: options_control(frameX, frameY);break;
            case 3: options_endGameConfirmation(frameX, frameY);break;
        }

        gp.keyH.enterPressed = false;
    }

    // Screen Trade
    public void drawTradeScreen()
    {
        switch(subState)
        {
            case 0: trade_select(); break;
            case 1: trade_buy(); break;
            case 2: trade_sell(); break;
            case 3: trade_upgrade(); break;
        }
        gp.keyH.enterPressed = false;
    }

    public void trade_select()
    {
        drawDialogScreen();

        // DRAW WINDOW
        int dialogX = gp.tileSize * 2;
        int dialogY = gp.tileSize / 2;
        int dialogWidth = gp.screenWidth - (gp.tileSize * 4);
        int dialogHeight = gp.tileSize * 2;

        int width = 180;
        int height = 200;
        int x = dialogX + dialogWidth - width;
        int y = dialogY + dialogHeight + 10;

        drawSubWindow(x, y, width, height);

        // DRAW TEXT
        int textX = x + 25;
        int textY = y + 45;
        int lineSpace = 45;

        g2.drawString("Buy", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-20, textY);
            if(gp.keyH.enterPressed == true){
                subState = 1;
            }
        }
        textY += lineSpace;

        g2.drawString("Sell", textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX-20, textY);
            if(gp.keyH.enterPressed == true){
                subState = 2;
            }
        }
        textY += lineSpace;

        g2.drawString("Upgrade", textX, textY);
        if(commandNum == 2){
            g2.drawString(">", textX-20, textY);
            if(gp.keyH.enterPressed == true){
                subState = 3;
            }
        }        
        textY += lineSpace;

        g2.drawString("Leave", textX, textY);
        if(commandNum == 3){
            g2.drawString(">", textX-20, textY);
            if(gp.keyH.enterPressed == true){
                commandNum = 0;
                gp.gameState = gp.dialogState;
                currentDialogue = "Come again soon!";
            }
        }        
    }

    public void trade_buy()
    {
        // DRAW PLAYER INVENTORY
        drawInventory(gp.player, false);
        
        // DRAW NPC INVENTORY
        drawInventory(npc, true);

        // DRAW HINT WINDOW
        int x = (gp.tileSize * 2);
        int y = gp.tileSize *5;
        int width = ((gp.tileSize/2) * 5) + 70;
        int height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] Back", x+24, y+75);
        
        // DRAW PLAYER'S COIN
        x = gp.screenWidth - width - gp.tileSize;;
        y = gp.tileSize *5;
        width = ((gp.tileSize/2) * 5) + 70;
        height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("Your Coins: " + gp.player.coin, x+24, y+75);

        // DRAW PRICE WINDOW
        int itemIndex = getItemIndex(npcSlotCol, npcSlotRow);
        if(itemIndex < npc.inventory.size()){
            x = (int) (gp.tileSize * 2.5) + 160;
            y = (int) (gp.tileSize * 2.5) + 100;
            width = (int) (gp.tileSize * 2.5) / 2;
            height = gp.tileSize / 2;
            drawSubWindow(x, y, width, height);

            int price = npc.inventory.get(itemIndex).price;
            String text = "$"+ price;
            g2.drawString(text, x+80, y+40);

            // BUY ITEM
            if(gp.keyH.enterPressed == true)
            {
                if(npc.inventory.get(itemIndex).price > gp.player.coin){
                    subState = 0;
                    gp.gameState = gp.dialogState;
                    currentDialogue = "You need more coins to buy that!";
                    drawDialogScreen();
                }
                else{
                    if(gp.player.canObtainItem(npc.inventory.get(itemIndex)) == true){
                        gp.player.coin -= npc.inventory.get(itemIndex).price;
                    }
                    else {
                        subState = 0;
                        gp.gameState = gp.dialogState;
                        currentDialogue = "You cannot carry any more items!";
                    }
                }
                // else if(gp.player.inventory.size() == gp.player.inventorySize){
                //     subState = 0;
                //     gp.gameState = gp.dialogState;
                //     currentDialogue = "You cannot carry any more items!";
                // }
                // else{
                //     gp.player.coin -= npc.inventory.get(itemIndex).price;
                //     gp.player.inventory.add(npc.inventory.get(itemIndex));
                // }
            }
        }
    }

    public void trade_sell()
    {
        // DRAW PLAYER INVENTORY
        drawInventory(gp.player, true);

        int x;
        int y;
        int width;
        int height;

        // DRAW HINT WINDOW
        x = (gp.tileSize * 2);
        y = gp.tileSize *5;
        width = ((gp.tileSize/2) * 5) + 70;
        height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] Back", x+24, y+75);
        
        // DRAW PLAYER'S COIN
        x = gp.screenWidth - width - gp.tileSize;;
        y = gp.tileSize *5;
        width = ((gp.tileSize/2) * 5) + 70;
        height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("Your Coins: " + gp.player.coin, x+24, y+75);

        // DRAW PRICE WINDOW
        int itemIndex = getItemIndex(playerSlotCol, playerSlotRow);
        if(itemIndex < gp.player.inventory.size()){
            x = (int) (gp.tileSize * 7) + 90;
            y = (int) (gp.tileSize * 2.5) + 100;
            width = (int) (gp.tileSize * 2.5) / 2;
            height = gp.tileSize / 2;
            drawSubWindow(x, y, width, height);

            int price = gp.player.inventory.get(itemIndex).price;
            String text = "$"+ price;
            g2.drawString(text, x+80, y+40);

            // SELL ITEM
            if(gp.keyH.enterPressed == true)
            {
                if(gp.player.inventory.get(itemIndex) == gp.player.currentSword ||
                gp.player.inventory.get(itemIndex) == gp.player.currentArmor){
                    commandNum = 0;
                    subState = 0;
                    gp.gameState = gp.dialogState;
                    currentDialogue = "You cannot sell an equipped item!";
                }
                else{
                    if(gp.player.inventory.get(itemIndex).amount > 1){
                        gp.player.inventory.get(itemIndex).amount--;
                    }
                    else{
                        gp.player.inventory.remove(itemIndex);
                    }
                    gp.player.coin += price;
                }
            }
        }
    }

    public void trade_upgrade()
    {
        // DRAW PLAYER INVENTORY
        drawInventory(gp.player, true);

        int x;
        int y;
        int width;
        int height;

        // DRAW HINT WINDOW
        x = (gp.tileSize * 2);
        y = gp.tileSize *5;
        width = ((gp.tileSize/2) * 5) + 70;
        height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("[ESC] Back", x+24, y+75);
        
        // DRAW PLAYER'S COIN
        x = gp.screenWidth - width - gp.tileSize;;
        y = gp.tileSize *5;
        width = ((gp.tileSize/2) * 5) + 70;
        height = (gp.tileSize/2) * 2;
        drawSubWindow(x, y, width, height);
        g2.drawString("Your Coins: " + gp.player.coin, x+24, y+75);

        // DRAW PRICE WINDOW
        int itemIndex = getItemIndex(playerSlotCol, playerSlotRow);
        if(itemIndex < gp.player.inventory.size()){
            x = (int) (gp.tileSize * 7) + 60;
            y = (int) (gp.tileSize * 2.5) + 100;
            width = (int) (gp.tileSize * 3.5) / 2;
            height = gp.tileSize / 2;
            drawSubWindow(x, y, width, height);

            String text = "Upgrade: $50";
            g2.drawString(text, x+20, y+40);

            // UPGRADE ITEM
            if(gp.keyH.enterPressed == true)
            {
                Entity selectedItem = gp.player.inventory.get(itemIndex);
                if(selectedItem.type != Entity.type_sword && selectedItem.type != Entity.type_armor){
                    gp.gameState = gp.dialogState;
                    currentDialogue = "Only weapon and armor \ncan be upgraded!";
                    return;
                }
                if(selectedItem.upgradeLevel >= 5){
                    gp.gameState = gp.dialogState;
                    currentDialogue = "This item is already MAX \nlevel!";
                    return;
                }
                if(gp.player.coin < 50){
                    gp.gameState = gp.dialogState;
                    currentDialogue = "Not enough coins!";
                    return;
                }
                int materialIndex = gp.player.findUpgradeMaterial(selectedItem);

                if(materialIndex == 999){
                    gp.gameState = gp.dialogState;
                    currentDialogue = "You need another " + selectedItem.name + "\nto Upgrade this!";
                    return;
                }             
                
                gp.player.inventory.remove(materialIndex);
                gp.player.coin -= 50;

                if(selectedItem.type == Entity.type_sword){
                    selectedItem.attackValue++;
                }     
                if(selectedItem.type == Entity.type_armor){
                    selectedItem.defenseValue++;
                }

                selectedItem.upgradeLevel++;
                gp.player.updateStats();



                // if(gp.player.inventory.get(itemIndex) == gp.player.currentSword ||
                // gp.player.inventory.get(itemIndex) == gp.player.currentArmor){
                //     commandNum = 0;
                //     subState = 0;
                //     gp.gameState = gp.dialogState;
                //     currentDialogue = "You cannot sell an equipped item!";
                // }
                // else{
                //     if(gp.player.inventory.get(itemIndex).amount > 1){
                //         gp.player.inventory.get(itemIndex).amount--;
                //     }
                //     else{
                //         gp.player.inventory.remove(itemIndex);
                //     }
                //     gp.player.coin += price;
                // }
            }
        }
    }    

    public void option_top(int frameX, int frameY){

        int textX;
        int textY;

        // TITLE
        String text = "Option";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize / 2;
        g2.drawString(text, textX, textY);

        // FULL SCREEN ON/OFF
        textX = frameX + gp.tileSize / 2;
        textY += gp.tileSize;
        g2.drawString("Full Screen", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX - 35, textY);
            if(gp.keyH.enterPressed){
                if(gp.fullScreenOn == false){
                    gp.fullScreenOn = true;
                }else{
                    gp.fullScreenOn = false;
                }
                subState = 1;
            }
        }

        // MUSIC
        textY+=gp.tileSize/2;
        g2.drawString("Music", textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX - 35, textY);
        }

        // SE
        textY+=gp.tileSize/2;
        g2.drawString("SE", textX, textY);
        if(commandNum == 2){
            g2.drawString(">", textX - 35, textY);
        }

        // CONTROL
        textY+=gp.tileSize/2;
        g2.drawString("Control", textX, textY);
        if(commandNum == 3){
            g2.drawString(">", textX - 35, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 2;
                commandNum = 0;
            }
        }

        // END GAME
        textY+=gp.tileSize/2;
        g2.drawString("Exit", textX, textY);
        if(commandNum == 4){
            g2.drawString(">", textX - 35, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 3;
            }
        }

        // BACK
        textY+=gp.tileSize*2;
        g2.drawString("Back", textX, textY);
        if(commandNum == 5){
            g2.drawString(">", textX - 35, textY);
            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.playState;
                commandNum = 0;

            }
        }

        // FULL SCREEN CHECK BOX
        textX = frameX + gp.tileSize*3;
        textY = frameY + gp.tileSize + gp.tileSize / 4;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX, textY, 30, 30);
        if(gp.fullScreenOn){
            g2.fillRect(textX, textY, 30, 30);
        }

        // MUSIC VOLUME
        textY += gp.tileSize / 2;
        g2.drawRect(textX, textY, 200, 30);
        int volumeWidth = 40 * gp.music.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        // SE
        textY += gp.tileSize / 2;
        g2.drawRect(textX, textY, 200, 30);
        volumeWidth = 40 * gp.se.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        // SAVE / DONT SAVE
        textY += (gp.tileSize / 2) * 2 + gp.tileSize / 4;
        
        String toggleText = "";
        if(commandNum == 4){
            if (saveGameOn == true) {
                toggleText = "Save";
                if(gp.keyH.enterPressed){
                    commandNum = 0;
                    subState = 0;
                    gp.saveLoad.save();
                    gp.gameState = gp.titleState;
                }
            } else {
                toggleText = "Dont Save";
                if(gp.keyH.enterPressed){
                    commandNum = 0;
                    subState = 0;
                    gp.gameState = gp.titleState;
                }
            }
            g2.drawString("< " + toggleText + " >", textX - 35, textY);
        }else {
            g2.drawString(toggleText, textX - 35, textY);
        }

        gp.config.saveConfig();
    }

    public void showMassage(){
        int messageX=gp.tileSize;
        int messageY=gp.tileSize*4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,37F));

        for(int i = 0; i< message.size();i++){
            if(message.get(i)!=null){
                g2.setColor(Color.black);
                g2.drawString(message.get(i), messageX+2, messageY+2);
                g2.setColor(Color.red);
                g2.drawString(message.get(i), messageX, messageY);

                int counter = messageCounter.get(i) + 1; //message coutner
                messageCounter.set(i,counter);//set the counter to the array
                messageY+=50;
                
                if(messageCounter.get(i)>180){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }

    }
    public void drawTitleScreen() {

        //BACKGROUND COLOR
        g2.drawImage(titleBackground, 0, 0, gp.getWidth(), gp.getHeight(), gp);

        //TITLE NAME
        String text = "Is it Wrong to Save a Girl in a Dungeon";
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
        int x = getXforCenteredText(text);
        int y = gp.getHeight() / 6;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);

        // MAIN COLOR
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        //Display Apapun lah yang ada dilayar utama
        x = gp.getWidth() / 2 - gp.player.entitySize / 2;
        y = gp.getHeight()/ 2 + 100;
        g2.drawImage(gp.player.up1, x, y, gp.player.entitySize, gp.player.entitySize, null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        int menuY = gp.getHeight() * 2 / 3;
        text = "NEW GAME";
        x = getXforCenteredText(text);

        g2.drawString(text, x, menuY);

        if(commandNum == 0){
            g2.drawString(">", x - 50, menuY);
        }


        menuY += 100;
        text = "LOAD GAME";
        x = getXforCenteredText(text);
        g2.drawString(text, x, menuY);
        if(commandNum == 1){
            g2.drawString(">", x - 50, menuY);
        }

        menuY += 100;
        text = "QUIT";
        x = getXforCenteredText(text);
        g2.drawString(text, x, menuY);
        if(commandNum == 2){
            g2.drawString(">", x - 50, menuY);
        }
    }

    public void drawDialogScreen(){
        //window
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 2;
        drawSubWindow(x, y, width, height);
        
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 35F));
        x += gp.tileSize;
        y += gp.tileSize;
        // g2.drawString(currentDialogue, x, y);
        
        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40; // jarak antar baris
        }
    }
    
    public void drawCharacterScreen(){

        // BUAT FRAME
        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*3;
        final int frameHeight = gp.tileSize*6;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // TEXT
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + 50;
        int buttomText = frameHeight+frameY;
        final int LineHeight = 50;

        // NAMES
        g2.drawString("Level", textX, textY);
        textY += LineHeight;
        g2.drawString("Exp", textX, textY);
        textY += LineHeight;
        g2.drawString("Hp", textX, textY);
        textY += LineHeight;
        g2.drawString("Attack", textX, textY);
        textY += LineHeight;
        g2.drawString("Defense", textX, textY);
        textY += LineHeight;

        // Item Player (di Bawah)
        g2.drawString("Armor", textX, buttomText-LineHeight*3);
        g2.drawString("Sword", textX, buttomText-LineHeight);

        // ISI (RATA KANAN)
        int tailX = (frameX + frameWidth) - 30;

        // reset TextY
        textY = frameY + 50;
        String value;

        value = String.valueOf(gp.player.getLevel());
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += LineHeight;

        value = String.valueOf(gp.player.getExp() + "/" + gp.player.getNextLevelExp());
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += LineHeight;

        value = String.valueOf(gp.player.getHp() + "/" + gp.player.getMaxHp());
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += LineHeight;

        value = String.valueOf(gp.player.getAtk() + "(+" + gp.player.currentSword.attackValue + ")");
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += LineHeight;

        value = String.valueOf(gp.player.getDefense() + "(+" + gp.player.currentArmor.defenseValue + ")");
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += gp.tileSize*3;

        g2.drawImage(gp.player.currentArmor.down1, textX, buttomText-LineHeight*4, null);
        textY += gp.tileSize*3;
        g2.drawImage(gp.player.currentSword.down1, textX, buttomText-LineHeight*2, null);

    }

    public void drawInventory(Entity entity, boolean cursor){
        int frameX = 0;
        int frameY = 0;
        int frameWidth = 0;
        int frameHeight = 0;
        int slotCol = 0;
        int slotRow = 0;

        if(entity == gp.player){
            frameWidth = ((gp.tileSize/2)* 5) + 70;
            frameHeight = ((gp.tileSize/2)* 5);
            frameX = gp.screenWidth - frameWidth - gp.tileSize;
            frameY = gp.tileSize;
            slotCol = playerSlotCol;
            slotRow = playerSlotRow;
        }
        else {
            frameWidth = ((gp.tileSize/2) * 5) + 70;
            frameHeight = (gp.tileSize/2) * 5;
            frameX = gp.tileSize * 2;
            frameY = gp.tileSize;
            slotCol = npcSlotCol;
            slotRow = npcSlotRow;
        }

        // int frameX = gp.tileSize * 6;
        // int frameY = gp.tileSize;
        // int frameWidth = gp.tileSize * 6;
        // int frameHeight = gp.tileSize * 5;

        // perbaiki biar fleksibel


        // int frameX = gp.getWidth() / 2 - gp.tileSize;
        // int frameY = gp.getHeight() / 8;
        // int frameWidth = gp.tileSize * 6;
        // int frameHeight= gp.tileSize * 5;

        // FRAME
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        final int slotXstart = frameX + 30;
        final int slotYstart = frameY + 30;

        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotsize = (gp.tileSize/2)+3;


        // DRAW ITEMS
        for(int i = 0; i < entity.inventory.size(); i++){

            // EQUIP CURSOR
            if(entity.inventory.get(i) == entity.currentSword || 
            entity.inventory.get(i) == entity.currentArmor)
            {
                g2.setColor(new Color(240, 190, 90));
                g2.fillRoundRect(slotX, slotY, gp.tileSize/2, gp.tileSize/2, 5, 5);
            }

            g2.drawImage(
                entity.inventory.get(i).down1,
                slotX,
                slotY,
                gp.tileSize/2,
                gp.tileSize/2,
                null
            );

            //DISPLAY AMOUNT 
            if (entity == gp.player && entity.inventory.get(i).amount > 1) {
                g2.setFont(g2.getFont().deriveFont(32f));
                int amountX;
                int amountY;

                String s = "" + entity.inventory.get(i).amount;
                amountX = getXforAlignToRightText(s, slotX + (gp.tileSize / 2));
                amountY = slotY + (gp.tileSize) / 2;

                //SHADOW
                g2.setColor(new Color(60,60,60));
                g2.drawString(s, amountX, amountY);

                //NUMBER
                g2.setColor(Color.white);
                g2.drawString(s, amountX - 1, amountY - 1);
            }  

            Entity item = entity.inventory.get(i);

            if(item.type == Entity.type_sword ||
            item.type == Entity.type_armor){

                String s = "+" + item.upgradeLevel;

                int levelX = slotX + 4;
                int levelY = slotY + 18;

                g2.setFont(g2.getFont().deriveFont(18f));

                // shadow
                g2.setColor(new Color(60,60,60));
                g2.drawString(s, levelX + 1, levelY + 1);

                // text
                g2.setColor(Color.YELLOW);
                g2.drawString(s, levelX, levelY);
            }

            slotX += slotsize;
            
            //sebelum
            // if(i == 4 || i==9 || i ==16){
            //     slotX = slotXstart;
            //     slotY += slotsize;
            // }

            //sesudah
            if ((i + 1) % 5 == 0) {
                slotX = slotXstart;
                slotY += slotsize;
            }
        }

        // CURSOR (SELECTION)
        if(cursor == true){
            int cursorX = slotXstart + (slotsize * slotCol);
            int cursorY = slotYstart + (slotsize * slotRow);

            int cursorWidth = gp.tileSize/2;
            int cursorHeight = gp.tileSize/2;

            g2.setColor(Color.WHITE);
            g2.setStroke(new java.awt.BasicStroke(5));

            g2.drawRoundRect(
                cursorX,
                cursorY,
                cursorWidth,
                cursorHeight,
                10,
                10
            );

            //description frame

            int dframeX=frameX;
            int dframeY=frameY+frameHeight;
            int dframeWidth=frameWidth;
            int dframeHeight=(gp.tileSize/2)*3;
            drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);

            //text

            int textX = dframeX+20;

            int textY = dframeY+gp.tileSize/2;
            g2.setFont(g2.getFont().deriveFont(28F));

            int itemIndex = getItemIndex(slotCol, slotRow);
            if(itemIndex<entity.inventory.size()){
                for(String line:entity.inventory.get(itemIndex).description.split("\n")){

                    g2.drawString(line,textX,textY);
                    textY+=32;
                    
                }
            }
        }
    }

    public int getItemIndex(int slotCol, int slotRow){
        int itemIndex = slotCol + (slotRow * 5);
        return itemIndex;
    }

    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 150);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new java.awt.BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    public void options_fullScreenNotification(int frameX, int frameY){
        int textX = frameX + gp.tileSize / 2;
        int textY = frameY + gp.tileSize*2;

        currentDialogue = "The Change Will \nTake Effect \nAfter Restarting \nThe Game";

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line, textX, textY);
            textY+=50;
        }

        // BACK
        textY = frameY + gp.tileSize*5 + gp.tileSize / 2;
        g2.drawString("Back", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX - 40, textY);
            if(gp.keyH.enterPressed){
                subState = 0;
            }
        }
    }

    public void options_control(int frameX, int frameY) {
        int textX;
        int textY;

        //TITLE
        String text = "Control";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize - 50;
        g2.drawString(text, textX, textY);

        textX = frameX + gp.tileSize - 70;
        textY += gp.tileSize;
        g2.drawString("Move", textX, textY); textY += gp.tileSize - 50 ;
        g2.drawString("Confirm / Attack", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("Shoot / Cast", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("Character Screen", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("Pause", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("Options", textX, textY); textY += gp.tileSize - 50;


        textX = frameX + gp.tileSize + gp.tileSize * 2;
        textY = frameY + gp.tileSize + 78 ;
        g2.drawString("WASD", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("ENTER", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("F", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("C", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("P", textX, textY); textY += gp.tileSize - 50;
        g2.drawString("ESC", textX, textY); textY += gp.tileSize - 50;


        //BACK
        textX = frameX + gp.tileSize ;
        textY = frameY + (gp.tileSize * 5) + 50;
        g2.drawString("Back", textX - 50, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 75, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
            }
        }
    }
    public void options_endGameConfirmation (int frameX, int frameY) {
        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize *3;

        currentDialogue = "Quit the game and \n return to the title screen?";

        for(String line: currentDialogue.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += 40;
        }

        //YES
        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.tileSize * 3;
        g2.drawString(text, textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX-25, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
                gp.gameState = gp.titleState;
                gp.resetGame(true);
            }
        }


        //NO
        text = "No";
        textX = getXforCenteredText(text);
        textY += gp.tileSize ;
        g2.drawString(text, textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX-25, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
                commandNum = 3;
            }
        }


    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.getWidth() / 2 - length / 2;
    }

    public int getXforRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

    public int getXforAlignToRightText(String text, int tailX) {
    int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    int x = tailX - length;
    return x;
}

}
