package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BushPinkFlowers extends SuperObject{

    GamePanel gp;

    public OBJ_BushPinkFlowers(GamePanel gp)
    {
        this.gp = gp;
        name = "BushPinkFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_pink_flowers1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
}
