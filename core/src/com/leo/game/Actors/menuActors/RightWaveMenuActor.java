package com.leo.game.Actors.menuActors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.leo.game.Security;
import com.leo.game.Textures.AssetLoader;
import com.leo.game.objects.animationMenu.RightWaveMenu;

import java.util.Iterator;

/**
 * Created by leonidtiskevic on 05.03.17.
 */

public class RightWaveMenuActor extends Actor {
    private long lastWave;
    private RightWaveMenu mRightWaveMenu;
    private Array<RightWaveMenu> mRightWaveMenuArray;

    public RightWaveMenuActor() {

        mRightWaveMenuArray = new Array<RightWaveMenu>();

    }

    public void wavesRight() {
        mRightWaveMenu = new RightWaveMenu(480, Security.HEIGHT / 2 - AssetLoader.orangeWave.getWidth() / 2 , AssetLoader.orangeWave.getHeight(), AssetLoader.orangeWave.getWidth());
        mRightWaveMenuArray.add(mRightWaveMenu);
        lastWave = TimeUtils.millis();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        for (RightWaveMenu rightWaveMenu : mRightWaveMenuArray) {
            batch.draw(AssetLoader.orangeWave, rightWaveMenu.getX(), Security.HEIGHT / 2 - rightWaveMenu.getHeight() / 2 - rightWaveMenu.getWidth() / 2 + 90, rightWaveMenu.getHeight(), rightWaveMenu.getWidth());
        }

        if (TimeUtils.millis() - lastWave > 650) wavesRight();

        Iterator<RightWaveMenu> iter = mRightWaveMenuArray.iterator();

        while (iter.hasNext()){
            RightWaveMenu rightWaveMenu = iter.next();
            rightWaveMenu.update(Gdx.graphics.getDeltaTime());
            if (rightWaveMenu.getX() < 350) iter.remove();
        }

    }


}
