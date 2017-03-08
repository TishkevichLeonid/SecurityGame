package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import com.leo.game.Textures.AssetLoader;

/**
 * Created by leonidtiskevic on 07.03.17.
 */

public class MusicOn extends Actor {

    public MusicOn(){


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.musicOn, 50, 730, 50, 50);

    }


    public static class MusicOff extends Actor{

        public MusicOff(){


        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);

            batch.draw(AssetLoader.musicOff, 50, 730, 50, 50);

        }
    }

}
