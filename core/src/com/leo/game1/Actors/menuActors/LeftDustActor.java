package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class LeftDustActor extends Actor {

    private com.leo.game1.objects.Animation.LeftShadow mLeftShadow;

    public LeftDustActor(){

        mLeftShadow = new com.leo.game1.objects.Animation.LeftShadow(-26, com.leo.game1.Security.HEIGHT / 2 - com.leo.game1.textures.AssetLoader.leftShadow.getHeight() / 2 + 60, com.leo.game1.textures.AssetLoader.leftShadow.getWidth(), com.leo.game1.textures.AssetLoader.leftShadow.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(com.leo.game1.textures.AssetLoader.leftShadow, mLeftShadow.getX(), mLeftShadow.getY(), mLeftShadow.getWidth(), mLeftShadow.getHeight());
        mLeftShadow.update(Gdx.graphics.getDeltaTime());

    }
}
