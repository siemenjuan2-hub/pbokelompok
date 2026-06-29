package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[50];

        mapTileNum = new int [gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/assets/Maps/Maps1.txt", 0);
        loadMap("/assets/Maps/Maps2.txt", 1);
        loadMap("/assets/Maps/Maps3.txt", 2);
        loadMap("/assets/Maps/Maps4.txt", 3);
        loadMap("/assets/Maps/Maps5.txt", 4);

    }

    public void getTileImage(){
        // Rumput & Jalan (Bisa Lewat)
        setup(0, "Rumput", false);
        setup(1, "JalanKanan", false);
        setup(2, "JalanKiri", false);
        setup(3, "Pasir", false);

        // Daerah Air / Penghalang (Tidak Bisa lewat)
        setup(4, "Water1", true);
        setup(5, "PasirPojokKiriBawah", true);
        setup(6, "PasirPojokKananBawah", true);
        setup(7, "PasirBawah", true);
        setup(8, "PasirPojokKiriAtas", true);
        setup(9, "PasirPojokKananAtas", true);
        
        // Pasir Atas (Bisa Lewat)
        setup(10, "PasirAtas", false);
        
        // Batas Pasir Samping (Gabisa Lewat)
        setup(11, "PasirKiri", true);
        setup(12, "PasirKanan", true);

        // Variasi Rumput Lainnya (Bisa lewati)
        setup(13, "RumputKanan", false);
        setup(14, "RumputKiri", false);
        setup(15, "RumputAtas", false);
        setup(16, "RumputBawah", false);
        setup(17, "RumputPojokKiriBawah", false);
        setup(18, "RumputPojokKananBawah", false);
        setup(19, "RumputPojokKiriAtas", false);
        setup(20, "RumputPojokKananAtas", false);
        setup(21, "Bunga", false);

        // World 2 (bisa ubah asset sesuaikan dengan dungeon atau dalam rumah)
        setup(22, "T603", false);
        setup(23, "/Rumah/floor01", false);
        setup(24, "/Rumah/wall01", true);

        // Dungeon (maps3.txt)
        setup(25, "/Dungeon/dungeon-door",false);
        setup(26, "/Dungeon/dungeon-floor1", false);
    }

    
public void setup(int index, String imageName, boolean collision) {
    UtilityTool uTool = new UtilityTool();

    try {
        tile[index] = new Tile();
        
        // 1. Ambil gambar mentah, langsung masukkan ke tujuan akhir
        tile[index].image = ImageIO.read(getClass().getResourceAsStream("/assets/World/" + imageName + ".jpeg"));
        
        // 2. Ambil gambar dari tujuan akhir, diperkecil, terus timpa balik ke tempat yang sama
        tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
        
        // 3. Atur status tabrakannya
        tile[index].collision = collision;
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public void loadMap(String filePath, int map) {
    try {
        InputStream is =
            getClass().getResourceAsStream(filePath);

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

                mapTileNum[map][col][row] = num;
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

            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;

            int screenX =
                worldX - gp.player.WorldX + gp.player.ScreenX;

            int screenY =
                worldY - gp.player.WorldY + gp.player.ScreenY;

            // render hanya area layar + buffer 1 tile
            if(
                screenX > -gp.tileSize &&
                screenX < gp.getWidth() + gp.tileSize &&
                screenY > -gp.tileSize &&
                screenY < gp.getHeight() + gp.tileSize
            ){
            if(tile[tileNum] == null){
                System.out.println("NULL TILE DETECTED");
                System.out.println("tileNum = " + tileNum);
                System.out.println("col = " + worldCol);
                System.out.println("row = " + worldRow);
                return;
            }
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

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
