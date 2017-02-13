package com.leo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.GoodTablet;

import java.awt.Rectangle;
import java.util.Iterator;

/**
 * Created by leonidtiskevic on 12.02.17.
 */

public class GoodTabletActor extends Actor {

    GoodTablet goodTablet;

    public GoodTabletActor(){

        goodTablet = new GoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2, AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());



    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());
        goodTablet.update(Gdx.graphics.getDeltaTime());

    }
}
