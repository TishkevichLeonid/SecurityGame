package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class DustBottomActor extends Actor {

    private com.leo.game1.objects.Animation.DustBottom mDustBottom;

    public DustBottomActor(){

        mDustBottom = new com.leo.game1.objects.Animation.DustBottom(com.leo.game1.Security.WIDTH / 2 - com.leo.game1.textures.AssetLoader.dustBottom.getWidth() / 2, -10, com.leo.game1.textures.AssetLoader.dustBottom.getWidth(), com.leo.game1.textures.AssetLoader.dustBottom.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(com.leo.game1.textures.AssetLoader.dustBottom, mDustBottom.getX(), mDustBottom.getY());
        mDustBottom.update(Gdx.graphics.getDeltaTime());

    }
}
