package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.Animation.OrangeWave;
import com.leo.game.objects.animationMenu.LeftWaveMenu;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class LeftWaveMenuActor extends Actor {

    private long lastWave;
    private LeftWaveMenu mLeftWaveMenu;
    private Array<LeftWaveMenu> mLeftWaveMenuArray;

    public LeftWaveMenuActor(){

        mLeftWaveMenuArray = new Array<LeftWaveMenu>();

    }

    public void wavesLeft(){
        mLeftWaveMenu = new LeftWaveMenu(-90, Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2, AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mLeftWaveMenuArray.add(mLeftWaveMenu);
        lastWave = TimeUtils.millis();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (LeftWaveMenu leftWaveMenu: mLeftWaveMenuArray){
            batch.draw(AssetLoader.orangeWave, leftWaveMenu.getX(), Security.HEIGHT / 2 - leftWaveMenu.getHeight() / 2 - leftWaveMenu.getWidth() / 2 + 90, leftWaveMenu.getHeight(), leftWaveMenu.getWidth());
        }

        if (TimeUtils.millis() - lastWave > 750) wavesLeft();

        Iterator<LeftWaveMenu> iter = mLeftWaveMenuArray.iterator();

        while (iter.hasNext()){
            LeftWaveMenu leftWaveMenu = iter.next();
            leftWaveMenu.update(Gdx.graphics.getDeltaTime());
            if (leftWaveMenu.getX() > 60){
                iter.remove();
            }
        }

    }
}
