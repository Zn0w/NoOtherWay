package com.znow.gamecore.input;

import java.awt.event.*;

public class Keyboard implements KeyListener
{
	
	private static boolean keys[] = new boolean[256];
	
	public static boolean is_key_pressed()
	{
		return true;
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_F)
			System.out.println("Key F is pressed!");
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		
	}
	
};