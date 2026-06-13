package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Bush1 extends SuperObject{

    GamePanel gp;

    public OBJ_Bush1(GamePanel gp)
    {
        this.gp = gp;
        name = "Bush1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_simple1_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
