package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class KiriAtas extends SuperObject{

    GamePanel gp;

    public KiriAtas(GamePanel gp)
    {
        this.gp = gp;
        name = "RumahKiriAtas";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Rumah/TileR1C1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;        
    }
}
