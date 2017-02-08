package com.leo.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class GoodTablet{

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    public GoodTablet(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(Security.WIDTH / 2, 0);
        velocity = new Vector2(0, 10);
        acceleration = new Vector2(0, 50);
    }

    public void update(float dt){
        velocity.add(acceleration.cpy().scl(dt));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(dt));


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
