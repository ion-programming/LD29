package com.ionprogramming.ld29.map;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.ArrayList;

import com.ionprogramming.ld29.entities.Dirt;

public class LoadMap {
	
	public static ArrayList<Dirt> level = new ArrayList<Dirt>();
	
	public void load(BufferedImage i){
		level.clear();
		Raster r = i.getData();
		DataBufferInt data = (DataBufferInt)r.getDataBuffer();
		int[] pixels = data.getData();
		for(int n = 0; n < pixels.length; n++){
			if(pixels[n] != 0){
				int t = 0;
				if(n > 0){
					if(pixels[n - 1] == 0){
						t = 1;
					}
				}
				if(n < pixels.length - 1){
					if(pixels[n + 1] == 0){
						t = 2;
					}
				}
				level.add(new Dirt(t, n - (int) (n/i.getWidth())*i.getWidth(), (int) (n/i.getWidth())));
			}
		}
	}
}
