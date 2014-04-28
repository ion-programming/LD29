package com.ionprogramming.ld29;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import com.ionprogramming.atomic2d.math.Collision;
import com.ionprogramming.ld29.entities.Cannon;
import com.ionprogramming.ld29.entities.Player;
import com.ionprogramming.ld29.entities.Projectile;
import com.ionprogramming.ld29.graphics.HUD;
import com.ionprogramming.ld29.graphics.Images;
import com.ionprogramming.ld29.graphics.TitleScreen;
import com.ionprogramming.ld29.map.Map;

public class Update {
	
	public static boolean intro = true;
	public static boolean ended = false;
	
	public static Player p;
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	static GradientPaint sky = new GradientPaint(0,0,new Color(0x2980b9),0, 500,new Color(0x194868));
	static GradientPaint mist = new GradientPaint(0,0,new Color(0x40969696, true),0, 500,new Color(0x40CCCCCC, true));
	
	static Graphics2D g2;
	public static Cannon c;
	
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
		c = new Cannon(1024, 256);
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
			
			
			p.update();
			for(int n = 0; n < Map.level.size(); n++){
				Collision.collide(p, Map.level.get(n));
			}
			p.draw(g, LD29.width, LD29.height);
			for(int n = 0; n < projectiles.size(); n++){
				projectiles.get(n).draw(g, LD29.width, LD29.height);
				projectiles.get(n).update();
			}
			
			c.update();
			c.draw(g, LD29.width, LD29.height);
			
			Map.draw(g, LD29.width, LD29.height);
			
			g2.setPaint(mist);
		    g2.fill(new Rectangle2D.Double(0, 0, 800, 500));
			
			HUD.render(g);
			
		}
	}
}
