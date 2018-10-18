package com.znow.gamecore;

import com.znow.gamecore.graphics.Display;
import com.znow.gamecore.entity.*;

import java.util.ArrayList;

public class Main implements Runnable
{
	
	public static int width = 120;
	public static int height = width * 16 / 9;
	public static int scale = 3;

	private Thread thread;
	private boolean game_running;
	
	Display display;

	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public static void main(String[] args)
	{
		Main game = new Main();
		game.startGame();
	}

	public synchronized void startGame()
	{
		thread= new Thread(this);
		thread.start();
	}

	public synchronized void stopGame()
	{
		try
		{
			thread.join();
		} catch(Exception e)
		{
			e.printStackTrace(System.out);
		}
	}

	@Override
	public void run()
	{
		init();
		
		while (game_running && display.getWindow().isDisplayable())
		{
			update();
			display.render(entities);
		}

		destroy();
	}

	private void update()
	{
		for (Entity entity : entities)
			entity.update(1.0f); // To add delta handling
	}

	private void init()
	{
		game_running = true;
		display = new Display("No Other Way <Game by Zn0w>", width * scale, height * scale);

		entities.add(new Player(80, 30, 100, 100, 0, 255, 0));
		entities.add(new Spike(100, 100, 50, 50, 180, 30, 56));

		System.out.println("Init game");
	}

	private void destroy()
	{
		System.out.println("Destroy game");
	}
	
};
