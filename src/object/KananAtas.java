package object;

import entity.Entity;
import main.GamePanel;

public class KananAtas extends Entity {
    public KananAtas(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = "RumahKananAtas";
        down1 = setUp("/assets/World/Rumah/TileR1C2", gp.tileSize, gp.tileSize);
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
