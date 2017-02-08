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

        mGoodTablet = new GoodTablet(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight(), 150, 183);

    }


    public void update(float delta){
        Gdx.app.log("GameWorld", "update");


    }

    public GoodTablet getGoodTablet(){

        return mGoodTablet;
    }

}
