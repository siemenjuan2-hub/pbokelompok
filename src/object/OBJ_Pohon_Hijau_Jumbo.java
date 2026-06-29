package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Pohon_Hijau_Jumbo extends Entity {
    public static final String objName = "Pohon Hijau Jumbo";

    public OBJ_Pohon_Hijau_Jumbo(GamePanel gp)
    {
        super(gp);
        entitySize = 256;
        name = objName;
        down1 = setUp("/assets/World/Trees/PohonSatuan/Hijau/Pohon_Hijau_Jumbo", gp.tileSize, gp.tileSize);
        solidArea.x = 94;
        solidArea.y = 192;
        solidArea.width = entitySize / 4;
        solidArea.height = entitySize / 4;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    @Override
    public void setAction() {
    }
}
