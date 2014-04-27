package com.ionprogramming.ld29.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static void render(Graphics g){
		g.setColor(new Color(0x802c3e50, true));
		g.fillRect(5, 5, 260, 105);
		
		g.setColor(new Color(0x80c0392b, true));
		g.fillRect(10, 10, 150, 20);
		
		g.fillRect(10, 35, 150, 20);
		
		g.fillRect(10, 60, 150, 20);
		
		g.fillRect(10, 85, 150, 20);
		
		g.setColor(new Color(0x80000000, true));
		g.fillRect(165, 10, 95, 95);
	}
	
}
