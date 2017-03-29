package com.leo.game1.Screens;

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
import com.leo.game1.objects.BadTablet;
import com.leo.game1.objects.Animation.BottomLight;
import com.leo.game1.objects.Animation.BottomWave;
import com.leo.game1.objects.Animation.DustBottom;
import com.leo.game1.objects.GameGoodTablet;
import com.leo.game1.textures.AssetLoader;
import com.leo.game1.objects.Animation.LeftShadow;
import com.leo.game1.objects.Animation.OrangeWave;
import com.leo.game1.objects.Animation.RightShadow;


import java.util.Iterator;


/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GameScreen implements Screen {
    final com.leo.game1.Security game;

    public static int showAd;

    private SpriteBatch mSpriteBatch;
    private OrthographicCamera camera;
    private GameGoodTablet goodTablet;
    private BadTablet badTablet;
    public static Vector2 velosity2;
    public static Vector2 velosity3;
    private Vector2 acceleration;
    private Vector3 touch;
    private Vector2 vel;
    private BottomLight mBottomLight;
    private BottomWave mBottomWave;
    private OrangeWave mOrangeWave;
    private com.leo.game1.objects.Animation.OrangeWaveRight mOrangeWaveRight;
    private DustBottom mDustBottom;
    private com.leo.game1.objects.Animation.DustTop mDustTop;
    private LeftShadow mLeftShadow;
    private RightShadow mRightShadow;


    private long currrentTime;
    private long timeGameOver;
    private long lastTime;
    private long lastTimeBad;
    private long lastWave;
    private long lastWaveOrange;
    private long lastWaveOrangeRight;

    public static int score1;
    private int lives;
   // private AdsController adsController;

    private com.leo.game1.objects.Lives mLives;

    private Array<GameGoodTablet> mGoodTabletArray;
    private Array<BadTablet> mBadTabletArray;
    private Array<BottomWave> mBottomWaveArray;
    private Array<OrangeWave> mOrangeWaveArray;
    private Array<com.leo.game1.objects.Animation.OrangeWaveRight> mOrangeWaveRightArray;


    public GameScreen(com.leo.game1.Security gam) {
        this.game = gam;

        velosity2 = new Vector2(0, -20);
        velosity3 = new Vector2(0, -50);
        acceleration = new Vector2(0, MathUtils.random(-17, -10));
        touch = new Vector3(0, 0, 0);
        vel = new Vector2(0, 0);
        lives = 4;
        mLives = new com.leo.game1.objects.Lives();
        mDustBottom = new DustBottom(com.leo.game1.Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -10, AssetLoader.dustBottom.getWidth(), AssetLoader.dustBottom.getHeight());
        mDustTop = new com.leo.game1.objects.Animation.DustTop(com.leo.game1.Security.WIDTH / 2 - AssetLoader.topShadow.getWidth() / 2, 300, AssetLoader.topShadow.getWidth(), AssetLoader.topShadow.getHeight());
        mLeftShadow = new LeftShadow(-26, com.leo.game1.Security.HEIGHT / 2 - AssetLoader.leftShadow.getHeight() / 2 + 40, AssetLoader.leftShadow.getWidth(), AssetLoader.leftShadow.getHeight());
        mRightShadow = new RightShadow(-34, com.leo.game1.Security.HEIGHT / 2 - AssetLoader.rightShadow.getHeight() / 2 +40, AssetLoader.rightShadow.getWidth(), AssetLoader.rightShadow.getHeight());

        mSpriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, com.leo.game1.Security.WIDTH, com.leo.game1.Security.HEIGHT);
        currrentTime = TimeUtils.millis();


        mBottomLight = new BottomLight(com.leo.game1.Security.WIDTH / 2 - AssetLoader.bottomLight.getWidth() / 2, -10, AssetLoader.bottomLight.getWidth()
                , AssetLoader.bottomLight.getHeight());
        mBottomWave = new BottomWave(com.leo.game1.Security.WIDTH / 2 - 150, -10, -25, 100);

        mGoodTabletArray = new Array<GameGoodTablet>();
        mBadTabletArray = new Array<BadTablet>();
        mBottomWaveArray = new Array<BottomWave>();
        mOrangeWaveArray = new Array<OrangeWave>();
        mOrangeWaveRightArray = new Array<com.leo.game1.objects.Animation.OrangeWaveRight>();
        spawnTablets();


    }

    public void bottomWaves(){
        mBottomWave = new BottomWave(com.leo.game1.Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -20, 300, 100);
        mBottomWaveArray.add(mBottomWave);
        lastWave = TimeUtils.millis();

    }

    public void orangeWavesRight(){
        mOrangeWaveRight = new com.leo.game1.objects.Animation.OrangeWaveRight(480, com.leo.game1.Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2, AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mOrangeWaveRightArray.add(mOrangeWaveRight);
        lastWaveOrangeRight = TimeUtils.millis();
    }

    public void orangeWaves(){
        mOrangeWave = new OrangeWave(-90, com.leo.game1.Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2, AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mOrangeWaveArray.add(mOrangeWave);
        lastWaveOrange = TimeUtils.millis();
    }

    public void spawnTablets(){
        goodTablet = new GameGoodTablet(com.leo.game1.Security.WIDTH / 2 - AssetLoader.goodTablet.getWidth() / 2,
                com.leo.game1.Security.HEIGHT + AssetLoader.goodTablet.getHeight(), AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());
        mGoodTabletArray.add(goodTablet);
        lastTime = TimeUtils.millis();
    }

    public void spawnBadTablets(){
        badTablet = new BadTablet(com.leo.game1.Security.WIDTH / 2 - AssetLoader.badTablet.getWidth() / 2,
                com.leo.game1.Security.HEIGHT + AssetLoader.badTablet.getHeight(), AssetLoader.badTablet.getWidth(),
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
      //  Gdx.app.log("GameScreen FPS", (1/delta) + "");
        Gdx.app.log("Time: ", (((TimeUtils.millis() - timeGameOver) / 1000)) + "");
       // Gdx.app.log("Time: ", (mBadTabletArray.size) + "");

        camera.update();

        mSpriteBatch.setProjectionMatrix(camera.combined);

        mSpriteBatch.begin();

        mSpriteBatch.draw(AssetLoader.bg, 0, 0, com.leo.game1.Security.WIDTH, com.leo.game1.Security.HEIGHT);

        for (GameGoodTablet goodTablet: mGoodTabletArray){
            mSpriteBatch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());
        }
        for (BadTablet badTablet : mBadTabletArray){
            mSpriteBatch.draw(AssetLoader.badTablet, badTablet.getX(), badTablet.getY(), badTablet.getWidth(), badTablet.getHeight());
        }
        for (Rectangle heart: mLives.getLives()){
            mSpriteBatch.draw(AssetLoader.heart, heart.x, heart.y, heart.getWidth(), heart.getHeight());
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
        game.font.draw(mSpriteBatch, " Score :" + score1, 15, 790);

        for (BottomWave bottomWave: mBottomWaveArray) {
            mSpriteBatch.draw(AssetLoader.testwave, com.leo.game1.Security.WIDTH / 2 - bottomWave.getWidth() / 2, bottomWave.getY(), bottomWave.getWidth(), bottomWave.getHeight());
        }

        for (OrangeWave orangeWave: mOrangeWaveArray){
            mSpriteBatch.draw(AssetLoader.orangeWave, orangeWave.getX(), com.leo.game1.Security.HEIGHT / 2 - orangeWave.getHeight() / 2 - orangeWave.getWidth() / 2 + 60, orangeWave.getHeight(), orangeWave.getWidth());
        }

        for (com.leo.game1.objects.Animation.OrangeWaveRight orangeWaveRight: mOrangeWaveRightArray){
            mSpriteBatch.draw(AssetLoader.orangeWave, orangeWaveRight.getX(), com.leo.game1.Security.HEIGHT / 2 - orangeWaveRight.getHeight() / 2 - orangeWaveRight.getWidth() / 2 + 60, orangeWaveRight.getHeight(), orangeWaveRight.getWidth());
        }

        mSpriteBatch.end();

        if (TimeUtils.millis() - lastWave > 600) bottomWaves();
        if (TimeUtils.millis() - lastWaveOrange > 750) orangeWaves();
        if (TimeUtils.millis() - lastWaveOrangeRight > 650) orangeWavesRight();


        if ((TimeUtils.millis() - currrentTime) < 10000) {
           if (System.currentTimeMillis() - lastTime > MathUtils.random(25, 40) * 100) {
               spawnTablets();
           }
        }

        if ((TimeUtils.millis() - currrentTime)  < 10000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(15, 38) * 100) {
                   spawnBadTablets();
               }
           }

        if ((TimeUtils.millis() - currrentTime) >= 10000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(15, 21) * 100) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 10000 && (TimeUtils.millis() - currrentTime) < 20000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(17, 23) * 100) {
                   spawnTablets();
               }

           }
        if ((TimeUtils.millis() - currrentTime) >= 20000 && (TimeUtils.millis() - currrentTime) < 30000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(10, 20) * 100) {
                   spawnTablets();
               }
           }

        if ((TimeUtils.millis() - currrentTime) >= 20000 && (TimeUtils.millis() - currrentTime) < 30000) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(10, 15) * 100) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 30000 && (TimeUtils.millis() - currrentTime) < 45000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(6, 13) * 100) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 30000 && (TimeUtils.millis() - currrentTime) < 45000) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(8, 17) * 100) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 45000 && (TimeUtils.millis() - currrentTime) < 65000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(5, 7) * 100) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 45000 && (TimeUtils.millis() - currrentTime) < 65000) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(7, 14) * 100) {
                spawnBadTablets();
            }
        }
        if ((TimeUtils.millis() - currrentTime) >= 65000 && (TimeUtils.millis() - currrentTime < 70000)) {
            velosity2.y = -300;
            if (TimeUtils.millis() - lastTime > MathUtils.random(14, 17) * 100) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 65000 && (TimeUtils.millis() - currrentTime < 70000)) {
            velosity3.y = -300;
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(13, 16) * 100) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 70000 && (TimeUtils.millis() - currrentTime < 77000)) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(25, 35) * 10) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 70000 && (TimeUtils.millis() - currrentTime < 77000)) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(50, 78) * 10) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 77000 && (TimeUtils.millis() - currrentTime < 85000)) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(6, 15) * 100) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 77000 && (TimeUtils.millis() - currrentTime < 85000)) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(7, 12) * 100) {
                spawnBadTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 85000) {
            if (TimeUtils.millis() - lastTime > MathUtils.random(27, 100) * 10) {
                spawnTablets();
            }
        }

        if ((TimeUtils.millis() - currrentTime) >= 85000) {
            if (TimeUtils.millis() - lastTimeBad > MathUtils.random(37, 60) * 10) {
                spawnBadTablets();
            }
        }



           Iterator<GameGoodTablet> iter = mGoodTabletArray.iterator();
           Iterator<BadTablet> iter1 = mBadTabletArray.iterator();
           Iterator<BottomWave> iter2 = mBottomWaveArray.iterator();
           Iterator<OrangeWave> iter3 = mOrangeWaveArray.iterator();
           Iterator<com.leo.game1.objects.Animation.OrangeWaveRight> iter4 = mOrangeWaveRightArray.iterator();
           Iterator<Rectangle> iter5 = mLives.getLives().iterator();

           while (iter2.hasNext()){
               BottomWave bottomWave = iter2.next();
               bottomWave.update(delta);
               if (bottomWave.getY() > 90){
                   iter2.remove();
               }

           }

           while (iter4.hasNext()){
               com.leo.game1.objects.Animation.OrangeWaveRight orangeWaveRight = iter4.next();
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
                   if (lives > 0) {
                       score1++;
                       game.score++;
                   }
               }

               if (goodTablet.getY() < 300) {
                   velosity2 = goodTablet.getVelocity();
               }
           }


        while (iter1.hasNext()){
            BadTablet badTablet = iter1.next();
            badTablet.update(delta);

            while (iter5.hasNext()) {
                Rectangle heart = iter5.next();
            }
                if (badTablet.getY() < -100) {
                    iter1.remove();
                    if (lives > 0) {
                        iter5.remove();
                        game.score -= 10;
                        score1 -= 10;
                    }
                    lives--;
                }

            if (lives == 0) timeGameOver = TimeUtils.millis();

            if (lives <= 0){
                mSpriteBatch.begin();
                game.font1.draw(mSpriteBatch, "GAME OVER", com.leo.game1.Security.WIDTH / 2 - 150, com.leo.game1.Security.HEIGHT / 2 + 220);
                mSpriteBatch.end();
                showAd = 1;
                if ((TimeUtils.millis() - timeGameOver) > 1500) {
                    score1 = 0;
                    if (game.score < 0) game.score = 0;
                    if (game.adsController.isInternet()) {
                        game.adsController.showInterstitialAd(new Runnable() {
                            @Override
                            public void run() {
                                game.setScreen(new GameOverScreen(game));
                            }
                        });
                    }
                    else game.setScreen(new GameOverScreen(game));
                    dispose();
                }
            }

            if (badTablet.getY() < 800) {
               // velosity3 = badTablet.getVelocity();
                velosity3.add(acceleration.cpy().scl(delta));
            }

            if (Gdx.input.isTouched()){
                touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                camera.unproject(touch);
                vel.x = touch.x;
                vel.y = touch.y;

                if (vel.y > 240 && vel.y < 560) {

                    if ((vel.x > (mBadTabletArray.get(0).getX() - AssetLoader.badTablet.getWidth() / 2 - 15) &&
                            vel.x < (mBadTabletArray.get(0).getX() + AssetLoader.badTablet.getWidth() + 15))
                            && (vel.y < mBadTabletArray.get(0).getY() + AssetLoader.badTablet.getHeight() + 50)
                            && (vel.y > mBadTabletArray.get(0).getY() - AssetLoader.badTablet.getHeight() / 2 + 30)) {
                        mBadTabletArray.get(0).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                        mBadTabletArray.get(0).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                        if (mBadTabletArray.get(0).getX() > 250 || mBadTabletArray.get(0).getX() < 160) {
                            mBadTabletArray.removeIndex(0);
                            if (lives > 0) {
                                game.score += 5;
                                score1 += 5;
                            }
                        }
                    }

                    if (mBadTabletArray.size >= 2) {

                        if ((vel.x > (mBadTabletArray.get(1).getX() - AssetLoader.badTablet.getWidth() / 2 - 15) &&
                                vel.x < (mBadTabletArray.get(1).getX() + AssetLoader.badTablet.getWidth() + 15))
                                && (vel.y < mBadTabletArray.get(1).getY() + AssetLoader.badTablet.getHeight() + 50)
                                && (vel.y > mBadTabletArray.get(1).getY() - AssetLoader.badTablet.getHeight() / 2 + 30)) {
                            mBadTabletArray.get(1).setX(vel.x - AssetLoader.badTablet.getWidth() / 2);
                            mBadTabletArray.get(1).setY(vel.y - AssetLoader.badTablet.getHeight() / 2);
                            if (mBadTabletArray.get(1).getX() > 250 || mBadTabletArray.get(1).getX() < 160) {
                                mBadTabletArray.removeIndex(1);
                                if (lives > 0) {
                                    game.score += 5;
                                    score1 += 5;
                                }
                            }
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
