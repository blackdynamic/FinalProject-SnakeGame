package com.snake3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Wall {
	List<Integer> wallX = new ArrayList<Integer>();
	List<Integer> wallY = new ArrayList<Integer>();
	public int wallSize;
	public int type;

	private Board board;

	public Wall(int type) {
		levelWall(type);
	}
	
	public void levelWall(int type) {
		if (type == 0) {
			wallX.clear();
			wallY.clear();
			wallX.add(-50);
			wallY.add(-50);
		}
		if (type == 1) {
			wallX.clear();
			wallY.clear();
			for (int i = 0; i <= 8; i++) {
				wallX.add(250);
				wallY.add(200 + i * 25);
			}
			for (int i = 0; i <= 8; i++) {
				wallX.add(750);
				wallY.add(200 + i * 25);
			}
		} else if (type == 2) {
			wallX.clear();
			wallY.clear();
			for (int i = 0; i <= 24; i++) {
				wallX.add(0);
				wallY.add(0 + i * 25);
				wallX.add(1000);
				wallY.add(0 + i * 25);
			}
			for (int i = 0; i <= 40; i++) {
				wallX.add(0 + i * 25);
				wallY.add(0);
				wallX.add(0 + i * 25);
				wallY.add(600);
			}
		} else if (type == 3) {
			wallX.clear();
			wallY.clear();
			for (int i = 0; i <= 24; i++) {
				wallX.add(775);
				wallY.add(0 + i * 25);
			}
			for (int i = 0; i <= 10; i++) {
				wallX.add(250);
				wallY.add(175 + i * 25);
			}
			for (int i = 0; i < 12; i++) {
				wallX.add(400 + i * 25);
				wallY.add(175);
				wallX.add(400 + i * 25);
				wallY.add(425);
			}
		} else if (type == 4) {
			wallX.clear();
			wallY.clear();
			for (int i = 0; i <= 9; i++) {
				wallX.add(0);
				wallY.add(0 + i * 25);
				wallX.add(1000);
				wallY.add(0 + i * 25);
				wallX.add(0);
				wallY.add(600 - i * 25);
				wallX.add(1000);
				wallY.add(600 - i * 25);
			}
			for (int i = 0; i <= 15; i++) {
				wallX.add(0 + i * 25);
				wallY.add(0);
				wallX.add(0 + i * 25);
				wallY.add(600);
				wallX.add(1000 - i * 25);
				wallY.add(0);
				wallX.add(1000 - i * 25);
				wallY.add(600);
			}
			for (int i = 0; i <= 20; i++) {
				wallX.add(250 + i * 25);
				wallY.add(250);
				wallX.add(250 + i * 25);
				wallY.add(275);
				wallX.add(250 + i * 25);
				wallY.add(300);
				wallX.add(250 + i * 25);
				wallY.add(325);
				wallX.add(250 + i * 25);
				wallY.add(350);
			}
			for (int i = 0; i <= 24; i++) {
				wallX.add(500);
				wallY.add(0 + i * 25);
			}
			for (int i = 0; i <= 40; i++) {
				wallX.add(0 + i * 25);
				wallY.add(300);
			}
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < wallY.size(); i++) {
			g.setColor(Color.RED);
			g.fillRect(wallX.get(i), wallY.get(i), board.PIXELSIZE, board.PIXELSIZE);
		}
	}
}
