package com.leo.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.leo.game.GameRander.AssetLoader;
import com.leo.game.Security;
import com.leo.game.states.GameScreen;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class BackgroundActor extends Actor {

    private Texture bg;
    private Sprite bgSprite;
    private GoodTablet goodTablet;

    public BackgroundActor(){

        bg = new Texture("bg.png");
        bgSprite = new Sprite(bg);
        bgSprite.setSize(Security.WIDTH, Security.HEIGHT);

        goodTablet = new GoodTablet(Gdx.graphics.getWidth() / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Gdx.graphics.getHeight() + AssetLoader.goodTablet.getHeight() / 2, AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        bgSprite.draw(batch);
        batch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());
        goodTablet.update(Gdx.graphics.getDeltaTime());


    }
}
