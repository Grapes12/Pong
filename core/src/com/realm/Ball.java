package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
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
        if (circle.y - circle.radius < 0 || circle.y + circle.radius > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        circle.x += xSpeed;
        circle.y += ySpeed;

    }
    public void checkCollision(Paddle paddle){
        if(collidesWith(paddle)){
            color = Color.GREEN;
            ySpeed = -ySpeed;

        }
        else {
            color = Color.WHITE;
        }
    }
    private boolean collidesWith(Paddle paddle) {
        if(CircleRectCollision(circle.x, circle.y, paddle.getRect().x, paddle.getRect().y, circle.radius, paddle.getRect().width, paddle.getRect().height)){
            return true;
        }
        return false;
    }
    public Boolean CircleRectCollision(float x1, float y1, float x2, float y2,
                                       float radius, float width, float height)
    {
        float distanceY = Math.abs(y1 - y2);
        if (distanceY > (height / 2 + radius)) return false;

        float distanceX = Math.abs(x1 - x2);
        if (distanceX > (width / 2 + radius)) return false;

        if (distanceX <= (width / 2)) return true;
        if (distanceY <= (height / 2)) return true;

        float a = distanceX - width / 2;
        float b = distanceY - height / 2;
        float cSqr = a * a + b * b;
        return (cSqr <= (radius * radius));
    }
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(circle.x, circle.y, circle.radius);
        shape.setColor(Color.WHITE);
    }
}