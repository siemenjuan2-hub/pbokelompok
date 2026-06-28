package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_AutumnBush extends Entity {
    public static final String objName = "AutumnBush";

    public OBJ_AutumnBush(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/Objects/Autumn_bush1", gp.tileSize, gp.tileSize);
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
