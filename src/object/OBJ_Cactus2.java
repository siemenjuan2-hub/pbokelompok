package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Cactus2 extends SuperObject{
    public OBJ_Cactus2()
    {
        name = "Cactus2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Cactus2_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
