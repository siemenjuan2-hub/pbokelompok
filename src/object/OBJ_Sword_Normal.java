package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity{
    
    public static final String objName = "Normal Sword";    

    public OBJ_Sword_Normal(GamePanel gp){
        super(gp);

        name = objName;
        down1 = setUp("/assets/Pedang/item1", 32, 32);
        attackValue = 1000;
        description ="["+name+"]\nan old sword";
        type = type_sword;
        price = 50;
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
