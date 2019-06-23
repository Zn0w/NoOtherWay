#pragma once

#define OLC_PGE_APPLICATION

#include "olcPixelGameEngine.h"

#include <stdio.h>
#include <cstdlib>
#include <ctime>

int level_width = 450;
int level_height = 800;

int jump_force = 10;
int jump_duration = 10;
int player_Xspeed = 5;
int player_Yspeed = 5;
int player_size = 50;

int spike_size = 50;
int spikes_max = 5;
int spikes_min = 3;

struct Entity
{
	int x, y, w, h;
	bool active;
};

class Game : public olc::PixelGameEngine
{

public:
	Game()
	{
		sAppName = "Example";
	}

private:
	Entity player;
	int jump_effect = 0;
	Entity spikes[32];

public:
	bool OnUserCreate() override
	{
		// Called once at the start, so create things here

		player.x = level_width / 2;
		player.y = level_height / 2;
		player.w = player_size;
		player.h = player_size;
		player.active = true;

		for (int i = 0; i < 16; i++)
		{
			spikes[i].w = spike_size;
			spikes[i].h = spike_size;
			spikes[i].y = 50 * i;
			spikes[i].x = 0;
		}

		for (int i = 16; i < 32; i++)
		{
			spikes[i].w = spike_size;
			spikes[i].h = -1 * spike_size;
			spikes[i].y = 50 * (i - 16);
			spikes[i].x = level_width;
		}

		updateSpikes();

		return true;
	}

	bool OnUserUpdate(float fElapsedTime) override
	{
		// called once per frame


		// clear screen
		for (int x = 0; x < ScreenWidth(); x++)
			for (int y = 0; y < ScreenHeight(); y++)
				Draw(x, y, olc::Pixel(250, 250, 250));


		// update player
		olc::HWButton jump_key;
		jump_key = GetKey(olc::SPACE);
		if (jump_key.bPressed)
			jump_effect = jump_duration;

		if (jump_effect > 0)
		{
			player.y -= jump_force;
			jump_effect--;
		}

		if (levelCompleted())
		{
 			player_Xspeed *= -1;

			// increase the x speed by absolute value
			if (player_Xspeed > 0)
				player_Xspeed++;
			else
				player_Xspeed--;

			updateSpikes();
		}
		printf("%d\n", player_Xspeed);

		if (player.y <= 0 || player.y + player.h >= level_height)
			return false;

		player.x += player_Xspeed;
		player.y += player_Yspeed;


		// draw player
		FillRect(player.x, player.y, player.w, player.h, olc::Pixel(50, 200, 120));

		// draw spikes
		for (int i = 0; i < 32; i++)
		{
			if (spikes[i].active)
				FillTriangle(
					spikes[i].x, spikes[i].y,
					spikes[i].x, spikes[i].y + spikes[i].w,
					spikes[i].x + spikes[i].h, spikes[i].y + spikes[i].w / 2,
					olc::Pixel(200, 0, 0)
				);
		}

		return true;
	}

	bool levelCompleted()
	{
		return player.x <= 0 || player.x + player.w >= level_width;
	}

	void updateSpikes()
	{
		srand((unsigned)time(0));
		int random_index;
		int num_of_spikes = spikes_min + int((spikes_max - spikes_min + 1)*rand() / (RAND_MAX + 1.0));

		int lowest = 0;
		int highest = 32;
		int range = (highest - lowest) + 1;

		for (int i = 0; i < num_of_spikes; i++)
		{
			random_index = lowest + int(range*rand() / (RAND_MAX + 1.0));
			if (spikes[random_index].active)
				spikes[random_index].active = false;
			else
				spikes[random_index].active = true;
		}
	}
};

int main()
{
	Game game;
	if (game.Construct(level_width, level_height, 1, 1))
		game.Start();
}