package com.ionprogramming.ld29;

import java.awt.Graphics;

import com.ionprogramming.ld29.graphics.Images;
import com.ionprogramming.ld29.graphics.TitleScreen;
import com.ionprogramming.ld29.map.Map;

public class Update {
	
	public static void initMenu(){
		TitleScreen.init();
	}
	
	public static void updateMenu(Graphics g){
		TitleScreen.update();
		TitleScreen.render(g);
	}
	
	public static void initGame(){
		Map.load(Images.map);
	}
	
	public static void updateGame(Graphics g){
		Map.draw(g, LD29.width, LD29.height);
	}
}
