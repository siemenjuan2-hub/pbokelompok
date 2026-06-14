package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Cactus1 extends SuperObject{

    GamePanel gp;

    public OBJ_Cactus1(GamePanel gp)
    {
        this.gp = gp;
        name = "Cactus1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Cactus1_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}
