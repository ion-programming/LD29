package com.ionprogramming.ld29.entities;

import com.ionprogramming.atomic2d.blocks.AnimBlock;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.graphics.Animation;
import com.ionprogramming.ld29.Input;
import com.ionprogramming.ld29.graphics.Images;

public class Player extends AnimBlock{
	
	public Player(float x, float y){
		setImages(Images.player);
		setCurrentImage(0);
		resize(56, 56);
		setLoc(x, y);
		setCentre(28, 28);
		setYAcc(64);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(56, 56);
		c.setFriction(0.25f);
		c.setBounce(0);
		c.setDynamic(false);
		collisionBody = c;
		addAnim(new Animation(new int[]{0, 1}, new float[]{200, 800}, "right"));
		addAnim(new Animation(new int[]{0, 1}, new float[]{400, 600}, "left"));
		addAnim(new Animation(new int[]{0, 1}, new float[]{600, 400}, "rightStill"));
		addAnim(new Animation(new int[]{0, 1}, new float[]{800, 200}, "leftStill"));
	}
	
	@Override
	public void update(){
		if(!(Input.l^Input.r)){
			if(Input.ml){
				if(getCurrentAnimID() != "leftStill"){
					playAnim("leftStill");
				}
			}
			else{
				if(getCurrentAnimID() != "rightStill"){
					playAnim("rightStill");
				}
			}
		}
		else{
			if(Input.ml){
				if(getCurrentAnimID() != "left"){
					playAnim("left");
				}
			}
			else{
				if(getCurrentAnimID() != "right"){
					playAnim("right");
				}
			}
			if(Input.l){
				setXVel(-128);
			}
			else{
				setXVel(128);
			}
		}
		if(Input.j && getYVel() == 0){
			setYVel(-128);
		}
		super.update();
	}
}
