package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class AssetLoader {

    public static Texture bg;
    public static Texture goodTablet;
    public static Sprite spriteGoodTablet;

    public static void load(){

        bg = new Texture("bg.png");

        goodTablet = new Texture("goodTablet.png");
        spriteGoodTablet = new Sprite(goodTablet, Gdx.graphics.getWidth() / 2, 600, 150, 183);

    }

    public static void dispose(){

        bg.getWidth();
        goodTablet.dispose();

    }

}
