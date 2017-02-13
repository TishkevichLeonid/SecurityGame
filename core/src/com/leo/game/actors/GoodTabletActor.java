package com.leo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.GoodTablet;

import java.awt.Rectangle;

/**
 * Created by leonidtiskevic on 12.02.17.
 */

public class GoodTabletActor extends Actor {

   // private Rectangle goodTablet;
    private GoodTablet goodTablet;
    private Vector2 velosity;
    private Vector2 acceleration;
    private Vector2 position;

    public GoodTabletActor(){
        /*
        velosity = new Vector2(0, 0);
        acceleration = new Vector2(0, -15);
        position = new Vector2(0,0);
        goodTablet = new Rectangle();
        goodTablet.x = (int) position.x;
        goodTablet.y = (int) position.y;
        goodTablet.width = AssetLoader.goodTablet.getWidth();
        goodTablet.height = AssetLoader.goodTablet.getHeight(); */
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
