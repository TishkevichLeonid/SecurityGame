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
    private java.lang.String sc;

    public Score(Security gam){

        this.game = gam;
        sc = Integer.toString(game.score);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.font2.draw(batch, "" + game.score, Security.WIDTH / 2 - 55, Security.HEIGHT / 2 + 250);
    }

}
