package com.ionprogramming.ld29.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] dirt;
	public static BufferedImage grass;
	public static BufferedImage skyboy;
	public static BufferedImage play;
	
	public static void load(){
		try {
			dirt = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirt.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtL.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtR.png")),
					};
			grass = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/grass.png"));
			skyboy = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/skyboy.png"));
			play = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/play.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
