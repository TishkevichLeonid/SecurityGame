package com.leo.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class MainMenuScreen implements Screen {
    final Security game;

    private Stage stage;

    private TextureAtlas buttonAtlas;
    private Skin skin;
    private ImageButton.ImageButtonStyle stylePlayBt;
    private ImageButton playBt;
    private Texture mPlayBtn;
    private OrthographicCamera mCamera;


    public MainMenuScreen(Security gam) {
        this.game = gam;
        mPlayBtn = new Texture("good.png");
       // stage = new Stage(new ScreenViewport());
        stage = new Stage(new StretchViewport(Security.WIDTH, Security.HEIGHT));
        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false, Security.WIDTH, Security.HEIGHT);

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
        stage.addActor(game.animActor);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        Gdx.app.log("MainMenuScreen FPS", (1/delta) + "");


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
