package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BushOrangeFlowers extends SuperObject{

    GamePanel gp;

    public OBJ_BushOrangeFlowers(GamePanel gp)
    {
        this.gp = gp;
        name = "BushOrangeFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_orange_flowers1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
