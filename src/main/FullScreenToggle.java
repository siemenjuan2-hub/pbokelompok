package main;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;

public class FullScreenToggle extends JFrame {

    public boolean fullscreen = false;
    private final GraphicsDevice device;

    public FullScreenToggle() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // harus true
        setTitle("is it wrong to save some girl in a dungeon?");

        device = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();

        addWindowStateListener((WindowEvent e) -> {

            if ((e.getNewState() & JFrame.MAXIMIZED_BOTH)
                    == JFrame.MAXIMIZED_BOTH) {

                if (!fullscreen) {
                    fullscreen = true;
                    dispose();
                    setUndecorated(true);
                    device.setFullScreenWindow(this);
                    setVisible(true);
                }

            } else {

                if (fullscreen) {
                    fullscreen = false;

                    device.setFullScreenWindow(null);

                    dispose();
                    setUndecorated(false);
                    setVisible(true);
                }
            }
        });
    }


    public void toggleFullscreen() {

        fullscreen = !fullscreen;

        if(fullscreen){

            dispose();
            setUndecorated(true);
            device.setFullScreenWindow(this);
            setVisible(true);

        } else {

            device.setFullScreenWindow(null);

            dispose();
            setUndecorated(false);
            setVisible(true);
        }
    }
}