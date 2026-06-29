package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Tent extends Entity {
    public static final String objName = "Tenda";

    public OBJ_Tent(GamePanel gp)
    {
        super(gp);
        entitySize = 256;
        name = objName;
        down1 = setUp("/assets/Asset_Tambahan/tent", gp.tileSize, gp.tileSize);
        solidArea.x = 0;
        solidArea.y = 128;
        solidArea.width = entitySize;
        solidArea.height = entitySize/2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }


    @Override
    public void setAction() {
    }
}
