package com.leo.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.objects.GameGoodTablet;
import com.leo.game.objects.GoodTablet;
import com.leo.game.Textures.AssetLoader;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameScreen implements Screen {
    final Security game;

    private SpriteBatch mSpriteBatch;
    private OrthographicCamera camera;
    private GameGoodTablet goodTablet;
    private Vector2 position;
    public static Vector2 velosity2;

    long lastdrtime;

    public Array<GameGoodTablet> mGoodTabletArray;


    public GameScreen(Security gam) {
        this.game = gam;

        velosity2 = new Vector2(0, -50);

        mSpriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        position = new Vector2(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2);

        mGoodTabletArray = new Array<GameGoodTablet>();

    }

    public void spawnTablets(){
        goodTablet = new GameGoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight(), AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());
        mGoodTabletArray.add(goodTablet);
        lastdrtime = TimeUtils.nanoTime();
    }


    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.app.log("GameScreen FPS", (1/delta) + "");

        mSpriteBatch.begin();

        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(AssetLoader.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (GameGoodTablet goodTablet: mGoodTabletArray){
            mSpriteBatch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY());
        }


        mSpriteBatch.end();

        if (TimeUtils.nanoTime() - lastdrtime > 1000000000) {spawnTablets(); }

        Iterator<GameGoodTablet> iter = mGoodTabletArray.iterator();

        while (iter.hasNext()){
            GameGoodTablet goodTablet = iter.next();
            goodTablet.update(delta);


            if (goodTablet.getY() < -75) {
                iter.remove();
            }
            if (goodTablet.getY() < 600) {
                velosity2 =  goodTablet.getVelocity();
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
