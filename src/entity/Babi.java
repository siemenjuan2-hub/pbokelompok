package entity;

import main.GamePanel;
import main.UtilityTool;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Babi extends Entity{
    public Babi (GamePanel gp){
        super(gp);
        entitySize = 128;
        solidArea = new Rectangle(0, 0, entitySize , entitySize );
        knockBackPower=3;
        this.setSpeed(3);
        collision = false;

        getImage();

        setDialogues();
    }

    public void getImage() {
        //Atas
        up1 = setUp("/assets/Npc/Babi/up_1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Npc/Babi/up_2", gp.tileSize, gp.tileSize);

        //Bawah
        down1 = setUp("/assets/Npc/Babi/down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Npc/Babi/down_2", gp.tileSize, gp.tileSize);

        //Kiri
        left1 = setUp("/assets/Npc/Babi/left_1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Npc/Babi/left_2", gp.tileSize, gp.tileSize);

        //Kanan
        right1 = setUp("/assets/Npc/Babi/right_1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Npc/Babi/right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogues() {
        dialogues[0] = "Oink! I'm a pig!";
        dialogues[1] = "I love rolling in the mud.";
        dialogues[2] = "Have you seen any mud around?";
        dialogues[3] = "Oink oink!";
        dialogues[4] = "The world is a big place for a little pig like me.";
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
