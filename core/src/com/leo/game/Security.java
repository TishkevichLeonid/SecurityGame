package com.leo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.Actors.BackgroundActor;
import com.leo.game.Actors.AnimationMenuActor;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	public BitmapFont font;

	public static int score;
	public static int record = 10;

	public static Preferences pref;

	public BackgroundActor background;
	public AnimationMenuActor animActor;
	public AssetManager mManager;

	@Override
	public void create () {
		this.setScreen(new LoadScreen(this));
		mManager = new AssetManager();
		AssetLoader.load();
		background = new BackgroundActor();
		background.setPosition(0,0);
		animActor = new AnimationMenuActor();
		mManager = new AssetManager();

		pref = Gdx.app.getPreferences("Score");
		pref.putInteger("record", record);


		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Orbitron-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Security.HEIGHT / 39;
		param.characters = FONT_CHARACTERS;
		font = generator.generateFont(param);
		font.setColor(0.196f, 0.4588f, 0.643f, 1);
		generator.dispose();

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
