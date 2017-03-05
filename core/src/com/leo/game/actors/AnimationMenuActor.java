package com.leo.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.animationMenu.BottomWaveMenu;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 10.02.17.
 */

public class AnimationMenuActor extends Actor {

    private long lastWave;
    private BottomWaveMenu mBottomWave;
    private Array<BottomWaveMenu> mBottomWaveMenuArray;

    public AnimationMenuActor(){

        mBottomWaveMenuArray = new Array<BottomWaveMenu>();

    }

    public void bottomWaves(){
        mBottomWave = new BottomWaveMenu(Security.WIDTH / 2 - 150, -20, 300, 100);
        mBottomWaveMenuArray.add(mBottomWave);
        lastWave = TimeUtils.millis();

    }




    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (BottomWaveMenu bottomWaveMenu : mBottomWaveMenuArray) {
            batch.draw(AssetLoader.testwave, Security.WIDTH / 2 - bottomWaveMenu.getWidth() / 2, bottomWaveMenu.getY(), bottomWaveMenu.getWidth(), bottomWaveMenu.getHeight());
        }

        if (TimeUtils.millis() - lastWave > 600) bottomWaves();

        Iterator<BottomWaveMenu> iter = mBottomWaveMenuArray.iterator();

        while (iter.hasNext()){
            BottomWaveMenu bottomWave = iter.next();
            bottomWave.update(Gdx.graphics.getDeltaTime());
            if (bottomWave.getY() > 90){
                iter.remove();
            }

        }

    }

}
