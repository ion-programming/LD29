package com.ionprogramming.ld29.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class City extends Block{
	
	public City( float x, float y){
		setImages(new BufferedImage[]{Images.city});
		setCurrentImage(0);
		resize(128, 192);
		setLoc(x, y);
		setCentre(64, 96);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(128, 192);
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
	}
}
