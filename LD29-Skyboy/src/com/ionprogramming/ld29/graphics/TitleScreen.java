package com.ionprogramming.ld29.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import com.ionprogramming.ld29.LD29;

public class TitleScreen {
	
	public static boolean enabled = true;
	public static boolean showing = true;
	
	public static ArrayList<Color> starColours = new ArrayList<Color>();
	
	public static BufferedImage[] stars = new BufferedImage[3];
	
	static Random r = new Random();
	
	public static int offset1 = 0;
	public static int offset2 = 0;
	public static int offset3 = 0;
	
	
	public static void init(){
		starColours.add(new Color(0xFFFFFF));
		starColours.add(new Color(0xFF3F4C));
		starColours.add(new Color(0xFFF189));
		starColours.add(new Color(0x96C3FF));
		starColours.add(new Color(0x3060FF));
		starColours.add(new Color(0xFF7E42));
		
		
		stars[0] = makeStars(2, 400);
		stars[1] = makeStars(3, 100);
		stars[2] = makeStars(4, 50);
	}
	
	public static void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LD29.width, LD29.height);
		
		//render stars
				
		g.drawImage(stars[0], offset1, 0, null);
		g.drawImage(stars[0], offset1 + stars[0].getWidth(), 0, null);
		
		g.drawImage(stars[1], offset2, 0, null);
		g.drawImage(stars[1], offset2 + stars[1].getWidth(), 0, null);
		
		g.drawImage(stars[2], offset3, 0, null);
		g.drawImage(stars[2], offset3 + stars[2].getWidth(), 0, null);
		
		
		//render earth
		g.drawImage(Images.earth, LD29.width/2-Images.earth.getWidth()/2, 150, null);
		
		//render logo
		g.drawImage(Images.skyboy, LD29.width/2-Images.skyboy.getWidth()/2, 5, null);
		
		//render options
		g.drawImage(Images.play, LD29.width/2-Images.play.getWidth()/2, LD29.height-Images.play.getHeight()-5, null);
		
	}
	
	public static void update(){
		offset1--;
		if(offset1 <= -stars[0].getWidth()){
			offset1 = 0;
		}
		
		offset2-=2;
		if(offset2 <= -stars[1].getWidth()){
			offset2 = 0;
		}
		
		offset3-=3;
		if(offset3 <= -stars[2].getWidth()){
			offset3 = 0;
		}
	}
	
	public static BufferedImage makeStars(int size, int num){
		BufferedImage out = new BufferedImage(LD29.width, LD29.height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = out.createGraphics();
		
		for(int a = 0; a < num; a++){
			int x = r.nextInt(LD29.width);
			int y = r.nextInt(LD29.height);
			int c = r.nextInt(starColours.size());
			
			g.setColor(starColours.get(c));
			
			g.fillOval(x, y, size, size);
		}
		
		g.dispose();
		
		return out;
		
	}
	
	
}
