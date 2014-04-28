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
	public int type = 0;
	
	public Cannon(int t, float x, float y){
		
		type = t;
		setImages(new BufferedImage[]{Images.cannon});
		
		setLoc(x, y);
		
		BoxCollisionBody c = new BoxCollisionBody();
		
		if(type == 0){
			resize(64, 64);
			setCentre(32, 48);
			c.setSize(32, 32);
		}
		else if(type == 1){
			resize(256, 256);
			setCentre(128, 192);
			c.setSize(128, 128);
		}
		c.setFriction(1);
		c.setBounce(1);
		c.setFixed(true);
		c.setDynamic(false);
		collisionBody = c;
		setCollisionStats();
	}
	
	public void update(){
		setOffset(Update.p.getOffset().x, Update.p.getOffset().y);
		if(type == 1 && GeomMath.length(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre()) < 2000){
			rot = GeomMath.angle(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), -(Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre())) + 90;
			if(type == 0){
				setRotation((float)Math.toRadians(rot), 32, 48);
			}
			else{
				setRotation((float)Math.toRadians(rot), 128, 192);
			}
			time--;
			if(time <= 0){
				Update.projectiles.add(new Projectile(getX() + getXCentre(), getY() + getYCentre(), "bbg"));
				time = 50;
			}
		}
		else if(GeomMath.length(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre()) < 400){
			rot = GeomMath.angle(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), -(Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre())) + 90;
			if(type == 0){
				setRotation((float)Math.toRadians(rot), 32, 48);
			}
			else{
				setRotation((float)Math.toRadians(rot), 128, 192);
			}
			time--;
			if(time <= 0){
				Update.projectiles.add(new Projectile(getX() + getXCentre(), getY() + getYCentre(), "gun"));
				time = 20;
			}
		}
	}
}
