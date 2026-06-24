package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.*;

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
    public int slotCol=0;
    public int slotRow=0;


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
            g2.drawString("HP: " + gp.player.getHp() + "/" + gp.player.getMaxHp(), gp.tileSize/8, gp.tileSize*8);
            g2.drawString("AGI: " + dFormat.format(gp.player.stamina) + "/" + gp.player.maxStamina, gp.tileSize*2, gp.tileSize*8);
            g2.drawString("Potion: " + gp.player.hasPotion, gp.tileSize*4, gp.tileSize*8);
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
        // character status
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory();
        }

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

        value = String.valueOf(gp.player.getAtk() + "(+" + gp.player.getStrength() + ")");
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += LineHeight;

        value = String.valueOf(gp.player.getDefense() + "(+" + gp.player.getDef() + ")");
        textX = getXforRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += gp.tileSize*3;

        g2.drawImage(gp.player.currentArmor.down1, textX, buttomText-LineHeight*4, null);
        textY += gp.tileSize*3;
        g2.drawImage(gp.player.currentSword.down1, textX, buttomText-LineHeight*2, null);

    }

    public void drawInventory(){

        // int frameX = gp.tileSize * 6;
        // int frameY = gp.tileSize;
        // int frameWidth = gp.tileSize * 6;
        // int frameHeight = gp.tileSize * 5;

        // perbaiki biar fleksibel
        int frameWidth = (gp.tileSize * 5) + 40; 
        int frameHeight = gp.tileSize * 5;
        int frameX = gp.screenWidth - frameWidth - (gp.tileSize / 2);
        int frameY = gp.tileSize;        

        // int frameX = gp.getWidth() / 2 - gp.tileSize;
        // int frameY = gp.getHeight() / 8;
        // int frameWidth = gp.tileSize * 6;
        // int frameHeight= gp.tileSize * 5;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        final int slotXstart = frameX + 30;
        final int slotYstart = frameY + 30;

        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotsize =gp.tileSize+3;


        // DRAW ITEMS
        for(int i = 0; i < gp.player.inventory.size(); i++){

            // EQUIP CURSOR
            if(gp.player.inventory.get(i) == gp.player.currentSword || 
            gp.player.inventory.get(i) == gp.player.currentArmor)
            {
                g2.setColor(new Color(240, 190, 90));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            }

            g2.drawImage(
                gp.player.inventory.get(i).down1,
                slotX,
                slotY,
                gp.tileSize,
                gp.tileSize,
                null
            );

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
        int cursorX = slotXstart + (slotsize * slotCol);
        int cursorY = slotYstart + (slotsize * slotRow);

        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;

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
        int dframeHeight=gp.tileSize*3;
        drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);

        //text

        int textX = dframeX+20;

        int textY = dframeY+gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(28F));

        int itemIndex = getItemIndex();
        if(itemIndex<gp.player.inventory.size()){
            for(String line:gp.player.inventory.get(itemIndex).description.split("\n")){

                g2.drawString(line,textX,textY);
                textY+=32;
                
            }
        }
    }

    public int getItemIndex(){
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


    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.getWidth() / 2 - length / 2;
    }

    public int getXforRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

}
