package com.znow.gamecore.entity;

import java.awt.event.KeyEvent;

import com.znow.gamecore.input.*;

public class Player extends Entity
{
	
	private float speed_x = 0.0001f;
	private float speed_y = 0.0f;
	
	public Player(float x, float y, float width, float height, int color_r, int color_g, int color_b)
	{
		super(x, y, width, height, color_r, color_g, color_b);
	}
	
	@Override
	public void update(float time)
	{
		/*x += speed_x;
		//y+= speed_y;
		
		if (x + width >= 600 || x <= 0)
			speed_x *= -1;
		
		if (Keyboard.is_key_pressed(KeyEvent.VK_F))
		{
			y += 0.01f * time;
			System.out.println("X: " + x + " Y: " + y);
		}*/

		if (Keyboard.is_key_pressed(KeyEvent.VK_F))
			System.out.println("F key is pressed!");
	}
	
}
