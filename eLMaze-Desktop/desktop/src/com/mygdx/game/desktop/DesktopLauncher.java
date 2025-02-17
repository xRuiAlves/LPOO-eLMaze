package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.elmaze.ELMaze;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 1024;
	    config.height = 768;
	    config.resizable = false;
	    config.fullscreen = true;
		
		new LwjglApplication(new ELMaze(), config);
	}
}
