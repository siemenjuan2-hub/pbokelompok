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

        //TITLE STATE 
        if(gp.gameState == gp.titleState) {
            if(key == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if(key == KeyEvent.VK_S) {
                downPressed = true;
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if(key == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                    // NEW GAME
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1) {
                    // LOAD GAME
                }
                if(gp.ui.commandNum == 2) {
                    // QUIT
                    System.exit(0);
                }
            }       
        }
        //play state  
        else if(gp.gameState == gp.playState) {
            if(key == KeyEvent.VK_W) {
                upPressed = true;
            }
    
            if(key == KeyEvent.VK_S) {
                downPressed = true;
            }
    
            if(key == KeyEvent.VK_A) {
                leftPressed = true;
            }
    
            if(key == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if(key == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(key == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
            if(key == KeyEvent.VK_SPACE){
                spacePressed = true;
            }
    
            if(key == KeyEvent.VK_SHIFT) {
                shiftPressed = true;
            }

            if(key == KeyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;
                }
                else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }

            if(key == KeyEvent.VK_E) {
                ePressed = true;
            }

            if(key == KeyEvent.VK_Q){
                atkPressed = true;
            }

            // Tampilkan Status Player
            if(key == KeyEvent.VK_M){
                gp.gameState = gp.characterState;
                inventory=true;
            }
           
        }
        //pause state
        else if(gp.gameState == gp.pauseState) {
            if(key == KeyEvent.VK_P) {
                if(gp.gameState == gp.playState) {
                    gp.gameState = gp.pauseState;
                }
                else if(gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                }
            }
        }
        //dialog state
        else if(gp.gameState == gp.dialogState) {
            if(key == KeyEvent.VK_SPACE||key == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
        //character state
        else if(gp.gameState == gp.characterState){
            if(key == KeyEvent.VK_M){
                gp.gameState = gp.playState;
            }
            if(key == KeyEvent.VK_W){
                if(gp.ui.slotRow > 0){
                    gp.ui.slotRow--;
                }
            }

            if(key == KeyEvent.VK_S){
                if(gp.ui.slotRow < 3){ // contoh 4 row
                    gp.ui.slotRow++;
                }
            }

            if(key == KeyEvent.VK_A){
                if(gp.ui.slotCol > 0){
                    gp.ui.slotCol--;
                }
            }

            if(key == KeyEvent.VK_D){
                if(gp.ui.slotCol < 4){ // 5 column
                    gp.ui.slotCol++;
                }
            }

            if(key == KeyEvent.VK_ENTER){
                gp.player.selectItem();
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
