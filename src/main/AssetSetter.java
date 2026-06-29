package main;

import entity.Ayam;
import entity.Babi;
import entity.Bebek;
import entity.Domba;
import entity.Kambing;
import entity.Keledai;
import entity.Npc_Merchant;
import entity.Npc_OldMan;
import entity.Sapi;
import object.OBJ_AutumnBush;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.OBJ_Potion_Health;
import object.OBJ_Sword_Copper;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;
import object.OBJ_Armor_Better;
import monster.MON_GreenSlime;

public class AssetSetter {
    GamePanel gp;
    int monsterCounterDungeon = 0;


    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject()
    {
        int mapNum = 0;
        int i = 0;
        gp.obj[mapNum][i] = new OBJ_AutumnBush(gp);
        gp.obj[mapNum][i].WorldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new OBJ_Bush1(gp);
        gp.obj[mapNum][i].WorldX = 30 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 21 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new OBJ_Bush2(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 41 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new OBJ_AutumnBush(gp);
        gp.obj[mapNum][i].WorldX = 25 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new OBJ_BurnedTree(gp);
        gp.obj[mapNum][i].WorldX = 25 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 21 * gp.tileSize;
        gp.obj[mapNum][i].collision = false;
        i++;
        gp.obj[mapNum][i] = new KananAtas(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KananBawah(gp);
        gp.obj[mapNum][i].WorldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 21 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new KiriAtas(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 20 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Kiribawah(gp);
        gp.obj[mapNum][i].WorldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 21 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new OBJ_Sword_Copper(gp);
        gp.obj[mapNum][i].WorldX = 25 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        gp.obj[mapNum][i].collision=false;
        i++;
        gp.obj[mapNum][i] = new OBJ_Armor_Better(gp);
        gp.obj[mapNum][i].WorldX = 26 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        gp.obj[mapNum][i].collision=false;
        i++;
        gp.obj[mapNum][i] = new OBJ_Potion_Health(gp);
        gp.obj[mapNum][i].WorldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new OBJ_Potion_Health(gp);
        gp.obj[mapNum][i].WorldX = 28 * gp.tileSize;
        gp.obj[mapNum][i].WorldY = 22 * gp.tileSize;
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
        gp.npc[mapNum][i].WorldY = gp.tileSize*9;
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
        gp.npc[mapNum][i].WorldX = gp.tileSize*37;
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
        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 23;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 40;
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 26;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 42;
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 28;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 38;
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 32;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 36;
        i++;

        gp.monster[mapNum][i] = new monster.MON_GreenSlime(gp);
        gp.monster[mapNum][i].WorldX = gp.tileSize * 35;
        gp.monster[mapNum][i].WorldY = gp.tileSize * 34;
        i++;

    }

    public void setMonsterDungeon() {
        int mapNum = 2;
        int i = 0;
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
        monsterCounterDungeon = i;
    }

    public void setMonsterDungeonBoss() {
        int mapNum = 3;
        int i = 0;
        // SPAWN BOSS DI SINI
        monsterCounterDungeon = i;
    }
}
