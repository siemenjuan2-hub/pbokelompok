package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Health extends Entity{

    public OBJ_Potion_Health(GamePanel gp) {
        super(gp);
        entitySize = 128;
        // int value = 25; HARUSNYA PAKE YG INI TAPI TIDAK BISA DIPAKAI DI METHOD use() entah kenapaaaa
        value = 25;

        name = "Health Potion";
        down1 = setUp("/assets/LootDrop/item567", 32, 32);
        attackValue = 14;
        description ="["+name+"]\nregenerate some of your health (25)";
        pickupable = true;
        type = type_consumable;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = entitySize;
        solidArea.height = entitySize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        // bisa tambah attack area kalo mau
    }

    public void use(Entity entity)
    {
        gp.gameState = gp.dialogState;
        gp.ui.currentDialogue = "You drink the " + name + "!"
        + "\nYour health has been recovered by " + value + ".";

        if(gp.player.getHp() > gp.player.getMaxHp())
        {
            gp.player.setHp(gp.player.getMaxHp());
        }
        else
        {
            gp.player.setHp(gp.player.getHp() + value);
        }
    }
    

    @Override
    public void setAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAction'");
    }
    
}
