package com.leo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameScreen implements Screen {
    final Security game;

    private Texture bg;
    private OrthographicCamera camera;
    private Stage stage;


    public GameScreen(Security gam) {
        this.game = gam;

        stage = new Stage(new ScreenViewport());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);

        bg = new Texture("bg.png");

        stage.addActor(game.background);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();


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
        bg.dispose();

    }
}
