package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Pohon_Coklat_Jumbo extends Entity {
    public static final String objName = "Pohon Coklat Jumbo";

    public OBJ_Pohon_Coklat_Jumbo(GamePanel gp)
    {
        super(gp);
        entitySize = 256;
        name = objName;
        down1 = setUp("/assets/World/Trees/PohonSatuan/Coklat/Pohon_Coklat_Jumbo", gp.tileSize, gp.tileSize);
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
