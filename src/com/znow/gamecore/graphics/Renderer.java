package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;

class Renderer extends JPanel
{
	
	int x, y;
	
	public Renderer(Display display)
	{
		display.window.setContentPane(this);
	}

	void render(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		//display.window.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 200, 200);
	}

};