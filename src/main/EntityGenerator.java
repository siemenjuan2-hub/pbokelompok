package main;

import entity.Entity;
import object.CEWE;
import object.DROP1;
import object.DROP2;
import object.KananAtas;
import object.KananBawah;
import object.KiriAtas;
import object.Kiribawah;
import object.OBJ_Armor_Better;
import object.OBJ_Armor_Normal;
import object.OBJ_BurnedTree;
import object.OBJ_Bush1;
import object.OBJ_Bush2;
import object.OBJ_Pohon_Hijau_Jumbo;
import object.OBJ_Potion_Health;
import object.OBJ_Sword_Copper;
import object.OBJ_Sword_Normal;

public class EntityGenerator {
    GamePanel gp;

    public EntityGenerator(GamePanel gp){
        this.gp = gp;
    }

    public Entity getObject(String itemNames){
        
        Entity obj = null;

        switch (itemNames) {
            case OBJ_Sword_Normal.objName: obj = new OBJ_Sword_Normal(gp); break;
            case OBJ_Sword_Copper.objName: obj = new OBJ_Sword_Copper(gp); break;
            case OBJ_Armor_Normal.objName: obj = new OBJ_Armor_Normal(gp); break;
            case OBJ_Armor_Better.objName: obj = new OBJ_Armor_Better(gp); break;
            case OBJ_Potion_Health.objName: obj = new OBJ_Potion_Health(gp); break;
            case KananBawah.objName: obj = new KananBawah(gp); break;
            case KananAtas.objName: obj = new KananAtas(gp); break;
            case Kiribawah.objName: obj = new Kiribawah(gp); break;
            case KiriAtas.objName: obj = new KiriAtas(gp); break;
            case OBJ_Pohon_Hijau_Jumbo.objName: obj = new OBJ_Pohon_Hijau_Jumbo(gp); break;
            case OBJ_BurnedTree.objName: obj = new OBJ_BurnedTree(gp); break;
            case OBJ_Bush1.objName: obj = new OBJ_Bush1(gp); break;
            case OBJ_Bush2.objName: obj = new OBJ_Bush2(gp); break;
            case DROP1.objName: obj = new DROP1(gp);break;
            case DROP2.objName: obj = new DROP2(gp);break;
            case CEWE.objName:obj = new CEWE(gp);break;
        }

        return obj;
    }
}
