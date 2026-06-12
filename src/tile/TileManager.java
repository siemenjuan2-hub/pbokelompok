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
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage(){
        try {
            //rumput
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Rumput.jpeg"));

            //jalan kanan
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/JalanKanan.jpeg"));

            //jalan kiri
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/JalanKiri.jpeg"));


            //daerah pantai / barrier
            //Pasir
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Pasir.jpeg"));

            //Air
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Water1.jpeg"));
            tile[4].collision = true;

            //Pasir pojok kiri bawah
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirPojokKiriBawah.jpeg"));
            tile[5].collision = true;

            //Pasir pojok kanan bawah
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirPojokKananBawah.jpeg"));
            tile[6].collision = true;

            //Pasir bawah
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirBawah.jpeg"));
            tile[7].collision = true;

              //Pasir pojok kiri atas
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirPojokKiriAtas.jpeg"));
            tile[8].collision = true;

            //Pasir pojok kanan atas
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirPojokKananAtas.jpeg"));
            tile[9].collision = true;

            //Pasir atas
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirAtas.jpeg"));
            
            // pasir kiri
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirKiri.jpeg"));
            tile[11].collision = true;

            // pasir kanan
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/PasirKanan.jpeg"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputKanan.jpeg"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputKiri.jpeg"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputAtas.jpeg"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputBawah.jpeg"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputPojokKiriBawah.jpeg"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputPojokKananBawah.jpeg"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputPojokKiriAtas.jpeg"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/RumputPojokKananAtas.jpeg"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/Bunga.jpeg"));
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

        while (row < gp.maxWorldRow) {

            String line = br.readLine();

            if (line == null) {
                System.out.println("Baris map kurang di row " + row);
                break;
            }

            String[] numbers = line.trim().split(" ");

            for (int col = 0; col < gp.maxWorldCol; col++) {

                if (col >= numbers.length) {
                    System.out.println("Kolom kurang di row " + row);
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
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            // worldCol & worldRow = nomor urut kotak tile di file teks map (0 sampai terserah map nya kita mau di set seberapa besar)
            // gp.tileSize         = ukuran 1 kotak tile dalam satuan piksel (misal: 48 piksel)
            int worldX = worldCol * gp.tileSize; // Posisi Jarak Piksel dari batas kiri World Map
            int worldY = worldRow * gp.tileSize; // Posisi Jarak Piksel dari batas atas World Map


            int screenX = worldX - gp.player.WorldX + gp.player.ScreenX; 
            int screenY = worldY - gp.player.WorldY + gp.player.ScreenY;


            //Ini biar Yang kegambar itu yang di layar laptop aja, yang jauh jauh ga kegamabar (efisiensi misal map e guede banget. Kalo mapnya kecill ga pake juga gamasalah)
            if (worldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX && 
                worldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX && 
                worldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY &&
                worldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY) 
            {
                
                g2.drawImage(
                        tile[tileNum].image,
                        screenX,
                        screenY,
                        gp.tileSize,
                        gp.tileSize,
                        null
                    );  
            }
            worldCol++;
            //Kalo kolom di baris nya dah habis digambar, reset ke kolom 0 lalu turun ke baris berikutnya
            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow ++;
            }
        }
    }
}
