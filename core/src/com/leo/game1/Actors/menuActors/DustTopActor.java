package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game1.textures.AssetLoader;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class DustTopActor extends Actor {

    private com.leo.game1.objects.Animation.DustTop mDustTop;

    public DustTopActor(){

        mDustTop = new com.leo.game1.objects.Animation.DustTop(com.leo.game1.Security.WIDTH / 2 - AssetLoader.topShadow.getWidth() / 2, 300, AssetLoader.topShadow.getWidth(), AssetLoader.topShadow.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.topShadow, mDustTop.getX(), mDustTop.getY(), mDustTop.getWidth(), mDustTop.getHeight());

    }
}
