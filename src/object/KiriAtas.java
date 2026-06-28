package object;

import entity.Entity;
import main.GamePanel;

public class KiriAtas extends Entity {
    public static final String objName = "RumahKiriAtas";

    public KiriAtas(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/World/Rumah/TileR1C1", gp.tileSize, gp.tileSize);
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
