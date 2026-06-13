package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_AutumnBush extends SuperObject{
    GamePanel gp;
    public OBJ_AutumnBush(GamePanel gp)
    {
        this.gp = gp;
        name = "AutumnBush";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Autumn_bush1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;
    }
}
