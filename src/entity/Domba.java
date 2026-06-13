package entity;

import main.GamePanel;
import main.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Domba extends Entity{
    public Domba (GamePanel gp){
        super(gp);
        solidArea = new Rectangle(0, 0, 128, 128);

        this.setSpeed(3);

        getImage();

        setDialogues();
    }

    public void getImage() {
        //Atas
        up1 = setUp("/assets/Npc/Domba/up_1");
        up2 = setUp("/assets/Npc/Domba/up_2");

        //Bawah
        down1 = setUp("/assets/Npc/Domba/down_1");
        down2 = setUp("/assets/Npc/Domba/down_2");

        //Kiri
        left1 = setUp("/assets/Npc/Domba/left_1");
        left2 = setUp("/assets/Npc/Domba/left_2");

        //Kanan
        right1 = setUp("/assets/Npc/Domba/right_1");
        right2 = setUp("/assets/Npc/Domba/right_2");
    }

    public void setDialogues() {
        dialogues[0] = "Baa! I'm a sheep!";
        dialogues[1] = "I love grazing in the meadow.";
        dialogues[2] = "Have you seen any grass around?";
        dialogues[3] = "Baa baa!";
        dialogues[4] = "The world is a big place for a little sheep like me.";
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
