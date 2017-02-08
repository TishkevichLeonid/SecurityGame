package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class GameWorld {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);


    public void update(float delta){
        Gdx.app.log("GameWorld", "update");



    }

    public Rectangle getRect(){

        return rect;
    }

}
