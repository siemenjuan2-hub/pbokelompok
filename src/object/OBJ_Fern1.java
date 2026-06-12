package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Fern1 extends SuperObject{
    public OBJ_Fern1()
    {
        name = "Fern1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Fern1_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
