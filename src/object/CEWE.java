package object;

import entity.Entity;
import main.GamePanel;

public class CEWE extends Entity{

    public static final String objName = "Lonely girl";

    public CEWE(GamePanel gp) {
        super(gp);
        entitySize = 150;

        name = objName;
        down1 = setUp("/assets/Objects/princess", 32, 32);
        description ="["+name+"]\n you saved the little girl!\nyou are now a hero !!!";
        pickupable = true;
        type = type_drop;
        price = 2500000;
        stackable = false;
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
