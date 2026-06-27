package data;

import java.io.Serializable;
import java.util.ArrayList;


public class DataStorage implements Serializable {
    
    // PLAYER STAT
    int level;
    int maxHp;
    int hp;
    int maxStamina;
    int strength;
    int def;
    int exp;
    int nextLevelExp;
    int coin;
    int dungeonLevel;
    int dungeonStage;

    // PLAYER INVENTORY
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemAmounts = new ArrayList<>();
    int currentSwordSlot;
    int currentArmorSlot;

    // OBJECT ON MAP
    String mapObjectNames[][];
    int mapObjectWorldX[][];
    int mapObjectWorldY[][];
    String mapObjectLootNames[][];
}
