package com.realm;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.*;

public class Realm extends Game {
	ShapeRenderer shape;
	//ArrayList<Ball> balls = new ArrayList<>();
	//Random r = new Random();
	Ball ball;
	Paddle paddle;

	@Override
	public void create() {
		System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
		shape = new ShapeRenderer();
		ball = new Ball(500, 200, 10, 7, 7);
		paddle = new Paddle(100);
		/*
		for (int i = 0; i < 10; i++) {
			int radius = r.nextInt(50);
			balls.add(new Ball(r.nextInt(Gdx.graphics.getWidth() - 2 * radius) + radius,
					r.nextInt(Gdx.graphics.getHeight() - 2 * radius) + radius,
					radius, r.nextInt(15), r.nextInt(15)));
		}
		*/
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		/*
		for (Ball ball : balls) {
			ball.update();
			ball.draw(shape);
		}
		 */
		paddle.update(Gdx.input.getX());
		paddle.draw(shape);
		ball.checkCollision(paddle);
		ball.update();
		ball.draw(shape);
		shape.end();

	}
}
