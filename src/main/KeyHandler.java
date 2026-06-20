package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed,enterPressed,ePressed,atkPressed, spacePressed;


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
            if(key == KeyEvent.VK_SPACE) {
                gp.gameState = gp.playState;
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
