package com.ionprogramming.ld29.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.IOException;

import com.ionprogramming.ld29.Window;
import com.ionprogramming.ld29.entities.Player;

public class HUD {
	
	public static Font f;
	
	public static void init(){
		if(!Window.isWindow){
			try {
				f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("res/NOVASQUARE.TTF") );
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void render(Graphics g){
		//Background
		g.setColor(new Color(0x802c3e50, true));
		g.fillRect(5, 5, 210, 55);
		
		//Health
		g.setColor(new Color(0x80c0392b, true));
		g.fillRect(10, 10, (int)((Player.health/(float)Player.maxHealth) * 100 * 1.5), 20);
		
		g.setColor(Color.white);
		g.setFont(f.deriveFont(18f));
		g.drawString("HEALTH", 15, 27);
		
		
		//Ammo
		g.setColor(new Color(0x80c0392b, true));
		g.fillRect(10, 35, (int)((Player.ammo/(float)Player.maxAmmo) * 100 * 1.5), 20);
		
		g.setColor(Color.white);
		g.drawString("AMMO", 15, 53);
		
		//Picture
		g.setColor(new Color(0x80000000, true));
		g.fillRect(165, 10, 45, 45);
		g.drawImage(Images.face, 175, 20, null);
	}
	
}
