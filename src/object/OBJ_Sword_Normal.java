package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity{
    
    public OBJ_Sword_Normal(GamePanel gp){
        super(gp);

        name = "Normal Sword";
        down1 = setUp("/assets/Pedang/item1", 32, 32);
        attackValue = 10;
        description ="["+name+"]\nan old sword";
        type = type_sword;
        price = 50;
        knockBackPower = 2;
    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
}
