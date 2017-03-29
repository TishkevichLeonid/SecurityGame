package com.leo.game1.Actors.gameOverActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class Record extends Actor {
    final com.leo.game1.Security game;

    public Record(com.leo.game1.Security gam){

        this.game = gam;
        

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.font1.draw(batch,  "BEST  " + game.pref.getInteger("record"), com.leo.game1.Security.WIDTH / 2 - 100, com.leo.game1.Security.HEIGHT / 2 + 140);
    }


}
