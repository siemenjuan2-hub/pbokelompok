package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BurnedTree extends SuperObject{

    GamePanel gp;

    public OBJ_BurnedTree(GamePanel gp)
    {
        this.gp = gp;
        name = "BurnedTree";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Burned_tree1.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
