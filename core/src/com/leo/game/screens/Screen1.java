package com.leo.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.textures.AssetLoader;

import java.awt.Rectangle;
import java.util.Iterator;

/**
 * Created by leonidtiskevic on 12.02.17.
 */

public class Screen1 implements Screen {
    final Security game;
    Array<Rectangle> goodTablets;
    private SpriteBatch mSpriteBatch;
    long lastDropTime;

    public Screen1(Security gam) {
        this.game = gam;
        mSpriteBatch = new SpriteBatch();
        goodTablets = new Array<Rectangle>();
        spawnGoodTablets();

    }

    private void spawnGoodTablets() { // метод создания капли. Создает новый Rectangle, устанавливает в слуйчаной позиции в верхней часте экрана и добавляет его в массив raindrops
        Rectangle goodTablet = new Rectangle();
        goodTablet.x = Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2;
        goodTablet.y = Gdx.graphics.getHeight();
        goodTablet.width = AssetLoader.goodTablet.getWidth();
        goodTablet.height = AssetLoader.goodTablet.getHeight();
        goodTablets.add(goodTablet);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mSpriteBatch.begin();

        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(AssetLoader.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (Rectangle goodtablet: goodTablets){
            mSpriteBatch.draw(AssetLoader.goodTablet, goodtablet.x, goodtablet.y, goodtablet.width, goodtablet.height);

        }

        mSpriteBatch.end();

        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnGoodTablets();

        Iterator<Rectangle> iter = goodTablets.iterator();

        while (iter.hasNext()) {
            Rectangle godTabl = iter.next();
            godTabl.y -= 150 * Gdx.graphics.getDeltaTime();
            if (godTabl.y < 0) iter.remove();
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
