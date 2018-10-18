package com.znow.gamecore.entity;

public abstract class Entity
{

	public float x, y, width, height;
	public int color_r, color_g, color_b;
	
	public Entity(float x, float y, float width, float height, int color_r, int color_g, int color_b)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.color_r = color_r;
		this.color_g = color_g;
		this.color_b = color_b;
	}
	
	public abstract void update(float time);

};