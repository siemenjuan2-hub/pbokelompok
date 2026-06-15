package object;

import entity.Entity;
import main.GamePanel;

public class Kiribawah extends Entity {
    public Kiribawah(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = "RumahKiriBawah";
        down1 = setUp("/assets/World/Rumah/TileR2C1");
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
