package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends Entity {
    KeyHandler keyH; 
    
    public int ScreenX;
    public int ScreenY;

    // public int hasKey = 0;
    public double stamina;
    public int maxStamina;
    boolean isiStamina;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
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
        maxStamina = 20;
        stamina = maxStamina;
        this.setMaxHp(100);
        this.setHp(this.getMaxHp());
        isiStamina = false;
        this.setSpeed(6);
        direction = "down";
        spriteNum = 1;
    }

    public void getPlayerImage() {
        //W
        up1 = setUp("/assets/Player/Tiles/TileR4C1");
        up2 = setUp("/assets/Player/Tiles/TileR4C2");
        up3 = setUp("/assets/Player/Tiles/TileR4C3");
        up4 = setUp("/assets/Player/Tiles/TileR4C4");
        up5 = setUp("/assets/Player/Tiles/TileR4C5");
        up6 = setUp("/assets/Player/Tiles/TileR4C6");

        //S
        down1 = setUp("/assets/Player/Tiles/TileR1C1");
        down2 = setUp("/assets/Player/Tiles/TileR1C2");
        down3 = setUp("/assets/Player/Tiles/TileR1C3");
        down4 = setUp("/assets/Player/Tiles/TileR1C4");
        down5 = setUp("/assets/Player/Tiles/TileR1C5");
        down6 = setUp("/assets/Player/Tiles/TileR1C6");

        //A
        left1 = setUp("/assets/Player/Tiles/TileR2C1");
        left2 = setUp("/assets/Player/Tiles/TileR2C2");
        left3 = setUp("/assets/Player/Tiles/TileR2C3");
        left4 = setUp("/assets/Player/Tiles/TileR2C4");
        left5 = setUp("/assets/Player/Tiles/TileR2C5");
        left6 = setUp("/assets/Player/Tiles/TileR2C6");

        //D
        right1 = setUp("/assets/Player/Tiles/TileR3C1");
        right2 = setUp("/assets/Player/Tiles/TileR3C2");
        right3 = setUp("/assets/Player/Tiles/TileR3C3");
        right4 = setUp("/assets/Player/Tiles/TileR3C4");
        right5 = setUp("/assets/Player/Tiles/TileR3C5");
        right6 = setUp("/assets/Player/Tiles/TileR3C6");
    }

    
    public void update() {
        if (keyH.shiftPrassed && stamina > 0 && !isiStamina) {
            this.setSpeed(10);
        } else {
            this.setSpeed(6);
            isiStamina = true;
        }

        if (stamina <= 0) {
            stamina = 0;
            isiStamina = true;
            this.setSpeed(6);
        }
        
        if (isiStamina) {
            if(keyH.shiftPrassed && stamina >= 5){
                isiStamina = false;
                this.setSpeed(10);
            }else{
                stamina+=0.01;
            }
        }
        
        if (stamina > 20) {
            stamina = 20;
        }
        
        if(keyH.upPressed == true||keyH.downPressed == true||keyH.leftPressed == true||keyH.rightPressed == true){
            
            if(keyH.upPressed == true){ direction = "up"; }
            if(keyH.downPressed == true){ direction = "down"; }
            if(keyH.rightPressed == true){ direction = "right"; }
            if(keyH.leftPressed == true){ direction = "left"; }

            // CHECK COLLUSION TILE
            collisionON = false;
            gp.cCheker.checkTile(this);

            // CHECK COLLUSION OBJEK
            int objIndex = gp.cCheker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK COLLUSION NPC
            int npcIndex = gp.cCheker.checkEntity(this, gp.npc);
            interactNpc(npcIndex);

            if (collisionON == false) {
                switch (direction) {
                    case "up": WorldY -= this.getSpeed(); break;
                    case "down": WorldY += this.getSpeed(); break;
                    case "left": WorldX -= this.getSpeed(); break;
                    case "right": WorldX += this.getSpeed(); break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(this.getSpeed() == 10){ 
                    stamina -= 1; 
                }
                
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
            // String ObjectName = gp.obj[i].name;
            // switch(ObjectName) {
            //     case "AutumnBush":
            //         hasKey++;
            //         gp.obj[i] = null;
            //         gp.ui.showMassage("You Got A Autumn Bush!");
            //         break;
            //     case "SnowBush":
            //         if(hasKey > 0) {
            //             gp.obj[i] = null;
            //             hasKey--;
            //             gp.ui.gameFinished = true;
            //         }
            //         break;
            // }
        }
    }
    
    public void interactNpc(int i){
        if(i != 999){
            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.dialogState;
                gp.npc[i].speak();
            }
            gp.keyH.enterPressed = false;
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

	@Override
	public void setAction() {
		//empty
	}
}