package com.znow.gamecore.graphics;

import javax.swing.*;
import java.awt.*;

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
		//window.addKeyListener(new Keyboard());
		window.setTitle(title);
		window.pack();
		window.setVisible(true);
	}

};