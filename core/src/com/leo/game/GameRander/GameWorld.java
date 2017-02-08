package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.leo.game.Security;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class GameWorld {

    private GoodTablet mGoodTablet;

    public GameWorld(){

        mGoodTablet = new GoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2, AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());

    }


    public void update(float delta){
        mGoodTablet.update(delta);

    }

    public GoodTablet getGoodTablet(){

        return mGoodTablet;
    }

}
