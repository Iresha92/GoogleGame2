package com.example.ucsc.googlegame2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

//import javafx.animation.Animation;

public class MyGdxGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private TextureAtlas shooterAtlas;
	private Animation animation;
	private float timePassed=0;

	@Override
	public void create () {
		batch=new SpriteBatch();

		shooterAtlas = new TextureAtlas(Gdx.files.internal("shooter.atlas"));
		animation=new Animation(1/30f, shooterAtlas.getRegions());
	}

	//get called at d end of transaction, to avoid memory leaks !!!
	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render () {
		//white color
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		timePassed +=Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(timePassed,true),300,500);
		batch.end();
	}
}
