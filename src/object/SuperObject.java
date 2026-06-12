package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 128, 128);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gp)
    {
        int screenX = worldX - gp.player.WorldX + gp.player.ScreenX;
        int screenY = worldY - gp.player.WorldY + gp.player.ScreenY;

        if(worldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX && 
            worldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX && 
            worldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY && 
            worldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY)
        {    
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }

        // buat cek collision lebih jelas
        g2.setColor(java.awt.Color.RED);
        g2.drawRect(screenX + solidAreaDefaultX, screenY + solidAreaDefaultY, solidArea.width, solidArea.height);
    }
}
