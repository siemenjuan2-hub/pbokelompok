package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_AutumnBush extends SuperObject{
    public OBJ_AutumnBush()
    {
        name = "AutumnBush";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Autumn_bush1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
