package com.ionprogramming.ld29;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ionprogramming.ld29.graphics.HUD;
import com.ionprogramming.ld29.sfx.Sound;

public class Window extends JFrame {
	static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public static boolean isWindow = false;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					isWindow = true;
					
					Sound.hurt = Applet.newAudioClip(Window.class.getResource("/res/hurt.wav"));
					Sound.shoot = Applet.newAudioClip(Window.class.getResource("/res/shoot.wav"));
					Sound.noammo = Applet.newAudioClip(Window.class.getResource("/res/noammo.wav"));
					Sound.jump = Applet.newAudioClip(Window.class.getResource("/res/jump.wav"));
					Sound.intro = Applet.newAudioClip(Window.class.getResource("/res/intro.wav"));
					Sound.music = Applet.newAudioClip(Window.class.getResource("/res/music.wav"));
					
					HUD.f = Font.createFont(Font.TRUETYPE_FONT, new BufferedInputStream(Window.class.getResource("/res/NOVASQUARE.TTF").openStream()));
					
					Window frame = new Window();
					frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		LD29 game = new LD29();
		setTitle("Skyboy - LD29 - Ion Programming");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, LD29.width + 6, LD29.height + 26);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(game);
		game.setVisible(true);
		
		
		
		game.init();
		game.start();
	}
}