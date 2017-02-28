package com.leo.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.GoodTablet;

/**
 * Created by leonidtiskevic on 10.02.17.
 */

public class AnimationMenuActor extends Actor {

    private GoodTablet goodTablet;
    private float X;
    private float Y;

    public AnimationMenuActor(){
        goodTablet = new GoodTablet(Security.WIDTH / 2 - AssetLoader.goodTablet.getWidth() / 2,
                Security.HEIGHT - AssetLoader.goodTablet.getHeight() / 2, AssetLoader.goodTablet.getWidth(),
                AssetLoader.goodTablet.getHeight());
        setWidth(goodTablet.getWidth());
        setHeight(goodTablet.getHeight());
        setBounds(X, Y, getWidth(), getHeight());

        setTouchable(Touchable.enabled);
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                goodTablet.setX(x + 190);
                goodTablet.setY(y + 730);
                return true; //super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                goodTablet.setY(y + 730);
                goodTablet.setX(x + 190);
                System.out.println(x + " " + y);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
              //  goodTablet.setPosition(new Vector2(100, 100));
            }
        });

    }

    public void setGoodTablet(GoodTablet goodTablet) {
        this.goodTablet = goodTablet;
    }



    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(AssetLoader.goodTablet, goodTablet.getX(), goodTablet.getY(), goodTablet.getWidth(), goodTablet.getHeight());
        goodTablet.update(Gdx.graphics.getDeltaTime());
        X = goodTablet.getX();
        Y = goodTablet.getY();

    }

}
