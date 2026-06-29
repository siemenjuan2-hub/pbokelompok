package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Better extends Entity{

    public static final String objName = "Better Armor";

    public OBJ_Armor_Better(GamePanel gp) {
        super(gp);
        entitySize = 128;

        name = objName;
        down1 = setUp("/assets/Armor/item240", 32, 32);
        defenseValue = 5;
        description ="["+name+"]\na better armor";
        pickupable = true;
        type = type_armor;
        price = 120;
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
