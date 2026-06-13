package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Kiribawah  extends SuperObject{

    GamePanel gp;

    public Kiribawah(GamePanel gp)
    {
        this.gp = gp;
        name = "RumahKiriBawah";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Rumah/TileR2C1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
