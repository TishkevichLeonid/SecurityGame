package com.leo.game.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by leonidtiskevic on 25.02.17.
 */

public class BottomWave {

    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;

    public BottomWave(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, -100);
        x = position.x;
        y = position.y;
    }


    public void update(float dt){
        position.add(velocity.cpy().scl(dt));

        if (position.y < -10){
            velocity.y = 100;

        }

        if (position.y > 400){
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
