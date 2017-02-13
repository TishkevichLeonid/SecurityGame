package com.leo.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.leo.game.textures.AssetLoader;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GoodTablet{

    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;

    public GoodTablet(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, -100);
        x = position.x;
        y = position.y;
    }


    public void update(float dt){
        position.add(velocity.cpy().scl(dt));

        if (position.y < 600){
            velocity.y = 100;

        }
        if (position.y > Gdx.graphics.getHeight()){
            velocity.y = -100;
        }


    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }


}
