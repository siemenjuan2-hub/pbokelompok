package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed,enterPressed,ePressed;


    //DEBUG 
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //TITLE STATE 
        if(gp.gameState == gp.titleState) {
            if(code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S) {
                downPressed = true;
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
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
            if(code == KeyEvent.VK_W) {
                upPressed = true;
            }
    
            if(code == KeyEvent.VK_S) {
                downPressed = true;
            }
    
            if(code == KeyEvent.VK_A) {
                leftPressed = true;
            }
    
            if(code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if(code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
    
            if(code == KeyEvent.VK_SHIFT) {
                shiftPressed = true;
            }
            if(code == KeyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;
                }
                else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }
        //pause state
        if(gp.gameState == gp.pauseState) {
            if(code == KeyEvent.VK_P) {
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
            if(code == KeyEvent.VK_ENTER) {
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_E) {
                ePressed = true;
            }
    }
    
}
