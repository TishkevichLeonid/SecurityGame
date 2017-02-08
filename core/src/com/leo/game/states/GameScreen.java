package com.leo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leo.game.GameRander.GameRender;
import com.leo.game.GameRander.GameWorld;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameScreen implements Screen {
    final Security game;

    private OrthographicCamera camera;
    private Stage stage;

    private GameWorld world;
    private GameRender render;

    private float runTime = 0;


    public GameScreen(Security gam) {
        this.game = gam;

        world = new GameWorld();
        render = new GameRender(world);

        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);


        stage.addActor(game.background);

    }


    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        render.render(runTime); // ????


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
