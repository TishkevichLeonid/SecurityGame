package com.leo.game;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by leonidtiskevic on 20.02.17.
 */

public class Collides {

    public boolean collide(Rectangle tablet){
        return tablet.overlaps(badTablet.getBadRec());

    }

}
