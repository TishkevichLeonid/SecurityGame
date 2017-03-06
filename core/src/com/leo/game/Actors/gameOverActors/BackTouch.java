package com.leo.game.Actors.gameOverActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class BackTouch extends Actor {
    final Security game;


    public BackTouch(Security gam) {
        this.game = gam;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.font.draw(batch,  "TAP TO RESTART", Security.WIDTH / 2 - 105, Security.HEIGHT / 2 - 200);

    }
}
