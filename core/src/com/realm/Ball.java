package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;
import java.awt.geom.Area;
import java.math.*;
public class Ball {

    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;
    Circle circle;
    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        circle = new Circle(x, y, size);
    }
    public void update() {
        if (circle.x - circle.radius < 0 || circle.x + circle.radius > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        else if (circle.y - circle.radius < 0 || circle.y + circle.radius > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        circle.x += xSpeed;
        circle.y += ySpeed;

    }
    public void checkCollision(Paddle paddle){
        if(CircleRectCollision(circle, paddle.getRect())){
            color = Color.GREEN;
            if(circle.y < paddle.getRect().y + paddle.getRect().height && circle.y > paddle.getRect().y - paddle.getRect().height) {
                xSpeed = -xSpeed;
            }
            else{
                ySpeed = -ySpeed;
            }
        }
        else {
            color = Color.WHITE;
        }
    }
    public void checkCollision(Block block) {
        if(CircleRectCollision(circle, block.getRect())){
            ySpeed = - ySpeed;
            block.destroyed = true;
        }
    }
    private boolean CircleRectCollision(Circle circle, Rectangle rect)
    {
        double x = Math.abs(circle.x - (rect.x + rect.width/2));
        double y = Math.abs(circle.y - rect.y);

        if (x > (rect.width/2 + circle.radius)) { return false; }
        if (y > (rect.height/2 + circle.radius)) { return false; }

        if (x <= (rect.width/2)) { return true; }
        if (y <= (rect.height/2)) { return true; }

        double cornerDistance_sq = Math.pow((x - rect.width/2), 2.0) +
                Math.pow((y - rect.height/2), 2.0);

        return cornerDistance_sq <= (Math.pow(circle.radius,2));
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(circle.x, Gdx.graphics.getHeight() - circle.y, circle.radius);
        shape.setColor(Color.WHITE);
    }
}