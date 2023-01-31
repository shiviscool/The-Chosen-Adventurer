package com.shivsama.entity;

import com.shivsama.GamePanel;
import com.shivsama.input.InputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    BufferedImage right1,right2,left1,left2,up1,up2,down1,down2,current_texture;
    public String direction;
    int frame,frameCount;
    public boolean running;

    public Player(GamePanel gamePanel) {
        rect.setBounds(1920/2,1080/2,gamePanel.TILESIZE,gamePanel.TILESIZE + 25);

        try {
            right1 = ImageIO.read(new File("res/player_right1.png"));
            right2 = ImageIO.read(new File("res/player_right2.png"));

            down1 = ImageIO.read(new File("res/player_down1.png"));
            down2 = ImageIO.read(new File("res/player_down2.png"));

            left1 = ImageIO.read(new File("res/player_left1.png"));
            left2 = ImageIO.read(new File("res/player_left2.png"));

            up1 = ImageIO.read(new File("res/player_up1.png"));
            up2 = ImageIO.read(new File("res/player_up2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        current_texture = right1;

        x_vel = 5;
        y_vel = 5;

        frame = 1;
        frameCount = 0;

        running = false;

        direction = "right";
    }

    public void update(Graphics2D g2d, InputHandler inputHandler,GamePanel gamePanel) {
        switch (direction) {
            case "right":
                if(frame == 1)
                    current_texture = right1;
                else
                    current_texture = right2;

                break;
            case "left":
                if(frame == 1)
                    current_texture = left1;
                else
                    current_texture = left2;

                break;
            case "up":
                if(frame == 1)
                    current_texture = up1;
                else
                    current_texture = up2;

                break;
            case "down":
                if(frame == 1)
                    current_texture = down1;
                else
                    current_texture = down2;

                break;
        }

        if(inputHandler.rightDown) {
            rect.x += x_vel/10;
            direction = "right";
            gamePanel.camera.offset.x -= x_vel;
            running = true;
        } else if(inputHandler.leftDown) {
            rect.x -= x_vel/10;
            direction = "left";
            gamePanel.camera.offset.x += x_vel;
            running = true;
        } else if(inputHandler.upDown) {
            rect.y -= y_vel/10;
            direction = "up";
            gamePanel.camera.offset.y += y_vel;
            running = true;
        } else if(inputHandler.downDown) {
            rect.y += y_vel/10;
            direction = "down";
            gamePanel.camera.offset.y -= y_vel;
            running = true;
        } else
            running = false;

        frameCount++;

        if(frameCount >= 25 && running) {
            if(frame == 1)
                frame = 2;
            else
                frame = 1;

            frameCount = 0;
        }

        g2d.drawImage(current_texture,rect.x,rect.y,rect.width,rect.height,null);
    }
}