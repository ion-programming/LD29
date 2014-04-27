package com.ionprogramming.ld29;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.ionprogramming.ld29.entities.Projectile;
import com.ionprogramming.ld29.graphics.TitleScreen;

public class Input {
	
	public static boolean l = false;
	public static boolean r = false;
	public static boolean j = false;
	
	public static boolean ml = false;
	
	public static void keyPressed(KeyEvent e){
		if(TitleScreen.showing&&!TitleScreen.ion && !TitleScreen.ld){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				Update.initGame();
				TitleScreen.showing = false;
			}
		}
		else{
			if(e.getKeyCode() == KeyEvent.VK_A){
				l = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_D){
				r = true;
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE){
				j = true;
			}
		}
	}
	
	public static void keyReleased(KeyEvent e){
		if(TitleScreen.showing){
			
		}
		else{
			if(e.getKeyCode() == KeyEvent.VK_A){
				l = false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_D){
				r = false;
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE){
				j = false;
			}
		}
	}
	
	public static void mouse(Applet a){
		MouseAdapter mouseAdapter = new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(TitleScreen.showing){
					//Do nothing... Theres no mouse input here
				}
				else{
					if(e.getButton() == MouseEvent.BUTTON1){
						
						Update.projectiles.add(new Projectile(Update.p.getX(), Update.p.getY(), Update.p.gunType));
					}
					else if(e.getButton() == MouseEvent.BUTTON3){
						
					}
				}
			}
			
			public void mouseMoved(MouseEvent e){
				if(e.getX() < LD29.width/2){
					ml = true;
				}
				else{
					ml = false;
				}
			}
		};
		
		a.addMouseListener(mouseAdapter);
		a.addMouseMotionListener(mouseAdapter);
		
	}
}
