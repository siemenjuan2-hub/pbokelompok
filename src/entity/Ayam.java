package entity;

import main.GamePanel;
import main.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Ayam extends Entity{
    public Ayam (GamePanel gp){
        super(gp);
        entitySize = 64;
        solidArea = new Rectangle(0, 0, entitySize, entitySize);
        this.setSpeed(3);

        getImage();

        setDialogues();
    }

    public void getImage() {
        //Atas
        up1 = setUp("/assets/Npc/Ayam/up_1");
        up2 = setUp("/assets/Npc/Ayam/up_2");

        //Bawah
        down1 = setUp("/assets/Npc/Ayam/down_1");
        down2 = setUp("/assets/Npc/Ayam/down_2");

        //Kiri
        left1 = setUp("/assets/Npc/Ayam/left_1");
        left2 = setUp("/assets/Npc/Ayam/left_2");

        //Kanan
        right1 = setUp("/assets/Npc/Ayam/right_1");
        right2 = setUp("/assets/Npc/Ayam/right_2");
    }

    public void setDialogues() {

        dialogues[0] = "Cluck! I'm a chicken!\n my name is Tyam!\n my mother is T-rex!";
        dialogues[1] = "Cluck you! I'm not a dinosaur, I'm a chicken!";
        dialogues[2] = "Why do you keep asking about my family? Are you a stalker?";
        dialogues[3] = "Cluck cluck!";
        dialogues[4] = "The world is a big place for a little chicken like me.";
        dialogues[5] = "I wish I could fly, but I can't. I'm just a chicken.";
        dialogues[6] = "You look so small to me, are you sure you're not a chick?";
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
