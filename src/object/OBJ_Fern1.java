package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Fern1 extends SuperObject{
    GamePanel gp;
    public OBJ_Fern1(GamePanel gp)
    {
        this.gp = gp;
        name = "Fern1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Fern1_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
