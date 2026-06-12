package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bush2 extends SuperObject{
    public OBJ_Bush2()
    {
        name = "Bush2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_simple2_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
