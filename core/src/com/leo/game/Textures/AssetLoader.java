package com.leo.game.Textures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class AssetLoader {

    public static Texture bg;
    public static Texture goodTablet;

    public static void load(){

        bg = new Texture("bg.png");

        goodTablet = new Texture("goodTablet.png");

       // bg.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
       // goodTablet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

    }

    public static void dispose(){

        bg.dispose();
        goodTablet.dispose();

    }

}
