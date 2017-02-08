package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.leo.game.Security;
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
        camera.setToOrtho(true, Security.WIDTH, Security.HEIGHT);

        mSpriteBatch = new SpriteBatch();
        mSpriteBatch.setProjectionMatrix(camera.combined);

        mShapeRenderer = new ShapeRenderer();
        mShapeRenderer.setProjectionMatrix(camera.combined);

    }

    public void render(){
        Gdx.app.log("GameRander", "render");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

}
