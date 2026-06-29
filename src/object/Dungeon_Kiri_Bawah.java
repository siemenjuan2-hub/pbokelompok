package object;

import entity.Entity;
import main.GamePanel;

public class Dungeon_Kiri_Bawah extends Entity {
    public static final String objName = "PintuDungeonKiriBawah";

    public Dungeon_Kiri_Bawah(GamePanel gp)
    {
        super(gp);
        entitySize = 128;
        name = objName;
        down1 = setUp("/Dungeon_door/DKIBAW", gp.tileSize, gp.tileSize);
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
