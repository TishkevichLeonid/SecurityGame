package com.leo.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.leo.game.Screens.GameScreen;
import com.leo.game.Textures.AssetLoader;
import com.badlogic.gdx.math.Rectangle;
//import java.awt.Rectangle;

/**
 * Created by leonidtiskevic on 13.02.17.
 */

public class BadTablet {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private Rectangle badRec;

    private int width;
    private int height;

    public BadTablet(int x, int y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y + 20);
      //  velocity = new Vector2(GameScreen.velosity3);
        velocity = new Vector2(0, -150);
        acceleration = new Vector2(0, -20);
        badRec = new Rectangle(0, 0, AssetLoader.badTablet.getWidth(), AssetLoader.badTablet.getHeight() + 40);

    }


    public void update(float dt){
        velocity.add(acceleration.cpy().scl(dt));
        position.add(velocity.cpy().scl(dt));
        badRec.y = position.y;
        badRec.x = position.x;

    }

    public Rectangle getBadRec(){
        return  badRec;

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

    public float setX(float x){
        return this.position.x = x;
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
