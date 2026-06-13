package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH; 

    public int ScreenX;
    public int ScreenY;

    public int hasKey = 0;
    double stamina;
    boolean isiStamina;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        // REVISI 1: Hitbox yang pas untuk karakter berukuran 48x48
        solidArea = new Rectangle();
        solidArea.x = 90;                 // Jarak aman dari sisi kiri karakter
        solidArea.y = 128;                // Jarak aman dari kepala (hitbox melindungi area perut ke kaki)
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 64;            // Lebar kotak tabrakan (48 - 8 - 8)
        solidArea.height = 64;           // Tinggi kotak tabrakan
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        WorldX = gp.tileSize * 23;
        WorldY = gp.tileSize * 21; 
        stamina = 20;
        isiStamina = false;
        speed = 6;
        direction = "down";
        spriteNum = 1;
    }

    public void getPlayerImage() {
        //W
        up1 = setUp("TileR4C1");
        up2 = setUp("TileR4C2");
        up3 = setUp("TileR4C3");
        up4 = setUp("TileR4C4");
        up5 = setUp("TileR4C5");
        up6 = setUp("TileR4C6");

        //S
        down1 = setUp("TileR1C1");
        down2 = setUp("TileR1C2");
        down3 = setUp("TileR1C3");
        down4 = setUp("TileR1C4");
        down5 = setUp("TileR1C5");
        down6 = setUp("TileR1C6");

        //A
        left1 = setUp("TileR2C1");
        left2 = setUp("TileR2C2");
        left3 = setUp("TileR2C3");
        left4 = setUp("TileR2C4");
        left5 = setUp("TileR2C5");
        left6 = setUp("TileR2C6");

        //D
        right1 = setUp("TileR3C1");
        right2 = setUp("TileR3C2");
        right3 = setUp("TileR3C3");
        right4 = setUp("TileR3C4");
        right5 = setUp("TileR3C5");
        right6 = setUp("TileR3C6");
    }

    public BufferedImage setUp (String ImageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/" + ImageName + ".png"));
            
            // REVISI 2: Masukkan variabel playerSize ke dalam fungsi scaleImage
            image = uTool.scaleImage(image, gp.tileSize * 2 , gp.tileSize * 2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public void update() {
        if (keyH.shiftPrassed && stamina > 0 && !isiStamina) {
            speed = 10;
        } else {
            speed = 6;
        }

        if (stamina <= 0) {
            stamina = 0;
            isiStamina = true;
            speed = 6;
        }
        
        if (isiStamina && stamina >= 5) {
            isiStamina = false;
        }
        
        if (stamina > 20) {
            stamina = 20;
        }
        
        if(keyH.upPressed == true||keyH.downPressed == true||keyH.leftPressed == true||keyH.rightPressed == true){
            
            if(keyH.upPressed == true){ direction = "up"; }
            if(keyH.downPressed == true){ direction = "down"; }
            if(keyH.rightPressed == true){ direction = "right"; }
            if(keyH.leftPressed == true){ direction = "left"; }

            collisionON = false;
            gp.cCheker.checkTile(this);

            int objIndex = gp.cCheker.checkObject(this, true);
            pickUpObject(objIndex);

            if (collisionON == false) {
                switch (direction) {
                    case "up": WorldY -= speed; break;
                    case "down": WorldY += speed; break;
                    case "left": WorldX -= speed; break;
                    case "right": WorldX += speed; break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if (isiStamina) { stamina += 0.2; }
                if(speed == 10){ stamina -= 1; }
                
                if(spriteNum == 1){ spriteNum = 2; } 
                else if (spriteNum == 2){ spriteNum = 3; } 
                else if (spriteNum == 3){ spriteNum = 4; } 
                else if (spriteNum == 4){ spriteNum = 5; } 
                else if (spriteNum == 5){ spriteNum = 6; } 
                else if (spriteNum == 6){ spriteNum = 1; }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i) {
        if(i != 999) {
            String ObjectName = gp.obj[i].name;
            switch(ObjectName) {
                case "AutumnBush":
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMassage("You Got A Autumn Bush!");
                    break;
                case "SnowBush":
                    if(hasKey > 0) {
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.gameFinished = true;
                    }
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        ScreenX = gp.getWidth() / 2 - (gp.tileSize / 2);
        ScreenY = gp.getHeight() / 2 - (gp.tileSize / 2);

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1){ image = up1; } 
                else if (spriteNum == 2){ image = up2; } 
                else if (spriteNum == 3){ image = up3; } 
                else if (spriteNum == 4){ image = up4; } 
                else if (spriteNum == 5){ image = up5; } 
                else if (spriteNum == 6){ image = up6; }
                break;
            case "down":
                if (spriteNum == 1){ image = down1; } 
                else if (spriteNum == 2){ image = down2; } 
                else if (spriteNum == 3){ image = down3; } 
                else if (spriteNum == 4){ image = down4; } 
                else if (spriteNum == 5){ image = down5; } 
                else if (spriteNum == 6){ image = down6; }
                break;
            case "left":
                if (spriteNum == 1){ image = left1; } 
                else if (spriteNum == 2){ image = left2; } 
                else if (spriteNum == 3){ image = left3; } 
                else if (spriteNum == 4){ image = left4; } 
                else if (spriteNum == 5){ image = left5; } 
                else if (spriteNum == 6){ image = left6; }
                break;
            case "right":
                if (spriteNum == 1){ image = right1; } 
                else if (spriteNum == 2){ image = right2; } 
                else if (spriteNum == 3){ image = right3; } 
                else if (spriteNum == 4){ image = right4; } 
                else if (spriteNum == 5){ image = right5; } 
                else if (spriteNum == 6){ image = right6; }
                break;
        }

        g2.drawImage(image, ScreenX, ScreenY, null);
    }
}