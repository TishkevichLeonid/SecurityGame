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

    public GameOverScreen(Security gam) {
        this.game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        batch = new SpriteBatch();
        bg = new Texture("bg1.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(bg, 0, 0, Security.WIDTH, Security.HEIGHT);
        game.font.draw(batch, "Your record is : " + game.pref.getInteger("record"), Security.WIDTH / 2 - 80, Security.HEIGHT / 2 + 50);
        game.font.draw(batch, "Your score is : " + game.score, Security.WIDTH / 2 - 100, Security.HEIGHT / 2 + 50);
        game.font.draw(batch, "Tap to restart", Security.WIDTH / 2 - 85, Security.HEIGHT / 2);
        batch.end();

        if (game.score > game.pref.getInteger("record")){
            game.pref.putInteger("record", game.score);
        }

        if (Gdx.input.isTouched()){
            game.score = 0;
            game.setScreen(new GameScreen(game));
            dispose();
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
