package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity{
    
    public OBJ_Sword_Normal(GamePanel gp){
        super(gp);

        name = "Normal Sword";
        attackValue = 1;
        down1 = setUp("/assets/Pedang/item1", 32, 32);

    }

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
}
