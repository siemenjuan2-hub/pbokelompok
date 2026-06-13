package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Bush2 extends SuperObject{

    GamePanel gp;

    public OBJ_Bush2(GamePanel gp)
    {
        this.gp = gp;
        name = "Bush2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_simple2_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
