package com.leo.game1.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class LeftWaveMenuActor extends Actor {

    private long lastWave;
    private com.leo.game1.objects.animationMenu.LeftWaveMenu mLeftWaveMenu;
    private Array<com.leo.game1.objects.animationMenu.LeftWaveMenu> mLeftWaveMenuArray;

    public LeftWaveMenuActor(){

        mLeftWaveMenuArray = new Array<com.leo.game1.objects.animationMenu.LeftWaveMenu>();

    }

    public void wavesLeft(){
        mLeftWaveMenu = new com.leo.game1.objects.animationMenu.LeftWaveMenu(-90, com.leo.game1.Security.HEIGHT / 2 - com.leo.game1.textures.AssetLoader.orangeWave.getWidth() / 2, com.leo.game1.textures.AssetLoader.orangeWave.getHeight(), com.leo.game1.textures.AssetLoader.orangeWave.getWidth());
        mLeftWaveMenuArray.add(mLeftWaveMenu);
        lastWave = TimeUtils.millis();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (com.leo.game1.objects.animationMenu.LeftWaveMenu leftWaveMenu: mLeftWaveMenuArray){
            batch.draw(com.leo.game1.textures.AssetLoader.orangeWave, leftWaveMenu.getX(), com.leo.game1.Security.HEIGHT / 2 - leftWaveMenu.getHeight() / 2 - leftWaveMenu.getWidth() / 2 + 90, leftWaveMenu.getHeight(), leftWaveMenu.getWidth());
        }

        if (TimeUtils.millis() - lastWave > 750) wavesLeft();

        Iterator<com.leo.game1.objects.animationMenu.LeftWaveMenu> iter = mLeftWaveMenuArray.iterator();

        while (iter.hasNext()){
            com.leo.game1.objects.animationMenu.LeftWaveMenu leftWaveMenu = iter.next();
            leftWaveMenu.update(Gdx.graphics.getDeltaTime());
            if (leftWaveMenu.getX() > 60){
                iter.remove();
            }
        }

    }
}
