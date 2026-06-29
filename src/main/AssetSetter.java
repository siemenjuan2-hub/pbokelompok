package main;

import java.util.Random;

import entity.Ayam;
import entity.Babi;
import entity.Bebek;
import entity.Domba;
import entity.Kambing;
import entity.Keledai;
import entity.Npc_Merchant;
import entity.Npc_OldMan;
import entity.Sapi;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.OBJ_Fountain;
import object.OBJ_Pohon_Hijau_Jumbo;
import object.OBJ_Pohon_Coklat_Jumbo;
import object.OBJ_Pohon_Kuning_Jumbo;
import object.OBJ_Pohon_Hijau_Sedang;
import object.OBJ_Potion_Health;
import object.OBJ_Sword_Copper;
import object.CEWE;
import object.DROP1;
import object.Dungeon_Kanan_Atas;
import object.Dungeon_Kanan_Bawah;
import object.Dungeon_Kiri_Atas;
import object.Dungeon_Kiri_Bawah;
import object.ShopSign;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;
import object.OBJ_Armor_Better;
import monster.MON_GreenSlime;
import monster.MON_QueenSlime;
import object.OBJ_Chest;
import object.OBJ_Tent;
import object.OBJ_Armor_Godly;
import object.OBJ_Sword_Godly;


public class AssetSetter {
    GamePanel gp;
    int monsterCounterDungeon = 0;
    public boolean bossRewardSpawned = false; // Penanda apakah hadiah sudah di-spawn
    public boolean taken = false; 
    public boolean rewardLocked = false;   // cewek hanya 1x selamanya
    public boolean phase2Active = false;   // untuk tracking fase 2
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        int mapNum = 0;
        int i = 0;
        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 29 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;           
        gp.obj[mapNum][i] = new ShopSign(gp);
        gp.obj[mapNum][i].WorldX = 35 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Tent(gp);
        gp.obj[mapNum][i].WorldX = 29 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 39 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;
        i++;   


        gp.obj[mapNum][i] = new OBJ_Tent(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 37 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;
        i++;                   


        gp.obj[mapNum][i] = new OBJ_Tent(gp);
        gp.obj[mapNum][i].WorldX = 29 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 32 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;
        i++;              


        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 13 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++; 


        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 13 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 14 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 16 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 10 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 16 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 17 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 12 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 15 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 15 * gp.tileSize;
        i++; 

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 17 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 17 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 16 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 14 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 18 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 14 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 18 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 13 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 16 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 17 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 14 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 10 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 15 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 11 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Sedang(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 15 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 17 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 16 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 11 * gp.tileSize;
        i++;

        for (int j = 23; j < 30; j++) {
            for (int k = 11; k < 24; k++) {
                if(j == 23){
                    gp.obj[mapNum][i] = new OBJ_Bush1(gp);
                    gp.obj[mapNum][i].WorldX = k * gp.tileSize;
                    gp.obj[mapNum][i].WorldY = j * gp.tileSize;
                    gp.obj[mapNum][i].collision = true;
                    i++;
                }
                if(j > 23 && j < 29 && k == 11){
                    gp.obj[mapNum][i] = new OBJ_Bush1(gp);
                    gp.obj[mapNum][i].WorldX = k * gp.tileSize;
                    gp.obj[mapNum][i].WorldY = j * gp.tileSize;
                    gp.obj[mapNum][i].collision = true;
                    i++;
                }
                if(j == 29){
                    gp.obj[mapNum][i] = new OBJ_Bush1(gp);
                    gp.obj[mapNum][i].WorldX = k * gp.tileSize;
                    gp.obj[mapNum][i].WorldY = j * gp.tileSize;
                    gp.obj[mapNum][i].collision = true;
                    i++;
                }
            }
        }

        
        gp.obj[mapNum][i] = new OBJ_Bush1(gp);
        gp.obj[mapNum][i].WorldX = 23 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 25 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;

        gp.obj[mapNum][i] = new OBJ_Bush1(gp);
        gp.obj[mapNum][i].WorldX = 23 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;

        gp.obj[mapNum][i] = new OBJ_Bush1(gp);
        gp.obj[mapNum][i].WorldX = 23 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        gp.obj[mapNum][i].collision = true;


        i++;

        gp.obj[mapNum][i] = new OBJ_Bush2(gp);
        gp.obj[mapNum][i].WorldX = 23 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_Fountain(gp);
        gp.obj[mapNum][i].WorldX = 16 * gp.tileSize + gp.tileSize / 2;
        gp.obj[mapNum][i].WorldY = 25 * gp.tileSize + gp.tileSize / 2;
        gp.obj[mapNum][i].collision = true;
        i++;



        gp.obj[mapNum][i] = new OBJ_Bush2(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 41 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new OBJ_Pohon_Hijau_Jumbo(gp);
        gp.obj[mapNum][i].WorldX = 26 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 25 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 21 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 15 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 17 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 15 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 12 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 16 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 14 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 10 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 11 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 12 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 14 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;

        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 19 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 28 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 28 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 31 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 31 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 24 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 35 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 25 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 35 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 34 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 25 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 34 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;


        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 31 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 31 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 27 * gp.tileSize;
        i++;


        // gp.obj[mapNum][i] = new OBJ_Sword_Copper(gp);
        // gp.obj[mapNum][i].WorldX = 25 * gp.tileSize;
        // gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        // gp.obj[mapNum][i].collision=false;
        // i++;
        // gp.obj[mapNum][i] = new OBJ_Armor_Better(gp);
        // gp.obj[mapNum][i].WorldX = 26 * gp.tileSize;
        // gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        // gp.obj[mapNum][i].collision=false;
        // i++;
        // gp.obj[mapNum][i] = new OBJ_Potion_Health(gp);
        // gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        // gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        // i++;
        // gp.obj[mapNum][i] = new OBJ_Potion_Health(gp);
        // gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        // gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        // i++;
        // gp.obj[mapNum][i] = new CEWE(gp);
        // gp.obj[mapNum][i].WorldX = 29 * gp.tileSize;
        // gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        // i++;
        gp.obj[mapNum][i] = new OBJ_Armor_Godly(gp);
        gp.obj[mapNum][i].WorldX = 29 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        i++;                

        gp.obj[mapNum][i] = new OBJ_Sword_Godly(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        i++;      

        gp.obj[mapNum][i] = new Dungeon_Kiri_Atas(gp);
        gp.obj[mapNum][i].WorldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;
        
        gp.obj[mapNum][i] = new Dungeon_Kanan_Atas(gp);
        gp.obj[mapNum][i].WorldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 8 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Dungeon_Kiri_Bawah(gp);
        gp.obj[mapNum][i].WorldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 9 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Dungeon_Kanan_Bawah(gp);
        gp.obj[mapNum][i].WorldX = 12 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 9 * gp.tileSize;
        i++;

        // MAP 2 (TRADER)
        mapNum ++;
        gp.obj[mapNum][i] = new OBJ_Chest(gp);
        gp.obj[mapNum][i].WorldX = 26 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;      
        gp.obj[mapNum][i] = new OBJ_Chest(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 23 * gp.tileSize;
        i++;            
    }

    public void setNpc(){
        // SPAWN ENTITY UNTUK  MAP 1 (mapNum = 0)
        int mapNum = 0;
        int i = 0;

        // PASUKAN KAKEK
        gp.npc[mapNum][i] = new Npc_OldMan(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*21;
        gp.npc[mapNum][i].WorldY = gp.tileSize*41;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Npc_OldMan(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*9;
        gp.npc[mapNum][i].WorldY = gp.tileSize*36;
        gp.npc[mapNum][i].direction = "up";
        i++;

        gp.npc[mapNum][i] = new Npc_OldMan(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*15;
        gp.npc[mapNum][i].WorldY = gp.tileSize*8;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN BEBEK
        gp.npc[mapNum][i] = new Bebek(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*25;
        gp.npc[mapNum][i].WorldY = gp.tileSize*21;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Bebek(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*28;
        gp.npc[mapNum][i].WorldY = gp.tileSize*11;
        gp.npc[mapNum][i].direction = "right";
        i++;

        gp.npc[mapNum][i] = new Bebek(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*25;
        gp.npc[mapNum][i].WorldY = gp.tileSize*31;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN KAMBING
        gp.npc[mapNum][i] = new Kambing(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*23;
        gp.npc[mapNum][i].WorldY = gp.tileSize*19;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Kambing(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*30;
        gp.npc[mapNum][i].WorldY = gp.tileSize*7;
        gp.npc[mapNum][i].direction = "down";
        i++;

        gp.npc[mapNum][i] = new Kambing(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*29;
        gp.npc[mapNum][i].WorldY = gp.tileSize*19;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN SAPI
        gp.npc[mapNum][i] = new Sapi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*13;
        gp.npc[mapNum][i].WorldY = gp.tileSize*19;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Sapi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*25;
        gp.npc[mapNum][i].WorldY = gp.tileSize*7;
        gp.npc[mapNum][i].direction = "up";
        i++;

        gp.npc[mapNum][i] = new Sapi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*19;
        gp.npc[mapNum][i].WorldY = gp.tileSize*10;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN DOMBA
        gp.npc[mapNum][i] = new Domba(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*17;
        gp.npc[mapNum][i].WorldY = gp.tileSize*19;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Domba(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*25;
        gp.npc[mapNum][i].WorldY = gp.tileSize*17;
        gp.npc[mapNum][i].direction = "right";
        i++;

        gp.npc[mapNum][i] = new Domba(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*19;
        gp.npc[mapNum][i].WorldY = gp.tileSize*19;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN Ayam
        gp.npc[mapNum][i] = new Ayam(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*27;
        gp.npc[mapNum][i].WorldY = gp.tileSize*8;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Ayam(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*32;
        gp.npc[mapNum][i].WorldY = gp.tileSize*17;
        gp.npc[mapNum][i].direction = "left";
        i++;

        gp.npc[mapNum][i] = new Ayam(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*29;
        gp.npc[mapNum][i].WorldY = gp.tileSize*6;
        gp.npc[mapNum][i].direction = "down";
        i++;


        // PASUKAN Babi
        gp.npc[mapNum][i] = new Babi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*17;
        gp.npc[mapNum][i].WorldY = gp.tileSize*8;
        gp.npc[mapNum][i].direction = "down";
        i++;

        gp.npc[mapNum][i] = new Babi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*27;
        gp.npc[mapNum][i].WorldY = gp.tileSize*17;
        gp.npc[mapNum][i].direction = "up";
        i++;

        gp.npc[mapNum][i] = new Babi(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*39;
        gp.npc[mapNum][i].WorldY = gp.tileSize*9;
        gp.npc[mapNum][i].direction = "right";
        i++;


        // PASUKAN Keledai
        gp.npc[mapNum][i] = new Keledai(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*30;
        gp.npc[mapNum][i].WorldY = gp.tileSize*38;
        gp.npc[mapNum][i].direction = "down";
        i++;

        gp.npc[mapNum][i] = new Keledai(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*39;
        gp.npc[mapNum][i].WorldY = gp.tileSize*27;
        gp.npc[mapNum][i].direction = "up";
        i++;

        gp.npc[mapNum][i] = new Keledai(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*12;
        gp.npc[mapNum][i].WorldY = gp.tileSize*9;
        gp.npc[mapNum][i].direction = "right";
        i++;

        // SPAWN ENTITY UNTUK  MAP 2 (mapNum = 1)
        mapNum++;
        
        // Merchant: Sprite masih pake yg kakek, letak merchant di map yang sama
        gp.npc[mapNum][i] = new Npc_Merchant(gp);
        gp.npc[mapNum][i].WorldX = gp.tileSize*24;
        gp.npc[mapNum][i].WorldY = gp.tileSize*24;
        gp.npc[mapNum][i].direction = "down";
        i++;

    }

    public void setMonsterMap1() {
        int mapNum = 0;
        int i = 0;
        // gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        // gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
        // gp.monster[mapNum][i].WorldY = gp.tileSize * 40;
        // i++;

        // gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        // gp.monster[mapNum][i].WorldX = gp.tileSize * 26;
        // gp.monster[mapNum][i].WorldY = gp.tileSize * 42;
        // i++;

        // gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        // gp.monster[mapNum][i].WorldX = gp.tileSize * 28;
        // gp.monster[mapNum][i].WorldY = gp.tileSize * 38;
        // i++;

        // gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        // gp.monster[mapNum][i].WorldX = gp.tileSize * 32;
        // gp.monster[mapNum][i].WorldY = gp.tileSize * 36;
        // i++;

        // gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        // gp.monster[mapNum][i].WorldX = gp.tileSize * 35;
        // gp.monster[mapNum][i].WorldY = gp.tileSize * 34;
        // i++;

    }

    public void setMonsterDungeon() {
        int mapNum = 2;
        int i = 0;

        // SLIME HIJAU KIRI
        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 10;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 30;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 12;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 33;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 13;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 34;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 15;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 15;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 33;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        // SLIME HIJAU KANAN
        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 38;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 30;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 37;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 33;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 33;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 30;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 35;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 34;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 33;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;



        // SLIME MERAH (KIRI ATAS)
        gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 13;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 19;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 8;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 19;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 8;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 13;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 10;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 21;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;


        // SLIME BIRU (KANAN ATAS)
        gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 35;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 19;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 40;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 19;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 39;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 22;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 35;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 38;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 21;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new MON_QueenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 24;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 15;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new MON_QueenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 24;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 11;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;

        gp.monster[mapNum][i] = new MON_QueenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 24;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 19;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        i++;
        
        monsterCounterDungeon = i;
    }

    public void setMonsterDungeonBoss() {

        int mapNum = 3;
        int i = 0;

        // ======================
        // Spawn Boss
        // ======================
        gp.monster[mapNum][i] = new monster.MON_KingSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 24;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk());
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp());
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());

        i++;
        monsterCounterDungeon = i;

        // ======================
        // Spawn Lantern
        // ======================

        int o = 0;
        Random rand = new Random();

        while (o < 25) { // jumlah lantern

            // Area lantai (sesuaikan dengan map Anda)
            int x = rand.nextInt(28) + 11; // 11 - 38
            int y = rand.nextInt(28) + 13; // 13 - 40

            // Hanya boleh di tile 26
            if (gp.tileM.mapTileNum[mapNum][x][y] != 26) {
                continue;
            }

            // Jangan di area boss
            if (x >= 20 && x <= 28 && y >= 27 && y <= 35 && x!=23 && y!=38) {
                continue;
            }

            // Jangan menumpuk dengan lantern lain
            boolean occupied = false;
            for (int j = 0; j < o; j++) {

                int objX = gp.obj[mapNum][j].WorldX / gp.tileSize;
                int objY = gp.obj[mapNum][j].WorldY / gp.tileSize;

                // Minimal jarak 4 tile
                if (Math.abs(objX - x) < 4 && Math.abs(objY - y) < 4) {
                    occupied = true;
                    break;
                }
            }

            if (occupied) {
                continue;
            }

            gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
            gp.obj[mapNum][o].WorldX = x * gp.tileSize;
            gp.obj[mapNum][o].WorldY = y * gp.tileSize;
            gp.obj[mapNum][o].collision=false;
            o++;

        }
    }

    public void setBossFase2() {
        int mapNum = 4;
        int i = 0;
        int o = 0;
        gp.monster[mapNum][i] = new monster.MON_KingSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 30;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() / 2); // ubah atkMonster
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() / 2); // ubah MaxHpMonster
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        gp.monster[mapNum][i].entitySize = 256;
        gp.monster[mapNum][i].solidArea.width = gp.monster[mapNum][i].entitySize;
        gp.monster[mapNum][i].solidArea.height = gp.monster[mapNum][i].entitySize;
        i++;

        gp.monster[mapNum][i] = new monster.MON_KingSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 24;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() / 2); // ubah atkMonster
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() / 2); // ubah MaxHpMonster
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        gp.monster[mapNum][i].entitySize = 256;
        gp.monster[mapNum][i].solidArea.width = gp.monster[mapNum][i].entitySize;
        gp.monster[mapNum][i].solidArea.height = gp.monster[mapNum][i].entitySize;
        i++;

        gp.monster[mapNum][i] = new monster.MON_KingSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 31;
        gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() / 2); // ubah atkMonster
        gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() / 2); // ubah MaxHpMonster
        gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
        gp.monster[mapNum][i].entitySize = 256;
        gp.monster[mapNum][i].solidArea.width = gp.monster[mapNum][i].entitySize;
        gp.monster[mapNum][i].solidArea.height = gp.monster[mapNum][i].entitySize;
        i++;
        monsterCounterDungeon = i;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 28;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 15;
        gp.obj[mapNum][o].collision=false;
        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 26;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 18;
        gp.obj[mapNum][o].collision=false;
        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 22;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 28;
        gp.obj[mapNum][o].collision=false;
        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 16;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 29;
        gp.obj[mapNum][o].collision=false;
        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 32;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 28;
                gp.obj[mapNum][o].collision=false;

        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 20;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 15;
                gp.obj[mapNum][o].collision=false;

        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 34;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 18;
        gp.obj[mapNum][o].collision=false;
        o++;

        gp.obj[mapNum][o] = new object.OBJ_Lantern(gp);
        gp.obj[mapNum][o].WorldX = gp.tileSize * 14;
        gp.obj[mapNum][o].WorldY = gp.tileSize * 31;
        gp.obj[mapNum][o].collision=true;
        o++;
    }

    public void SpawnMonsterBoss(){
        int mapNum = 3;
        int i = monsterCounterDungeon;
        if(gp.monster[3][0] == null){
            
        }
        else if(gp.monster[3][0] != null && gp.monster[3][0].getMaxHp() * 25 / 100 > gp.monster[3][0].getHp() && !gp.eHandler.spawn3){
            i = 1;
            // SPAWN BAWAH
            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = 27;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 25;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 24;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 21;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 19;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 25;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KANAN
            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 29;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 26;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 22;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 28;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 22;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KIRI
            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 20;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 21;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 26;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_RedSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 18;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

        }
        else if(gp.monster[3][0] != null && gp.monster[3][0].getMaxHp() * 50 / 100 > gp.monster[3][0].getHp() && !gp.eHandler.spawn3){
            i = 1;
            // SPAWN BAWAH
            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = 27;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 25;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 24;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 21;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 19;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 25;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KANAN
            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 29;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 26;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 22;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 28;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 22;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KIRI
            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 20;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 21;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 26;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_BlueSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 18;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

        }
        else if(gp.monster[3][0] != null && gp.monster[3][0].getMaxHp() * 75 / 100 > gp.monster[3][0].getHp() && !gp.eHandler.spawn3){
            i = 1;
            // SPAWN bAWAH
            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = 27;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 25;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 24;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 21;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 23;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 19;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 25;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KANAN
            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 29;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 26;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 22;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 28;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 22;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            // SPAWN KIRI
            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 20;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 21;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 26;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 29;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

            gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
            gp.monster[mapNum][i].WorldX = gp.tileSize * 18;
            gp.monster[mapNum][i].WorldY = gp.tileSize * 18;
            gp.monster[mapNum][i].setAtk(gp.monster[mapNum][i].getAtk() + (gp.player.getDungeonStage()*gp.player.getDungeonLevel())); // ubah atkMonster Berdasarkan levelDungeon
            gp.monster[mapNum][i].setMaxHp(gp.monster[mapNum][i].getMaxHp() + ((2+gp.player.getDungeonStage())*gp.player.getDungeonLevel())); // ubah MaxHpMonster Berdasarkan LevelDungeon
            gp.monster[mapNum][i].setHp(gp.monster[mapNum][i].getMaxHp());
            i++;

        }
        monsterCounterDungeon = i;
        

    }

    public void bossReward(){
        int mapNum = 4;
        int i=0;
        int bossRewardIndex = -1; // Menyimpan lokasi indeks array objek CEWE
        gp.obj[mapNum][i]= new object.CEWE(gp);
        gp.obj[mapNum][i].WorldX = 26 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        gp.obj[mapNum][i].collision=false;
        i++;

    }
}
