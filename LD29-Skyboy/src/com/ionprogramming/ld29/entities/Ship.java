package com.ionprogramming.ld29.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class Ship extends Block{
	
	public Ship( float x, float y){
		setImages(new BufferedImage[]{Images.ship});
		setCurrentImage(0);
		resize(192, 64);
		setLoc(x, y);
		setCentre(96, 32);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(192, 64);
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
