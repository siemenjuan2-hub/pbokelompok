package entity;

import main.GamePanel;
import main.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Npc_OldMan extends Entity{
    public Npc_OldMan (GamePanel gp){
        super(gp);
        entitySize = 100;
        solidArea = new Rectangle(0, 0, entitySize, entitySize);
        knockBackPower=3;
        direction = "down";
        this.setSpeed(3);
        getImage();

        setDialogues();
    }

    public void getImage() {
        //Atas
        up1 = setUp("/assets/Npc/Wizard/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Npc/Wizard/oldman_up_2", gp.tileSize, gp.tileSize);

        //Bawah
        down1 = setUp("/assets/Npc/Wizard/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Npc/Wizard/oldman_down_2", gp.tileSize, gp.tileSize);

        //Kiri
        left1 = setUp("/assets/Npc/Wizard/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Npc/Wizard/oldman_left_2", gp.tileSize, gp.tileSize);

        //Kanan
        right1 = setUp("/assets/Npc/Wizard/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Npc/Wizard/oldman_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogues() {
        dialogues[0] = "Hello, young adventurer!";
        dialogues[1] = "The world is full of mysteries.";
        dialogues[2] = "Be careful out there.";
        dialogues[3] = "I used to be a great wizard, you know.";
        dialogues[4] = "If you find any magical artifacts, bring them to me.";
    }

    @Override
    public void setAction() {
        
        actionLockCounter++; // Waktu Untuk Random Gerakan biar ga kejang kejang XD
        
        if(actionLockCounter == 120){
            Random rand = new Random();
            int i = rand.nextInt(4)+1;
            if(i == 1){
                direction = "up";
            } 
            if(i == 2){
                direction = "down";
            } 
            if(i == 3){
                direction = "left";
            }
            if(i == 4){
                direction = "right";
            }
            actionLockCounter = 0;
        }


    }

    public void speak(){
        super.speak();
    }
}
