package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Fern2 extends SuperObject{
    public OBJ_Fern2()
    {
        name = "Fern1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/Fern2_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
