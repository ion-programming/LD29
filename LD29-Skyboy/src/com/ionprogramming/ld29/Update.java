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
import com.ionprogramming.ld29.entities.Pickup;
import com.ionprogramming.ld29.entities.Player;
import com.ionprogramming.ld29.entities.Projectile;
import com.ionprogramming.ld29.graphics.HUD;
import com.ionprogramming.ld29.graphics.Images;
import com.ionprogramming.ld29.graphics.TitleScreen;
import com.ionprogramming.ld29.map.Map;

public class Update {
	
	public static boolean intro = true;
	public static boolean ended = false;
	
	static Graphics2D g2;
	
	
	public static Player p;
	
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
		p = new Player(0, 0);
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
				if(GeomMath.length(projectiles.get(n).getX() - p.getX(), projectiles.get(n).getY() - p.getY()) > 1000){
					projectiles.remove(projectiles.get(n));
					n--;
				}
				if(n >= 0){
					projectiles.get(n).draw(g, LD29.width, LD29.height);
				}
			}
			p.update();
			for(int n = 0; n < Map.level.size(); n++){
				Collision.collide(p, Map.level.get(n));
				for(int p = 0; p < projectiles.size(); p++){
					if(Collision.collide(projectiles.get(p), Map.level.get(n))){
						projectiles.remove(p);
						p--;
					}
				}
			}
			p.draw(g, LD29.width, LD29.height);

			for(int n = 0; n < pickups.size(); n++){
				pickups.get(n).update();
				pickups.get(n).draw(g, LD29.width, LD29.height);
			}
			
			for(int n = 0; n < cannons.size(); n++){
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
