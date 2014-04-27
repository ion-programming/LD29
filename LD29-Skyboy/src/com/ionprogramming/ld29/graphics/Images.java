package com.ionprogramming.ld29.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] dirt;
	public static BufferedImage[] player;
	public static BufferedImage grass;
	public static BufferedImage skyboy;
	public static BufferedImage play;
	public static BufferedImage map;
	public static BufferedImage earth;	
	public static BufferedImage ion;
	public static BufferedImage ld;

	
	public static void load(){
		try {
			dirt = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirt.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtL.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtR.png")),
					};
			player = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirt.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtL.png"))
					};
			grass = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/grass.png"));
			skyboy = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/skyboy.png"));
			play = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/play.png"));
			map = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/map.png"));
			earth = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/earth.png"));
			
			ion = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ionlogo.png"));
			ld = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ld29.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
