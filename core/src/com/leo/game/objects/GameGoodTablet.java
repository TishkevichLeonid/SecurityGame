package com.leo.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by leonidtiskevic on 13.02.17.
 */

public class GameGoodTablet {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    // private Array<GoodTablet> mGoodTabletArray;

    private int width;
    private int height;

    public GameGoodTablet(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, -100);
        acceleration = new Vector2(0, -15);
        x = position.x;
        y = position.y;

    }


    public void update(float dt){
        velocity.add(acceleration.cpy().scl(dt));

        if (velocity.y < -200) {
            velocity.y = -200;
        }


        position.add(velocity.cpy().scl(dt));

    }
    public void setY(){
        position.y = Gdx.graphics.getHeight();

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


