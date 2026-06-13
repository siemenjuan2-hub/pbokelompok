package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class KananAtas extends SuperObject{

    GamePanel gp;

    public KananAtas(GamePanel gp)
    {
        this.gp = gp;
        name = "RumahKananAtas";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Rumah/TileR1C2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;        
    }
}
