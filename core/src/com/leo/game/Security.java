package com.leo.game;

import com.badlogic.gdx.Game;
import com.leo.game.textures.AssetLoader;
import com.leo.game.actors.BackgroundActor;
import com.leo.game.actors.AnimationMenuActor;
import com.leo.game.screens.MainMenuScreen;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";

	// public SpriteBatch batch;
	public BackgroundActor background;
	public AnimationMenuActor animActor;
	
	@Override
	public void create () {
	//	batch = new SpriteBatch();
		AssetLoader.load();
		background = new BackgroundActor();
		background.setPosition(0,0);
		animActor = new AnimationMenuActor();
		this.setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		super.dispose();
		AssetLoader.dispose();
	}
}
