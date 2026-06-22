package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Armor_Normal extends Entity{
    
    public OBJ_Armor_Normal(GamePanel gp){
        super(gp);

        name = "Normal Armor";
        defenseValue = 1;
        down1 = setUp("/assets/Armor/item220", 32, 32);
        entitySize = 0;

    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
}
