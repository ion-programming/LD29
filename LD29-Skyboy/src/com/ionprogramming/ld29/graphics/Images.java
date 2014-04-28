package com.ionprogramming.ld29.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] dirt;
	public static BufferedImage[] player;
	public static BufferedImage[] bullet;
	public static BufferedImage cannon;
	public static BufferedImage grass;
	public static BufferedImage skyboy;
	public static BufferedImage play;
	public static BufferedImage map;
	public static BufferedImage earth;	
	public static BufferedImage ion;
	public static BufferedImage ld;
	public static BufferedImage intro;
	public static BufferedImage ending;
	
	public static void load(){
		try {
			dirt = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirt.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtL.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/dirtR.png")),
					};
			player = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/sR1.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/sR2.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/sL1.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/sL2.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/R1.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/R2.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/L1.png")),
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/L2.png")),
					};
			bullet = new BufferedImage[]{
					ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/bullet.png")),
					};
			cannon = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/cannon.png"));
			grass = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/grass.png"));
			skyboy = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/skyboy.png"));
			play = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/play.png"));
			map = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/map.png"));
			earth = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/earth.png"));
			
			ion = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ionlogo.png"));
			ld = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/ld29.png"));
			intro = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/intro.png"));
			ending = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("res/end.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
