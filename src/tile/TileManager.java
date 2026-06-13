package tile;

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
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
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
