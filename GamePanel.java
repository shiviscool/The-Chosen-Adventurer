package com.shivsama;

import com.shivsama.entity.Player;
import com.shivsama.gfx.Camera;
import com.shivsama.input.InputHandler;
import com.shivsama.map.MapManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int TILESIZE = 48;
    final int SCREEN_WIDTH = 1920;
    final int SCREEN_HEIGHT = 1080;
    InputHandler inputHandler;
    MapManager mapManager;
    public Camera camera;
    Thread thread;
    Player player;

    public GamePanel() {
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player = new Player(this);

        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        setFocusable(true);

        mapManager = new MapManager();

        camera = new Camera();

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60f;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime,timer = 0;
        int drawCount = 0;

        while (thread != null) {
            currentTime = System.nanoTime();

            timer += (currentTime - lastTime);
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.printf("FPS -> %d\n", drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        mapManager.update(g2d,this,player,camera);
        player.update(g2d,inputHandler,this);

        g2d.dispose();
    }
}