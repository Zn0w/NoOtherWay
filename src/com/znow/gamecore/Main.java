package com.znow.gamecore;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable
{

	public static int SCREEN_WIDTH = 400;
	public static int SCREEN_HEIGHT = 400 / 16 * 9;		// 16:9 screen aspect ratio
	public static int SCREEN_SCALE = 3;

	private Thread game_thread;
	private boolean running = false;

	private JFrame frame;
	private BufferedImage bi = new BuffredImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);

	public Main()
	{
		initGraphics();
	}

	private void initGraphics()
	{
		setPreferredSize(new Dimension(SCREEN_WIDTH * SCREEN_SCALE, SCREEN_HEIGHT * SCREEN_SCALE));
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("No Other Way (development version)");
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public synchronized void start()
	{
		running = true;
		game_thread = new Thread(this);
		game_thread.start();
	}

	public synchronized void stop()
	{
		try {
			game_thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		while (running && frame.isDisplayable())
		{
			update();
			render();
		}

		stop();
		System.out.println("Game stopped");
	}

	private void update()
	{

	}

	private void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());		// background
		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.start();
	}

};