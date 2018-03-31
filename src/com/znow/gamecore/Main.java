package com.znow.gamecore;

import com.znow.gamecore.graphics.Display;

public class Main
{
	
	public boolean game_running;
	private Display display;
	
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
			
		}
		
		destroy();
	}

	void init()
	{
		display = new Display("Testing", 680, 800);

		game_running = true;
	}

	void destroy()
	{
		System.out.println("Game has ended");
	}
	
};
