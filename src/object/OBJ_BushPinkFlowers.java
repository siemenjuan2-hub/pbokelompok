package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BushPinkFlowers extends SuperObject{
    public OBJ_BushPinkFlowers()
    {
        name = "BushPinkFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_pink_flowers1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
