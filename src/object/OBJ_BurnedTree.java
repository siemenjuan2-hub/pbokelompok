package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BurnedTree extends SuperObject{
    public OBJ_BurnedTree()
    {
        name = "BurnedTree";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Burned_tree1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
