package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bush2 extends Entity {
    public OBJ_Bush2(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = "Bush2";
        down1 = setUp("/assets/Objects/Bush_simple2_1");
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    @Override
    public void setAction() {
    }
}
