package com.leo.game1.textures;


import com.badlogic.gdx.graphics.Texture;

/**
 * Created by leonidtiskevic on 08.02.17.
 */

public class AssetLoader {

    public static Texture bg;
    public static Texture goodTablet;
    public static Texture badTablet;
    public static Texture bottomLight;
    public static Texture testwave;
    public static Texture dustBottom;
    public static Texture topShadow;
    public static Texture leftShadow;
    public static Texture rightShadow;
    public static Texture orangeWave;
    public static Texture heart;
    public static Texture lock;
    public static Texture musicOn;
    public static Texture musicOff;

    public static void load(){

        bg = new Texture("bg.png");
        bottomLight = new Texture("bottomLight.png");
        testwave = new Texture("testvolna.png");
        dustBottom = new Texture("dustBottom.png");
        topShadow = new Texture("topShadow.png");
        leftShadow = new Texture("leftShadow.png");
        rightShadow = new Texture("rightShadow.png");
        orangeWave = new Texture("orangeWave.png");
        heart = new Texture("heart.png");
        lock = new Texture("lock.png");
        musicOn = new Texture("mOn.png");
        musicOff = new Texture("mOff.png");

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
        bottomLight.dispose();
        testwave.dispose();
        dustBottom.dispose();
        topShadow.dispose();
        leftShadow.dispose();
        orangeWave.dispose();
        heart.dispose();

    }

}
