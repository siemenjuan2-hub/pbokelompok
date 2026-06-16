package object;

import entity.Entity;
import main.GamePanel;

public class Kanan extends Entity {
    public Kanan(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = "RumahKanan";
        down1 = setUp("/assets/World/Rumah/TileR2C1", gp.tileSize, gp.tileSize);
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
