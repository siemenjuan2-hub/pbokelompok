package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Normal extends Entity{
    
    public static final String objName = "Normal Armor";

    public OBJ_Armor_Normal(GamePanel gp){
        super(gp);

        name = objName;
        down1 = setUp("/assets/Armor/item220", 32, 32);
        defenseValue = 2;
        entitySize = 0;
        description ="["+name+"]\nan old armor";
        type = type_armor;
        price = 75;
        stackable = false;
    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
}
