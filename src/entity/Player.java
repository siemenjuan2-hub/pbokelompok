package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Armor_Normal;
import object.OBJ_Sword_Normal;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    
    
    public ArrayList <Entity> inventory = new ArrayList<>();
    public final int inventorySize = 20;

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
        setItems();
    }
    
    public void setDefaultValues() {
        WorldX = gp.tileSize * 23;
        WorldY = gp.tileSize * 21;
        isiStamina = false;
        direction = "down";
        spriteNum = 1;
        
        // PLAYER STATUS

        maxStamina=20;
        stamina = maxStamina;
        this.setMaxHp(100);
        this.setHp(this.getMaxHp());
        this.setSpeed(6);
        this.setStrength(1);
        this.setDef(1);
        this.setExp(0);
        this.setNextLevelExp(5);
        this.setCoin(0);
        currentArmor = new OBJ_Armor_Normal(gp);
        currentSword = new OBJ_Sword_Normal(gp);
        setAtk(this.getStrength() + currentSword.attackValue);
        setDefense(this.getDef() + currentArmor.defenseValue);
    }

    public void setItems(){

    inventory.clear(); // penting agar tidak duplicate

        inventory.add(currentArmor);
        inventory.add(currentSword);
    
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
        attackUp1 = setUp("/assets/Player/Tiles2/TileR4C2", gp.tileSize, gp.tileSize);
        attackUp2 = setUp("/assets/Player/Tiles2/TileR4C3", gp.tileSize, gp.tileSize);
        attackUp3 = setUp("/assets/Player/Tiles2/TileR4C4", gp.tileSize, gp.tileSize);
        attackUp4 = setUp("/assets/Player/Tiles2/TileR4C5", gp.tileSize, gp.tileSize);
        attackUp5 = setUp("/assets/Player/Tiles2/TileR4C6", gp.tileSize, gp.tileSize);
        attackUp6 = setUp("/assets/Player/Tiles2/TileR4C7", gp.tileSize, gp.tileSize);

        //S
        attackDown1 = setUp("/assets/Player/Tiles2/TileR1C2", gp.tileSize, gp.tileSize);
        attackDown2 = setUp("/assets/Player/Tiles2/TileR1C3", gp.tileSize, gp.tileSize);
        attackDown3 = setUp("/assets/Player/Tiles2/TileR1C4", gp.tileSize, gp.tileSize);
        attackDown4 = setUp("/assets/Player/Tiles2/TileR1C5", gp.tileSize, gp.tileSize);
        attackDown5 = setUp("/assets/Player/Tiles2/TileR1C6", gp.tileSize, gp.tileSize);
        attackDown6 = setUp("/assets/Player/Tiles2/TileR1C7", gp.tileSize, gp.tileSize);

        //A
        attackLeft1 = setUp("/assets/Player/Tiles2/TileR2C2", gp.tileSize, gp.tileSize);
        attackLeft2 = setUp("/assets/Player/Tiles2/TileR2C3", gp.tileSize, gp.tileSize);
        attackLeft3 = setUp("/assets/Player/Tiles2/TileR2C4", gp.tileSize, gp.tileSize);
        attackLeft4 = setUp("/assets/Player/Tiles2/TileR2C5", gp.tileSize, gp.tileSize);
        attackLeft5 = setUp("/assets/Player/Tiles2/TileR2C6", gp.tileSize, gp.tileSize);
        attackLeft6 = setUp("/assets/Player/Tiles2/TileR2C7", gp.tileSize, gp.tileSize);

        //D
        attackRight1 = setUp("/assets/Player/Tiles2/TileR3C2", gp.tileSize, gp.tileSize);
        attackRight2 = setUp("/assets/Player/Tiles2/TileR3C3", gp.tileSize, gp.tileSize);
        attackRight3 = setUp("/assets/Player/Tiles2/TileR3C4", gp.tileSize, gp.tileSize);
        attackRight4 = setUp("/assets/Player/Tiles2/TileR3C5", gp.tileSize, gp.tileSize);
        attackRight5 = setUp("/assets/Player/Tiles2/TileR3C6", gp.tileSize, gp.tileSize);
        attackRight6 = setUp("/assets/Player/Tiles2/TileR3C7", gp.tileSize, gp.tileSize);
    }

    
    public void update() {
        ScreenX = gp.getWidth()/2 - entitySize/2;
        ScreenY = gp.getHeight()/2 - entitySize/2;
        
        if (attack == true && stamina > 2) {
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
        
        
        if (stamina >= maxStamina) {
            isiStamina = false;
            stamina = maxStamina;
        }

        if(getHp() <= 0){
            setHp(0);
            gp.gameState = gp.titleState;
        }

        // invincibleCounter++;
        // if (invincibleCounter > 60) {
        //     if (invincible == true) {
        //         this.setHp(this.getHp() - 1);
        //         invincible = false;
        //         invincibleCounter = 0;
        //     }
        // }

        if (invincible == true) {
            invincibleCounter++;
            
            if (invincibleCounter > 60) { // Angka 60 = 1 detik pas (karena FPS 60)
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
        }else if(attackCounter <= 10){
            spriteNum = 2;
        }else if(attackCounter <= 15){
            spriteNum = 3;
        }else if(attackCounter <= 20){
            spriteNum = 4;
        }else if(attackCounter <= 25){
            spriteNum = 5;
        }else if(attackCounter <= 30){
            spriteNum = 6;

            //Nyimpan Posisi saat ini
            int currentWorldX = WorldX;
            int currentWorldY = WorldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //Adjust posisi player untuk area serangan
            // switch(direction){
            // case "up":
            //     solidArea.y -= attackArea.height;
            //     break;

            // case "down":
            //     solidArea.y += attackArea.height;
            //     break;

            // case "left":
            //     solidArea.x -= attackArea.width;
            //     break;

            // case "right":
            //     solidArea.x += attackArea.width;
            //     break;
            // }
            switch (direction) {
                case "up": WorldY -= attackArea.height; break;
                case "down": WorldY += attackArea.height; break;
                case "left": WorldX -= attackArea.width; break;
                case "right": WorldX += attackArea.width; break;
            }            

            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cCheker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);
            
            solidArea.x = solidAreaDefaultX;
            solidArea.y = solidAreaDefaultY;

            WorldX = currentWorldX;
            WorldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if(attackCounter > 30){
            spriteNum = 1;
            spriteCounter = 0;
            attack = false;
            stamina-=2;
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
            // String ObjectName = gp.obj[i].name;
            // switch(ObjectName) {
            //     case "AutumnBush":
            //         hasPotion++;
            //         gp.obj[i] = null;
            //         gp.ui.showMassage("You Got A Autumn Bush!");
            //         break;
            // }
            String text; 
            if(gp.obj[i].pickupable)
            {
                if(inventory.size() != inventorySize)
                {
                    inventory.add(gp.obj[i]);
                    text = "Got a " + gp.obj[i].name + "!";
                }
                else
                {
                    text = "You cannot carry any more!";
                }
                gp.obj[i] = null;
            }

        }
    }
    
    public void interactNpc(int i){
        if(gp.keyH.spacePressed == true){
            if(i != 999){
                gp.gameState = gp.dialogState;
                gp.npc[i].speak();
            }
        }
    }

    public void contactMonster(int i){
        if(i != 999){
            if(invincible == false){
                int damage = gp.monster[i].getAtk() - getDefense();
                if(damage<0){
                    damage=0;
                }
                setHp(getHp()-damage);
                invincible = true;
            }
        }
        
    }

    public void damageMonster(int i){
        boolean hit = false;
        if (i != 999) {
            // if (invincible == false ) {
            //     System.out.println("Monster Hit!");
                
            // } else {
            //     System.out.println("Miss!");
            // }
            if (gp.monster[i].invincible == false ) {

                // System.out.println("Monster Hit!");
                int damage = getAtk() - gp.monster[i].getDefense();
                if(damage<0){
                    damage=0;
                }
                
                gp.monster[i].setHp(gp.monster[i].getHp() - damage);
                gp.ui.showMassage(damage+" damage!");
                gp.monster[i].invincible = true;
                hit = true;

                if(gp.monster[i].getHp() <= 0)
                {
                    gp.monster[i].dying = true;
                    gp.ui.showMassage("killed the "+ gp.monster[i].name +"!");
                    gp.ui.showMassage("Exp "+ gp.monster[i].getExp() +"!");

                    setExp(getExp()+gp.monster[i].getExp());
                    checkLevelUp();

                }
            }
            if(gp.monster[i].invincible == false && hit == false){
                System.out.println("Miss!");

            }

            
        }
    }
    public void checkLevelUp(){
        if(getExp()>= getNextLevelExp()){
            int temp = maxStamina+5;

            setLevel(getLevel()+1);
            setNextLevelExp(getNextLevelExp()*2);
            setExp(0);
            setMaxHp(getMaxHp()+10);
            setHp(getMaxHp());
            maxStamina=temp;
            stamina=temp;
            
        }
    }

    public void selectItem()
    {
        int itemIndex = gp.ui.getItemIndex();

        if(itemIndex < inventory.size())
        {
            Entity selectedItem = inventory.get(itemIndex);

            if(selectedItem.type == type_sword)
            {
                currentSword = selectedItem;
                // di tutorial: 
                // attack (kodingan kita nama var. attackValue) = getAttack() sudah kucoba tidak work jadi buat method baru
                updateStats();
            }
            if(selectedItem.type == type_armor)
            {
                currentArmor = selectedItem;
                updateStats();            
            }        
            if(selectedItem.type == type_consumable)
            {
                // sementara sprite potion pakai sprite emas lootdrop (item 567)
                selectedItem.use(this);
                inventory.remove(itemIndex);
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
                    if (spriteNum == 1){ image = attackUp1; }
                    else if (spriteNum == 2){ image = attackUp2; }
                    else if (spriteNum == 3){ image = attackUp3; }
                    else if (spriteNum == 4){ image = attackUp4; }
                    else if (spriteNum == 5){ image = attackUp5; }
                    else if (spriteNum == 6){ image = attackUp6; }
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
                    else if (spriteNum == 3){ image = attackDown3; }  
                    else if (spriteNum == 4){ image = attackDown4; }  
                    else if (spriteNum == 5){ image = attackDown5; }  
                    else if (spriteNum == 6){ image = attackDown6; } 
                    
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
                    if (spriteNum == 1){ image = attackLeft1; }
                    else if (spriteNum == 2){ image = attackLeft2; }
                    else if (spriteNum == 3){ image = attackLeft3; }
                    else if (spriteNum == 4){ image = attackLeft4; }
                    else if (spriteNum == 5){ image = attackLeft5; }
                    else if (spriteNum == 6){ image = attackLeft6; }
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
                    if (spriteNum == 1){ image = attackRight1; } 
                    else if (spriteNum == 2){ image = attackRight2; } 
                    else if (spriteNum == 3){ image = attackRight3; } 
                    else if (spriteNum == 4){ image = attackRight4; } 
                    else if (spriteNum == 5){ image = attackRight5; } 
                    else if (spriteNum == 6){ image = attackRight6; } 
                    
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

    public void updateStats()
    {
        setAtk(getStrength() + currentSword.attackValue);
        setDefense(getDef() + currentArmor.defenseValue);
    }
}