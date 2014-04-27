package com.ionprogramming.ld29;

import java.awt.Graphics;

import com.ionprogramming.ld29.graphics.TitleScreen;

public class Update {
	
	public static void initMenu(){
		TitleScreen.init();
	}
	
	public static void updateMenu(Graphics g){
		TitleScreen.update();
		TitleScreen.render(g);
	}
	
	public static void initGame(){
		
	}
	
	public static void updateGame(){
		
	}
}
