package com.leo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leo.game.objects.BackgroundActor;
import com.leo.game.states.MainMenu;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";

	public SpriteBatch batch;
	public BackgroundActor background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new BackgroundActor();
		background.setPosition(0,0);
		this.setScreen(new MainMenu(this));

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
	}
}
