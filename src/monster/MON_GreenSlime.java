package monster;

import entity.Entity;
import main.GamePanel;

public class MON_GreenSlime extends Entity {
    public MON_GreenSlime(GamePanel gp) {
        super(gp);
        type = 1;
        entitySize = 64;
        name = "Green Slime";
        this.setSpeed(1);
        this.setMaxHp(10);
        this.setHp(this.getMaxHp());

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
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
        actionLockCounter++;

        if(actionLockCounter == 120) {
            int i = new java.util.Random().nextInt(100) + 1; // 1 - 100

            if(i <= 25) {
                direction = "up";
            }
            else if(i > 25 && i <= 50) {
                direction = "down";
            }
            else if(i > 50 && i <= 75) {
                direction = "left";
            }
            else if(i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }
}