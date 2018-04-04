package com.znow.gamecore;

import java.util.List;
import java.util.ArrayList;

import com.znow.gamecore.graphics.Display;

import com.znow.gamecore.entity.*;

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

		float previous_time = 0.0f;
		float elapsed_time = 0.0f;
		
		while (game_running && display.window.isDisplayable())
		{
			//previous_time = System.currentTimeMillis();
			//System.out.println("Elapsed time: " + elapsed_time);
			
			update(elapsed_time);
			
			display.render(entities);
			
			elapsed_time = System.currentTimeMillis() - previous_time;
			previous_time = System.currentTimeMillis();
		}
		
		destroy();
	}

	void init()
	{
		display = new Display("Testing", 600, 800);

		game_running = true;

		entities = new ArrayList<Entity>();
		
		// Player init
		Player player = new Player(300, 400, 120, 80);
		entities.add(player);
	}

	void update(float time)
	{
		for (Entity entity : entities)
		{
			entity.update(time);
		}
	}

	void destroy()
	{
		System.out.println("Game has ended");
	}
	
};
