package com.leo.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.leo.game.screens.GameScreen;

/**
 * Created by leonidtiskevic on 13.02.17.
 */

public class BadTablet {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    // private Array<GoodTablet> mGoodTabletArray;

    private int width;
    private int height;

    public BadTablet(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(GameScreen.velosity2);
        acceleration = new Vector2(0, -20);
        x = position.x;
        y = position.y;

    }


    public void update(float dt){
        velocity.add(acceleration.cpy().scl(dt));
        position.add(velocity.cpy().scl(dt));

    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getVelocity() {
        return velocity;
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
