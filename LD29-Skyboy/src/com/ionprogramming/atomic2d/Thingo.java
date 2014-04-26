package com.ionprogramming.atomic2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ionprogramming.atomic2d.CollisionBodies.BoxCollisionBody;
import com.ionprogramming.atomic2d.Math.Collision;
import com.ionprogramming.atomic2d.blocks.MovingBlock;

public class Thingo {
	
	static MovingBlock b1 = new MovingBlock();
	static BoxCollisionBody c1 = new BoxCollisionBody();
	
	static MovingBlock b2 = new MovingBlock();
	static BoxCollisionBody c2 = new BoxCollisionBody();
	
	public static void init(){
		b1.setImages(new BufferedImage[]{Test.pic});
		b1.setCurrentImage(0);
		b1.setLoc(200, 200);
		b1.setCentre(25, 25);
		b1.resize(50, 50);
		b1.setVel(0, 30);
		c1.setSize(50, 50);
		c1.setFriction(1);
		c1.setBounce(1);
		c1.setDynamic(true);
		b1.collisionBody = c1;
		
		b2.setImages(new BufferedImage[]{Test.pic});
		b2.setCurrentImage(0);
		b2.resize(50, 50);
		b2.setCentre(25, 25);	//local pivot point for rotations
		b2.setLoc(300, 200);	//Top left of object
		b2.setVel(-30, 30);	//Adjust this						  
		c2.setSize(50, 50);
		c2.setFriction(1);	//1 means no friction, 0 means complete friction (all speed in direction of collision tangent is lost)
		c2.setBounce(1);	//1 means full bounce, 0 means no bounce (all speed in direction of collision force is lost)
		c2.setDynamic(true);
		b2.collisionBody = c2;
	}
	
	public static void update(Graphics g){
		b1.update();
		b2.update();
		Collision.collide(b2, b1);
		b1.draw(g);
		b2.draw(g);
	}
}
