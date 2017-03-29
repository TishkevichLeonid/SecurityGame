package com.leo.game1.objects;

import com.badlogic.gdx.math.Vector2;
import com.leo.game1.textures.AssetLoader;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by leonidtiskevic on 13.02.17.
 */

public class GameGoodTablet {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Rectangle goodRec;

    private int width;
    private int height;

    public GameGoodTablet(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(com.leo.game1.Screens.GameScreen.velosity2);
        acceleration = new Vector2(0, -20);
        goodRec = new Rectangle(0, 0, AssetLoader.goodTablet.getWidth(), AssetLoader.goodTablet.getHeight() + 40);

    }


    public void update(float dt){
        velocity.add(acceleration.cpy().scl(dt));
        position.add(velocity.cpy().scl(dt));
        goodRec.x =  position.x;
        goodRec.y =  position.y;

    }

    public Rectangle getGoodRec(){
        return  goodRec;

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
    public float setY(float y){
        return this.position.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }


}


