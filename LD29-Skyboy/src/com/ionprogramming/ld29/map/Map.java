package com.ionprogramming.ld29.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.ArrayList;

import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.entities.Cannon;
import com.ionprogramming.ld29.entities.Dirt;
import com.ionprogramming.ld29.entities.Pickup;
import com.ionprogramming.ld29.entities.Player;

public class Map {
	
	public static ArrayList<Dirt> level = new ArrayList<Dirt>();
	public static int mapwidth = 0;
	public static int mapheight = 0;
	
	public static void load(BufferedImage i){
		level.clear();
		BufferedImage img = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		mapwidth = i.getWidth() * 64;
		mapheight = i.getHeight() * 64;
		
	    img.getGraphics().drawImage(i, 0, 0, null);
		Raster r = img.getData();
		DataBufferInt data = (DataBufferInt)r.getDataBuffer();
		int[] pixels = data.getData();
		for(int n = 0; n < pixels.length; n++){
			if(pixels[n] == 0){
				int t = 0;
				if(n > 0){
					if(pixels[n - 1] != 0){
						t = 1;
					}
				}
				if(n < pixels.length - 1){
					if(pixels[n + 1] != 0){
						t = 2;
					}
				}
				level.add(new Dirt(t, (n - (int) (n/img.getWidth())*img.getWidth())*64, ((int) (n/img.getWidth()))*64));
			}
			
			else if(pixels[n] == 0xFF0000){
				Update.pickups.add(new Pickup(0, (n - (int) (n/img.getWidth())*img.getWidth())*64+ 24, ((int) (n/img.getWidth()))*64+44));
			}
			else if(pixels[n] == 0xFFFF00){
				Update.pickups.add(new Pickup(1, (n - (int) (n/img.getWidth())*img.getWidth())*64 + 24, ((int) (n/img.getWidth()))*64+44));
			}
			else if(pixels[n] == 0x00FF00){
				Update.cannons.add(new Cannon(0, (n - (int) (n/img.getWidth())*img.getWidth())*64, ((int) (n/img.getWidth()))*64));
			}
			else if(pixels[n] == 0x0000FF){
				Update.cannons.add(new Cannon(1, (n - (int) (n/img.getWidth())*img.getWidth())*64, ((int) (n/img.getWidth()))*64));
			}
			else if(pixels[n] == 0xFF00FF){
				Update.p = new Player((n - (int) (n/img.getWidth())*img.getWidth())*64, ((int) (n/img.getWidth()))*64);
			}
			
			//ship FF7800
			
			//city 00FFFF
		}
	}
	
	public static void draw(Graphics g, float w, float h){
		for(int n = 0; n < level.size(); n++){
			level.get(n).draw(g, w, h);
		}
	}
}
