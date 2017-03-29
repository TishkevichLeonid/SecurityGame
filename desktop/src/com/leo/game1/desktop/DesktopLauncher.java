package com.leo.game1.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = com.leo.game1.Security.WIDTH;
		config.height = com.leo.game1.Security.HEIGHT;
		config.title = com.leo.game1.Security.TITLE;
		new LwjglApplication(new com.leo.game1.Security(null), config);
	}
}
