package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BushBlueFlowers extends SuperObject{
    public OBJ_BushBlueFlowers()
    {
        name = "BushBlueFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_blue_flowers1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
