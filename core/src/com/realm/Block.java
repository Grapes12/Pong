package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Block {
    private Rectangle rect;
    public boolean destroyed;
    public Block(int x, int y, int width, int height) {
        rect = new Rectangle(x,y,width,height);
        destroyed = false;
    }
    public Rectangle getRect() {
        return rect;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(rect.x, Gdx.graphics.getHeight() - rect.y, rect.width, rect.height);
    }
}