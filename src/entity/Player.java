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
    int chargeCounter = 0;
    int attackCounter = 0;
    public int hasPotion = 0;
    public int entitySize = 256;
    public boolean atkDelay = false;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;

        // 1: Hitbox 
        solidArea = new Rectangle();
        solidArea.x = 90;                 // Jarak aman dari sisi kiri karakter
        solidArea.y = 120;                // Jarak aman dari kepala (hitbox melindungi area perut ke kaki)
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 64;            // Lebar kotak tabrakan (48 - 8 - 8)
        solidArea.height = 64;           // Tinggi kotak tabrakan
    

        attackArea.width = 64;           // Lebar area serangan (sesuai dengan sprite serangan)
        attackArea.height = 64;          // Tinggi area serangan (sesuai dengan sprite serangan)

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
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

        // PLAYER STATUS
        // maxLife = 6;
        // life = maxLife;
    }

    public void getPlayerImage() {
        //W
        up1 = setUp("/assets/Player/Tiles/TileR4C1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Player/Tiles/TileR4C2", gp.tileSize, gp.tileSize);
        up3 = setUp("/assets/Player/Tiles/TileR4C3", gp.tileSize, gp.tileSize);
        up4 = setUp("/assets/Player/Tiles/TileR4C4", gp.tileSize, gp.tileSize);
        up5 = setUp("/assets/Player/Tiles/TileR4C5", gp.tileSize, gp.tileSize);
        up6 = setUp("/assets/Player/Tiles/TileR4C6", gp.tileSize, gp.tileSize);

        //S
        down1 = setUp("/assets/Player/Tiles/TileR1C1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Player/Tiles/TileR1C2", gp.tileSize, gp.tileSize);
        down3 = setUp("/assets/Player/Tiles/TileR1C3", gp.tileSize, gp.tileSize);
        down4 = setUp("/assets/Player/Tiles/TileR1C4", gp.tileSize, gp.tileSize);
        down5 = setUp("/assets/Player/Tiles/TileR1C5", gp.tileSize, gp.tileSize);
        down6 = setUp("/assets/Player/Tiles/TileR1C6", gp.tileSize, gp.tileSize);

        //A
        left1 = setUp("/assets/Player/Tiles/TileR2C1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Player/Tiles/TileR2C2", gp.tileSize, gp.tileSize);
        left3 = setUp("/assets/Player/Tiles/TileR2C3", gp.tileSize, gp.tileSize);
        left4 = setUp("/assets/Player/Tiles/TileR2C4", gp.tileSize, gp.tileSize);
        left5 = setUp("/assets/Player/Tiles/TileR2C5", gp.tileSize, gp.tileSize);
        left6 = setUp("/assets/Player/Tiles/TileR2C6", gp.tileSize, gp.tileSize);

        //D
        right1 = setUp("/assets/Player/Tiles/TileR3C1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Player/Tiles/TileR3C2", gp.tileSize, gp.tileSize);
        right3 = setUp("/assets/Player/Tiles/TileR3C3", gp.tileSize, gp.tileSize);
        right4 = setUp("/assets/Player/Tiles/TileR3C4", gp.tileSize, gp.tileSize);
        right5 = setUp("/assets/Player/Tiles/TileR3C5", gp.tileSize, gp.tileSize);
        right6 = setUp("/assets/Player/Tiles/TileR3C6", gp.tileSize, gp.tileSize);
    }

    public void getPlayerAttackImage() {
        //W
        attackUp1 = setUp("/assets/Player/Tiles/TileR4C7", gp.tileSize, gp.tileSize);
        attackUp2 = setUp("/assets/Player/Tiles/TileR4C8", gp.tileSize, gp.tileSize);

        //S
        attackDown1 = setUp("/assets/Player/Tiles/TileR1C7", gp.tileSize, gp.tileSize);
        attackDown2 = setUp("/assets/Player/Tiles/TileR1C8", gp.tileSize, gp.tileSize);

        //A
        attackLeft1 = setUp("/assets/Player/Tiles/TileR2C7", gp.tileSize, gp.tileSize);
        attackLeft2 = setUp("/assets/Player/Tiles/TileR2C8", gp.tileSize, gp.tileSize);

        //D
        attackRight1 = setUp("/assets/Player/Tiles/TileR3C7", gp.tileSize, gp.tileSize);
        attackRight2 = setUp("/assets/Player/Tiles/TileR3C8", gp.tileSize, gp.tileSize);
    }

    
    public void update() {
        ScreenX = gp.getWidth()/2 - entitySize/2;
        ScreenY = gp.getHeight()/2 - entitySize/2;
        
        if (attack == true) {
            attack();
        } else {
            // Jika enter ditekan (dari KeyHandler), ubah status menjadi menyerang
            if (keyH.enterPressed == true) {
                attack = true;
                attackCounter = 0; // Reset counter serangan ke awal
            }

        
        if (keyH.shiftPressed && stamina > 0 && !isiStamina) {
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
        
        
        if (stamina >= 20) {
            isiStamina = false;
            stamina = 20;
        }

        if(getHp() <= 0){
            setHp(0);
            gp.gameState = gp.gameOverState;
        }

        invincibleCounter++;
        if (invincibleCounter > 60) {
                if (invincible == true) {
                invincible = false;
                invincibleCounter = 0;
            }
        }


        
        
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
        
        if (collisionON == false && keyH.upPressed == true || collisionON == false && keyH.downPressed == true || collisionON == false && keyH.rightPressed == true || collisionON == false && keyH.leftPressed == true) {
            switch (direction) {
                case "up": WorldY -= this.getSpeed(); break;
                case "down": WorldY += this.getSpeed(); break;
                case "left": WorldX -= this.getSpeed(); break;
                case "right": WorldX += this.getSpeed(); break;
            }
            // CHECK COLLUSION Event
            spriteCounter++;
            gp.eHandler.checkEvent();
        }else{
            isiStamina = true;
        }
        chargeCounter++;
        
        if(spriteCounter > 10){
            if(this.getSpeed() == 10){ 
                stamina -= 1; 
            }
            if(spriteNum == 1){ spriteNum = 2; }
            else if(spriteNum == 2){ spriteNum = 3; }
            else if(spriteNum == 3){ spriteNum = 4; }
            else if(spriteNum == 4){ spriteNum = 5; }
            else if(spriteNum == 5){ spriteNum = 6; }
            else if(spriteNum == 6){ spriteNum = 1; }
            spriteCounter = 0;
        }
        
        if(chargeCounter > 10) {
            if (atkDelay) {
                attack();
                atkDelay = false;
            }
            if (isiStamina) {
                if(keyH.shiftPressed && keyH.upPressed == false && keyH.downPressed == false && keyH.rightPressed == false && keyH.leftPressed == false){
                    stamina+=0.5;
                }else if(keyH.shiftPressed && stamina >= 5){
                    isiStamina = false;
                    this.setSpeed(10);
                }else{
                    stamina+=0.5;
                }
            }
            if(keyH.ePressed && this.getHp() < this.getMaxHp() && hasPotion > 0){
                this.setHp(this.getHp() + 10);
                hasPotion--;
            }
            chargeCounter = 0;
        }
    }
}
        
    public void attack(){
        attackCounter ++;

        if(attackCounter <= 5){
            spriteNum = 1;
        }
        if(attackCounter > 5 && attackCounter <= 25){
            spriteNum = 2;

            //Nyimpan Posisi saat ini
            int currentWorldX = WorldX;
            int currentWorldY = WorldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //Adjust posisi player untuk area serangan
            switch(direction){
                case "up":
                    WorldY -= attackArea.height;
                    break;
                case "down":
                    WorldY += attackArea.height;
                    break;
                case "left":
                    WorldX -= attackArea.width;
                    break;
                case "right":
                    WorldX += attackArea.width;
                    break;
            }

            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cCheker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            WorldX = currentWorldX;
            WorldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(attackCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attack = false;
        }

        // simpan
        int oldX = WorldX;
        int oldY = WorldY;


        int oldW = solidArea.width;
        int oldH = solidArea.height;

        solidArea.width = attackArea.width;
        solidArea.height = attackArea.height;

        // restore
        WorldX = oldX;
        WorldY = oldY;

        solidArea.width = oldW;
        solidArea.height = oldH;
    }

    public void pickUpObject(int i) {
        if(i != 999) {
            String ObjectName = gp.obj[i].name;
            switch(ObjectName) {
                case "AutumnBush":
                    hasPotion++;
                    gp.obj[i] = null;
                    gp.ui.showMassage("You Got A Autumn Bush!");
                    break;
            }
        }
    }
    
    public void interactNpc(int i){
        if(gp.keyH.enterPressed == true){
            if(i != 999){
                gp.gameState = gp.dialogState;
                gp.npc[i].speak();
            }
            else{
                if(attack == false){
                    attack = true;
                    spriteNum = 1;
                    spriteCounter = 0;
                }
            }
        }
    }

    public void contactMonster(int i){
        if(i != 999){
            if(invincible == false){
                this.setHp(this.getHp() - 1);
                invincible = true;
            }
        }
        
    }

    public void damageMonster(int i){
        if (i != 999) {
            // if (invincible == false ) {
            //     System.out.println("Monster Hit!");
                
            // } else {
            //     System.out.println("Miss!");
            // }
            if (gp.monster[i].invincible == false ) {
                System.out.println("Monster Hit!");
                gp.monster[i].hp -= 1;
                gp.monster[i].invincible = true;

                if(gp.monster[i].hp <= 0)
                {
                    gp.monster[i].dying = true;
                }
            } else {
                System.out.println("Miss!");

            }        
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        int tempScreenX = ScreenX;
        int tempScreenY = ScreenY;

        switch(direction) {
            case "up":
                if (attack == false) {
                    if (spriteNum == 1){ image = up1; } 
                    else if (spriteNum == 2){ image = up2; }
                    else if (spriteNum == 3){ image = up3; } 
                    else if (spriteNum == 4){ image = up4; } 
                    else if (spriteNum == 5){ image = up5; } 
                    else if (spriteNum == 6){ image = up6; } 
                }
                if (attack == true) {
                    tempScreenY = ScreenY - gp.tileSize;    // Geser gambar serangan ke atas
                    if (spriteNum == 1){ image = attackUp1; } 
                    else if (spriteNum == 2){ image = attackUp2; } 
                }
                break;


            case "down":
                if (attack == false) {
                    if (spriteNum == 1){ image = down1; } 
                    else if (spriteNum == 2){ image = down2; } 
                    else if (spriteNum == 3){ image = down3; } 
                    else if (spriteNum == 4){ image = down4; } 
                    else if (spriteNum == 5){ image = down5; } 
                    else if (spriteNum == 6){ image = down6; }
                }
                if (attack == true) {
                    if (spriteNum == 1){ image = attackDown1; } 
                    else if (spriteNum == 2){ image = attackDown2; } 
                }
                break;


            case "left":
                if (attack == false) {
                    if (spriteNum == 1){ image = left1; } 
                    else if (spriteNum == 2){ image = left2; } 
                    else if (spriteNum == 3){ image = left3; } 
                    else if (spriteNum == 4){ image = left4; } 
                    else if (spriteNum == 5){ image = left5; } 
                    else if (spriteNum == 6){ image = left6; }
                }
                if (attack == true) {
                    tempScreenX = ScreenX - gp.tileSize;    // Geser gambar serangan ke kiri
                    if (spriteNum == 1){ image = attackLeft1; } 
                    else if (spriteNum == 2){ image = attackLeft2; } 
                }
                break;


            case "right":
                if (attack == false) {
                    if (spriteNum == 1){ image = right1; } 
                    else if (spriteNum == 2){ image = right2; } 
                    else if (spriteNum == 3){ image = right3; } 
                    else if (spriteNum == 4){ image = right4; } 
                    else if (spriteNum == 5){ image = right5; } 
                    else if (spriteNum == 6){ image = right6; }
                }
                if (attack == true) {
                    tempScreenX = ScreenX + gp.tileSize;    // Geser gambar serangan ke kanan
                    if (spriteNum == 1){ image = attackRight1; } 
                    else if (spriteNum == 2){ image = attackRight2; } 
                }
                break;
        }

        if (invincible == true) {
            g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.3f));
        }

        g2.drawImage(image, tempScreenX, tempScreenY, entitySize, entitySize, null);

        // RESET ALPHA
        g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER,1f));

        // HITBOX PLAYER
        g2.setColor(java.awt.Color.GREEN);
        
        g2.drawRect(
            tempScreenX + solidArea.x,
            tempScreenY + solidArea.y,
            solidArea.width,
            solidArea.height);

            // HITBOX ATTACK
            if(attack){
            
                int atkX = tempScreenX + solidArea.x;
                int atkY = tempScreenY + solidArea.y;
            
                switch(direction){
            
                    case "up":
                        atkY -= attackArea.height;
                        break;
            
                    case "down":
                        atkY += solidArea.height;
                        break;
            
                    case "left":
                        atkX -= attackArea.width;
                        break;
            
                    case "right":
                        atkX += solidArea.width;
                        break;
                }
            
                g2.setColor(java.awt.Color.RED);
            
                g2.drawRect(
                    atkX,
                    atkY,
                    attackArea.width,
                    attackArea.height
                );
            }
        }
	@Override
	public void setAction() {
		//empty
	}
}