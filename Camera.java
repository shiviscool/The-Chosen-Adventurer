package com.shivsama.gfx;

import com.shivsama.math.Vector2;

public class Camera {
    public Vector2 offset;

    public Camera() {
        offset = new Vector2(0,0);
    }

    public int getOffsetX() {
        return offset.x;
    }

    public int getOffsetY() {
        return offset.y;
    }

    public void setOffsetX(int x) {
        offset.x = x;
    }

    public void setOffsetY(int y) {
        offset.y = y;
    }
}