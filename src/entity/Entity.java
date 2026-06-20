package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;


public abstract class Entity {
    public GamePanel gp;
    public BufferedImage up1, up2, up3, up4, up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6;
    public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4,attackUp5, attackUp6,attackDown1, attackDown2, attackDown3, attackDown4,attackDown5, attackDown6, attackLeft1, attackLeft2, attackLeft3, attackLeft4,attackLeft5, attackLeft6, attackRight1, attackRight2, attackRight3, attackRight4, attackRight5, attackRight6 ;
    public BufferedImage image;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public Rectangle attackArea = new Rectangle(0, 0, 32, 32);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = true;
    String dialogues[] = new String[20];
    public int entitySize;
    public String names; // bedanya sama bawah apa cug
    
    // STATE
    public int WorldX, WorldY;
    public String direction = "down";
    public int spriteNum = 1;
    int dialogueIndex = 0;
    public boolean collisionON = false;
    public boolean invincible = false;
    boolean attack = false;
    public boolean alive = true;
    public boolean dying = false;

    boolean hpBarOn = false;

    // COUNTER 
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 60;
    int dyingCounter = 0;
    int hpBarCounter = 0;

    // CHARACTER ATRIBUTES
    public int type; // 0 = npc, 1 = monster.
    public String name; // Bedanya sama atas apa cug
    private int speed;
    // private int maxHp;
    // private int hp;
    public int maxHp;
    public int hp;

    // CHARACTER STATUS
    // public int maxLife;
    // public int life;

    

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

        //CEK COLLISON MONSTER
        gp.cCheker.checkEntity(this, gp.monster);
    
        // CEK COLLISON PLAYER    
        boolean contactPlayer = gp.cCheker.checkPlayer(this);
            if(this.type == 1 && contactPlayer == true){
                if(gp.player.invincible == false){
                    gp.player.setHp(gp.player.getHp() - 1);
                    gp.player.invincible = true;
                }
            }

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

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 40) { // Angka 40 = seberapa lama monster berkedip (bisa diubah)
                invincible = false;
                invincibleCounter = 0;
            }
        }        
    }

    public BufferedImage setUp (String ImagePath, int width, int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(ImagePath + ".png"));
            
            // REVISI 2: Masukkan variabel playerSize ke dalam fungsi scaleImage
            image = uTool.scaleImage(image, width * 2, height * 2);

            
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

            // HP BAR MONSTER SLIME IJO
            if(type == 1 && hpBarOn == true)
            {
                double oneScale = (double) entitySize/maxHp;
                double hpBarValue = oneScale * hp;
                
                g2.setColor(new Color(35,35,35));
                g2.fillRect(screenX-1, screenY-16, entitySize + 2, 12);

                g2.setColor(new Color(255,0,30));
                g2.fillRect(screenX, screenY-15, (int)hpBarValue, 10);

                hpBarCounter++;

                if(hpBarCounter > 600)
                {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }

            if(invincible == true)
            {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4f);
            }
            if(dying == true)
            {
                dyingAnimation(g2); 
            }

            g2.drawImage(image, screenX, screenY, entitySize, entitySize, null);
            changeAlpha(g2, 1f);            

            // DEBUG HITBOX
            g2.setColor(java.awt.Color.PINK);
            g2.drawRect(
                screenX + solidArea.x,
                screenY + solidArea.y,
                solidArea.width,
                solidArea.height
            );
        }
    }

    public void dyingAnimation(Graphics2D g2)
    {
        dyingCounter++;
        int i =5;

        if(dyingCounter <= i)
        {
            changeAlpha(g2, 0);
        }
        if(dyingCounter > i && dyingCounter <= i*2)
        {
            changeAlpha(g2, 1);        
        }
        if(dyingCounter > i*2 && dyingCounter <= i*3)
        {
            changeAlpha(g2, 0);        
        }
        if(dyingCounter > i*3 && dyingCounter <= i*4)
        {
            changeAlpha(g2, 1);
        }
        if(dyingCounter > i*4 && dyingCounter <= i*5)
        {
            changeAlpha(g2, 0);        
        }
        if(dyingCounter > i*5 && dyingCounter <= i*6)
        {
            changeAlpha(g2, 1);
        }
        if(dyingCounter > i*6 && dyingCounter <= i*7)
        {
            changeAlpha(g2, 0);
        }  
        if(dyingCounter > i*7 && dyingCounter <= i*8)
        {
            changeAlpha(g2, 1);
        }
        if(dyingCounter > i*8)
        {
            dying = false;
            alive = false;
        }
    }

    public void changeAlpha(Graphics2D g2, float alphaValue)
    {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
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
