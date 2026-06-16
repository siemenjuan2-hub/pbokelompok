package main;

import entity.Ayam;
import entity.Babi;
import entity.Bebek;
import entity.Domba;
import entity.Kambing;
import entity.Keledai;
import entity.Npc_OldMan;
import entity.Sapi;
import object.OBJ_AutumnBush;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;


import monster.MON_GreenSlime;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        gp.obj[0] = new OBJ_AutumnBush(gp);
        gp.obj[0].WorldX = 22 * gp.tileSize;
        gp.obj[0].WorldY = 20 * gp.tileSize;
        gp.obj[0].collision = false;

        gp.obj[1] = new OBJ_Bush1(gp);
        gp.obj[1].WorldX = 30 * gp.tileSize;
        gp.obj[1].WorldY = 21 * gp.tileSize;    
        gp.obj[1].collision = false;  

        gp.obj[2] = new OBJ_Bush2(gp);
        gp.obj[2].WorldX = 37 * gp.tileSize;
        gp.obj[2].WorldY = 41 * gp.tileSize;  
        gp.obj[2].collision = false;

        gp.obj[3] = new OBJ_AutumnBush(gp);
        gp.obj[3].WorldX = 25 * gp.tileSize;
        gp.obj[3].WorldY = 20 * gp.tileSize;
        gp.obj[3].collision = false;
        
        gp.obj[4] = new OBJ_BurnedTree(gp);
        gp.obj[4].WorldX = 25 * gp.tileSize;
        gp.obj[4].WorldY = 21 * gp.tileSize;
        gp.obj[4].collision = false;

        gp.obj[5] = new KananAtas(gp);
        gp.obj[5].WorldX = 37 * gp.tileSize;
        gp.obj[5].WorldY = 20 * gp.tileSize;
        gp.obj[5].collision = false;

        gp.obj[6] = new KananBawah(gp);
        gp.obj[6].WorldX = 37 * gp.tileSize;
        gp.obj[6].WorldY = 21 * gp.tileSize;
        gp.obj[6].collision = true;

        gp.obj[7] = new KiriAtas(gp);
        gp.obj[7].WorldX = 36 * gp.tileSize;
        gp.obj[7].WorldY = 20 * gp.tileSize;
        gp.obj[7].collision = false;

        gp.obj[8] = new Kiribawah(gp);
        gp.obj[8].WorldX = 36 * gp.tileSize;
        gp.obj[8].WorldY = 21 * gp.tileSize;
        gp.obj[8].collision = true;
        
    }

    public void setNpc(){

        // PASUKAN KAKEK
        gp.npc[0] = new Npc_OldMan(gp);
        gp.npc[0].WorldX = gp.tileSize*21;
        gp.npc[0].WorldY = gp.tileSize*31;
        gp.npc[0].direction = "right";

        gp.npc[1] = new Npc_OldMan(gp);
        gp.npc[1].WorldX = gp.tileSize*21;
        gp.npc[1].WorldY = gp.tileSize*41;
        gp.npc[1].direction = " left";

        gp.npc[2] = new Npc_OldMan(gp);
        gp.npc[2].WorldX = gp.tileSize*9;
        gp.npc[2].WorldY = gp.tileSize*36;
        gp.npc[2].direction = "up";

        gp.npc[3] = new Npc_OldMan(gp);
        gp.npc[3].WorldX = gp.tileSize*15;
        gp.npc[3].WorldY = gp.tileSize*9;
        gp.npc[3].direction = "down";



        // PASUKAN BEBEK
        gp.npc[4] = new Bebek(gp);
        gp.npc[4].WorldX = gp.tileSize*25;
        gp.npc[4].WorldY = gp.tileSize*21;
        gp.npc[4].direction = "left";

        gp.npc[5] = new Bebek(gp);
        gp.npc[5].WorldX = gp.tileSize*28;
        gp.npc[5].WorldY = gp.tileSize*11;
        gp.npc[5].direction = "right";

        gp.npc[6] = new Bebek(gp);
        gp.npc[6].WorldX = gp.tileSize*25;
        gp.npc[6].WorldY = gp.tileSize*31;
        gp.npc[6].direction = "down";


        // PASUKAN KAMBING
        gp.npc[7] = new Kambing(gp);
        gp.npc[7].WorldX = gp.tileSize*23;
        gp.npc[7].WorldY = gp.tileSize*19;
        gp.npc[7].direction = "left";

        gp.npc[8] = new Kambing(gp);
        gp.npc[8].WorldX = gp.tileSize*30;
        gp.npc[8].WorldY = gp.tileSize*7;
        gp.npc[8].direction = "down";

        gp.npc[9] = new Kambing(gp);
        gp.npc[9].WorldX = gp.tileSize*29;
        gp.npc[9].WorldY = gp.tileSize*19;
        gp.npc[9].direction = "down";


        // PASUKAN SAPI
        gp.npc[10] = new Sapi(gp);
        gp.npc[10].WorldX = gp.tileSize*13;
        gp.npc[10].WorldY = gp.tileSize*19;
        gp.npc[10].direction = "left";

        gp.npc[11] = new Sapi(gp);
        gp.npc[11].WorldX = gp.tileSize*25;
        gp.npc[11].WorldY = gp.tileSize*7;
        gp.npc[11].direction = "up";

        gp.npc[12] = new Sapi(gp);
        gp.npc[12].WorldX = gp.tileSize*19;
        gp.npc[12].WorldY = gp.tileSize*10;
        gp.npc[12].direction = "down";


        // PASUKAN DOMBA
        gp.npc[13] = new Domba(gp);
        gp.npc[13].WorldX = gp.tileSize*17;
        gp.npc[13].WorldY = gp.tileSize*19;
        gp.npc[13].direction = "left";

        gp.npc[14] = new Domba(gp);
        gp.npc[14].WorldX = gp.tileSize*25;
        gp.npc[14].WorldY = gp.tileSize*17;
        gp.npc[14].direction = "right";

        gp.npc[15] = new Domba(gp);
        gp.npc[15].WorldX = gp.tileSize*19;
        gp.npc[15].WorldY = gp.tileSize*19;
        gp.npc[15].direction = "down";


        // PASUKAN Ayam
        gp.npc[16] = new Ayam(gp);
        gp.npc[16].WorldX = gp.tileSize*27;
        gp.npc[16].WorldY = gp.tileSize*8;
        gp.npc[16].direction = "left";

        gp.npc[17] = new Ayam(gp);
        gp.npc[17].WorldX = gp.tileSize*32;
        gp.npc[17].WorldY = gp.tileSize*17;
        gp.npc[17].direction = "left";

        gp.npc[18] = new Ayam(gp);
        gp.npc[18].WorldX = gp.tileSize*29;
        gp.npc[18].WorldY = gp.tileSize*6;
        gp.npc[18].direction = "down";


        // PASUKAN Babi
        gp.npc[19] = new Babi(gp);
        gp.npc[19].WorldX = gp.tileSize*17;
        gp.npc[19].WorldY = gp.tileSize*8;
        gp.npc[19].direction = "down";

        gp.npc[20] = new Babi(gp);
        gp.npc[20].WorldX = gp.tileSize*27;
        gp.npc[20].WorldY = gp.tileSize*17;
        gp.npc[20].direction = "up";

        gp.npc[21] = new Babi(gp);
        gp.npc[21].WorldX = gp.tileSize*39;
        gp.npc[21].WorldY = gp.tileSize*9;
        gp.npc[21].direction = "right";


        // PASUKAN Babi
        gp.npc[22] = new Keledai(gp);
        gp.npc[22].WorldX = gp.tileSize*30;
        gp.npc[22].WorldY = gp.tileSize*38;
        gp.npc[22].direction = "down";

        gp.npc[23] = new Keledai(gp);
        gp.npc[23].WorldX = gp.tileSize*37;
        gp.npc[23].WorldY = gp.tileSize*27;
        gp.npc[23].direction = "up";

        gp.npc[24] = new Keledai(gp);
        gp.npc[24].WorldX = gp.tileSize*12;
        gp.npc[24].WorldY = gp.tileSize*9;
        gp.npc[24].direction = "right";
    }

    public void setMonster() {
        gp.monster[0] = new monster.MON_GreenSlime(gp);
        gp.monster[0].WorldX = gp.tileSize*23;
        gp.monster[0].WorldY = gp.tileSize*37;

        gp.monster[1] = new monster.MON_GreenSlime(gp);
        gp.monster[1].WorldX = gp.tileSize*26;
        gp.monster[1].WorldY = gp.tileSize*42;
    }
}
