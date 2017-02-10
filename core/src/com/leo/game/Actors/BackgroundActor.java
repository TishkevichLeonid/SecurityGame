package com.leo.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class BackgroundActor extends Actor {

    private Texture bg;
    private Sprite bgSprite;
    private GoodTablet goodTablet;

    public BackgroundActor(){

        bg = new Texture("bg.png");
        bgSprite = new Sprite(bg);
        bgSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bgSprite.draw(batch);


    }
}
