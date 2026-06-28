package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BurnedTree extends Entity {
    public static final String objName = "BurnedTree";

    public OBJ_BurnedTree(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/Objects/Burned_tree1", gp.tileSize, gp.tileSize);
        pickupable = false;
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
