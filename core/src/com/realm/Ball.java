package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        x += xSpeed;
        y += ySpeed;

    }
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }
}