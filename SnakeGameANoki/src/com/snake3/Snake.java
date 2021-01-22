package com.snake3;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	private final int[] x = new int[Board.getAllDots()];
	private final int[] y = new int[Board.getAllDots()];
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	public Color snakeColor;

	private int joints = 0; 				
	
	private Board board;
	
    public void SnakeColor(Color sColor) {
    	this.snakeColor = sColor;
    }
    
	public void draw(Graphics g, Color snakeColor) {
		for (int i = 0; i < this.joints; i++) {
			if (i == 0) {
				g.setColor(snakeColor);
				g.fillRect(x[i], y[i], board.PIXELSIZE, board.PIXELSIZE);
			} else {
				g.setColor(snakeColor);
        		g.fillRect(x[i], y[i], board.PIXELSIZE, board.PIXELSIZE);
        	}
		}
	}
	
	public int getSnakeX(int index) {
	    return x[index];
	}

	public int getSnakeY(int index) {
	    return y[index];
	}

	public void setSnakeX(int i) {
	    x[0] = i;
	}

	public void setSnakeY(int i) {
	    y[0] = i;
	}

	public boolean isMovingLeft() {
	    return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
	    this.movingLeft = movingLeft;
	}

	public boolean isMovingRight() {
	    return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
	    this.movingRight = movingRight;
	}

	public boolean isMovingUp() {
	    return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
	    this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
	    return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
	    this.movingDown = movingDown;
	}

	public int getJoints() {
	    return joints;
	}

	public void setJoints(int j) {
	    joints = j;
	}
	
	public boolean collide(boolean inGame, Wall wall, Food food) {
		for (int i = this.joints; i > 0; i--) {
			if ((this.x[0]  == this.x[i]) && (this.y[0]  == this.y[i] )) {
				return true;
			}
		}
		
		for (int i = 0; i < wall.wallY.size(); i++) {
			if (this.x[0] == wall.wallX.get(i) && this.y[0] == wall.wallY.get(i)) {
				return true;
			}
		}

		for (int i = 0;i < getJoints(); i++) {
			if (this.x[i] < 0) {
				this.x[i] = board.BOARDWIDTH - 25;
			}
			else if (this.x[i] >= board.BOARDWIDTH) {
				this.x[i] = 0;
			}
			else if (this.y[i] < 0) {
				this.y[i] = board.BOARDHEIGHT - 25;
			}
			else if (this.y[i] >= board.BOARDHEIGHT) {
				this.y[i] = 0;
			}
			if ((x[0] == food.getFoodX() && y[0] == food.getFoodY())) foodCollision(food);
		}
		
		return false;
		
	}
	
	public boolean foodCollision(Food food) {
		if ((x[0] == food.getFoodX() && y[0] == food.getFoodY())) {
			setJoints(getJoints() + 1);
			food.createFood();
			return true;
		}
		return false;
	}
	

	public void move() {
	    for (int i = joints; i > 0; i--) {
	        x[i] = x[(i - 1)];
	        y[i] = y[(i - 1)];
	    }

	    if (movingLeft) {
	        x[0] -= Board.getDotSize();
	    }
	    if (movingRight) {
	        x[0] += Board.getDotSize();
	    }
	    if (movingDown) {
	        y[0] += Board.getDotSize();
	    }
	    if (movingUp) {
	        y[0] -= Board.getDotSize();
	    }
	    
	}
}
