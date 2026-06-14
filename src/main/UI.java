package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean massageOn = false;
    public String massage = "";
    int massageCounter = 0; // waktu notifikasi terlihat
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0"); // formating playtime
    public String currentDialogue = "";
    public int commandNum = 0; // menu

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMassage(String text){
        massage = text;
        massageOn = true;
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
        }
        // pause state
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //dialog state
        if(gp.gameState == gp.dialogState){
            drawDialogScreen();
        }

    }

        public void drawTitleScreen() {

            //BACKGROUND COLOR
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            String text = "Is it Wrong to Save a Girl in a Dungeon";
            int x = getXforCenteredText(text) - 100;
            int y = gp.tileSize;

            //SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x + 5, y + 5);

            // MAIN COLOR
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            //Display Apapun lah yang ada dilayar utama 
            x = (gp.screenWidth / 2) - 150;
            y += gp.tileSize * 1.5;
            g2.drawImage(gp.player.down1, x - (gp.tileSize / 2), y - (gp.tileSize / 2), null);

            //MENU 
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));

            text = "NEW GAME";
            x = getXforCenteredText(text) - 100;
            y += gp.tileSize * 3;
            g2.drawString(text, x, y);

            if(commandNum == 0){
                g2.drawString(">", x - gp.tileSize, y);
            }


            text = "LOAD GAME";
            x = getXforCenteredText(text) - 100; 
            y += gp.tileSize * 1.2;
            g2.drawString(text, x, y);

            if(commandNum == 1){
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text) - 100;  
            y += gp.tileSize * 1.2;
            g2.drawString(text, x, y);

            if(commandNum == 2){
                g2.drawString(">", x - gp.tileSize, y);
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
            g2.drawString(currentDialogue, x, y);

            for(String line : currentDialogue.split("\n")) {
                g2.drawString(line, x, y);
                y += 40; // jarak antar baris
            }
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
    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
