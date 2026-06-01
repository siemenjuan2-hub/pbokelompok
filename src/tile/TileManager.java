package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/rumput1.jpeg"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/jalan1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
    try {
        InputStream is =
            getClass().getResourceAsStream("/assets/Maps/Maps1.txt");

        if (is == null) {
            System.out.println("Map file tidak ditemukan!");
            return;
        }

        BufferedReader br =
            new BufferedReader(new InputStreamReader(is));

        int row = 0;

        while (row < gp.maxScreenRow) {

            String line = br.readLine();

            if (line == null) {
                System.out.println("Baris map kurang di row " + row);
                break;
            }

            String[] numbers = line.trim().split(" ");

            for (int col = 0; col < gp.maxScreenCol; col++) {

                if (col >= numbers.length) {
                    System.out.println(
                        "Kolom kurang di row " + row
                    );
                    break;
                }

                int num = Integer.parseInt(numbers[col]);

                mapTileNum[col][row] = num;
            }

            row++;
        }

        br.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+=gp.tileSize;
            }
        }
    }
}
