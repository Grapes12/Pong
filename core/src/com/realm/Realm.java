package com.realm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Realm extends ApplicationAdapter {
	ShapeRenderer shape;
	int x = 50;
	int y = 50;
	int xSpeed = 5;

	@Override
	public void create () {
		shape = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		x+=5;
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(x, y, 50);
		shape.end();
	}
}
