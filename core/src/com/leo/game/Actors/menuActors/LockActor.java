package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;

/**
 * Created by leonidtiskevic on 06.03.17.
 */

public class LockActor extends Actor {

    public LockActor(){



    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.lock, Security.WIDTH / 2 - 120, 350, 240, 300);

    }
}
