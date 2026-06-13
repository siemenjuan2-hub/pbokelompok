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

    public int ScreenX;
    public int ScreenY;

    // buat interaksi kunci dan pintu, saat ini belum ada kunci
    public int hasKey = 0;

    double stamina;
    boolean isiStamina;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;


        //bugg
        solidArea = new Rectangle();
        solidArea.x = 96; //Nanti Sesuain sama ukuran karakter Hitung area solid nya, misal ukuran karakter kita 48 terus yang mau dibuat solid ditulis
        solidArea.y = 128; //Nanti Sesuian sama ukuran krakter, misal ukuran karakter kita 48 terus yang mau dibuat solid ditulis

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 64; //Nanti Sesuain dengan ukuran tiles yang dipake, misal lebar karakter kita 48 terus yang mau dibuat solid ditulis
        solidArea.height = 64; //Nanti sesuain dengan ukuran tiles yang dipake, misal tinggi karakter kita 48 terus yang mau dibuat solid ditulis


        // Untuk dapat titik tengah device


        setDefaultValues();
        
        getPlayerImage();}
    public void setDefaultValues() {
        WorldX = gp.tileSize * 23;// ini nanti tergantuns mau spawn dimana gitu
        WorldY = gp.tileSize *21; // sama
        stamina = 20;
        isiStamina = false;
        speed = 6;
        direction = "down";
        spriteNum = 1;
    }

    public void getPlayerImage() {
        try{
            //W
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR4C6.png"));

            //S
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR1C6.png"));

            //A
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR2C6.png"));        
            
            //D
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/assets/Player/Tiles/TileR3C6.png"));


        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // sprint
        if (keyH.shiftPrassed && stamina > 0 && !isiStamina) {
            speed = 10;
        } else {
            speed = 6;
        }

        // stamina habis
        if (stamina <= 0) {
            stamina = 0;
            isiStamina = true;
            speed = 6;
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

            // cek objek collision
            int objIndex = gp.cCheker.checkObject(this, true);
            pickUpObject(objIndex);

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
            System.out.println("X=" + WorldX + " Y=" + WorldY);
            if(spriteCounter > 10){
                    // isi ulang Stamina
                    if (isiStamina) {
                        stamina += 0.2;
                    }
                    if(speed == 10){
                        stamina-=1;
                    }
                    if(spriteNum == 1){
                        spriteNum = 2;
                    } else if (spriteNum == 2){
                        spriteNum = 3;
                    } else if (spriteNum == 3){
                        spriteNum = 4;
                    } else if (spriteNum == 4){
                        spriteNum = 5;
                    } else if (spriteNum == 5){
                        spriteNum = 6;
                    } else if (spriteNum == 6){
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }
    }

    public void pickUpObject(int i)
    {
        if(i != 999)
        {
            String ObjectName = gp.obj[i].name;

            // interaksi kunci dan pintu, saat ini belum ada objek kunci dan pintu
            switch(ObjectName)
            {
                case "AutumnBush":
                    hasKey++; // kunci player bertambah saat nyentuh objek kunci
                    gp.obj[i] = null; //index yang ditempati kunci objeknya dihilangkan setelah diambil
                    gp.ui.showMassage("You Got A Autumn Bush!");
                    break;
                case "SnowBush":
                    if(hasKey > 0)
                    {
                        gp.obj[i] = null; // buka pintu menggunakan kunci, pintu dihilangkan
                        hasKey--; // kunci berkurang dipakai untuk pintu
                        gp.ui.gameFinished = true;
                    }
                    break;
            }
        }
    }
    
public void draw(Graphics2D g2) {

    ScreenX = gp.getWidth() / 2 - (gp.tileSize / 2);
    ScreenY = gp.getHeight() / 2 - (gp.tileSize / 2);
    BufferedImage image = null;

    switch(direction) {
        case "up":
            if (spriteNum == 1){
                image = up1;
            } else if (spriteNum == 2){
                image = up2;
            } else if (spriteNum == 3){
                image = up3;
            } else if (spriteNum == 4){
                image = up4;
            } else if (spriteNum == 5){
                image = up5;
            } else if (spriteNum == 6){
                image = up6;
            }
            break;

        case "down":
            if (spriteNum == 1){
                image = down1;
            } else if (spriteNum == 2){
                image = down2;
            } else if (spriteNum == 3){
                image = down3;
            } else if (spriteNum == 4){
                image = down4;
            } else if (spriteNum == 5){
                image = down5;
            } else if (spriteNum == 6){
                image = down6;
            }
            break;

        case "left":
            if (spriteNum == 1){
                image = left1;
            } else if (spriteNum == 2){
                image = left2;
            } else if (spriteNum == 3){
                image = left3;
            } else if (spriteNum == 4){
                image = left4;
            } else if (spriteNum == 5){
                image = left5;
            } else if (spriteNum == 6){
                image = left6;
            }
            break;

        case "right":
            if (spriteNum == 1){
                image = right1;
            } else if (spriteNum == 2){
                image = right2;
            } else if (spriteNum == 3){
                image = right3;
            } else if (spriteNum == 4){
                image = right4;
            } else if (spriteNum == 5){
                image = right5;
            } else if (spriteNum == 6){
                image = right6;
            }
            break;
    }
    System.out.println("Panel = " + gp.getWidth() + " x " + gp.getHeight());
    System.out.println("Camera = " + ScreenY + " x " + ScreenX);
    System.out.println("Player = " + WorldY + " x " + WorldX);
    System.out.println(
    "Width="+gp.getWidth()+
    " Height="+gp.getHeight()
    );

    g2.drawImage(
        image,
        ScreenX,
        ScreenY,
        gp.tileSize*2,
        gp.tileSize*2,
        null
    );
}

}
