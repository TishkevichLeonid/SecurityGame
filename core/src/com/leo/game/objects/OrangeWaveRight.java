package com.leo.game.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by leonidtiskevic on 26.02.17.
 */

public class OrangeWaveRight {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 widthChange;
    private Vector2 deltaWidth;

    private int width;
    private int height;

    public OrangeWaveRight(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(-50, 0);
        widthChange = new Vector2(300, 100);
        deltaWidth = new Vector2(30, 0);
        x = position.x;
        y = position.y;
    }


    public void update(float dt){
        position.add(velocity.cpy().scl(dt));
        widthChange.add(deltaWidth.cpy().scl(dt));

        if (position.x < 410){
            velocity.x = -35;
            deltaWidth.y = -20;
            deltaWidth.x = -110;
        }

    }


    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return widthChange.x;
    }

    public float getHeight() {
        return widthChange.y;
    }

}
