package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class BackgroundActorMenu extends Actor {

    private Texture bg;
    private Sprite bgSprite;
    private GoodTablet goodTablet;

    public BackgroundActorMenu(){

        bg = new Texture("bgmenu_75.png");
        bgSprite = new Sprite(bg);
        bgSprite.setSize(Security.WIDTH, Security.HEIGHT);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bgSprite.draw(batch);


    }
}
