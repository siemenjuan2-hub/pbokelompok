package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bush2 extends Entity {
    public static final String objName = "Bush2";

    public OBJ_Bush2(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/Objects/Bush_simple2_1", gp.tileSize, gp.tileSize);
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
