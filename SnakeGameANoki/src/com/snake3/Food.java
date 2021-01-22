package com.snake3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food {
	private Snake snake = new Snake();
	private int foodX; 
	private int foodY; 
	private Board board;
	private Wall wall;
	public Food(int type) {
		wall = new Wall(type);
	}
	public void createFood() {
		Random random = new Random();
		do {
			foodX = random.nextInt((int)(976/25))*25;
		    foodY = random.nextInt((int)(576/25))*25;
		} while (notempty(foodX, foodY));
	    

	    if ((foodX == snake.getSnakeX(0)) && (foodY == snake.getSnakeY(0))) {
	        createFood();
	    }
	}
	
	public void levelFood(int type) {
		wall.levelWall(type);
	}
	
	
	
	private boolean notempty(int x, int y) {
		for (int i = 0; i < snake.getJoints(); i++) {
			if (x == snake.getSnakeX(i) && y == snake.getSnakeY(i)) return true;
			else continue;
		}
		
		for (int i = 0; i < wall.wallX.size(); i++) {
			if (x == wall.wallX.get(i) && y == wall.wallY.get(i)) return true;
			else continue;
		}
		
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(foodX, foodY, board.PIXELSIZE, board.PIXELSIZE);
	}

	public int getFoodX() {
	    return foodX;
	}

	public int getFoodY() {
	    return foodY;
	}
	
	
}
