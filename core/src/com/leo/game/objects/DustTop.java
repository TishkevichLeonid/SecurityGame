package com.leo.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 26.02.17.
 */

public class DustTop {

    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;

    public DustTop(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, -100);
        x = position.x;
        y = position.y;
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
