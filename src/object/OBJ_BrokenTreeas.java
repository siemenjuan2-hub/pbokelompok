package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_BrokenTreeas extends SuperObject{

    GamePanel gp;
    public OBJ_BrokenTreeas(GamePanel gp)
    {
        this.gp = gp;
        name = "BrokenTree";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Broken_tree1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
