package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Copper extends Entity{

    public static final String objName = "Copper Sword";

    public OBJ_Sword_Copper(GamePanel gp) {
        super(gp);
        entitySize = 128;

        name = objName;
        down1 = setUp("/assets/Pedang/item3", 32, 32);
        attackValue = 250;
        description ="["+name+"]\na copper sword";
        pickupable = true;
        type = type_sword;
        price = 100;
        knockBackPower=29;
        stackable = false;
        collision = false;


        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        // bisa tambah attack area kalo mau
    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
    
}
