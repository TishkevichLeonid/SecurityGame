package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.DustBottom;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class DustBottomActor extends Actor {

    private DustBottom mDustBottom;

    public DustBottomActor(){

        mDustBottom = new DustBottom(Security.WIDTH / 2 - AssetLoader.dustBottom.getWidth() / 2, -10, AssetLoader.dustBottom.getWidth(), AssetLoader.dustBottom.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.dustBottom, mDustBottom.getX(), mDustBottom.getY());
        mDustBottom.update(Gdx.graphics.getDeltaTime());

    }
}
