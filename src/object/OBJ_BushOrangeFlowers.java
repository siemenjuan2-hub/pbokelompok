package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BushOrangeFlowers extends SuperObject{
    public OBJ_BushOrangeFlowers()
    {
        name = "BushOrangeFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_orange_flowers1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
