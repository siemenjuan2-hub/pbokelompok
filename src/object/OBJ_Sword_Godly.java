package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Godly extends Entity{
    
    public static final String objName = "Godly Sword";    

    public OBJ_Sword_Godly(GamePanel gp){
        super(gp);
        entitySize = 128;

        name = objName;
        down1 = setUp("/assets/Pedang/item12", 32, 32);
        attackValue = 1000;
        description ="["+name+"]\na Godly sword..";
        type = type_sword;
        pickupable = true;
        price = 1000;
        knockBackPower=1;
        stackable = false;
        collision = false;

    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
}
