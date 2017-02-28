package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
import com.leo.game.objects.DustTop;
import com.leo.game.objects.GameGoodTablet;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.LeftShadow;
import com.leo.game.objects.OrangeWave;
import com.leo.game.objects.OrangeWaveRight;
import com.leo.game.objects.RightShadow;

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
    private OrangeWave mOrangeWave;
    private OrangeWaveRight mOrangeWaveRight;
    private DustBottom mDustBottom;
    private DustTop mDustTop;
    private LeftShadow mLeftShadow;
    private RightShadow mRightShadow;

    private long currrentTime;
    private long lastTime;
    private long lastTimeBad;
    private long lastWave;
    private long lastWaveOrange;
    private long lastWaveOrangeRight;

    public static int score;
    private int score1;
    private BitmapFont font;

    private Array<GameGoodTablet> mGoodTabletArray;
    private Array<BadTablet> mBadTabletArray;
    private Array<BottomWave> mBottomWaveArray;
    private Array<OrangeWave> mOrangeWaveArray;
    private Array<OrangeWaveRight> mOrangeWaveRightArray;


    public GameScreen(Security gam) {
        this.game = gam;

        velosity2 = new Vector2(0, -20);
        velosity3 = new Vector2(0, -50);
        touchPos = new Vector3();
        touch = new Vector3(0, 0, 0);
        vel = new Vector2(0, 0);
        mDustBottom = new DustBottom(Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -10, AssetLoader.dustBottom.getWidth(), AssetLoader.dustBottom.getHeight());
        mDustTop = new DustTop(Security.WIDTH / 2 - AssetLoader.topShadow.getWidth() / 2, 300, AssetLoader.topShadow.getWidth(), AssetLoader.topShadow.getHeight());
        mLeftShadow = new LeftShadow(-26, Security.HEIGHT / 2 - AssetLoader.leftShadow.getHeight() / 2 + 40, AssetLoader.leftShadow.getWidth(), AssetLoader.leftShadow.getHeight());
        mRightShadow = new RightShadow(-34, Security.HEIGHT / 2 - AssetLoader.rightShadow.getHeight() / 2 +40, AssetLoader.rightShadow.getWidth(), AssetLoader.rightShadow.getHeight());

        mSpriteBatch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        currrentTime = TimeUtils.millis();


        mBottomLight = new BottomLight(Security.WIDTH / 2 - AssetLoader.bottomLight.getWidth() / 2, -10, AssetLoader.bottomLight.getWidth()
                , AssetLoader.bottomLight.getHeight());
        mBottomWave = new BottomWave(Security.WIDTH / 2 - 150, -10, -25, 100);

        mGoodTabletArray = new Array<GameGoodTablet>();
        mBadTabletArray = new Array<BadTablet>();
        mBottomWaveArray = new Array<BottomWave>();
        mOrangeWaveArray = new Array<OrangeWave>();
        mOrangeWaveRightArray = new Array<OrangeWaveRight>();
        spawnTablets();

    }

    public void bottomWaves(){
        mBottomWave = new BottomWave(Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -20, 300, 100);
        mBottomWaveArray.add(mBottomWave);
        lastWave = TimeUtils.millis();

    }

    public void orangeWavesRight(){
        mOrangeWaveRight = new OrangeWaveRight(480, Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2, AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mOrangeWaveRightArray.add(mOrangeWaveRight);
        lastWaveOrangeRight = TimeUtils.millis();
    }

    public void orangeWaves(){
        mOrangeWave = new OrangeWave(-90, Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2, AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mOrangeWaveArray.add(mOrangeWave);
        lastWaveOrange = TimeUtils.millis();
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
      //  Gdx.app.log("GameScreen FPS", (1/delta) + "");
       // Gdx.app.log("Time: ", (((TimeUtils.millis() - currrentTime) / 1000)) + "");
       // Gdx.app.log("Time: ", (mBadTabletArray.size) + "");

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
        mSpriteBatch.draw(AssetLoader.topShadow, mDustTop.getX(), mDustTop.getY(), mDustTop.getWidth(), mDustTop.getHeight());
        mSpriteBatch.draw(AssetLoader.leftShadow, mLeftShadow.getX(), mLeftShadow.getY(), mLeftShadow.getWidth(), mLeftShadow.getHeight());
        mLeftShadow.update(delta);
        mSpriteBatch.draw(AssetLoader.rightShadow, mRightShadow.getX(), mRightShadow.getY(), mRightShadow.getWidth(), mRightShadow.getHeight());
        mRightShadow.update(delta);
        font.draw(mSpriteBatch, "Your score is : " + score1, 0, 780);

        for (BottomWave bottomWave: mBottomWaveArray) {
            mSpriteBatch.draw(AssetLoader.testwave, Security.WIDTH / 2 - bottomWave.getWidth() / 2, bottomWave.getY(), bottomWave.getWidth(), bottomWave.getHeight());
        }

        for (OrangeWave orangeWave: mOrangeWaveArray){
            mSpriteBatch.draw(AssetLoader.orangeWave, orangeWave.getX(), Security.HEIGHT / 2 - orangeWave.getHeight() / 2 - orangeWave.getWidth() / 2 + 60, orangeWave.getHeight(), orangeWave.getWidth());
        }

        for (OrangeWaveRight orangeWaveRight: mOrangeWaveRightArray){
            mSpriteBatch.draw(AssetLoader.orangeWave, orangeWaveRight.getX(), Security.HEIGHT / 2 - orangeWaveRight.getHeight() / 2 - orangeWaveRight.getWidth() / 2 + 60, orangeWaveRight.getHeight(), orangeWaveRight.getWidth());
        }

        mSpriteBatch.end();

        if (TimeUtils.millis() - lastWave > 600) bottomWaves();
        if (TimeUtils.millis() - lastWaveOrange > 750) orangeWaves();
        if (TimeUtils.millis() - lastWaveOrangeRight > 650) orangeWavesRight();


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

           Iterator<GameGoodTablet> iter = mGoodTabletArray.iterator();
           Iterator<BadTablet> iter1 = mBadTabletArray.iterator();
           Iterator<BottomWave> iter2 = mBottomWaveArray.iterator();
           Iterator<OrangeWave> iter3 = mOrangeWaveArray.iterator();
           Iterator<OrangeWaveRight> iter4 = mOrangeWaveRightArray.iterator();

           while (iter2.hasNext()){
               BottomWave bottomWave = iter2.next();
               bottomWave.update(delta);
               if (bottomWave.getY() > 90){
                   iter2.remove();
               }

           }

           while (iter4.hasNext()){
               OrangeWaveRight orangeWaveRight = iter4.next();
               orangeWaveRight.update(delta);
               if (orangeWaveRight.getX() < 350) iter4.remove();
           }

           while (iter3.hasNext()){
               OrangeWave orangeWave = iter3.next();
               orangeWave.update(delta);
               if (orangeWave.getX() > 60){
                   iter3.remove();
               }

           }

           while (iter.hasNext()) {
               GameGoodTablet goodTablet = iter.next();
               goodTablet.update(delta);

               if (goodTablet.getY() < -40) {
                   iter.remove();
               }

               if (goodTablet.getY() < 300) {
                   velosity2 = goodTablet.getVelocity();
               }

           }

        while (iter1.hasNext()){
            BadTablet badTablet = iter1.next();
            badTablet.update(delta);

            if (badTablet.getY() < -100) {
                iter1.remove();
                score += 5;
                score1 += 5;
            }

            if (badTablet.getY() < 400) {
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
                    if (mBadTabletArray.get(0).getX() > 250 || mBadTabletArray.get(0).getX() < 160) {
                        mBadTabletArray.removeIndex(0);
                        score += 5;
                        score1 += 5;
                    }
                }

                if (mBadTabletArray.size >=2) {

                    if ((vel.x > (mBadTabletArray.get(1).getX() - AssetLoader.badTablet.getWidth() / 2) &&
                            vel.x < (mBadTabletArray.get(1).getX() + AssetLoader.badTablet.getWidth()))
                            && (vel.y < mBadTabletArray.get(1).getY() + AssetLoader.badTablet.getHeight())
                            && (vel.y > mBadTabletArray.get(1).getY() - AssetLoader.badTablet.getHeight() / 2)) {
                        mBadTabletArray.get(1).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                        mBadTabletArray.get(1).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                        if (mBadTabletArray.get(1).getX() > 250 || mBadTabletArray.get(1).getX() < 160) {
                            mBadTabletArray.removeIndex(1);
                            score += 5;
                            score1 += 5;
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
