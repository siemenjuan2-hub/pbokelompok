package entity;

import main.GamePanel;
import main.UtilityTool;
import object.OBJ_Armor_Better;
import object.OBJ_Armor_Normal;
import object.OBJ_Potion_Health;
import object.OBJ_Sword_Copper;
import object.OBJ_Sword_Normal;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Npc_Merchant extends Entity{
    public Npc_Merchant (GamePanel gp){
        super(gp);
        entitySize = 100;
        solidArea = new Rectangle(0, 0, entitySize , entitySize);

        direction = "down";
        this.setSpeed(0);

        getImage();
        setDialogues();
        setItems();
    }

    public void getImage() {
        // Merchant tidak gerak
        //Atas
        up1 = setUp("/assets/Npc/Wizard/oldman_down_1", gp.tileSize, gp.tileSize);
        up2 = setUp("/assets/Npc/Wizard/oldman_down_2", gp.tileSize, gp.tileSize);

        //Bawah
        down1 = setUp("/assets/Npc/Wizard/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("/assets/Npc/Wizard/oldman_down_2", gp.tileSize, gp.tileSize);

        //Kiri
        left1 = setUp("/assets/Npc/Wizard/oldman_down_1", gp.tileSize, gp.tileSize);
        left2 = setUp("/assets/Npc/Wizard/oldman_down_2", gp.tileSize, gp.tileSize);

        //Kanan
        right1 = setUp("/assets/Npc/Wizard/oldman_down_1", gp.tileSize, gp.tileSize);
        right2 = setUp("/assets/Npc/Wizard/oldman_down_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogues() {
        dialogues[0] = "Hey! You found me, want to trade?\nI got the good stuff.";
        dialogues[1] = "Want to trade? I got some good items.";
    }

    public void speak(){
        super.speak();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }

    public void setItems()
    {
        inventory.add(new OBJ_Potion_Health(gp));
        inventory.add(new OBJ_Sword_Copper(gp));
        inventory.add(new OBJ_Armor_Better(gp));
        inventory.add(new OBJ_Sword_Normal(gp));
        inventory.add(new OBJ_Armor_Normal(gp));
    }

    @Override
    public void setAction() {
        //merchant tidak bergerak
    }
}
