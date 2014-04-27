package com.ionprogramming.ld29.entities;

import java.util.ArrayList;

import com.ionprogramming.atomic2d.blocks.AnimBlock;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.graphics.Animation;
import com.ionprogramming.ld29.graphics.Images;

public class Player extends AnimBlock{
	
	public Player(float x, float y){
		setImages(Images.player);
		setCurrentImage(0);
		resize(56, 56);
		setLoc(x, y);
		setCentre(28, 28);
		setYAcc(3);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(56, 56);
		c.setFriction(0.25f);
		c.setBounce(0);
		c.setDynamic(false);
		collisionBody = c;
		ArrayList<Animation> a = new ArrayList<Animation>();
//		a.add(new Animation(, , "right"));
//		a.add(new Animation(, , "left"));
//		a.add(new Animation(, , "jump"));
	}
	
	@Override
	public void update(){
		
		super.update();
	}
}
