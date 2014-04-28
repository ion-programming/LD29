package com.ionprogramming.ld29.entities;

import java.awt.Graphics;

import com.ionprogramming.atomic2d.blocks.AnimBlock;
import com.ionprogramming.atomic2d.collisionbodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.graphics.Animation;
import com.ionprogramming.ld29.Input;
import com.ionprogramming.ld29.LD29;
import com.ionprogramming.ld29.graphics.Images;

public class Player extends AnimBlock{
	
	public String gunType = "laser";
	
	public static int health = 20;
	public static int maxHealth = 20;
	public static int ammo = 40;
	public static int maxAmmo = 40;
	
	
	public Player(float x, float y){
		setImages(Images.player);
		setCurrentImage(0);
		resize(56, 56);
		setLoc(x, y);
		setCentre(28, 28);
		setYAcc(512);
		BoxCollisionBody c = new BoxCollisionBody();
		c.setSize(56, 56);
		c.setFriction(0.8f);
		c.setBounce(0.1f);
		c.setDynamic(true);
		collisionBody = c;
		setCollisionStats();
		addAnim(new Animation(new int[]{4, 5}, new float[]{250, 250}, "right"));
		addAnim(new Animation(new int[]{6, 7}, new float[]{250, 250}, "left"));
		addAnim(new Animation(new int[]{0, 1}, new float[]{250, 250}, "rightStill"));
		addAnim(new Animation(new int[]{2, 3}, new float[]{250, 250}, "leftStill"));
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
				setXVel(getXVel() - 64);
				if(getXVel() < -256){
					setXVel(-256);
				}
			}
			else{
				setXVel(getXVel() + 64);
				if(getXVel() > 256){
					setXVel(256);
				}
			}
		}
		if(Input.j && Math.abs(getYVel()) <= 5){
			setYVel(-512);
		}
		super.update();
	}
	
	@Override
	public void draw(Graphics g, float w, float h){
		setOffset(- getX() + LD29.width/2 - getWidth()/2, - getY() + LD29.height/2 - getHeight()/2);
		super.draw(g, w, h);
	}
}
