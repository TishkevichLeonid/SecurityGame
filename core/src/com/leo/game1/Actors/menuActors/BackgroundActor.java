package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class BackgroundActor extends Actor {

    private Texture bg;
    private Sprite bgSprite;
    private com.leo.game1.objects.GoodTablet goodTablet;

    public BackgroundActor(){

        bg = new Texture("bg1.png");
        bgSprite = new Sprite(bg);
        bgSprite.setSize(com.leo.game1.Security.WIDTH, com.leo.game1.Security.HEIGHT);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bgSprite.draw(batch);


    }
}
