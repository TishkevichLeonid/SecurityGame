package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 10.02.17.
 */

public class BottomMenuActor extends Actor {

    private long lastWave;
    private com.leo.game1.objects.animationMenu.BottomWaveMenu mBottomWave;
    private Array<com.leo.game1.objects.animationMenu.BottomWaveMenu> mBottomWaveMenuArray;

    public BottomMenuActor(){

        mBottomWaveMenuArray = new Array<com.leo.game1.objects.animationMenu.BottomWaveMenu>();

    }

    public void bottomWaves(){
        mBottomWave = new com.leo.game1.objects.animationMenu.BottomWaveMenu(com.leo.game1.Security.WIDTH / 2 - 150, -20, 300, 100);
        mBottomWaveMenuArray.add(mBottomWave);
        lastWave = TimeUtils.millis();

    }




    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (com.leo.game1.objects.animationMenu.BottomWaveMenu bottomWaveMenu : mBottomWaveMenuArray) {
            batch.draw(com.leo.game1.textures.AssetLoader.testwave, com.leo.game1.Security.WIDTH / 2 - bottomWaveMenu.getWidth() / 2, bottomWaveMenu.getY(), bottomWaveMenu.getWidth(), bottomWaveMenu.getHeight());
        }

        if (TimeUtils.millis() - lastWave > 600) bottomWaves();

        Iterator<com.leo.game1.objects.animationMenu.BottomWaveMenu> iter = mBottomWaveMenuArray.iterator();

        while (iter.hasNext()){
            com.leo.game1.objects.animationMenu.BottomWaveMenu bottomWave = iter.next();
            bottomWave.update(Gdx.graphics.getDeltaTime());
            if (bottomWave.getY() > 90){
                iter.remove();
            }

        }

    }

}
