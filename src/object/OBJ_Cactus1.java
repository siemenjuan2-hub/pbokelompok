package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Cactus1 extends SuperObject{
    public OBJ_Cactus1()
    {
        name = "Cactus1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Cactus1_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
