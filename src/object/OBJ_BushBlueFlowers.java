package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BushBlueFlowers extends SuperObject{
    GamePanel gp;
    public OBJ_BushBlueFlowers(GamePanel gp)
    {
        this.gp = gp;
        name = "BushBlueFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_blue_flowers1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
