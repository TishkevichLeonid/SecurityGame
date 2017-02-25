package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.objects.BadTablet;
import com.leo.game.objects.BottomLight;
import com.leo.game.objects.BottomWave;
import com.leo.game.objects.DustBottom;
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
    private Vector3 touchPos;
    public static Vector2 velosity2;
    public static Vector2 velosity3;
    private Vector3 touch;
    private Vector2 vel;
    private BottomLight mBottomLight;
    private BottomWave mBottomWave;
    private DustBottom mDustBottom;

    private long currrentTime;
    private long lastTime;
    private long lastTimeBad;
    private long lastWave;

    private Array<GameGoodTablet> mGoodTabletArray;
    private Array<BadTablet> mBadTabletArray;
    private Array<BottomWave> mBottomWaveArray;


    public GameScreen(Security gam) {
        this.game = gam;

        velosity2 = new Vector2(0, -20);
        velosity3 = new Vector2(0, -50);
        touchPos = new Vector3();
        touch = new Vector3(0, 0, 0);
        vel = new Vector2(0, 0);
        mDustBottom = new DustBottom(Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -10, AssetLoader.dustBottom.getWidth(), AssetLoader.dustBottom.getHeight());

        mSpriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        currrentTime = TimeUtils.millis();


        mBottomLight = new BottomLight(Security.WIDTH / 2 - AssetLoader.bottomLight.getWidth() / 2, -10, AssetLoader.bottomLight.getWidth()
                , AssetLoader.bottomLight.getHeight());
        mBottomWave = new BottomWave(Security.WIDTH / 2 - 150, -10, 300, 100);

        mGoodTabletArray = new Array<GameGoodTablet>();
        mBadTabletArray = new Array<BadTablet>();
        mBottomWaveArray = new Array<BottomWave>();
        spawnTablets();

    }

    public void bottomWaves(){
        mBottomWave = new BottomWave(Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -20, 300, 100);
        mBottomWaveArray.add(mBottomWave);
        lastWave = TimeUtils.millis();

    }


    public void spawnTablets(){
        goodTablet = new GameGoodTablet(Security.WIDTH / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Security.HEIGHT + AssetLoader.goodTablet.getHeight(), AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());
        mGoodTabletArray.add(goodTablet);
        lastTime = TimeUtils.millis();
    }

    public void spawnBadTablets(){
        badTablet = new BadTablet(Security.WIDTH / 2 - AssetLoader.badTablet.getWidth() / 2,
                Security.HEIGHT + AssetLoader.badTablet.getHeight(), AssetLoader.badTablet.getWidth(),
                AssetLoader.badTablet.getHeight());
        mBadTabletArray.add(badTablet);
        lastTimeBad = TimeUtils.millis();
    }


    public boolean collide(Rectangle tablet){
        return tablet.overlaps(badTablet.getBadRec());

    }

    public boolean collidebad(Rectangle tablet){
        return tablet.overlaps(goodTablet.getGoodRec());

    }

    public boolean collideGoodtoBad(Rectangle tablet){
        return tablet.overlaps(mBadTabletArray.get(0).getBadRec());
    }

    public boolean collideBadtoGood(Rectangle tablet){
        return tablet.overlaps(mGoodTabletArray.get(0).getGoodRec());
    }
    public boolean collideGoodtoGood(Rectangle tablet){
        return tablet.overlaps(mGoodTabletArray.get(0).getGoodRec());
    }
    public boolean colliedBadtoBad(Rectangle tablet){
        return tablet.overlaps(mBadTabletArray.get(0).getBadRec());
    }

    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       // Gdx.app.log("GameScreen FPS", (1/delta) + "");
       // Gdx.app.log("Time: ", (((TimeUtils.millis() - currrentTime) / 1000)) + "");
        Gdx.app.log("Time: ", (mBadTabletArray.size) + "");

        camera.update();

        mSpriteBatch.setProjectionMatrix(camera.combined);

        mSpriteBatch.begin();

        mSpriteBatch.draw(AssetLoader.bg, 0, 0, Security.WIDTH, Security.HEIGHT);

        for (GameGoodTablet goodTablet: mGoodTabletArray){
            mSpriteBatch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());
        }
        for (BadTablet badTablet : mBadTabletArray){
            mSpriteBatch.draw(AssetLoader.badTablet, badTablet.getX(), badTablet.getY(), badTablet.getWidth(), badTablet.getHeight());
        }

        mSpriteBatch.draw(AssetLoader.bottomLight, mBottomLight.getX(), mBottomLight.getY(), mBottomLight.getWidth(), mBottomLight.getHeight());
        mBottomLight.update(delta);
        mSpriteBatch.draw(AssetLoader.dustBottom, mDustBottom.getX(), mDustBottom.getY());
        mDustBottom.update(delta);

        for (BottomWave bottomWave: mBottomWaveArray) {
            mSpriteBatch.draw(AssetLoader.testwave, Security.WIDTH / 2 - bottomWave.getWidth() / 2, bottomWave.getY(), bottomWave.getWidth(), bottomWave.getHeight());
        }
        mSpriteBatch.end();

        if (TimeUtils.millis() - lastWave > 600) bottomWaves();


        if ((TimeUtils.millis() - currrentTime) < 10000) {
           if (System.currentTimeMillis() - lastTime > MathUtils.random(3500, 4000)) {
               spawnTablets();
           }
        }

        if ((TimeUtils.millis() - currrentTime)  < 10000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(1500, 3800)) {
                   spawnBadTablets();
               }
           }

        if ((TimeUtils.millis() - currrentTime) >= 10000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(2500, 2800)) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 10000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(2000, 2400)) {
                   spawnTablets();
               }

           }
        if ((TimeUtils.millis() - currrentTime) >= 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(1500, 2000)) {
                   spawnTablets();
               }
           }

        if ((TimeUtils.millis() - currrentTime) >= 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(1500, 2000)) {
                spawnBadTablets();
            }
        }

        if (goodTablet.getY() > 800 && badTablet.getY() > 800) {

            if (collide(goodTablet.getGoodRec())) {

                goodTablet.setVelocity(badTablet.getVelocity());
                if (goodTablet.getY() > badTablet.getY()) {
                    float a = 0;
                    a = goodTablet.getY() - badTablet.getY();
                    goodTablet.setY(goodTablet.getY() + a);
                }
                if (badTablet.getY() > goodTablet.getY()) {
                    float a = 0;
                    a = badTablet.getY() - goodTablet.getY();
                    badTablet.setY(badTablet.getY() + a);
                }

            }

            if (collidebad(badTablet.getBadRec())) {
                if (badTablet.getY() > goodTablet.getY()) {
                    float a = 0;
                    a = badTablet.getY() - goodTablet.getY();
                    badTablet.setY(badTablet.getY() + a);
                }
                if (goodTablet.getY() > badTablet.getY()) {
                    float a = 0;
                    a = goodTablet.getY() - badTablet.getY();
                    goodTablet.setY(goodTablet.getY() + a);
                }

                badTablet.setVelocity(goodTablet.getVelocity());

            }
        }

        if (mBadTabletArray.size > 0 & mGoodTabletArray.size > 0) {

        if (goodTablet.getY() < 800 && badTablet.getY() < 800) {

            if (collideGoodtoBad(mGoodTabletArray.get(0).getGoodRec())) {
                if (mGoodTabletArray.get(0).getY() > mBadTabletArray.get(0).getY()) {
                    mGoodTabletArray.get(0).setVelocity(mBadTabletArray.get(0).getVelocity());
                }

                if (mGoodTabletArray.get(0).getY() < mBadTabletArray.get(0).getY()) {
                    mBadTabletArray.get(0).setVelocity(mGoodTabletArray.get(0).getVelocity());
                }
            }

            if (collideBadtoGood(badTablet.getBadRec())) {
                if (badTablet.getY() > goodTablet.getY()) {
                    badTablet.setVelocity(goodTablet.getVelocity());
                }

                if (badTablet.getY() < goodTablet.getY()) {
                    goodTablet.setVelocity(badTablet.getVelocity());
                }
            }
        }


            if (mBadTabletArray.size > 2 & mGoodTabletArray.size > 2) {

                if (collideGoodtoGood(mGoodTabletArray.get(1).getGoodRec())) {
                    mGoodTabletArray.get(1).setVelocity(mGoodTabletArray.get(0).getVelocity());

                }
                if (colliedBadtoBad(mBadTabletArray.get(1).getBadRec())) {
                    mBadTabletArray.get(1).setVelocity(mBadTabletArray.get(0).getVelocity());
                }
            }

        }

           Iterator<GameGoodTablet> iter = mGoodTabletArray.iterator();
           Iterator<BadTablet> iter1 = mBadTabletArray.iterator();
           Iterator<BottomWave> iter2 = mBottomWaveArray.iterator();

           while (iter2.hasNext()){
               BottomWave bottomWave = iter2.next();
               bottomWave.update(delta);
               if (bottomWave.getY() > 90){
                   iter2.remove();
               }

           }

           while (iter.hasNext()) {
               GameGoodTablet goodTablet = iter.next();
               goodTablet.update(delta);

               if (goodTablet.getY() < -40) {
                   iter.remove();
               }

               if (goodTablet.getY() < 500) {
                   velosity2 = goodTablet.getVelocity();
               }

           }

        while (iter1.hasNext()){
            BadTablet badTablet = iter1.next();
            badTablet.update(delta);

            if (badTablet.getY() < -100) {
                iter1.remove();
            }

            if (badTablet.getY() < 600) {
                velosity3 = badTablet.getVelocity();
            }

            if (Gdx.input.isTouched()){
                touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(touch);
                vel.x = touch.x;
                vel.y = touch.y;

                if ((vel.x > (mBadTabletArray.get(0).getX() - AssetLoader.badTablet.getWidth() / 2) &&
                        vel.x < (mBadTabletArray.get(0).getX() + AssetLoader.badTablet.getWidth()))
                        && (vel.y < mBadTabletArray.get(0).getY() + AssetLoader.badTablet.getHeight())
                        && (vel.y > mBadTabletArray.get(0).getY() - AssetLoader.badTablet.getHeight() / 2)){
                    mBadTabletArray.get(0).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                    mBadTabletArray.get(0).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                    if (mBadTabletArray.get(0).getX() > 230 || mBadTabletArray.get(0).getX() < 180) {
                        mBadTabletArray.removeIndex(0);
                    }
                }

                if (mBadTabletArray.size >=2) {

                    if ((vel.x > (mBadTabletArray.get(1).getX() - AssetLoader.badTablet.getWidth() / 2) &&
                            vel.x < (mBadTabletArray.get(1).getX() + AssetLoader.badTablet.getWidth()))
                            && (vel.y < mBadTabletArray.get(1).getY() + AssetLoader.badTablet.getHeight())
                            && (vel.y > mBadTabletArray.get(1).getY() - AssetLoader.badTablet.getHeight() / 2)) {
                        mBadTabletArray.get(1).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                        mBadTabletArray.get(1).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                        if (mBadTabletArray.get(1).getX() > 230 || mBadTabletArray.get(1).getX() < 180) {
                            mBadTabletArray.removeIndex(1);
                        }
                    }
                }

                if (mBadTabletArray.size >= 3) {

                    if ((vel.x > (mBadTabletArray.get(2).getX() - AssetLoader.badTablet.getWidth() / 2) &&
                            vel.x < (mBadTabletArray.get(2).getX() + AssetLoader.badTablet.getWidth()))
                            && (vel.y < mBadTabletArray.get(2).getY() + AssetLoader.badTablet.getHeight())
                            && (vel.y > mBadTabletArray.get(2).getY() - AssetLoader.badTablet.getHeight() / 2)) {
                        mBadTabletArray.get(2).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                        mBadTabletArray.get(2).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                        if (mBadTabletArray.get(2).getX() > 230 || mBadTabletArray.get(2).getX() < 180) {
                            mBadTabletArray.removeIndex(2);
                        }
                    }
                }

                if (mBadTabletArray.size >=4) {

                    if ((vel.x > (mBadTabletArray.get(3).getX() - AssetLoader.badTablet.getWidth() / 2) &&
                            vel.x < (mBadTabletArray.get(3).getX() + AssetLoader.badTablet.getWidth()))
                            && (vel.y < mBadTabletArray.get(3).getY() + AssetLoader.badTablet.getHeight())
                            && (vel.y > mBadTabletArray.get(3).getY() - AssetLoader.badTablet.getHeight() / 2)) {
                        mBadTabletArray.get(3).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                        mBadTabletArray.get(3).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                        if (mBadTabletArray.get(3).getX() > 230 || mBadTabletArray.get(3).getX() < 180) {
                            mBadTabletArray.removeIndex(3);
                        }
                    }
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
