package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed,enterPressed,ePressed,atkPressed, spacePressed;
    public boolean inventory = false;

    //DEBUG
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // TITLE STATE
        if(gp.gameState == gp.titleState) {
            if(key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if(key == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if(key == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                    gp.resetGame(true);
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1) {
                    // LOAD GAME
                    gp.saveLoad.load();
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 2) {
                    System.exit(0);
                }
            }
        }
        
        // PLAY STATE
        else if(gp.gameState == gp.playState) {
            if(key == KeyEvent.VK_W) { upPressed = true; }
            if(key == KeyEvent.VK_S) { downPressed = true; }
            if(key == KeyEvent.VK_A) { leftPressed = true; }
            if(key == KeyEvent.VK_D) { rightPressed = true; }
            if(key == KeyEvent.VK_ENTER) { enterPressed = true; }
            if(key == KeyEvent.VK_SPACE) { spacePressed = true; }
            if(key == KeyEvent.VK_SHIFT) { shiftPressed = true; }
            if(key == KeyEvent.VK_E) { ePressed = true; }
            if(key == KeyEvent.VK_Q) { atkPressed = true; }
            
            if(key == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(key == KeyEvent.VK_T) {
                checkDrawTime = !checkDrawTime;
            }
            if(key == KeyEvent.VK_M) {
                gp.gameState = gp.characterState;
                inventory = true;
            }
            if(key == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.optionState;
            }
            if(key == KeyEvent.VK_R){
                switch (gp.currentMap) {
                    case 0:
                        gp.tileM.loadMap("/assets/Maps/Maps1.txt", 0);
                        break;
                    case 1:
                        gp.tileM.loadMap("/assets/Maps/Maps2.txt", 1);
                }
            }
        }
        
        // PAUSE STATE
        else if(gp.gameState == gp.pauseState) {
            if(key == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }
        
        // DIALOG STATE
        else if(gp.gameState == gp.dialogState) {
            if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
        
        // CHARACTER STATE
        else if(gp.gameState == gp.characterState) {
            if(key == KeyEvent.VK_M) {
                gp.gameState = gp.playState;
            }

            if(key == KeyEvent.VK_ENTER) {
                gp.player.selectItem();
            }
            playerInventory(key);
        }
        
        // OPTION STATE
        else if(gp.gameState == gp.optionState) {
            if(key == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
            if(key == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            int maxCommandNum = 0;
            switch (gp.ui.subState) {
                case 0: maxCommandNum = 5; break;
                case 3: maxCommandNum = 1; break;
            }
            
            if(key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = maxCommandNum;
                }
            }
            if(key == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > maxCommandNum) {
                    gp.ui.commandNum = 0;
                }
            }

            if (gp.ui.subState == 0) {
                // Tombol A (Kiri)
                if (key == KeyEvent.VK_A) {
                    if (gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
                        gp.music.volumeScale--;
                        gp.music.checkVolume();
                    }
                    if (gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
                        gp.se.volumeScale--;
                    }
                    // Tombol (A) akan memilih "Save"
                    if (gp.ui.commandNum == 4 && !gp.ui.saveGameOn) {
                        gp.ui.saveGameOn = true;
                    }else if(gp.ui.commandNum == 4 && gp.ui.saveGameOn){
                        gp.ui.saveGameOn = false;
                    }
                }

                // Tombol D (Kanan)
                if (key == KeyEvent.VK_D) {
                    if (gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
                        gp.music.volumeScale++;
                        gp.music.checkVolume();
                    }
                    if (gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
                        gp.se.volumeScale++;
                    }
                    // Tombol (D) akan memilih "Dont Save"6
                    if (gp.ui.commandNum == 4 && !gp.ui.saveGameOn) {
                        gp.ui.saveGameOn = true;
                    }else if(gp.ui.commandNum == 4 && gp.ui.saveGameOn){
                        gp.ui.saveGameOn = false;
                    }
                }
            }
        }

        //GAME OVER STATE
        else if (gp.gameState == gp.gameOverState) {
            if (key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
            }
            if (key == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0;
                }
            }

            if(key == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.resetGame(false);
                    gp.playMusic(0);
                }else if(gp.ui.commandNum == 1){
                    gp.gameState = gp.titleState;
                    gp.resetGame(true);
                }
            }
        }

        // TRADE STATE
        else if(gp.gameState == gp.tradeState)
        {
            if(key == KeyEvent.VK_ENTER){
                enterPressed = true;
            }

            if(gp.ui.subState == 0){
                if(key == KeyEvent.VK_W){
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 3;
                    }
                }
                if(key == KeyEvent.VK_S){
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 3){
                        gp.ui.commandNum = 0;
                    }
                }                
            }
            if(gp.ui.subState == 1){
                npcInventory(key);
                if(key == KeyEvent.VK_ESCAPE){
                    gp.ui.subState = 0;
                }
            }
            if(gp.ui.subState == 2){
                playerInventory(key);
                if(key == KeyEvent.VK_ESCAPE){
                    gp.ui.subState = 0;
                }
            }   
            if(gp.ui.subState == 3){
                playerInventory(key);
                if(key == KeyEvent.VK_ESCAPE){
                    gp.ui.subState = 0;
                }
            }                       
        }

        // DUNGEON OPTION
        else if(gp.gameState == gp.dungeonOption){
            int maxCommandNum = 1;
            if(key == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
            if(key == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
            if(key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = maxCommandNum;
                }
            }
            if(key == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > maxCommandNum) {
                    gp.ui.commandNum = 0;
                }
            }
            if(key == KeyEvent.VK_A){
                if (gp.ui.commandNum == 0 && !gp.ui.InfiniteMode) {
                    gp.ui.InfiniteMode = true;
                }else if(gp.ui.commandNum == 0 && gp.ui.InfiniteMode){
                    gp.ui.InfiniteMode = false;
                }
            }
            if(key == KeyEvent.VK_D){
                if (gp.ui.commandNum == 0 && !gp.ui.InfiniteMode) {
                    gp.ui.InfiniteMode = true;
                }else if(gp.ui.commandNum == 0 && gp.ui.InfiniteMode){
                    gp.ui.InfiniteMode = false;
                }
            }
            
        }


    }

    public void playerInventory(int key)
    {
            if(key == KeyEvent.VK_W) {
                if(gp.ui.playerSlotRow > 0) { gp.ui.playerSlotRow--; }
                gp.playSE(2);
                
            }
            if(key == KeyEvent.VK_S) {
                if(gp.ui.playerSlotRow < 3) { gp.ui.playerSlotRow++; }
                gp.playSE(2);
            }
            if(key == KeyEvent.VK_A) {
                if(gp.ui.playerSlotCol > 0) { gp.ui.playerSlotCol--; }
                gp.playSE(2);
            }
            if(key == KeyEvent.VK_D) {
                if(gp.ui.playerSlotCol < 4) { gp.ui.playerSlotCol++; }
                gp.playSE(2);
            }
    }

    public void npcInventory(int key)
    {
            if(key == KeyEvent.VK_W) {
                if(gp.ui.npcSlotRow > 0) { gp.ui.npcSlotRow--; }
                gp.playSE(2);
            }
            if(key == KeyEvent.VK_S) {
                if(gp.ui.npcSlotRow < 3) { gp.ui.npcSlotRow++; }
                gp.playSE(2);

            }
            if(key == KeyEvent.VK_A) {
                if(gp.ui.npcSlotCol > 0) { gp.ui.npcSlotCol--; }
                gp.playSE(2);

            }
            if(key == KeyEvent.VK_D) {
                if(gp.ui.npcSlotCol < 4) { gp.ui.npcSlotCol++; }
                gp.playSE(2);
            }
    }    

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            upPressed = false;
        }

        if(key == KeyEvent.VK_S) {
            downPressed = false;
        }

        if(key == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if(key == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if(key == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }
        if(key == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
        if(key == KeyEvent.VK_E) {
            ePressed = false;
        }
        if(key == KeyEvent.VK_Q){
            atkPressed = false;
        }
        if(key == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}