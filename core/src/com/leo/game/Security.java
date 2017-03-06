package com.leo.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.leo.game.Actors.gameOverActors.BackTouch;
import com.leo.game.Actors.gameOverActors.Record;
import com.leo.game.Actors.gameOverActors.Score;
import com.leo.game.Actors.menuActors.BackgroundActorMenu;
import com.leo.game.Actors.menuActors.BottomLightMenuActor;
import com.leo.game.Actors.menuActors.DustBottomActor;
import com.leo.game.Actors.menuActors.DustTopActor;
import com.leo.game.Actors.menuActors.LeftDustActor;
import com.leo.game.Actors.menuActors.LeftWaveMenuActor;
import com.leo.game.Actors.menuActors.LockActor;
import com.leo.game.Actors.menuActors.RightDustActor;
import com.leo.game.Actors.menuActors.RightWaveMenuActor;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.Actors.menuActors.BackgroundActor;
import com.leo.game.Actors.menuActors.BottomMenuActor;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	public BitmapFont font, font1, font2;

	public static int score;
	public static int record = 10;

	private Music mMusic;

	public static Preferences pref;

	public BackgroundActor background;
	public BottomMenuActor animActor;
	public RightWaveMenuActor mRightWaveMenu;
	public LeftWaveMenuActor mLeftWaveMenuActor;
	public AssetManager mManager;
	public BottomLightMenuActor mBottomLightMenuActor;
	public DustBottomActor mDustBottomActor;
	public LeftDustActor mLeftDustActor;
	public RightDustActor mRightDustActor;
	public DustTopActor mDustTopActor;
	public BackgroundActorMenu mBackgroundActorMenu;
	public LockActor mLockActor;
	public Record mRecord;
	public Score mScore;
	public BackTouch mBackTouch;

	@Override
	public void create () {
		this.setScreen(new LoadScreen(this));
		mManager = new AssetManager();
		AssetLoader.load();
		background = new BackgroundActor();
		background.setPosition(0,0);
		animActor = new BottomMenuActor();
		mRightWaveMenu = new RightWaveMenuActor();
		mLeftWaveMenuActor = new LeftWaveMenuActor();
		mBottomLightMenuActor = new BottomLightMenuActor();
		mDustBottomActor = new DustBottomActor();
		mLeftDustActor = new LeftDustActor();
		mRightDustActor = new RightDustActor();
		mDustTopActor = new DustTopActor();
		mBackgroundActorMenu = new BackgroundActorMenu();
		mLockActor = new LockActor();
		mRecord = new Record(this);
		mScore = new Score(this);
		mBackTouch = new BackTouch(this);

		mMusic = Gdx.audio.newMusic(Gdx.files.internal("music/backmusic.mp3"));

		mMusic.setLooping(true);
		mMusic.play();

		mManager = new AssetManager();

		pref = Gdx.app.getPreferences("Score");
		pref.putInteger("record", record);


		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Orbitron-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Security.HEIGHT / 39;
		param.characters = FONT_CHARACTERS;
		font = generator.generateFont(param);
		font.setColor(0.196f, 0.4588f, 0.643f, 1);

		FreeTypeFontGenerator.FreeTypeFontParameter param1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param1.size = Security.HEIGHT / 19;
		param1.characters = FONT_CHARACTERS;
		font1 = generator.generateFont(param1);
		font1.setColor(0.196f, 0.4588f, 0.643f, 1);

		FreeTypeFontGenerator.FreeTypeFontParameter param2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param2.size = Security.HEIGHT / 10;
		param2.characters = FONT_CHARACTERS;
		font2 = generator.generateFont(param2);
		font2.setColor(0.196f, 0.4588f, 0.643f, 1);
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
