package com.ionprogramming.ld29.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class Pickup extends Block{
	
	public Pickup(int type, float x, float y){
		setImages(new BufferedImage[]{Images.health, Images.ammo});
		setCurrentImage(type);
		resize(16, 16);
		setLoc(x, y);
		setCentre(8, 8);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(16, 16);
		c.setFriction(1);
		c.setBounce(1);
		c.setFixed(true);
		c.setDynamic(false);
		collisionBody = c;
		setCollisionStats();
	}
	
	@Override
	public void draw(Graphics g, float w, float h){
		update();
		setOffset(Update.p.getOffset().x, Update.p.getOffset().y);
		super.draw(g, w, h);
	}
	
	
	public void update(){
		
	}
}
