package com.leo.game1.desktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by leonidtiskevic on 07.02.17.
 */

public class TextureParker1 {
    private static final String TEXTURES_DIRECTORY = "desktop/menuBtn";
    private static final String ATLAS_DIRECTORY = "menuBtn";
    private static final String ATLAS_FILE_NAME = "menuBtn";

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
