package com.ionprogramming.ld29;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LD29 extends Applet implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;

	private Image dbImage;
	private Graphics dbg;
	public int width = 512;
	public int height = 512;
	public Color c = new Color(80, 180, 255);
	
	int angle = 0;
	static BufferedImage pic;

	public void init() {
		setSize(width, height);
		addKeyListener(this);
		setFocusable(true);
		setBackground(c);
		try {
			pic = ImageIO.read(LD29.class.getClassLoader().getResourceAsStream("res/mug.png"));
		} 
		catch (IOException e) {
		}
		Update.initMenu();
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void stop() {
		System.exit(0);
	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			update();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void update() {
		repaint();
	}

	public void paint(Graphics g) {
		Update.updateMenu(g);
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}