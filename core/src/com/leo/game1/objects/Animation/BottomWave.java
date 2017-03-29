package com.leo.game1.objects.Animation;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by leonidtiskevic on 25.02.17.
 */

public class BottomWave {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 widthChange;
    private Vector2 deltaWidth;

    private int width;
    private int height;

    public BottomWave(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, -100);
        widthChange = new Vector2(300, 100);
        deltaWidth = new Vector2(30, 0);
        x = position.x;
        y = position.y;
    }


    public void update(float dt){
        position.add(velocity.cpy().scl(dt));
        widthChange.add(deltaWidth.cpy().scl(dt));

        if (position.y < -10){
            velocity.y = 50;
            deltaWidth.x = -110;
            deltaWidth.y = -38;
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
