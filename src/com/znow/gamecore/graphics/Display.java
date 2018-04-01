package com.znow.gamecore.graphics;

import javax.swing.*;

public class Display
{

	public JFrame window;
	int x, y;
	public Renderer renderer;
	
	public Display(String title, int width, int height)
	{
		window = new JFrame(title);
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		init_renderer();
	}

	private void init_renderer()
	{
		renderer = new Renderer(this);
		renderer.render(0, 0);
	}

};