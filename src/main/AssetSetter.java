package main;

import entity.Npc_OldMan;
import object.OBJ_AutumnBush;
import object.OBJ_BrokenTree;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.OBJ_BushBlueFlowers;
import object.OBJ_BushOrangeFlowers;
import object.OBJ_BushPinkFlowers;
import object.OBJ_BushRedFlowers;
import object.OBJ_Cactus1;
import object.OBJ_Cactus2;
import object.OBJ_Fern1;
import object.OBJ_Fern2;
import object.OBJ_SnowBush;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        // gp.obj[0] = new OBJ_AutumnBush(gp);
        // gp.obj[0].worldX = 22 * gp.tileSize;
        // gp.obj[0].worldY = 20 * gp.tileSize;

        gp.obj[1] = new OBJ_BrokenTree(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;      

        gp.obj[2] = new OBJ_BurnedTree(gp);
        gp.obj[2].worldX = 24 * gp.tileSize;
        gp.obj[2].worldY = 20 * gp.tileSize;  
        
        gp.obj[3] = new OBJ_Bush1(gp);
        gp.obj[3].worldX = 25 * gp.tileSize;
        gp.obj[3].worldY = 20 * gp.tileSize;  
        
        gp.obj[4] = new OBJ_Bush2(gp);
        gp.obj[4].worldX = 26 * gp.tileSize;
        gp.obj[4].worldY = 20 * gp.tileSize;  

        gp.obj[5] = new OBJ_BushBlueFlowers(gp);
        gp.obj[5].worldX = 27 * gp.tileSize;
        gp.obj[5].worldY = 20 * gp.tileSize;  
        
        gp.obj[6] = new OBJ_BushOrangeFlowers(gp);
        gp.obj[6].worldX = 28 * gp.tileSize;
        gp.obj[6].worldY = 20 * gp.tileSize;  
        
        gp.obj[7] = new OBJ_BushOrangeFlowers(gp);
        gp.obj[7].worldX = 29 * gp.tileSize;
        gp.obj[7].worldY = 20 * gp.tileSize;  
        
        gp.obj[8] = new OBJ_BushPinkFlowers(gp);
        gp.obj[8].worldX = 30 * gp.tileSize;
        gp.obj[8].worldY = 20 * gp.tileSize;  
        
        gp.obj[9] = new OBJ_BushRedFlowers(gp);
        gp.obj[9].worldX = 31 * gp.tileSize;
        gp.obj[9].worldY = 20 * gp.tileSize;  
        
        gp.obj[10] = new OBJ_Cactus1(gp);
        gp.obj[10].worldX = 32 * gp.tileSize;
        gp.obj[10].worldY = 20 * gp.tileSize;  
        
        gp.obj[11] = new OBJ_Cactus2(gp);
        gp.obj[11].worldX = 33 * gp.tileSize;
        gp.obj[11].worldY = 20 * gp.tileSize;  
        
        gp.obj[12] = new OBJ_Fern1(gp);
        gp.obj[12].worldX = 34 * gp.tileSize;
        gp.obj[12].worldY = 20 * gp.tileSize;    
        
        gp.obj[13] = new OBJ_Fern2(gp);
        gp.obj[13].worldX = 35 * gp.tileSize;
        gp.obj[13].worldY = 20 * gp.tileSize;  

        gp.obj[14] = new KananAtas(gp);
        gp.obj[14].worldX = 37 * gp.tileSize;
        gp.obj[14].worldY = 19 * gp.tileSize;

        gp.obj[15] = new KananBawah(gp);
        gp.obj[15].worldX = 37 * gp.tileSize;
        gp.obj[15].worldY = 20 * gp.tileSize;

        gp.obj[16] = new KiriAtas(gp);
        gp.obj[16].worldX = 36 * gp.tileSize;
        gp.obj[16].worldY = 19 * gp.tileSize;

        gp.obj[17] = new Kiribawah(gp);
        gp.obj[17].worldX = 36 * gp.tileSize;
        gp.obj[17].worldY = 20 * gp.tileSize;
        
        
        // gp.obj[14] = new OBJ_SnowBush(gp);
        // gp.obj[14].worldX = 36 * gp.tileSize;
        // gp.obj[14].worldY = 20 * gp.tileSize;                
        
    }

    public void setNpc(){

        gp.npc[0] = new Npc_OldMan(gp);
        gp.npc[0].WorldX = gp.tileSize*21;
        gp.npc[0].WorldY = gp.tileSize*21;
    }
}
