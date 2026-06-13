package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SnowBush extends SuperObject{
    public OBJ_SnowBush()
    {
        name = "SnowBush";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Snow_bush1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;        
    }
}
