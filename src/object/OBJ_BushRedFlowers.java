package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BushRedFlowers extends SuperObject{
    public OBJ_BushRedFlowers()
    {
        name = "BushRedFlowers";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Bush_red_flowers1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
