package com.shivsama.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean upDown,leftDown,rightDown,downDown;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            downDown = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftDown = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightDown = true;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            upDown = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            downDown = false;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftDown = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightDown = false;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            upDown = false;
    }
}