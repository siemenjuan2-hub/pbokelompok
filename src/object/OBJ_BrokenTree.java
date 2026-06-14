package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BrokenTree extends SuperObject{

    GamePanel gp;

    public OBJ_BrokenTree(GamePanel gp)
    {
        this.gp = gp;
        name = "BrokenTree";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Broken_tree1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
