package com.znow.gamecore.entity;

public abstract class Entity
{

	public float x, y, width, height;
	
	public Entity(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update(float time);

};