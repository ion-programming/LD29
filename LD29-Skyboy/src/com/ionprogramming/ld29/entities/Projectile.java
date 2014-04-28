package com.ionprogramming.ld29.entities;

import com.ionprogramming.atomic2d.blocks.MovingBlock;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.math.GeomMath;
import com.ionprogramming.ld29.Input;
import com.ionprogramming.ld29.LD29;
import com.ionprogramming.ld29.Update;
import com.ionprogramming.ld29.graphics.Images;

public class Projectile extends MovingBlock{
	
	public Projectile(float x, float y, String type){
		setImages(Images.bullet);
		BoxCollisionBody c = new BoxCollisionBody();
		setLoc(x, y);
		if(type == "laser"){
			setCurrentImage(0);
			resize(3,3);
			setCentre(1.5f, 1.5f);
			c.setSize(3, 3);
			float a = GeomMath.angle(Input.mx - LD29.width/2, Input.my - LD29.height/2);
			setVel(GeomMath.rotate(300, a));
			if(Input.ml){
				setX(getX() - 8);
			}
			else{
				setX(getX() + 8);
			}
			Update.p.setVel(Update.p.getXVel() - getXVel(), Update.p.getYVel() - getYVel());
		}
		else if(type == "gun"){
			setCurrentImage(0);
			resize(5,5);
			setCentre(2.5f, 2.5f);
			c.setSize(5, 5);
			float a = GeomMath.angle(Update.p.getX() + Update.p.getXCentre() - getX() - getXCentre(), Update.p.getY() + Update.p.getYCentre() - getY() - getYCentre());
			setVel(GeomMath.rotate(200, a));
		}
		c.setDynamic(false);
		collisionBody = c;
	}
	
	@Override
	public void update(){
		setOffset(Update.p.getOffset().x, Update.p.getOffset().y);
		super.update();
		
	}
}
