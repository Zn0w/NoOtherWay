package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.znow.gamecore.entity.Entity;

public class Renderer extends JPanel
{
	
	int x, y;
	
	public Renderer(Display display)
	{
		//display.window.setContentPane(this);
	}

	public void render(Entity entity/*List<Entity> entities*/)
	{
		x = (int) entity.x;
		y = (int) entity.y;

		/*for (Entity entity : entities)
		{
			renderer.render(Color.GREEN, entity.x, entity.y);
		}*/
	}

	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 50, 50);
	}

};