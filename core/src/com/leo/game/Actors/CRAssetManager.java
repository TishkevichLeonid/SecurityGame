package com.leo.game.Actors;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by leonidtiskevic on 20.02.17.
 */

public class CRAssetManager extends AssetManager {

    private static CRAssetManager instance;

    public static CRAssetManager getInstance() {
        if (instance == null) {
            instance = new CRAssetManager();
        }
        return instance;
    }

    public void init() {

    }

    @Override
    public synchronized void dispose() {
        super.dispose();
        instance = null;
    }
}

