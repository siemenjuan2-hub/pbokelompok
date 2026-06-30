package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.DROP1;
import object.DROP2;
import object.OBJ_Armor_Better;
import object.OBJ_Sword_Copper;
import object.OBJ_Sword_Normal;

public class MON_GreenSlime extends Entity {
    public MON_GreenSlime(GamePanel gp) {
        super(gp);
        type = type_monster;
        entitySize = 64;
        name = "Green Slime";
        defaultSpeed=2;
        this.setSpeed(defaultSpeed);
        this.setMaxHp(100);
        this.setHp(this.getMaxHp());
        this.setExp(10);
        this.setAtk(10);
        this.setDef(5);
        knockBackPower=5;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    public void getImage() {
        up1 = setUp("/assets/Monster/greenSlime/greenslime_down_1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Monster/greenSlime/greenslime_down_2", gp.tileSize, gp.tileSize);
        down1 = setUp("/assets/Monster/greenSlime/greenslime_down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Monster/greenSlime/greenslime_down_2", gp.tileSize, gp.tileSize);
        left1 = setUp("/assets/Monster/greenSlime/greenslime_down_1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Monster/greenSlime/greenslime_down_2", gp.tileSize, gp.tileSize);
        right1 = setUp("/assets/Monster/greenSlime/greenslime_down_1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Monster/greenSlime/greenslime_down_2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {
        int xDistance = Math.abs(WorldX - gp.player.WorldX);
        int yDistance = Math.abs(WorldY - gp.player.WorldY);

        if (xDistance < gp.tileSize * 5 && yDistance < gp.tileSize * 5) {
            onPath = true;
        } else {
            onPath = false;
        }
        if (onPath) {
            int playerCenterX = gp.player.WorldX + gp.player.solidArea.x + gp.player.solidArea.width / 2;
            int playerCenterY = gp.player.WorldY + gp.player.solidArea.y + gp.player.solidArea.height / 2;

            int goalCol = playerCenterX / gp.tileSize;
            int goalRow = playerCenterY / gp.tileSize;

            searchPath(goalCol, goalRow);
        } else {

            actionLockCounter++;

            if (actionLockCounter == 120) {
                int i = new java.util.Random().nextInt(100) + 1; // 1 - 100

                if (i <= 25) {
                    direction = "up";
                } else if (i > 25 && i <= 50) {
                    direction = "down";
                } else if (i > 50 && i <= 75) {
                    direction = "left";
                } else if (i > 75 && i <= 100) {
                    direction = "right";
                }

                actionLockCounter = 0;
            }
        }
    }

    public void checkDrop() {
        // cast a die
        int i = new Random().nextInt(100) + 1;
        if (i < 40) {
            
        }
        if (i >= 40 && i < 80) {
            dropItem(new DROP1(gp));
        }
        if (i >= 80 && i <= 100) {
            dropItem(new DROP2(gp));
        }
    }
}