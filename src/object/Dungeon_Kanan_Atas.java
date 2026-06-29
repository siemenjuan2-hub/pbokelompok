package object;

import entity.Entity;
import main.GamePanel;

public class Dungeon_Kanan_Atas extends Entity {
    public static final String objName = "PintuDungeonKananAtas";

    public Dungeon_Kanan_Atas(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/Dungeon_door/DKANAT", gp.tileSize, gp.tileSize);
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
