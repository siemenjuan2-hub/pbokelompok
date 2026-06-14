package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Fern2 extends SuperObject{

    GamePanel gp;

    public OBJ_Fern2(GamePanel gp)
    {
        this.gp = gp;
        name = "Fern1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Fern2_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
