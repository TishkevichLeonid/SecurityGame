package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class LockActor extends Actor {

    public LockActor(){



    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(com.leo.game1.textures.AssetLoader.lock, com.leo.game1.Security.WIDTH / 2 - 120, 350, 240, 300);

    }
}
