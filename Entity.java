package com.shivsama.entity;

import java.awt.*;

public class Entity {
    public Rectangle rect;
    public int x_vel,y_vel;

    public Entity() {
        rect = new Rectangle();
        x_vel = 0;
        y_vel = 0;
    }
}