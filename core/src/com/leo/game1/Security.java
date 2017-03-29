package com.leo.game1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.leo.game1.Actors.gameOverActors.BackTouch;
import com.leo.game1.Actors.gameOverActors.Record;
import com.leo.game1.Actors.menuActors.BackgroundActorMenu;
import com.leo.game1.Actors.menuActors.BottomLightMenuActor;
import com.leo.game1.Actors.menuActors.DustBottomActor;
import com.leo.game1.Actors.menuActors.DustTopActor;
import com.leo.game1.Actors.menuActors.LeftDustActor;
import com.leo.game1.Actors.menuActors.LeftWaveMenuActor;
import com.leo.game1.Actors.menuActors.LockActor;
import com.leo.game1.Actors.menuActors.RightWaveMenuActor;
import com.leo.game1.textures.AssetLoader;
import com.leo.game1.Actors.menuActors.BackgroundActor;
import com.leo.game1.Actors.menuActors.BottomMenuActor;

public class Security extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Security";
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	public BitmapFont font, font1, font2;

	public static int score = 0;
	public static int record = 0;

	public static Music mMusic;
	public AdsController adsController;

	public static Preferences pref;

	public BackgroundActor background;
	public BottomMenuActor animActor;
	public RightWaveMenuActor mRightWaveMenu;
	public LeftWaveMenuActor mLeftWaveMenuActor;
	public AssetManager mManager;
	public BottomLightMenuActor mBottomLightMenuActor;
	public DustBottomActor mDustBottomActor;
	public LeftDustActor mLeftDustActor;
	public com.leo.game1.Actors.menuActors.RightDustActor mRightDustActor;
	public DustTopActor mDustTopActor;
	public BackgroundActorMenu mBackgroundActorMenu;
	public LockActor mLockActor;
	public Record mRecord;
	public com.leo.game1.Actors.gameOverActors.Score mScore;
	public BackTouch mBackTouch;
	public com.leo.game1.Actors.menuActors.MusicOn mMusicOn;
	public com.leo.game1.Actors.menuActors.MusicOn.MusicOff mMusicOff;

	public Security(AdsController adsController){
		if (adsController != null) {
			this.adsController = adsController;
		} else {
			this.adsController = new DummyAdsController();
		}
	}

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
		mRightDustActor = new com.leo.game1.Actors.menuActors.RightDustActor();
		mDustTopActor = new DustTopActor();
		mBackgroundActorMenu = new BackgroundActorMenu();
		mLockActor = new LockActor();
		mRecord = new Record(this);
		mScore = new com.leo.game1.Actors.gameOverActors.Score(this);
		mBackTouch = new BackTouch(this);
		mMusicOn = new com.leo.game1.Actors.menuActors.MusicOn();
		mMusicOff = new com.leo.game1.Actors.menuActors.MusicOn.MusicOff();

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
