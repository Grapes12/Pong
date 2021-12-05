package com.realm;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    Rectangle rect;
    public Paddle(int s){
        rect = new Rectangle(0,0,s, 10);

    }

    public void update(int x){
        rect.setX(x);
        rect.setY(100);
    }
    public Rectangle getRect() {
        return rect;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(rect.x - rect.width/2,rect.y - rect.height/2,rect.width, rect.height);
    }

}
