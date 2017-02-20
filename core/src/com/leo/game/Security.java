package com.leo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.Actors.BackgroundActor;
import com.leo.game.Actors.AnimationMenuActor;
import com.leo.game.Screens.MainMenuScreen;
import com.leo.game.Actors.ActorMenu;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";

	// public SpriteBatch batch;
	public BackgroundActor background;
	public AnimationMenuActor animActor;
	public ActorMenu mGoodTabletActor;
	public AssetManager mManager;
	
	@Override
	public void create () {
	//	batch = new SpriteBatch();
		this.setScreen(new LoadScreen(this));
		mManager = new AssetManager();
		AssetLoader.load();
		background = new BackgroundActor();
		background.setPosition(0,0);
		animActor = new AnimationMenuActor();
		mGoodTabletActor = new ActorMenu();
		mManager = new AssetManager();

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
