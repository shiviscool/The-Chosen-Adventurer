package com.shivsama.map;

import com.shivsama.GamePanel;
import com.shivsama.entity.Player;
import com.shivsama.gfx.Camera;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapManager {
    String[] map;
    BufferedImage grass,stone,tree;

    public MapManager() {
        map = new String[]{
                "ggggggggggggggggggggtggggggggggggggtggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "gggggggggtgggggggggggggggggggggggtggggggggg",
                "ggggggggggggggggggggggtgggggggggggggggggggg",
                "gggggggggggggggggggggggggggggggggggggtggggg",
                "ggggggggggggtgggggggggggggggggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "gggtgggggggggggggggggggggtggggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "ggggggggggggggggggggggggggtgggggggggggggggg",
                "ggggggggggtgggggggggggggggggggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "ggggggggggggggggggggggggggggggtgggggggggggg",
                "ggggggggggtgggggggggggggggggggggggggggggggg",
                "gggggtgggggggggggggggggggggtggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "ggggggggggggtgggggggggggggggggggggggtgggggg",
                "gggggggggggggggggggggggggggtggggggggggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
                "ggggggtgggggggggggggggggggggggggggggggggggg",
                "ggggggggggggggggtggggggggggggggggggtggggggg",
                "ggggggggggggggggggggggggggggggggggggggggggg",
        };

        try {
            grass = ImageIO.read(new File("res/grass.png"));
            stone = ImageIO.read(new File("res/stone.png"));
            tree = ImageIO.read(new File("res/tree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Graphics2D g2d, GamePanel gamePanel, Player player, Camera camera) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length(); col++) {
                switch (map[row].charAt(col)) {
                    case 'g':
                        g2d.drawImage(grass, col * gamePanel.TILESIZE + gamePanel.camera.getOffsetX(), row * gamePanel.TILESIZE + gamePanel.camera.getOffsetY(), gamePanel.TILESIZE, gamePanel.TILESIZE, null);

                        break;
                    case 's':
                        g2d.drawImage(stone, col * gamePanel.TILESIZE + gamePanel.camera.getOffsetX(), row * gamePanel.TILESIZE + gamePanel.camera.getOffsetY(), gamePanel.TILESIZE, gamePanel.TILESIZE, null);
                        break;
                    case 't':
                        g2d.drawImage(tree,col * gamePanel.TILESIZE + gamePanel.camera.getOffsetX(), row * gamePanel.TILESIZE + gamePanel.camera.getOffsetY(), gamePanel.TILESIZE,gamePanel.TILESIZE,null);

                        Rectangle rect = new Rectangle(col * gamePanel.TILESIZE + gamePanel.camera.getOffsetX(), row * gamePanel.TILESIZE + gamePanel.camera.getOffsetY(),gamePanel.TILESIZE,gamePanel.TILESIZE);

                        if (player.rect.intersects(rect)) {
                            switch (player.direction) {
                                case "right":
                                    player.rect.x -= player.x_vel/10;
                                    camera.offset.x += player.x_vel;

                                    break;
                                case "left":
                                    player.rect.x += player.x_vel/10;
                                    camera.offset.x -= player.x_vel;

                                    break;
                                case "up":
                                    player.rect.y += player.y_vel/10;
                                    camera.offset.y -= player.y_vel;

                                    break;
                                case "down":
                                    player.rect.y -= player.y_vel/10;
                                    camera.offset.y += player.y_vel;

                                    break;
                                }
                            }

                        break;
                }
            }
        }
    }
}