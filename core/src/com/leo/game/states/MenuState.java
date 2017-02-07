package com.leo.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class MenuState extends State {

    private Texture mBg;
    private Texture mPlayBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        mBg = new Texture("bg.png");
        mPlayBtn = new Texture("good.png");

    }

    @Override
    protected void handleinput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(mBg, 0, 0, Security.WIDTH, Security.HEIGHT);
        sb.draw(mPlayBtn, (Security.WIDTH / 2) - (mPlayBtn.getWidth() / 2), Security.HEIGHT / 2);
        sb.end();

    }

    @Override
    public void dispose() {

        mBg.dispose();
        mPlayBtn.dispose();

    }
}
