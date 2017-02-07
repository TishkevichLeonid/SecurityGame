package com.leo.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class PlayState extends State {

    private Texture mBad;
    private Texture mBg;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        mBg = new Texture("bg.png");
        mBad = new Texture("bad.png");

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
        sb.draw(mBad, Security.WIDTH / 2, Security.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
