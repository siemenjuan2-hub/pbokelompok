package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;


public abstract class Entity {

    GamePanel gp;
    public int WorldX, WorldY;
    private int speed;
    private int maxHp;
    private int hp;
    public BufferedImage up1, up2, up3, up4, up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionON = false;
    public int actionLockCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public abstract void setAction();
    public void speak(){
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;
            if(dialogues[dialogueIndex] == null){
                dialogueIndex = 0;
            }
        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }

    }
    public void update(){

        setAction();
        collisionON = false;
        // Cek collison tile
        gp.cCheker.checkTile(this);

        // cek collison npc
        gp.cCheker.checkEntity(this, gp.npc);
        
        //CEK COLLISON OBJEK
        gp.cCheker.checkObject(this, false);
    
        // CEK COLLISON PLAYER    
        gp.cCheker.checkPlayer(this);

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
            if(spriteNum == 1){ spriteNum = 2; } 
            else if (spriteNum == 2){ spriteNum = 3; } 
            else if (spriteNum == 3){ spriteNum = 4; } 
            else if (spriteNum == 4){ spriteNum = 5; } 
            else if (spriteNum == 5){ spriteNum = 6; } 
            else if (spriteNum == 6){ spriteNum = 1; }
            spriteCounter = 0;
        }
    }

    public BufferedImage setUp (String ImagePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(ImagePath + ".png"));
            
            // REVISI 2: Masukkan variabel playerSize ke dalam fungsi scaleImage
            image = uTool.scaleImage(image, gp.tileSize * 2 , gp.tileSize * 2);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;
        int screenX = WorldX - gp.player.WorldX + gp.player.ScreenX;
        int screenY = WorldY - gp.player.WorldY + gp.player.ScreenY;

        if(WorldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX && 
            WorldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX && 
            WorldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY && 
            WorldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY)
        {

            switch(direction) {
            case "up":
                if (spriteNum == 1){ image = up1; } 
                else if (spriteNum == 2){ image = up2; } 
                else if (spriteNum == 3){ image = up1; } 
                else if (spriteNum == 4){ image = up2; } 
                else if (spriteNum == 5){ image = up1; } 
                else if (spriteNum == 6){ image = up2; }
                break;
            case "down":
                if (spriteNum == 1){ image = down1; } 
                else if (spriteNum == 2){ image = down2; } 
                else if (spriteNum == 3){ image = down1; } 
                else if (spriteNum == 4){ image = down2; } 
                else if (spriteNum == 5){ image = down1; } 
                else if (spriteNum == 6){ image = down2; }
                break;
            case "left":
                if (spriteNum == 1){ image = left1; } 
                else if (spriteNum == 2){ image = left2; } 
                else if (spriteNum == 3){ image = left1; } 
                else if (spriteNum == 4){ image = left2; } 
                else if (spriteNum == 5){ image = left1; } 
                else if (spriteNum == 6){ image = left2; }
                break;
            case "right":
                if (spriteNum == 1){ image = right1; } 
                else if (spriteNum == 2){ image = right2; } 
                else if (spriteNum == 3){ image = right1; } 
                else if (spriteNum == 4){ image = right2; } 
                else if (spriteNum == 5){ image = right1; } 
                else if (spriteNum == 6){ image = right2; }
                break;
        }
            
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }


    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    

}
