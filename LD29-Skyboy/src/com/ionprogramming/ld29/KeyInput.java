package com.ionprogramming.ld29;

import java.awt.event.KeyEvent;

import com.ionprogramming.ld29.graphics.TitleScreen;

public class KeyInput {
	
	public static void keyPressed(KeyEvent e){
		if(TitleScreen.showing){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				Update.initGame();
				TitleScreen.showing = false;
			}
		}
		else{
			//Game Keys
		}
	}
	
	public static void keyReleased(KeyEvent e){
		if(TitleScreen.showing){
			
		}
		else{
			//Game Keys
		}
	}
}
