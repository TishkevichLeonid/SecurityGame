package com.leo.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.BottomLight;

/**
 * Created by leonidtiskevic on 25.02.17.
 */

public class BottomActor extends Actor {

    private BottomLight mBottomLight;

    public BottomActor(){

        mBottomLight = new BottomLight(Security.WIDTH / 2 - AssetLoader.bottomLight.getWidth() / 2, 10, AssetLoader.bottomLight.getWidth()
                , AssetLoader.bottomLight.getHeight());


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetLoader.bottomLight, mBottomLight.getX(), mBottomLight.getY());
        mBottomLight.update(Gdx.graphics.getDeltaTime());
    }
}
