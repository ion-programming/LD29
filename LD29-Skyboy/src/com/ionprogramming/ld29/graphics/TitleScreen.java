package com.ionprogramming.ld29.graphics;

import java.awt.Color;
import java.awt.Graphics;

import com.ionprogramming.ld29.LD29;

public class TitleScreen {
	
	public static boolean enabled = true;
	public static boolean showing = true;
	
	
	public static void init(){
		
	}
	
	public static void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LD29.width, LD29.height);
		
		//render stars
		
		//render earth
		g.drawImage(Images.earth, LD29.width/2-Images.earth.getWidth()/2, 150, null);
		//render logo
		g.drawImage(Images.skyboy, LD29.width/2-Images.skyboy.getWidth()/2, 5, null);
		
		//render options
		g.drawImage(Images.play, LD29.width/2-Images.play.getWidth()/2, LD29.height-Images.play.getHeight()-5, null);
		
	}
	
	public static void update(){
		
	}
	
	
}
