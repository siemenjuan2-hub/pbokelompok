package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/rumput1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        for(int i = 0 ; i < gp.maxScreenCol ; i++){
            for(int j = 0 ; j < gp.maxScreenRow ; j ++){
                g2.drawImage(tile[0].image, i*gp.tileSize, j*gp.tileSize, gp.tileSize, gp.tileSize, null);
            }
        }
    }
}
