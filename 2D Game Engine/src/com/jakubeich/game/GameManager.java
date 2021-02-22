package com.jakubeich.game;

import java.awt.event.KeyEvent;

import com.jakubeich.engine.AbstractGame;
import com.jakubeich.engine.GameContainer;
import com.jakubeich.engine.Renderer;
import com.jakubeich.engine.audio.SoundClip;
import com.jakubeich.engine.gfx.Image;
import com.jakubeich.engine.gfx.ImageTile;

public class GameManager extends AbstractGame{
	
	private ImageTile image;
	float temp = 0;
	private SoundClip clip;
	
	public GameManager() {
		
		image = new ImageTile("/test.png", 16, 16);
		clip = new SoundClip("/audio/test.wav");
		clip.setVolume(-20);
	}

	@Override
	public void update(GameContainer gc, float dt) {
		
		if(gc.getInput().isKeyDown(KeyEvent.VK_A)) {
			
			clip.play();
			
		}
		
		temp += dt;
		
		if(temp > 3) {
			
			temp = 0;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		
		r.drawImage(image, gc.getInput().getMouseX(), gc.getInput().getMouseY());
		
	}
	
	public static void main(String args[]) {
		
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHeight(240);
		gc.setScale(3f);
		gc.start();
	}

}
