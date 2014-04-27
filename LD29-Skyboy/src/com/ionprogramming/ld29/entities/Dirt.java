package com.ionprogramming.ld29.entities;

import java.awt.Graphics;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.graphics.Images;

public class Dirt extends Block{
	
	public Dirt(int type, float x, float y){
		setImages(Images.dirt);
		setCurrentImage(type);
		resize(64, 64);
		setLoc(x, y);
		setCentre(32, 32);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(64, 64);
		c.setFriction(1);
		c.setBounce(1);
		c.setDynamic(false);
		collisionBody = c;
	}
	
	@Override
	public void draw(Graphics g){
		super.draw(g);
		g.drawImage(Images.grass, (int) (getX() + getXOffset() - 8), (int) (getY() + getYOffset() - 8), null);
	}
}
