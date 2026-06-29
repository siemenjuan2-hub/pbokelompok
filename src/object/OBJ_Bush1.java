package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bush1 extends Entity {
    public static final String objName = "Bush1";

    public OBJ_Bush1(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/Objects/Bush_simple1_1", gp.tileSize, gp.tileSize);
        solidArea.x = 32;
        solidArea.y = 64;
        solidArea.width = entitySize / 2;
        solidArea.height = entitySize / 6;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    @Override
    public void setAction() {
    }
}
