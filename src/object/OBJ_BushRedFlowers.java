package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BushRedFlowers extends SuperObject{

    GamePanel gp;

    public OBJ_BushRedFlowers(GamePanel gp)
    {
        this.gp = gp;
        name = "BushRedFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_red_flowers1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
