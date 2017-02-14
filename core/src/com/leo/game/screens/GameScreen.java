package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.objects.BadTablet;
import com.leo.game.objects.GameGoodTablet;
import com.leo.game.Textures.AssetLoader;

import java.util.Iterator;


/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameScreen implements Screen {
    final Security game;

    private SpriteBatch mSpriteBatch;
    private OrthographicCamera camera;
    private GameGoodTablet goodTablet;
    private BadTablet badTablet;
    private Vector2 position;
    public static Vector2 velosity2;
    public static Vector2 velosity3;

    long currrentTime;
    long lastTime;
    long lastTimeBad;

    public Array<GameGoodTablet> mGoodTabletArray;
    private Array<BadTablet> mBadTabletArray;


    public GameScreen(Security gam) {
        this.game = gam;

        velosity2 = new Vector2(0, -20);
        velosity3 = new Vector2(0, -50);

        mSpriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        position = new Vector2(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2);
        currrentTime = TimeUtils.millis();

        mGoodTabletArray = new Array<GameGoodTablet>();
        mBadTabletArray = new Array<BadTablet>();
        spawnTablets();

    }

    public void spawnTablets(){
        goodTablet = new GameGoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight(), AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());
        mGoodTabletArray.add(goodTablet);
        lastTime = TimeUtils.millis();
    }

    public void spawnBadTablets(){
        badTablet = new BadTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.badTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.badTablet.getHeight(), AssetLoader.badTablet.getWidth(),
                AssetLoader.badTablet.getHeight());
        mBadTabletArray.add(badTablet);
        lastTimeBad = TimeUtils.millis();
    }


    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       // Gdx.app.log("GameScreen FPS", (1/delta) + "");
        Gdx.app.log("Time: ", ((TimeUtils.millis() - lastTime)) + "");

        mSpriteBatch.begin();

        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(AssetLoader.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        for (GameGoodTablet goodTablet: mGoodTabletArray){
            mSpriteBatch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY());
        }
        for (BadTablet badTablet: mBadTabletArray){
            mSpriteBatch.draw(AssetLoader.badTablet, badTablet.getX(), badTablet.getY());
        }

        mSpriteBatch.end();

        if ((TimeUtils.millis() - currrentTime) < 10000) {
           if (System.currentTimeMillis() - lastTime > MathUtils.random(4000, 5000)) {
               spawnTablets();
           }
        }

        if ((TimeUtils.millis() - currrentTime) > 5000 && (TimeUtils.millis() - currrentTime) < 10000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(4000, 5000)) {
                   spawnBadTablets();
               }
           }

        if ((TimeUtils.millis() - currrentTime) >= 15000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(2000, 2400)) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 15000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(2000, 2400)) {
                   spawnTablets();
               }

           }
        if ((TimeUtils.millis() - currrentTime) >= 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(400, 800)) {
                   spawnTablets();
               }

           }


           Iterator<GameGoodTablet> iter = mGoodTabletArray.iterator();
           Iterator<BadTablet> iter1 = mBadTabletArray.iterator();

           while (iter.hasNext()) {
               GameGoodTablet goodTablet = iter.next();
               goodTablet.update(delta);

               if (goodTablet.getY() < -75) {
                   iter.remove();
               }

               if (goodTablet.getY() < 500) {
                   velosity2 = goodTablet.getVelocity();
               }

           }

        while (iter1.hasNext()){
            BadTablet badTablet = iter1.next();
            badTablet.update(delta);

            if (badTablet.getY() < -75) {
                iter1.remove();
            }
            if (badTablet.getY() < 600) {
                velosity3 = badTablet.getVelocity();
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
