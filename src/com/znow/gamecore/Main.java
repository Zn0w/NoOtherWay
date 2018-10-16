package com.znow.gamecore;

import com.znow.gamecore.graphics.Display;

public class Main implements Runnable
{
	
	public static int width = 150;
	public static int height = width * 16 / 9;
	public static int scale = 3;

	private Thread thread;
	private boolean game_running;
	
	Display display;
	
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
		
		while (game_running)
		{

		}

		destroy();
	}

	public void init()
	{
		game_running = true;
		display = new Display("No Other Way <Game by Zn0w>", width * scale, height * scale);
	}

	public void destroy()
	{

	}
	
};
