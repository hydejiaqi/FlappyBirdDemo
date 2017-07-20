package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FlappyBirdDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyBirdDemo.WIDTH;
		config.height = FlappyBirdDemo.HEIGHT;
		config.title = FlappyBirdDemo.TITLE;
		new LwjglApplication(new FlappyBirdDemo(), config);
	}
}
