package com.ionprogramming.ld29.entities;

import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.graphics.Images;

public class Cannon extends Block{
	
	public Cannon(float x, float y){
		setImages(new BufferedImage[]{Images.cannon});
		resize(64, 64);
		setLoc(x, y);
		setCentre(32, 32);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(64, 64);
		c.setFriction(1);
		c.setBounce(1);
		c.setFixed(true);
		c.setDynamic(false);
		collisionBody = c;
		setCollisionStats();
	}
}
