package com.realm;

import com.badlogic.gdx.Game;
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
	ArrayList<Block> blocks = new ArrayList<>();

	@Override
	public void create() {
		shape = new ShapeRenderer();
		ball = new Ball(500, 400, 10, 7, 7);
		paddle = new Paddle(100);
		/*
		for (int i = 0; i < 10; i++) {
			int radius = r.nextInt(50);
			balls.add(new Ball(r.nextInt(Gdx.graphics.getWidth() - 2 * radius) + radius,
					r.nextInt(Gdx.graphics.getHeight() - 2 * radius) + radius,
					radius, r.nextInt(15), r.nextInt(15)));
		}
		*/
		int blockWidth = 62;
		int blockHeight = 20;
		for (int y = 0; y < Gdx.graphics.getHeight()/2; y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
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
		for (Block b : blocks) {
			b.draw(shape);
			ball.checkCollision(b);
		}
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.destroyed) {
				blocks.remove(b);
				// we need to decrement i when a ball gets removed, otherwise we skip a ball!
				i--;
			}
		}
		paddle.update(Gdx.input.getX());
		paddle.draw(shape);
		ball.checkCollision(paddle);
		ball.update();
		ball.draw(shape);
		shape.end();

	}
}
