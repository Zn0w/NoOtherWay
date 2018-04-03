package com.znow.gamecore.entity;

import java.awt.event.KeyEvent;

import com.znow.gamecore.input.*;

public class Player extends Entity
{
	
	public Player(float x, float y, float width, float height)
	{
		super(x, y, width, height);
	}
	
	@Override
	public void update()
	{
		if (Keyboard.is_key_pressed(KeyEvent.VK_F))
		{
			y += 0.01f;
			System.out.println("X: " + x + " Y: " + y);
		}
	}
	
}
