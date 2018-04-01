package com.znow.gamecore;

import com.znow.gamecore.graphics.Display;
import com.znow.gamecore.graphics.Renderer;

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

		int i = 0;
		while (game_running && display.window.isDisplayable())
		{
			if (i < 10)
			{
				display.renderer.render(i, i);
				i++;
			}
		}
		
		destroy();
	}

	void init()
	{
		display = new Display("Testing", 600, 800);

		game_running = true;
	}

	void destroy()
	{
		System.out.println("Game has ended");
	}
	
};
