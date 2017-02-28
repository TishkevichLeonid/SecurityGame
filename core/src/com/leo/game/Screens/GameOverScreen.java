package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 28.02.17.
 */

public class GameOverScreen implements Screen {
    final Security game;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture bg;
    private BitmapFont mFont;

    public GameOverScreen(Security gam) {
        this.game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        batch = new SpriteBatch();
        bg = new Texture("bg1.png");
        mFont = new BitmapFont();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        batch.draw(bg, 0, 0, Security.WIDTH, Security.HEIGHT);
        mFont.draw(batch, "Yor score is : " + GameScreen.score, Security.WIDTH / 2, Security.HEIGHT / 2);
        batch.end();

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
