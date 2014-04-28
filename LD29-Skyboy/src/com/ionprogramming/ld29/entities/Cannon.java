package com.ionprogramming.ld29.entities;

import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.blocks.Block;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.math.GeomMath;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class Cannon extends Block{
	
	public float rot = 0;
	public int time = 0;
	
	public Cannon(float x, float y){
		setImages(new BufferedImage[]{Images.cannon});
		resize(64, 64);
		setLoc(x, y);
		setCentre(32, 48);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(32, 32);
		c.setFriction(1);
		c.setBounce(1);
		c.setFixed(true);
		c.setDynamic(false);
		collisionBody = c;
		setCollisionStats();
	}
	
	public void update(){
		setOffset(Update.p.getOffset().x, Update.p.getOffset().y);
		if(GeomMath.length(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre()) < 400){
			rot = GeomMath.angle(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), -(Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre())) + 90;
			setRotation((float)Math.toRadians(rot), 32, 48);
			time--;
			if(time <= 0){
				Update.projectiles.add(new Projectile(getX() + getXCentre(), getY() + getYCentre(), "gun"));
				time = 20;
			}
		}
	}
}
