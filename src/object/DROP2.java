package object;

import entity.Entity;
import main.GamePanel;

public class DROP2 extends Entity{

    public static final String objName = "Red gems";

    public DROP2(GamePanel gp) {
        super(gp);
        entitySize = 32;

        name = objName;
        down1 = setUp("/assets/Objects/item535", 32, 32);
        description ="["+name+"]\n pure RAGE from the slime monster!\ncould be valuable?";
        pickupable = true;
        type = type_drop;
        price = 300;
        stackable = true;
        collision=false;

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
