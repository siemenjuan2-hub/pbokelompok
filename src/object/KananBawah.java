package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class KananBawah extends SuperObject{

    GamePanel gp;

    public KananBawah(GamePanel gp)
    {
        this.gp = gp;
        name = "RumahKananBawah";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Rumah/TileR2C2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;        
    }
}
