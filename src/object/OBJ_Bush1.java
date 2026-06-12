package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bush1 extends SuperObject{
    public OBJ_Bush1()
    {
        name = "Bush1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_simple1_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
