package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Cactus2 extends SuperObject{

    GamePanel gp;
    
    public OBJ_Cactus2(GamePanel gp)
    {
        this.gp = gp;
        name = "Cactus2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Cactus2_1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
