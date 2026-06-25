package main;

import entity.Entity;

public class CollisonChecker {

    GamePanel gp;

    public CollisonChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX =
                entity.WorldX + entity.solidArea.x;

        int entityRightWorldX =
                entity.WorldX +
                entity.solidArea.x +
                entity.solidArea.width;

        int entityTopWorldY =
                entity.WorldY +
                entity.solidArea.y;

        int entityBottomWorldY =
                entity.WorldY +
                entity.solidArea.y +
                entity.solidArea.height;


        int entityLeftCol =
                entityLeftWorldX / gp.tileSize;

        int entityRightCol =
                entityRightWorldX / gp.tileSize;

        int entityTopRow =
                entityTopWorldY / gp.tileSize;

        int entityBottomRow =
                entityBottomWorldY / gp.tileSize;


        switch(entity.direction){

            case "up":
                entityTopRow =
                        (entityTopWorldY - entity.getSpeed())
                        / gp.tileSize;
                break;

            case "down":
                entityBottomRow =
                        (entityBottomWorldY + entity.getSpeed())
                        / gp.tileSize;
                break;

            case "left":
                entityLeftCol =
                        (entityLeftWorldX - entity.getSpeed())
                        / gp.tileSize;
                break;

            case "right":
                entityRightCol =
                        (entityRightWorldX + entity.getSpeed())
                        / gp.tileSize;
                break;
        }


        // CEGAH KELUAR MAP
        if(
            entityLeftCol < 0 ||
            entityRightCol >= gp.maxWorldCol ||
            entityTopRow < 0 ||
            entityBottomRow >= gp.maxWorldRow
        ){
            entity.collisionON = true;
            return;
        }


        int tileNum1 =
            gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];

        int tileNum2 =
            gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];


        if(
            gp.tileM.tile[tileNum1].collision ||
            gp.tileM.tile[tileNum2].collision
        ){
            entity.collisionON = true;
        }
    }
    // check collision object
    public int checkObject(Entity entity, boolean player)
    {
        int index = 999;
        for(int i=0; i<gp.obj[1].length; i++)
        {
            if(gp.obj[gp.currentMap][i] != null)
            {
                // cari posisi solid areanya entity
                entity.solidArea.x = entity.WorldX + entity.solidArea.x;
                entity.solidArea.y = entity.WorldY + entity.solidArea.y;

                // cari solid area objek
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].WorldX + gp.obj[gp.currentMap][i].solidArea.x;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].WorldY + gp.obj[gp.currentMap][i].solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.getSpeed();
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionON = true;
                            }
                            // supaya npc/bukan player tidak bisa interaksi dgn objek
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.getSpeed();
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionON = true;
                            }
                            // supaya npc/bukan player tidak bisa interaksi dgn objek
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.getSpeed();
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionON = true;
                            }
                            // supaya npc/bukan player tidak bisa interaksi dgn objek
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.getSpeed();
                        if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                        {
                            if(gp.obj[gp.currentMap][i].collision == true)
                            {
                                entity.collisionON = true;
                            }
                            // supaya npc/bukan player tidak bisa interaksi dgn objek
                            if(player == true)
                            {
                                index = i;
                            }
                        }
                        break;
                }
                if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea))
                {
                    if(gp.obj[gp.currentMap][i].collision == true)
                    {
                        entity.collisionON = true;
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        return index;
    }

    // NPC OR MONSTER
    public int checkEntity(Entity entity, Entity[][] target){
        int index = 999;
        for(int i = 0 ; i < target[1].length ; i++)
        {
            if(target[gp.currentMap][i] != null && target[gp.currentMap][i] != entity)
            {
                // cari posisi solid areanya entity
                entity.solidArea.x = entity.WorldX + entity.solidArea.x;
                entity.solidArea.y = entity.WorldY + entity.solidArea.y;

                // cari solid area objek
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].WorldX + target[gp.currentMap][i].solidArea.x;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].WorldY + target[gp.currentMap][i].solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.getSpeed();
                        if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea))
                        {
                            entity.collisionON = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.getSpeed();
                        if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea))
                        {
                            entity.collisionON = true;
                                index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.getSpeed();
                        if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea))
                        {
                            entity.collisionON = true;
                            index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.getSpeed();
                        if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea))
                        {
                            entity.collisionON = true;
                            index = i;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        return index;
    }

    public boolean checkPlayer(Entity entity){

        boolean contactPlayer = false;

        // cari posisi solid areanya entity
        entity.solidArea.x = entity.WorldX + entity.solidArea.x;
        entity.solidArea.y = entity.WorldY + entity.solidArea.y;

        // cari solid area objek
        gp.player.solidArea.x = gp.player.WorldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.WorldY + gp.player.solidArea.y;

        switch(entity.direction)
        {
            case "up":
                entity.solidArea.y -= entity.getSpeed();
                if(entity.solidArea.intersects(gp.player.solidArea))
                {
                    entity.collisionON = true;
                    contactPlayer = true;
                }
                break;
            case "down":
                entity.solidArea.y += entity.getSpeed();
                if(entity.solidArea.intersects(gp.player.solidArea))
                {
                    entity.collisionON = true;
                    contactPlayer = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.getSpeed();
                if(entity.solidArea.intersects(gp.player.solidArea))
                {
                    entity.collisionON = true;
                    contactPlayer = true;
                }
                break;
            case "right":
                entity.solidArea.x += entity.getSpeed();
                if(entity.solidArea.intersects(gp.player.solidArea))
                {
                    entity.collisionON = true;
                    contactPlayer = true;
                }
                break;
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        
        // cari posisi solid areanya entity
                entity.solidArea.x = entity.WorldX + entity.solidArea.x;
                entity.solidArea.y = entity.WorldY + entity.solidArea.y;

                // cari solid area objek
                gp.player.solidArea.x = gp.player.WorldX + gp.player.solidArea.x;
                gp.player.solidArea.y = gp.player.WorldY + gp.player.solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                        entity.solidArea.y -= entity.getSpeed();
                        if(entity.solidArea.intersects(gp.player.solidArea))
                        {
                            entity.collisionON = true;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.getSpeed();
                        if(entity.solidArea.intersects(gp.player.solidArea))
                        {
                            entity.collisionON = true;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.getSpeed();
                        if(entity.solidArea.intersects(gp.player.solidArea))
                        {
                            entity.collisionON = true;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.getSpeed();
                        if(entity.solidArea.intersects(gp.player.solidArea))
                        {
                            entity.collisionON = true;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.player.solidArea.x = gp.player.solidAreaDefaultX;
                gp.player.solidArea.y = gp.player.solidAreaDefaultY;

        return contactPlayer;
    }
}

