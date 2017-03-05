package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.DustTop;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class DustTopActor extends Actor {

    private DustTop mDustTop;

    public DustTopActor(){

        mDustTop = new DustTop(Security.WIDTH / 2 - AssetLoader.topShadow.getWidth() / 2, 300, AssetLoader.topShadow.getWidth(), AssetLoader.topShadow.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.topShadow, mDustTop.getX(), mDustTop.getY(), mDustTop.getWidth(), mDustTop.getHeight());

    }
}
