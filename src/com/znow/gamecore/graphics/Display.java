package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;

import java.util.List;

import com.znow.gamecore.entity.Entity;
import com.znow.gamecore.input.*;

@SuppressWarnings("serial")
public class Display extends JPanel
{

	public JFrame window;

	private List<Entity> entity_buffer;
	
	public Display(String title, int width, int height)
	{
		window = new JFrame(title);
		window.setSize(width, height);
		window.setContentPane(this);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.addKeyListener(new Keyboard());
		window.setVisible(true);
	}

	public void render(List<Entity> entities)
	{
		entity_buffer = entities;
		repaint();
		//entity_buffer = null;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Clear display
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, window.getWidth(), window.getHeight());

		g.setColor(Color.GREEN);
		
		for (Entity entity : entity_buffer)
		{
			g.fillRect(entity.x, entity.y, entity.width, entity.height);
		}
	}

};