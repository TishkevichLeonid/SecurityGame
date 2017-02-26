package com.leo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Actors.CRAssetManager;
import com.leo.game.Screens.MainMenuScreen;

/**
 * Created by leonidtiskevic on 20.02.17.
 */

public class LoadScreen implements Screen {
    final Security game;

    private Texture loadscr;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    long currentTime = TimeUtils.millis();

    public LoadScreen(Security gam) {
        this.game = gam;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);

    }

    private void loadAssets(){

        CRAssetManager.getInstance().load("loadscr.png", Texture.class);
        CRAssetManager.getInstance().load("bad.png", Texture.class);
        CRAssetManager.getInstance().load("badTablet.png", Texture.class);
        CRAssetManager.getInstance().load("bg.png", Texture.class);
        CRAssetManager.getInstance().load("bg1.png", Texture.class);
        CRAssetManager.getInstance().load("good.png", Texture.class);
        CRAssetManager.getInstance().load("goodTablet.png", Texture.class);
        CRAssetManager.getInstance().load("bottomLight.png", Texture.class);
        CRAssetManager.getInstance().load("testvolna.png", Texture.class);
        CRAssetManager.getInstance().load("topShadow.png", Texture.class);

    }

    @Override
    public void show() {
        CRAssetManager.getInstance().load("loadscr.png", Texture.class);
        CRAssetManager.getInstance().finishLoading();
        loadscr = CRAssetManager.getInstance().get("loadscr.png");
        loadAssets();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08235f, 0.0784f, 0.1254f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(loadscr, 0, 0, Security.WIDTH, Security.HEIGHT);
        batch.end();

        if (CRAssetManager.getInstance().update()){
            if(TimeUtils.millis() - currentTime > 4000) {
                game.setScreen(new MainMenuScreen(game));
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

        loadscr.dispose();

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
