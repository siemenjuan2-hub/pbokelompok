package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Armor_Better;
import object.OBJ_Sword_Copper;
import object.OBJ_Sword_Normal;

public class MON_KingSlime extends Entity {
    Random rand = new Random();
        // ANTI STUCK
        private int stuckCounter = 0;
        private int freeMoveCounter = 0;

        // DASH
        private boolean dashing = false;
        private int dashCounter = 0;

        private int lastWorldX;
        private int lastWorldY;

        private int noMoveCounter = 0;

    public MON_KingSlime(GamePanel gp) {
        super(gp);
        type = type_monster;
        entitySize = 512;
        name = "King Slime";
        defaultSpeed=3;
        this.setSpeed(defaultSpeed);
        this.setMaxHp(1000);
        this.setHp(this.getMaxHp());
        this.setExp(100);
        this.setAtk(100);
        this.setDef(20);
        knockBackPower=10;
        lastWorldX = WorldX;
        lastWorldY = WorldY;


        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    public void getImage() {
        up1 = setUp("/assets/Monster/kingSlime/kingslime_down_1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Monster/kingSlime/kingslime_down_2", gp.tileSize, gp.tileSize);
        down1 = setUp("/assets/Monster/kingSlime/kingslime_down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Monster/kingSlime/kingslime_down_2", gp.tileSize, gp.tileSize);
        left1 = setUp("/assets/Monster/kingSlime/kingslime_down_1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Monster/kingSlime/kingSlime_down_2", gp.tileSize, gp.tileSize);
        right1 = setUp("/assets/Monster/kingSlime/kingslime_down_1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Monster/kingSlime/kingSlime_down_2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {

        int xDistance = Math.abs(WorldX - gp.player.WorldX);
        int yDistance = Math.abs(WorldY - gp.player.WorldY);

        if (xDistance < gp.tileSize * 10 && yDistance < gp.tileSize * 10) {
            onPath = true;
        } else {
            onPath = false;
        }
        if (onPath) {

            int playerCenterX = gp.player.WorldX +
                    gp.player.solidArea.x +
                    gp.player.solidArea.width / 2;

            int playerCenterY = gp.player.WorldY +
                    gp.player.solidArea.y +
                    gp.player.solidArea.height / 2;

            int goalCol = playerCenterX / gp.tileSize;
            int goalRow = playerCenterY / gp.tileSize;

            if(noMoveCounter > 60){

                // paksa hitung ulang path
                pathList.clear();

                playerCenterX = gp.player.WorldX +
                        gp.player.solidArea.x +
                        gp.player.solidArea.width / 2;

                playerCenterY = gp.player.WorldY +
                        gp.player.solidArea.y +
                        gp.player.solidArea.height / 2;

                goalCol = playerCenterX / gp.tileSize;
                goalRow = playerCenterY / gp.tileSize;

                searchPath(goalCol, goalRow);

                noMoveCounter = 0;
            }


            // Jika sedang tidak keluar dari stuck
            if (freeMoveCounter <= 0) {

                searchPath(goalCol, goalRow);

                if(WorldX == lastWorldX && WorldY == lastWorldY){
                    noMoveCounter++;
                }
                else{
                    noMoveCounter = 0;
                }

                lastWorldX = WorldX;
                lastWorldY = WorldY;

                

                // Deteksi mentok
                if (collisionON) {
                    stuckCounter++;
                } else {
                    stuckCounter = 0;
                }

                // Jika mentok terlalu lama
                if (stuckCounter > 5) {

                    switch (rand.nextInt(4)) {

                        case 0:
                            direction = "up";
                            gp.playSE(9);
                            break;

                        case 1:
                            direction = "down";
                            gp.playSE(9);
                            break;

                        case 2:
                            direction = "left";
                            gp.playSE(9);
                            break;

                        case 3:
                            direction = "right";
                            gp.playSE(9);
                            break;
                    }

                    this.setSpeed((defaultSpeed + 5) * 3);
                    freeMoveCounter = 20;
                    stuckCounter = 0;
                }else{
                    this.setSpeed(defaultSpeed);
                }

            } else {

                freeMoveCounter--;
            }

            // DASH SYSTEM
            if (!dashing) {

                // 5% chance tiap frame
                if (rand.nextInt(1000) < 5) {

                    dashing = true;
                    dashCounter = 120;

                    this.setSpeed((defaultSpeed + 5) * 3);
                }

            } else {

                dashCounter--;

                if (dashCounter <= 0) {

                    dashing = false;
                    setSpeed(defaultSpeed);
                }
            }
        } else {
            actionLockCounter++;
            

            if (actionLockCounter == 120) {
                
                int i = rand.nextInt(100) + 1; // 1 - 100

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
        if (i < 50) {
            dropItem(new OBJ_Armor_Better(gp));
        }
        if (i > 50 && i < 100) {
            dropItem(new OBJ_Sword_Copper(gp));
        }
    }
}
