package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;
import com.leo.game.states.GameScreen;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class GameRender {

    private GameWorld myWorld;
    private OrthographicCamera camera;
    private ShapeRenderer mShapeRenderer;

    private SpriteBatch mSpriteBatch;

    public GameRender(GameWorld world){

        myWorld = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);

        mSpriteBatch = new SpriteBatch();
        mSpriteBatch.setProjectionMatrix(camera.combined);

        mShapeRenderer = new ShapeRenderer();
        mShapeRenderer.setProjectionMatrix(camera.combined);

    }

    public void render(float runTime){

        GoodTablet goodTablet = myWorld.getGoodTablet();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Отрисуем Background цвет
        mShapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        mShapeRenderer.rect(0, 0, 136, 66);

        mShapeRenderer.end();

        mSpriteBatch.begin();

        mSpriteBatch.disableBlending();
        mSpriteBatch.draw(AssetLoader.bg, 0, 0, Security.WIDTH, Security.HEIGHT);

        mSpriteBatch.disableBlending();

        mSpriteBatch.draw(AssetLoader.spriteGoodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());

        mSpriteBatch.end();



    }

}
