package com.leo.game.Actors.gameOverActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class Score extends Actor {

    final Security game;

    public Score(Security gam){

        this.game = gam;

        if (game.score < 0) game.score = 0;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.font2.draw(batch, "" + game.score, Security.WIDTH / 2 - 90, Security.HEIGHT / 2 + 250);
    }

}
