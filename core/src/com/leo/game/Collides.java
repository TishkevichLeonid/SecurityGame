package com.leo.game;

import com.badlogic.gdx.math.Rectangle;
import com.leo.game.Screens.GameScreen;

/**
 * Created by leonidtiskevic on 20.02.17.
 */

public class Collides {

    private static GameScreen mGameScreen;

    public static boolean collideGoodtoBad(Rectangle tablet){
        return tablet.overlaps(mGameScreen.getBadTabletArray().get(0).getBadRec());

    }

    public static boolean collideBadtoGood(Rectangle tablet){
        return tablet.overlaps(mGameScreen.getGoodTabletArray().get(0).getGoodRec());

    }

    public static boolean collidGoodtoGood(Rectangle tablet){
        return tablet.overlaps(mGameScreen.getGoodTabletArray().get(0).getGoodRec());

    }

    public static boolean collidBadtoBad(Rectangle tablet){
        return tablet.overlaps(mGameScreen.getBadTabletArray().get(0).getBadRec());

    }

}
