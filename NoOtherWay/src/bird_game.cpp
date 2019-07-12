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
	Entity left_spikes[16];
	Entity right_spikes[16];

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
			left_spikes[i].w = spike_size;
			left_spikes[i].h = spike_size;
			left_spikes[i].y = 50 * i;
			left_spikes[i].x = 0;
		}

		for (int i = 0; i < 16; i++)
		{
			right_spikes[i].w = spike_size;
			right_spikes[i].h = spike_size;
			right_spikes[i].y = 50 * i;
			right_spikes[i].x = level_width;
		}

		updateSpikes(1);

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

			updateSpikes(player_Xspeed);
		}
		printf("%d\n", player_Xspeed);

		if (player.y <= 0 || player.y + player.h >= level_height)
			return false;

		player.x += player_Xspeed;
		player.y += player_Yspeed;

		if (player_Xspeed > 0)
		{
			for (int i = 0; i < 16; i++)
			{
				if (right_spikes[i].active && collide(right_spikes[i], player))
					printf("collision, game over\n");
			}
		}
		else
		{
			for (int i = 0; i < 16; i++)
			{
				if (left_spikes[i].active && collide(left_spikes[i], player))
					printf("collision, game over\n");
			}
		}


		// draw player
		FillRect(player.x, player.y, player.w, player.h, olc::Pixel(50, 200, 120));

		// draw spikes
		for (int i = 0; i < 16; i++)
		{
			if (left_spikes[i].active)
				FillTriangle(
					left_spikes[i].x, left_spikes[i].y,
					left_spikes[i].x, left_spikes[i].y + left_spikes[i].w,
					left_spikes[i].x + left_spikes[i].h, left_spikes[i].y + left_spikes[i].w / 2,
					olc::Pixel(200, 0, 0)
				);
			
			if (right_spikes[i].active)
				FillTriangle(
					right_spikes[i].x, right_spikes[i].y,
					right_spikes[i].x, right_spikes[i].y + right_spikes[i].w,
					right_spikes[i].x - right_spikes[i].h, right_spikes[i].y + right_spikes[i].w / 2,
					olc::Pixel(200, 0, 0)
				);
		}

		return true;
	}

	bool levelCompleted()
	{
		return player.x <= 0 || player.x + player.w >= level_width;
	}

	void updateSpikes(int direction)
	{
		srand((unsigned)time(0));
		int random_index;
		int num_of_spikes = spikes_min + int((spikes_max - spikes_min + 1)*rand() / (RAND_MAX + 1.0));

		int lowest = 0;
		int highest = 16;
		int range = (highest - lowest) + 1;

		if (direction > 0)
		{
			for (int i = 0; i < num_of_spikes; i++)
			{
				random_index = lowest + int(range*rand() / (RAND_MAX + 1.0));
				if (right_spikes[random_index].active)
					right_spikes[random_index].active = false;
				else
					right_spikes[random_index].active = true;
			}
		}
		else
		{
			for (int i = 0; i < num_of_spikes; i++)
			{
				random_index = lowest + int(range*rand() / (RAND_MAX + 1.0));
				if (left_spikes[random_index].active)
					left_spikes[random_index].active = false;
				else
					left_spikes[random_index].active = true;
			} 
		}
	}

	bool collide(Entity e1, Entity e2)
	{
		return	e1.x < e2.x + e2.w &&
			e1.x + e1.w > e2.x &&
			e1.y < e2.y + e2.h &&
			e1.y + e1.h > e2.y;
	}
};

int main()
{
	Game game;
	if (game.Construct(level_width, level_height, 1, 1))
		game.Start();
}