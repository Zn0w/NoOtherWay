package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.List;

import com.znow.gamecore.entity.Entity;

public class Display
{

	public JFrame window;

	private BufferedImage buffered_image;
	private Graphics2D graphics;
	
	public Display(String title, int width, int height)
	{
		window = new JFrame(title);
		window.setSize(width, height);
		window.getContentPane().setLayout(new FlowLayout());
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		buffered_image = new BufferedImage(600, 800, BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D) buffered_image.getGraphics();
	}

	public void render(List<Entity> entities)
	{
		for (Entity entity : entities)
		{
			entity.draw(graphics);
		}
		
		Graphics temp_g = window.getGraphics();
		temp_g.drawImage(buffered_image, 0, 0, null);
		temp_g.dispose();
	}

};