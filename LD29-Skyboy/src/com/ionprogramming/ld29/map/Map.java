package com.ionprogramming.ld29.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.ArrayList;

import com.ionprogramming.ld29.entities.Dirt;

public class Map {
	
	public static ArrayList<Dirt> level = new ArrayList<Dirt>();
	
	public static void load(BufferedImage i){
		level.clear();
		BufferedImage img = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
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
		}
	}
	
	public static void draw(Graphics g, float w, float h){
		for(int n = 0; n < level.size(); n++){
			level.get(n).draw(g, w, h);
		}
	}
}
