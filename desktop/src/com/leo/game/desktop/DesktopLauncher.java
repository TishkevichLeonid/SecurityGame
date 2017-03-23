package com.leo.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.leo.game.Security;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Security.WIDTH;
		config.height = Security.HEIGHT;
		config.title = Security.TITLE;
		new LwjglApplication(new Security(null), config);
	}
}
