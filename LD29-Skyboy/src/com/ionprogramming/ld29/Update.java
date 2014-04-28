package com.ionprogramming.ld29;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import com.ionprogramming.atomic2d.math.Collision;
import com.ionprogramming.atomic2d.math.GeomMath;
import com.ionprogramming.ld29.entities.Cannon;
import com.ionprogramming.ld29.entities.City;
import com.ionprogramming.ld29.entities.Pickup;
import com.ionprogramming.ld29.entities.Player;
import com.ionprogramming.ld29.entities.Projectile;
import com.ionprogramming.ld29.entities.Ship;
import com.ionprogramming.ld29.graphics.HUD;
import com.ionprogramming.ld29.graphics.Images;
import com.ionprogramming.ld29.graphics.TitleScreen;
import com.ionprogramming.ld29.map.Map;
import com.ionprogramming.ld29.sfx.Sound;

public class Update {
	
	public static boolean intro = true;
	public static boolean ended = false;
	
	static Graphics2D g2;
	
	
	public static Player p;
	
	public static Ship ship;
	
	public static City city;
	
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static ArrayList<Pickup> pickups = new ArrayList<Pickup>();
	public static ArrayList<Cannon> cannons = new ArrayList<Cannon>();
	
	static GradientPaint sky = new GradientPaint(0,0,new Color(0x2980b9),0, 500,new Color(0x194868));
	static GradientPaint mist = new GradientPaint(0,0,new Color(0x40969696, true),0, 500,new Color(0x40CCCCCC, true));
	
	public static void initMenu(){
		TitleScreen.init();
	}
	
	public static void updateMenu(Graphics g){
		TitleScreen.update();
		TitleScreen.render(g);
	}
	
	public static void initGame(){
		Map.load(Images.map);
		Sound.music.stop();
		Sound.music.loop();
		Sound.intro.stop();
	}
	
	public static void updateGame(Graphics g){
		if(intro){
			g.setColor(Color.black);
			g.fillRect(0, 0, LD29.width, LD29.height);
			g.drawImage(Images.intro, 0, 0, null);
			g2 = (Graphics2D) g;
		}
		else if(ended){
			g.setColor(Color.black);
			g.fillRect(0, 0, LD29.width, LD29.height);
			g.drawImage(Images.ending, 0, 0, null);
		}
		else{
			
			//gradient
			g2.setPaint(sky);
		    g2.fill(new Rectangle2D.Double(0, 0, 800, 500));
			
			for(int n = 0; n < projectiles.size(); n++){
				projectiles.get(n).update();
				if(projectiles.get(n).type == "bbg" && GeomMath.length(projectiles.get(n).getX() - p.getX(), projectiles.get(n).getY() - p.getY()) > 4000){
					projectiles.remove(projectiles.get(n));
					n--;
				}
				else if(GeomMath.length(projectiles.get(n).getX() - p.getX(), projectiles.get(n).getY() - p.getY()) > 1000){
					projectiles.remove(projectiles.get(n));
					n--;
				}
				if(n >= 0){
					projectiles.get(n).draw(g, LD29.width, LD29.height);
					if(Collision.checkCollide(p, projectiles.get(n)) && projectiles.get(n).type != "laser"){
						projectiles.remove(n);
						Player.health--;
						Sound.hurt.play();
						n--;
					}
					else{
						for(int c = 0; c < cannons.size(); c++){
							if(n >= 0){
								if(Collision.checkCollide(cannons.get(c), projectiles.get(n)) && projectiles.get(n).type == "laser"){
									projectiles.remove(n);
									cannons.get(c).health -= 2;
									n--;
								}
							}
						}
					}
				}
			}
			for(int n = 0; n < pickups.size(); n++){
				if(Collision.checkCollide(p, pickups.get(n))){
					if(pickups.get(n).type == 0){
						Player.health += 4;
						if(Player.health > Player.maxHealth){
							Player.health = Player.maxHealth;
						}
					}
					if(pickups.get(n).type == 1){
						Player.ammo += 10;
						if(Player.ammo > Player.maxAmmo){
							Player.ammo = Player.maxAmmo;
						}
					}
					pickups.remove(n);
				}
			}
			p.update();
			for(int n = 0; n < Map.level.size(); n++){
				Collision.collide(p, Map.level.get(n));
				for(int p = 0; p < projectiles.size(); p++){
					if(Collision.checkCollide(projectiles.get(p), Map.level.get(n))){
						projectiles.remove(p);
						p--;
					}
				}
			}
			p.draw(g, LD29.width, LD29.height);
			ship.draw(g, LD29.width, LD29.height);
			if(Collision.collide(p, city)){
				ended = true;
			}
			city.draw(g, LD29.width, LD29.height);
			
			for(int n = 0; n < pickups.size(); n++){
				pickups.get(n).update();
				pickups.get(n).draw(g, LD29.width, LD29.height);
			}
			
			for(int n = 0; n < cannons.size(); n++){
				if(cannons.get(n).health <= 0){
					cannons.remove(n);
					n--;
				}
				cannons.get(n).update();
				cannons.get(n).draw(g, LD29.width, LD29.height);
			}
			
			Map.draw(g, LD29.width, LD29.height);
			
			g2.setPaint(mist);
		    g2.fill(new Rectangle2D.Double(0, 0, 800, 500));
			
			HUD.render(g);
			
		}
	}
}
