package com.znow.gamecore;

import java.util.List;
import java.util.ArrayList;

import com.znow.gamecore.graphics.Display;

import com.znow.gamecore.entity.Entity;

public class Main
{
	
	public boolean game_running;
	private Display display;

	//private Entity player; Player player;
	private List<Entity> entities;
	
	public static void main(String[] args)
	{
		Main game = new Main();
		game.run();
	}

	void run()
	{
		init();

		while (game_running && display.window.isDisplayable())
		{
			display.render(entities);
		}
		
		destroy();
	}

	void init()
	{
		display = new Display("Testing", 600, 800);

		game_running = true;

		entities = new ArrayList<Entity>();
	}

	void update()
	{
		// player.update();
		// for entities entity.update();
	}

	void destroy()
	{
		System.out.println("Game has ended");
	}
	
};
