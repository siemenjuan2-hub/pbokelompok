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
    DecimalFormat dFormat = new DecimalFormat("#0.00"); // formating playtime

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

        if(gp.gameState == gp.playState){
            // do play state stuff
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

        g2.drawString("HP: " + gp.player.getHp() + "/" + gp.player.getMaxHp(), gp.tileSize/8, gp.tileSize*8);
        g2.drawString("AGI: " + dFormat.format(gp.player.stamina) + "/" + gp.player.maxStamina, gp.tileSize*2, gp.tileSize*8);

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
