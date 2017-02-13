package com.leo.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leo.game.Security;
import com.leo.game.actors.GoodTabletActor;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 12.02.17.
 */

public class GameScreenWithActors implements Screen {
    final Security game;
    private Stage stage;
    Array<GoodTabletActor> mGoodTabletActorArray;
    long lastdroptime;


    public GameScreenWithActors(Security gam) {
        this.game = gam;
        stage = new Stage(new ScreenViewport());
        mGoodTabletActorArray = new Array<GoodTabletActor>();


        stage.addActor(game.background);
        stage.addActor(game.mGoodTabletActor);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.app.log("MainMenuScreen FPS", (1/delta) + "");


        stage.act(delta);
        stage.draw();
        stage.act();


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
