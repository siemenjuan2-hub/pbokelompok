package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.crypto.Data;

import entity.Entity;
import main.GamePanel;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;
import object.OBJ_Armor_Better;
import object.OBJ_Armor_Normal;
import object.OBJ_AutumnBush;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.OBJ_Potion_Health;
import object.OBJ_Sword_Copper;
import object.OBJ_Sword_Normal;

public class SaveLoad {
    
    GamePanel gp;

    public SaveLoad(GamePanel gp){
        this.gp = gp;
    }



    public void save(){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));

            DataStorage ds = new DataStorage();

            // PLAYER STATS
            ds.level = gp.player.getLevel();
            ds.maxHp = gp.player.getMaxHp();
            ds.hp = gp.player.getHp();
            ds.maxStamina = gp.player.maxStamina;
            ds.strength = gp.player.getStrength();
            ds.def = gp.player.getDef();
            ds.exp = gp.player.getExp();
            ds.nextLevelExp = gp.player.getNextLevelExp();
            ds.coin = gp.player.coin;
            ds.dungeonLevel = gp.player.getDungeonLevel();
            ds.dungeonStage = gp.player.getDungeonStage();
            ds.dungeonInfiniteHighest = gp.player.getDungeonInfiniteHighest();

            // PLAYER INVENTORY
            for (int i = 0 ; i < gp.player.inventory.size() ; i++){
                ds.itemNames.add(gp.player.inventory.get(i).name);
                ds.itemAmounts.add(gp.player.inventory.get(i).amount);
            }

            // PLAYER EQUIPMENT
            ds.currentSwordSlot = gp.player.getCurrentSwordSlot();
            ds.currentArmorSlot = gp.player.getCurrentArmorSlot();

            // OBJECT ON MAP
            ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];

            for(int mapNum = 0 ; mapNum < gp.maxMap ; mapNum++){
                for(int i = 0 ; i < gp.obj[1].length ; i++){
                    if(gp.obj[mapNum][i] == null){
                        ds.mapObjectNames[mapNum][i] = "NA";
                    }else{
                        ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
                        ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].WorldX;
                        ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].WorldY;
                    }
                }
            }


            // write the DataStorage Object
            oos.writeObject(ds);

            oos.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            // read DataStorage Object
            DataStorage ds = (DataStorage)ois.readObject();

            // SET POSITION PALYER
            gp.player.setDefaultPosition();

            // PLAYER STATS
            gp.player.setLevel(ds.level);
            gp.player.setMaxHp(ds.maxHp);
            gp.player.maxStamina = ds.maxStamina;
            gp.player.setHp(ds.hp);
            gp.player.setStrength(ds.strength);
            gp.player.setDef(ds.def);
            gp.player.setExp(ds.exp);
            gp.player.setNextLevelExp(ds.nextLevelExp);
            gp.player.coin = ds.coin;
            gp.player.setDungeonLevel(ds.dungeonLevel);
            gp.player.setDungeonStage(ds.dungeonStage);
            gp.player.setDungeonInfiniteHighest(ds.dungeonInfiniteHighest);

            // PLAYER INVENTORY
            gp.player.inventory.clear();
            for(int i = 0 ; i < ds.itemNames.size() ; i++){
                gp.player.inventory.add(gp.eGenerator.getObject(ds.itemNames.get(i)));
                gp.player.inventory.get(i).amount = ds.itemAmounts.get(i);
            }

            // PLAYER EQUIPMENT
            gp.player.currentSword = gp.player.inventory.get(ds.currentSwordSlot);
            gp.player.currentArmor = gp.player.inventory.get(ds.currentArmorSlot);

            // OBJECT ON MAP
            for(int mapNum = 0 ; mapNum < gp.maxMap ; mapNum++){
                for(int i = 0 ; i < gp.obj[1].length ; i++){
                    if(ds.mapObjectNames[mapNum][i].equals("NA")){
                        gp.obj[mapNum][i] = null;
                    }else{
                        gp.obj[mapNum][i] = gp.eGenerator.getObject(ds.mapObjectNames[mapNum][i]);
                        gp.obj[mapNum][i].WorldX = ds.mapObjectWorldX[mapNum][i];
                        gp.obj[mapNum][i].WorldY = ds.mapObjectWorldY[mapNum][i];

                    }
                }
            }
            
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
