package com.znow.gamecore;

// import thread	

public class Main implements Runnable
{
	
	public static int width = 300;
	public static int height = width * 16 / 9;
	public static int scale = 3;

	private Thread thread;
	private boolean game_running;
	
	public static void main(String[] args)
	{
		Main game = new Main();
		game.run();
	}

	public synchronized void startGame()
	{
		game_running = true;
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

	}

	public void destroy()
	{

	}
	
};
