package com.leo.game1.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class MainMenuScreen implements Screen {
    final com.leo.game1.Security game;

    private Stage stage;

    private TextureAtlas buttonAtlas;
    private Skin skin;
    private ImageButton.ImageButtonStyle stylePlayBt;
    private ImageButton playBt;
    private Vector3 touch;
    private OrthographicCamera camera;


    public MainMenuScreen(com.leo.game1.Security gam) {
        this.game = gam;
        stage = new Stage(new StretchViewport(com.leo.game1.Security.WIDTH, com.leo.game1.Security.HEIGHT));
       // stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        touch = new Vector3(0, 0, 0);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, com.leo.game1.Security.WIDTH, com.leo.game1.Security.HEIGHT);

        buttonAtlas = new TextureAtlas(Gdx.files.internal("menuBtn/menuBtn.atlas"));
        skin = new Skin();
        skin.addRegions(buttonAtlas);
        stylePlayBt = new ImageButton.ImageButtonStyle();
        stylePlayBt.up = skin.getDrawable("Start button");
        stylePlayBt.down = skin.getDrawable("Start button");

        playBt = new ImageButton(stylePlayBt);
        playBt.setSize(400, 70);
        playBt.setPosition(com.leo.game1.Security.WIDTH / 2 - 200, 130);


        playBt.addListener(new ClickListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                game.setScreen(new GameScreen(game));
                dispose();

            }
        });

        stage.addActor(game.background);
        stage.addActor(game.animActor);
        stage.addActor(game.mRightWaveMenu);
        stage.addActor(game.mLeftWaveMenuActor);
        stage.addActor(game.mBottomLightMenuActor);
        stage.addActor(game.mDustBottomActor);
        stage.addActor(game.mLeftDustActor);
        stage.addActor(game.mRightDustActor);
        stage.addActor(game.mDustTopActor);
        stage.addActor(game.mBackgroundActorMenu);

        stage.addActor(playBt);
        stage.addActor(game.mLockActor);
        stage.addActor(game.mMusicOn);


        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


      //  Gdx.app.log("MainMenuScreen FPS", (1/delta) + "");


        stage.act(delta);
        stage.draw();
        stage.act();

        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            if ((touch.x > 15) && (touch.x < 85) && (touch.y > 700) && (touch.y < 760)){
                if (com.leo.game1.Security.mMusic.getVolume() > 0.99) {
                    com.leo.game1.Security.mMusic.setVolume(0);
                    stage.addActor(game.mMusicOff);
                    game.mMusicOn.remove();
                }
                else {
                    com.leo.game1.Security.mMusic.setVolume(1);
                    stage.addActor(game.mMusicOn);
                    game.mMusicOff.remove();
                }
            }
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();

    }
}
