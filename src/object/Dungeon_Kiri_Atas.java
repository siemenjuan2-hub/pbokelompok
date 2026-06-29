package object;

import entity.Entity;
import main.GamePanel;

public class Dungeon_Kiri_Atas extends Entity {
    public static final String objName = "PintuDungeonKiriAtas";

    public Dungeon_Kiri_Atas(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/assets/World/Dungeon_door/DKIRAT", gp.tileSize, gp.tileSize);
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
