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
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1) {
                    // LOAD GAME
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
            if(key == KeyEvent.VK_W) {
                if(gp.ui.slotRow > 0) { gp.ui.slotRow--; }
            }
            if(key == KeyEvent.VK_S) {
                if(gp.ui.slotRow < 3) { gp.ui.slotRow++; }
            }
            if(key == KeyEvent.VK_A) {
                if(gp.ui.slotCol > 0) { gp.ui.slotCol--; }
            }
            if(key == KeyEvent.VK_D) {
                if(gp.ui.slotCol < 4) { gp.ui.slotCol++; }
            }
            if(key == KeyEvent.VK_ENTER) {
                gp.player.selectItem();
            }
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
                // Tombol A (Kecilkan Volume)
                if (key == KeyEvent.VK_A) {
                    // PERBAIKAN: Menggunakan gp.music
                    if (gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
                        gp.music.volumeScale--;
                        gp.music.checkVolume();
                        gp.playSE(9);
                    }
                    // PERBAIKAN: Menggunakan gp.se
                    if (gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
                        gp.se.volumeScale--;
                        gp.playSE(9);
                    }
                }

                // Tombol D (Besarkan Volume)
                if (key == KeyEvent.VK_D) {
                    // PERBAIKAN: Menggunakan gp.music
                    if (gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
                        gp.music.volumeScale++;
                        gp.music.checkVolume();
                        gp.playSE(9);
                    }
                    // PERBAIKAN: Menggunakan gp.se
                    if (gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
                        gp.se.volumeScale++;
                        gp.playSE(9);
                    }
                }
            }
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