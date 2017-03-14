package com.leo.game.Actors.gameOverActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class Record extends Actor {
    final Security game;

    public Record(Security gam){

        this.game = gam;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.font1.draw(batch,  "BEST  " + game.pref.getInteger("record"), Security.WIDTH / 2 - 100, Security.HEIGHT / 2 + 140);
    }
}
