package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class GameOverScreen implements Screen {
    final Security game;

    private Stage stage;
    private OrthographicCamera camera;
    private Vector3 touch;
    private Vector3 touch1;


    public GameOverScreen(Security gam) {
        this.game = gam;

        stage = new Stage(new StretchViewport(Security.WIDTH, Security.HEIGHT));

        touch = new Vector3(0, 0, 0);
        touch1 = new Vector3(0, 0, 0);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);

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

        stage.addActor(game.mRecord);
        stage.addActor(game.mScore);
        stage.addActor(game.mBackTouch);
        stage.addActor(game.mMusicOn);

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

        if (Gdx.input.isTouched()){
            touch1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch1);

            if ((touch.x > 10) && (touch.x < 470) && (touch.y > 100) && (touch.y < 500)) {
                game.score = 0;
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }
        }

        if (Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            if ((touch.x > 15) && (touch.x < 85) && (touch.y > 700) && (touch.y < 760)){
                if (Security.mMusic.getVolume() > 0.99) {
                    Security.mMusic.setVolume(0);
                    stage.addActor(game.mMusicOff);
                    game.mMusicOn.remove();
                }
                else {
                    Security.mMusic.setVolume(1);
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

    }
}
