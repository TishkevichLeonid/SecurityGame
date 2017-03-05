package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.LeftShadow;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class LeftDustActor extends Actor {

    private LeftShadow mLeftShadow;

    public LeftDustActor(){

        mLeftShadow = new LeftShadow(-26, Security.HEIGHT / 2 - AssetLoader.leftShadow.getHeight() / 2 + 60, AssetLoader.leftShadow.getWidth(), AssetLoader.leftShadow.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.leftShadow, mLeftShadow.getX(), mLeftShadow.getY(), mLeftShadow.getWidth(), mLeftShadow.getHeight());
        mLeftShadow.update(Gdx.graphics.getDeltaTime());

    }
}
