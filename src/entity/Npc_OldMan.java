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
        solidArea = new Rectangle(0, 0, 128, 128);

        direction = "down";
        this.setSpeed(3);

        getImage();
    }

    public void getImage() {
        //Atas
        up1 = setUp("/assets/Npc/Wizard/oldman_up_1");
        up2 = setUp("/assets/Npc/Wizard/oldman_up_2");

        //Bawah
        down1 = setUp("/assets/Npc/Wizard/oldman_down_1");
        down2 = setUp("/assets/Npc/Wizard/oldman_down_2");

        //Kiri
        left1 = setUp("/assets/Npc/Wizard/oldman_left_1");
        left2 = setUp("/assets/Npc/Wizard/oldman_left_2");

        //Kanan
        right1 = setUp("/assets/Npc/Wizard/oldman_right_1");
        right2 = setUp("/assets/Npc/Wizard/oldman_right_2");
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
    
    
}
