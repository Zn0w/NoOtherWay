package com.znow.gamecore.entity;

import java.awt.Graphics2D;

public abstract class Entity
{

	public int x, y, width, height;

	public abstract void draw(Graphics2D graphics);

};