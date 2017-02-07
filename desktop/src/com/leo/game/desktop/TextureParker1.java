package com.leo.game.desktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class TextureParker1 {
    private static final String TEXTURES_DIRECTORY = "desktop/pots";
    private static final String ATLAS_DIRECTORY = "buttons";
    private static final String ATLAS_FILE_NAME = "buttons";

    public static void main(String[] args) {

        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 1024;
        settings.maxHeight = 1024;
        settings.filterMin = Texture.TextureFilter.Linear;
        settings.filterMag = Texture.TextureFilter.Linear;

        TexturePacker.process(settings,
                TEXTURES_DIRECTORY,
                ATLAS_DIRECTORY,
                ATLAS_FILE_NAME);

    }

}
