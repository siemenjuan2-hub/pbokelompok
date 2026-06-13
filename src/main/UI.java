package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_AutumnBush;

public class UI {

    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage bush_image;
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
        OBJ_AutumnBush bush = new OBJ_AutumnBush();
        bush_image = bush.image;
    }

    public void showMassage(String text){
        massage = text;
        massageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished){
            // JIKA GAME TAMAT
            String text;
            int textLength;
            int x;
            int y;


            // MASSAGE JIKA GAME SELESAI
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            text = "You Found Hidden Ending!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize*4);
            g2.drawString(text, x, y);

            text = "Your Time Is: " + dFormat.format(playTime) + "!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize*3);
            g2.drawString(text, x, y);


            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize*2);
            g2.drawString(text, x, y);

            // GAME BERHENTI
            gp.gameThread = null;
        }else{

            
            // JIKA GAME BELUM TAMAT
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(bush_image, gp.tileSize/8, gp.tileSize/8, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey, 130, gp.tileSize/2+20);
            
            // PLAYED TIME
            playTime+=(double)1/60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 65);

            // MASSAGE (NOTIFIKASI)
            if(massageOn){

                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(massage, gp.tileSize/8, gp.tileSize*3);

                massageCounter++;

                if(massageCounter > 120){
                    massageCounter = 0;
                    massageOn = false;
                }
            }
        }
        
    }
}
