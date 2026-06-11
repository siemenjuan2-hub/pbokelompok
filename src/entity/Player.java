package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH; 

    public final int ScreenX;
    public final int ScreenY;

    double stamina;
    boolean isiStamina;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 8; //Nanti Sesuain sama ukuran karakter Hitung area solid nya, misal ukuran karakter kita 48 terus yang mau dibuat solid ditulis
        solidArea.y = 16; //Nanti Sesuian sama ukuran krakter, misal ukuran karakter kita 48 terus yang mau dibuat solid ditulis
        solidArea.width = 48; //Nanti Sesuain dengan ukuran tiles yang dipake, misal lebar karakter kita 48 terus yang mau dibuat solid ditulis
        solidArea.height = 48; //Nanti sesuain dengan ukuran tiles yang dipake, misal tinggi karakter kita 48 terus yang mau dibuat solid ditulis




// Untuk dapat titik tengah device
        ScreenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        ScreenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        setDefaultValues();
        getPlayerImage();}
    public void setDefaultValues() {
        WorldX = gp.tileSize * 23;// ini nanti tergantuns mau spawn dimana gitu
        WorldY = gp.tileSize *21; // sama
        stamina = 20;
        isiStamina = false;
        speed = 3;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/char1.jpeg"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/charback1.jpeg"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/char1.jpeg"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/charback1.jpeg"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/char1.jpeg"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/charback1.jpeg"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/char1.jpeg"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/charback1.jpeg"));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // sprint
        if (keyH.shiftPrassed && stamina > 0 && !isiStamina) {
            speed = 5;
        } else {
            speed = 3;
        }

        // stamina habis
        if (stamina <= 0) {
            stamina = 0;
            isiStamina = true;
            speed = 3;
        }
        
        // sudah cukup -> sprint boleh lagi
        if (isiStamina && stamina >= 5) {
            isiStamina = false;
        }
        
        // batas max
        if (stamina > 20) {
            stamina = 20;
        }
        if(keyH.upPressed == true||keyH.downPressed == true||keyH.leftPressed == true||keyH.rightPressed == true){
            
            if(keyH.upPressed == true){
                direction = "up";
            }
            if(keyH.downPressed == true){
                direction = "down";
            }
            if(keyH.rightPressed == true){
                direction = "right";
            }
            if(keyH.leftPressed == true){
                direction = "left";
            }

            // Cek tile collison
            collisionON = false;
            gp.cCheker.checkTile(this);

            // Kalo collisonnya false, playernya bisa gerak
            if (collisionON == false) {
                switch (direction) {
                    case "up":
                        WorldY -= speed;
                        break;
                    case "down":
                        WorldY += speed;
                        break;
                    case "left":
                        WorldX -= speed;
                        break;
                    case "right":
                        WorldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                    // isi ulang Stamina
                    if (isiStamina) {
                        stamina += 0.2;
                    }
                    if(speed == 5){
                        stamina-=1;
                    }
                    if(spriteNum == 1){
                        spriteNum = 2;
                    } else if (spriteNum == 2){
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }
    }
    public void draw(Graphics2D g2) {
            // g2.setColor(Color.white);
            // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
            BufferedImage image = null;
            switch(direction) {
                case "up":
                    if (spriteNum == 1){
                        image = up1;
                    } else if (spriteNum == 2){
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1){
                        image = down1;
                    } else if (spriteNum == 2){
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1){
                        image = left1;
                    } else if (spriteNum == 2){
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1){
                        image = right1;
                    } else if (spriteNum == 2){
                        image = right2;
                    }
                    break;
            }
            g2.drawImage(image, ScreenX, ScreenY, gp.tileSize, gp.tileSize, null);
    }
}
