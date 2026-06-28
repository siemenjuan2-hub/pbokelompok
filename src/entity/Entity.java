package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import AI.Node;
import main.GamePanel;
import main.UtilityTool;

public abstract class Entity {
    public GamePanel gp;
    public BufferedImage up1, up2, up3, up4, up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3,
            left4, left5, left6, right1, right2, right3, right4, right5, right6;
    public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4, attackUp5, attackUp6, attackDown1, attackDown2,
            attackDown3, attackDown4, attackDown5, attackDown6, attackLeft1, attackLeft2, attackLeft3, attackLeft4,
            attackLeft5, attackLeft6, attackRight1, attackRight2, attackRight3, attackRight4, attackRight5,
            attackRight6;
    public BufferedImage image;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public Rectangle attackArea = new Rectangle(0, 0, 32, 32);
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collision = true;
    public boolean pickupable = false;

    String dialogues[] = new String[20];
    public int entitySize;
    public String names; // bedanya sama bawah apa cug // ga ada bedanya, bisa di hapus hahahah
                         // (Stevanus)

    // cooldown atk monster
    public int attackCooldown = 0;
    public final int attackInterval = 60; // 60 frame = 1 atk/detik
    public ArrayList<Node> pathList = new ArrayList<>();

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
    public boolean onPath = false;
    boolean drawPath = true;
    public boolean knockBack=false;

    // COUNTER
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 60;
    int dyingCounter = 0;
    int hpBarCounter = 0;
    public int knockBackCounter=0;
    public int knockBackDirectionTime = 0;

    // ENITTY ATRIBUTES
    public String name; // Bedanya sama atas apa cug
    public int defaultSpeed;
    public int value;
    private int speed;
    private int maxHp;
    private int hp;
    private int level = 1;
    private int atk;
    private int strength;
    private int defense;
    private int def; // defense awal player (tidak di hitung atribute armor)
    private int exp;
    private int nextLevelExp = 5;
    private int coin;

    // ENTITY ITEM
    public Entity currentSword;
    public Entity currentArmor;
    public int upgradeLevel = 0;
    public static final int max_upgrade = 5;

    // ITEM ATTRIBUTE
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int inventorySize = 20;
    public int attackValue;
    public int defenseValue;
    public String description = "";
    public int price;
    public int knockBackPower=0;
    public boolean stackable = false;
    public int amount = 1;
    // CHARACTER STATUS
    // public int maxLife;
    // public int life;

    // TYPE
    public int type; // 0 = npc, 1 = monster.
    public final static int type_npc = 0;
    public final static int type_monster = 1;
    public final static int type_sword = 2;
    public final static int type_armor = 3;
    public final static int type_consumable = 4;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public abstract void setAction();

    public void speak() {
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
        if (dialogues[dialogueIndex] == null) {
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

    public boolean use(Entity entity) {
        return false;
    }

    public void checkDrop() {

    }

    public void dropItem(Entity droppedItem) {
        for (int i = 0; i < gp.obj[1].length; i++) {
            if (gp.obj[gp.currentMap][i] == null) {
                gp.obj[gp.currentMap][i] = droppedItem;
                gp.obj[gp.currentMap][i].WorldX = WorldX;
                gp.obj[gp.currentMap][i].WorldY = WorldY;
                break;
            }
        }
    }

    public void update() {
        if(knockBack){

            collisionON = false;

            gp.cCheker.checkTile(this);

            if(!collisionON){

                switch(direction){

                    case "up":
                        WorldY -= getSpeed();
                        break;

                    case "down":
                        WorldY += getSpeed();
                        break;

                    case "left":
                        WorldX -= getSpeed();
                        break;

                    case "right":
                        WorldX += getSpeed();
                        break;
                }
            }

            knockBackCounter++;

            if(knockBackCounter > 8){

                knockBack = false;
                knockBackCounter = 0;
                setSpeed(defaultSpeed);
            }

            return;
        }
        else{
            setAction();
            checkCollision();
            if (attackCooldown > 0) {
                attackCooldown--;
            }
    
            if (collisionON == false) {
                switch (direction) {
                    case "up":
                        WorldY -= this.getSpeed();
                        break;
                    case "down":
                        WorldY += this.getSpeed();
                        break;
                    case "left":
                        WorldX -= this.getSpeed();
                        break;
                    case "right":
                        WorldX += this.getSpeed();
                        break;
                }
            }

        }

        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 1;
            }
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

    public void checkCollision() {
        collisionON = false;
        // Cek collison tile
        gp.cCheker.checkTile(this);

        // cek collison npc
        gp.cCheker.checkEntity(this, gp.npc);

        // CEK COLLISON OBJEK
        gp.cCheker.checkObject(this, false);

        // CEK COLLISON MONSTER
        if (type != type_monster) {
            gp.cCheker.checkEntity(this, gp.monster);
        }

        // CEK COLLISION PLAYER
        boolean contactPlayer = gp.cCheker.checkPlayer(this);
        if (type == type_monster && contactPlayer == true) {
            damagePlayer(atk);
            gp.player.invincible = true;
        }

    }

    public void knockbackPlayer(int power){

        gp.player.knockBack = true;

        switch(direction){

            case "up":
                gp.player.direction = "up";
                break;

            case "down":
                gp.player.direction = "down";
                break;

            case "left":
                gp.player.direction = "left";
                break;

            case "right":
                gp.player.direction = "right";
                break;
        }

        gp.player.setSpeed(power);
    }

    public void damagePlayer(int atk) {

        if (attackCooldown > 0) {
            return;
        }

        int damage = Math.max(0, atk - gp.player.getDefense());

        gp.player.setHp(gp.player.getHp() - damage);

        gp.player.knockBack = true;
        gp.player.direction = direction;
        gp.player.setSpeed(knockBackPower + 5);
        
        attackCooldown = attackInterval;
    }

    public BufferedImage setUp(String ImagePath, int width, int height) {
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

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = WorldX - gp.player.WorldX + gp.player.ScreenX;
        int screenY = WorldY - gp.player.WorldY + gp.player.ScreenY;

        if (WorldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX &&
                WorldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX &&
                WorldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY &&
                WorldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    } else if (spriteNum == 2) {
                        image = up2;
                    } else if (spriteNum == 3) {
                        image = up1;
                    } else if (spriteNum == 4) {
                        image = up2;
                    } else if (spriteNum == 5) {
                        image = up1;
                    } else if (spriteNum == 6) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    } else if (spriteNum == 2) {
                        image = down2;
                    } else if (spriteNum == 3) {
                        image = down1;
                    } else if (spriteNum == 4) {
                        image = down2;
                    } else if (spriteNum == 5) {
                        image = down1;
                    } else if (spriteNum == 6) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    } else if (spriteNum == 2) {
                        image = left2;
                    } else if (spriteNum == 3) {
                        image = left1;
                    } else if (spriteNum == 4) {
                        image = left2;
                    } else if (spriteNum == 5) {
                        image = left1;
                    } else if (spriteNum == 6) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    } else if (spriteNum == 2) {
                        image = right2;
                    } else if (spriteNum == 3) {
                        image = right1;
                    } else if (spriteNum == 4) {
                        image = right2;
                    } else if (spriteNum == 5) {
                        image = right1;
                    } else if (spriteNum == 6) {
                        image = right2;
                    }
                    break;
            }

            // HP BAR MONSTER SLIME IJO
            if (type == type_monster && hpBarOn == true) {
                double oneScale = (double) entitySize / maxHp;
                double hpBarValue = oneScale * hp;

                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX - 1, screenY - 16, entitySize + 2, 12);

                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);

                hpBarCounter++;

                if (hpBarCounter > 600) {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }

            if (invincible == true) {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4f);
            }
            if (dying == true) {
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
                    solidArea.height);

            // DEBUG PATHFINDING
            if(drawPath){
                g2.setColor(new Color(255, 0, 0, 70));

                for(int i = 0; i < pathList.size(); i++){
                    int worldX = pathList.get(i).col * gp.tileSize;
                    int worldY = pathList.get(i).row * gp.tileSize;

                    int pathScreenX = worldX - gp.player.WorldX + gp.player.ScreenX;
                    int pathScreenY = worldY - gp.player.WorldY + gp.player.ScreenY;

                    g2.fillRect(pathScreenX, pathScreenY, gp.tileSize, gp.tileSize);
                }
            }
        }
    }
    
    public void searchPath(int goalCol, int goalrow) {

        int startCol = (WorldX + solidArea.x) / gp.tileSize;
        int startRow = (WorldY + solidArea.y) / gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalrow);

        if (gp.pFinder.search() == true) {

            pathList = new ArrayList<>(gp.pFinder.pathList);

            // next WorldX & WorldY
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            // entity solid area position
            int enLeftX = WorldX + solidArea.x;
            int enRightX = WorldX + solidArea.x + solidArea.width;
            int enTopY = WorldY + solidArea.y;
            int enBottomY = WorldY + solidArea.y + solidArea.height;

            if (enTopY > nextY && enLeftX >= nextX && enRightX <= nextX + gp.tileSize) {
                direction = "up";
                checkCollision();
            } else if (enTopY < nextY && enLeftX >= nextX && enRightX <= nextX + gp.tileSize) {
                direction = "down";
                checkCollision();
            } else if (enTopY >= nextY && enBottomY <= nextY + gp.tileSize) {
                // left or right
                if (enLeftX > nextX) {
                    direction = "left";
                    checkCollision();
                }
                if (enRightX < nextX + gp.tileSize) {
                    direction = "right";
                    checkCollision();
                }
            } else if (enTopY > nextY && enLeftX > nextX) {
                // up or left
                direction = "up";
                checkCollision();
                if (collisionON) {
                    direction = "left";
                    checkCollision();
                }
            } else if (enTopY > nextY && enLeftX < nextX) {
                // up or right
                direction = "up";
                checkCollision();
                if (collisionON) {
                    direction = "right";
                    checkCollision();
                }
            } else if (enTopY < nextY && enLeftX > nextX) {
                // down or left
                direction = "down";
                checkCollision();
                if (collisionON) {
                    direction = "left";
                    checkCollision();
                }
            } else if (enTopY < nextY && enLeftX < nextX) {
                // down or right
                direction = "down";
                checkCollision();
                if (collisionON) {
                    direction = "right";
                    checkCollision();
                }
            }

            // if reaches the goal, stop the search
            int nextCol = gp.pFinder.pathList.get(0).col;
            int nextRow = gp.pFinder.pathList.get(0).row;
            if (nextCol == goalCol && nextRow == goalrow) {
                onPath = false;
            }

        }
    }

    public void dyingAnimation(Graphics2D g2) {
        dyingCounter++;
        int i = 5;

        if (dyingCounter <= i) {
            changeAlpha(g2, 0);
        }
        if (dyingCounter > i && dyingCounter <= i * 2) {
            changeAlpha(g2, 1);
        }
        if (dyingCounter > i * 2 && dyingCounter <= i * 3) {
            changeAlpha(g2, 0);
        }
        if (dyingCounter > i * 3 && dyingCounter <= i * 4) {
            changeAlpha(g2, 1);
        }
        if (dyingCounter > i * 4 && dyingCounter <= i * 5) {
            changeAlpha(g2, 0);
        }
        if (dyingCounter > i * 5 && dyingCounter <= i * 6) {
            changeAlpha(g2, 1);
        }
        if (dyingCounter > i * 6 && dyingCounter <= i * 7) {
            changeAlpha(g2, 0);
        }
        if (dyingCounter > i * 7 && dyingCounter <= i * 8) {
            changeAlpha(g2, 1);
        }
        if (dyingCounter > i * 8) {
            dying = false;
            alive = false;
        }
    }

    public void changeAlpha(Graphics2D g2, float alphaValue) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }

    // GETTER SETTER

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextLevelExp() {
        return nextLevelExp;
    }

    public void setNextLevelExp(int nextLevelExp) {
        this.nextLevelExp = nextLevelExp;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

}
