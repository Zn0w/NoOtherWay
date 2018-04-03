package com.znow.gamecore.entity;

//import java.awt.Graphics;

public abstract class Entity
{

	public int x, y, width, height;
	
	public Entity(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	//public abstract void draw(Graphics g); I may not need it
	
	public abstract void update();

};