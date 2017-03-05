package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.RightShadow;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class RightDustActor extends Actor {

    private RightShadow mRightShadow;

    public RightDustActor(){

        mRightShadow = new RightShadow(-34, Security.HEIGHT / 2 - AssetLoader.rightShadow.getHeight() / 2 + 60, AssetLoader.rightShadow.getWidth(), AssetLoader.rightShadow.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.rightShadow, mRightShadow.getX(), mRightShadow.getY(), mRightShadow.getWidth(), mRightShadow.getHeight());
        mRightShadow.update(Gdx.graphics.getDeltaTime());

    }
}
