package com.leo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leo.game.GameRander.AssetLoader;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class MainMenu implements Screen {
    final Security game;

    private float runTime = 0;

    private Stage stage;

    private GoodTablet goodTablet;

    private TextureAtlas buttonAtlas;
    private Skin skin;
    private ImageButton.ImageButtonStyle stylePlayBt;
    private ImageButton playBt;
    private Texture mPlayBtn;
    private OrthographicCamera mCamera;
    private SpriteBatch mBatch;



    public MainMenu(Security gam) {
        this.game = gam;
        mPlayBtn = new Texture("good.png");
        stage = new Stage(new ScreenViewport());
        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);
        mBatch = new SpriteBatch();

        goodTablet = new GoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2, AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());


        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.atlas"));
        skin = new Skin();
        skin.addRegions(buttonAtlas);
        stylePlayBt = new ImageButton.ImageButtonStyle();
        stylePlayBt.up = skin.getDrawable("bad");
        stylePlayBt.down = skin.getDrawable("good");

        playBt = new ImageButton(stylePlayBt);
        playBt.setSize(mPlayBtn.getWidth(), mPlayBtn.getHeight());
        playBt.setPosition(Security.WIDTH / 2 - mPlayBtn.getWidth() / 2, Security.HEIGHT / 2);


        playBt.addListener(new ClickListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){

                return true;

            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button){

                game.setScreen(new GameScreen(game));
                dispose();

            }

        });


        stage.addActor(game.background);
        stage.addActor(playBt);
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.app.log("GameScreen FPS", (1/delta) + "");
      //  goodTablet.update(delta);
        /*
        mBatch.begin();
        mBatch.disableBlending();
        mBatch.draw(AssetLoader.bg, 0, 0, Security.WIDTH, Security.HEIGHT);
        mBatch.disableBlending();
        playBt.draw(mBatch, delta);
        mBatch.disableBlending();
        mBatch.draw(AssetLoader.goodTablet,150, 150, goodTablet.getWidth(), goodTablet.getHeight());
        mBatch.end(); */

        stage.act(delta);
        stage.draw();
        stage.act();

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
        stage.dispose();

    }
}
