package com.leo.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.BadTablet;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 16.02.17.
 */

public class BadTabletActor extends Actor {

    private BadTablet badTablet;
    private Array<BadTablet> mBadTabletArray;
    long lastTimeBad;

    public BadTabletActor(){

       /* badTablet = new BadTablet(Security.WIDTH / 2 - AssetLoader.badTablet.getWidth() / 2,
                Security.HEIGHT + AssetLoader.badTablet.getHeight(), AssetLoader.badTablet.getWidth(),
                AssetLoader.badTablet.getHeight()); */

        mBadTabletArray = new Array<BadTablet>();

    }

    public void spawnBadTablets() {
        badTablet = new BadTablet(Security.WIDTH / 2 - AssetLoader.badTablet.getWidth() / 2,
                Security.HEIGHT + AssetLoader.badTablet.getHeight(), AssetLoader.badTablet.getWidth(),
                AssetLoader.badTablet.getHeight());
        mBadTabletArray.add(badTablet);
        lastTimeBad = TimeUtils.millis();

        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    @Override
    public boolean isTouchable() {
        return super.isTouchable();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (BadTablet badTablet: mBadTabletArray){
            batch.draw(AssetLoader.badTablet, badTablet.getX(), badTablet.getY());
        }

        if (System.currentTimeMillis() - lastTimeBad > MathUtils.random(1500, 3800)) {
            spawnBadTablets();
        }

        Iterator<BadTablet> iter1 = mBadTabletArray.iterator();

        while (iter1.hasNext()) {
            BadTablet badTablet = iter1.next();
            badTablet.update(Gdx.graphics.getDeltaTime());

            if (badTablet.getY() < -100) {
                iter1.remove();
            }

        }
    }
}
