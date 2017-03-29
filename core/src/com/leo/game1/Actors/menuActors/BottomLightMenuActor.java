package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game1.objects.Animation.BottomLight;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class BottomLightMenuActor extends Actor {

    private BottomLight mBottomLight;

    public BottomLightMenuActor(){

        mBottomLight = new BottomLight(com.leo.game1.Security.WIDTH / 2 - com.leo.game1.textures.AssetLoader.bottomLight.getWidth() / 2, -10, com.leo.game1.textures.AssetLoader.bottomLight.getWidth()
                , com.leo.game1.textures.AssetLoader.bottomLight.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(com.leo.game1.textures.AssetLoader.bottomLight, mBottomLight.getX(), mBottomLight.getY(), mBottomLight.getWidth(), mBottomLight.getHeight());
        mBottomLight.update(Gdx.graphics.getDeltaTime());
    }
}
