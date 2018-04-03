package com.znow.gamecore.input;

import java.awt.event.*;

public class Keyboard implements KeyListener
{
	
	private static boolean keys[] = new boolean[256];
	
	public static boolean is_key_pressed(int key_code)
	{
		return keys[key_code];
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		keys[event.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		keys[event.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent event)
	{
		
	}
	
};