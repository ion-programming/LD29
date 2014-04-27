package com.ionprogramming.ld29.entities;

import com.ionprogramming.atomic2d.blocks.MovingBlock;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.ld29.Input;
import com.ionprogramming.ld29.graphics.Images;

public class Projectile extends MovingBlock{
	
	public Projectile(float x, float y, String type){
		if(type == "laser"){
			setImages(Images.dirt);
		}
		else if(type == "gun"){
			setImages(Images.dirt);
		}
		setCurrentImage(0);
		resize(10,2);
		setLoc(x, y);
		setCentre(5, 1);
		if(Input.ml){
			setXVel(-200);
		}
		else{
			setXVel(200);
		}
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(10,2);
		c.setDynamic(false);
		collisionBody = c;
	}
	
	@Override
	public void update(){
		
		super.update();
	}
}
