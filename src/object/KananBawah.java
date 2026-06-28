package object;

import entity.Entity;
import main.GamePanel;

public class KananBawah extends Entity {
    public static final String objName = "RumahKananBawah";

    public KananBawah(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/World/Rumah/TileR2C2", gp.tileSize, gp.tileSize);
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collision = false;
    }

    @Override
    public void setAction() {
    }
}
