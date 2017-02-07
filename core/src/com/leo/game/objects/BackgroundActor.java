package com.leo.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class BackgroundActor extends Actor {

    private Texture bg;
    private Sprite bgSprite;

    public BackgroundActor(){

        bg = new Texture("bg.png");
        bgSprite = new Sprite(bg);
        bgSprite.setSize(Security.WIDTH, Security.HEIGHT);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bgSprite.draw(batch);
    }
}
