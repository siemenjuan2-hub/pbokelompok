package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Godly extends Entity{

    public static final String objName = "Godly Armor";

    public OBJ_Armor_Godly(GamePanel gp) {
        super(gp);
        entitySize = 128;

        name = objName;
        down1 = setUp("/assets/Armor/item225", 32, 32);
        defenseValue = 50000;
        description ="["+name+"]\na Godly armor..";
        pickupable = true;
        type = type_armor;
        price = 1000;
        stackable = false;

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
