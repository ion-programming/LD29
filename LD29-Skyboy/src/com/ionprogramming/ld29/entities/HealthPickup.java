package com.ionprogramming.ld29.entities;

import java.awt.Graphics;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class HealthPickup extends Block{
	
	public HealthPickup(int type, float x, float y){
//		setImages(Images.health);
		setCurrentImage(type);
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
	
	@Override
	public void draw(Graphics g, float w, float h){
		setOffset(Update.p.getOffset().x, Update.p.getOffset().y);
		super.draw(g, w, h);
		if((int) (getX() + getXOffset()) > -getWidth() - 8 || (int) (getX() + getXOffset() - 8) < w){
			if((int) (getY() + getYOffset()) > -getHeight() - 8 || (int) (getY() + getYOffset() - 8) < h){
				g.drawImage(Images.grass, (int) (getX() + getXOffset() - 8), (int) (getY() + getYOffset() - 8), null);
			}
		}
	}
}
