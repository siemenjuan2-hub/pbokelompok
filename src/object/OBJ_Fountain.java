package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Fountain extends Entity {
    public static final String objName = "Fountain";

    public OBJ_Fountain(GamePanel gp)
    {
        super(gp);
        entitySize = 256;
        name = objName;
        down1 = setUp("/assets/Objects/Fountain", gp.tileSize, gp.tileSize);
        solidArea.x = 42;
        solidArea.y = 64;
        solidArea.width = entitySize / 2 + 48;
        solidArea.height = entitySize / 2;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    @Override
    public void setAction() {
    }
}
