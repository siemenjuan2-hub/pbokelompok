package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BrokenTree extends SuperObject{
    public OBJ_BrokenTree()
    {
        name = "BrokenTree";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Broken_tree1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
