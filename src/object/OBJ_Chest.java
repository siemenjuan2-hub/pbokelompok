package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity {
    public static final String objName = "Chest";

    public OBJ_Chest(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/Asset_Tambahan/chest", gp.tileSize, gp.tileSize);
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = true;
    }

    @Override
    public void setAction() {
    }
}
