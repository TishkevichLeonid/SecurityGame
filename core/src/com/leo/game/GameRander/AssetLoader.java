package com.leo.game.GameRander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.leo.game.Security;

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
        spriteGoodTablet = new Sprite(goodTablet, Security.WIDTH / 2 - bg.getWidth() / 2, Gdx.graphics.getHeight() / 2, bg.getWidth(), bg.getHeight());

        bg.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        goodTablet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

    }

    public static void dispose(){

        bg.getWidth();
        goodTablet.dispose();

    }

}
