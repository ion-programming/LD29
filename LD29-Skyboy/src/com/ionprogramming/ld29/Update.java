package com.ionprogramming.ld29;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.ionprogramming.atomic2d.math.Collision;
import com.ionprogramming.ld29.entities.Player;
import com.ionprogramming.ld29.entities.Projectile;
import com.ionprogramming.ld29.graphics.HUD;
import com.ionprogramming.ld29.graphics.Images;
import com.ionprogramming.ld29.graphics.TitleScreen;
import com.ionprogramming.ld29.map.Map;

public class Update {
	
	public static boolean intro = true;
	
	public static Player p;
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
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
		}
		else{
			p.update();
			for(int n = 0; n < Map.level.size(); n++){
				Collision.collide(p, Map.level.get(n));
			}
			p.draw(g, LD29.width, LD29.height);
			for(int n = 0; n < projectiles.size(); n++){
				projectiles.get(n).update();
				projectiles.get(n).draw(g, LD29.width, LD29.height);
			}
			Map.draw(g, LD29.width, LD29.height);
			HUD.render(g);
		}
	}
}
