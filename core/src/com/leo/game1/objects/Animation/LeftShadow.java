package com.leo.game1.objects.Animation;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by leonidtiskevic on 26.02.17.
 */

public class LeftShadow {

    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;

    public LeftShadow(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        x = position.x;
        y = position.y;
    }


    public void update(float dt){
        position.add(velocity.cpy().scl(dt));

        if (position.x > -5){
            velocity.x = -12;

        }
        if (position.x < -25){
            velocity.x = 12;
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
