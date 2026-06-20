// package object;

// import java.io.IOException;

// import javax.imageio.ImageIO;

// public class OBJ_Heart extends SuperObject{
//     Gamepanel gp;

//     public OBJ_Heart(Gamepanel gp)
//     {
//         this.gp = gp;

//         name = "Heart";
//         try {
//             image = ImageIO.read(getClass().getResourceAsStream("/assets/Objects/heart-full"));
//             image1 =ImageIO.read(getClass().getResourceAsStream("/assets/Objects/heart-half"));
//             image2 =ImageIO.read(getClass().getResourceAsStream("/assets/Objects/heart-blank"));
//             uTool.scaleImage(image, gp.tileSize, gp.tileSize);
//             uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
//             uTool.scaleImage(image3, gp.tileSize, gp.tileSize);


//         } catch(IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
