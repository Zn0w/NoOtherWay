package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import java.util.ArrayList;

import com.znow.gamecore.entity.*;
import com.znow.gamecore.input.Keyboard;

@SuppressWarnings("serial")
public class Display extends Canvas
{

	public JFrame window;
	
	public Display(String title, int width, int height)
	{
		setPreferredSize(new Dimension(width, height));
		
		window = new JFrame(title);
		window.add(this);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.addKeyListener(new Keyboard());
		window.setTitle(title);
		window.pack();
		window.setVisible(true);
	}

	public void render(ArrayList<Entity> entities)
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// Set white background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (Entity entity : entities)
		{
			g.setColor(Color.GREEN);
			g.fillRect(
				(int) entity.x, 
				(int) entity.y, 
				(int) (entity.x + entity.width), 
				(int) (entity.y + entity.height)
			);
		}

		g.dispose();
		bs.show();
	}

};