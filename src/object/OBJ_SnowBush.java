package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_SnowBush extends SuperObject{

    GamePanel gp;

    public OBJ_SnowBush(GamePanel gp)
    {
        this.gp = gp;
        name = "SnowBush";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Snow_bush1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;        
    }
}
