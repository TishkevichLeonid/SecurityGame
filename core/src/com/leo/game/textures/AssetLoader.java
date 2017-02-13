package com.leo.game.textures;


import com.badlogic.gdx.graphics.Texture;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class AssetLoader {

    public static Texture bg;
    public static Texture goodTablet;
    public static Texture badTablet;

    public static void load(){

        bg = new Texture("bg.png");

        goodTablet = new Texture("goodTablet.png");
        badTablet = new Texture("badTablet.png");
        bg.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        goodTablet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        badTablet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

    }

    public static void dispose(){

        bg.dispose();
        goodTablet.dispose();
        badTablet.dispose();

    }

}
