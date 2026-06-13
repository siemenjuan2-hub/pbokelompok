package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPrassed,enterPressed;


    //DEBUG 
    boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(gp.gameState == gp.playState) {
        //play state    
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
    
            if(key == KeyEvent.VK_SHIFT) {
                shiftPrassed = true;
            }
            if(key == KeyEvent.VK_T) {
                if (checkDrawTime == false) {
                    checkDrawTime = true;
                }
                else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }
            }

        }
        //pause state
        if(gp.gameState == gp.pauseState) {
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
            if(key == KeyEvent.VK_ENTER) {
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
            shiftPrassed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
}
