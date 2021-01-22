
package com.snake3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Board extends JPanel {
	public final static int BOARDWIDTH = 1025;
	public final static int BOARDHEIGHT = 625;
	public final static int PIXELSIZE = 25;
	private final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT) / (PIXELSIZE * PIXELSIZE);
	public boolean inGame = false;
	private static int speed = 60;
	public int foodEaten;
	private Snake snake = new Snake();
	private Food food;
	private Wall wall;
	private MainMenu menu;
	private int startX = 100;
	private int startY = 100;
	public int level;

	public Board(int type) {

		// add(new Game());
		// menu.level = way;

		// this.menu.level = way;
		// if (menu.getLevel() == 2)
		wall = new Wall(type);

		food = new Food(type);

		initializeGame();

		this.foodEaten = 0;

		addKeyListener(new Keys());
		setBackground(Color.BLACK);

		setFocusable(true);
		setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));

//		 mainMenu
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);

	}
	/*
	 * void Gamonian(int type) { // menu.level = type; add(new Board(type)); }
	 */

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	void draw(Graphics g) {

		// for menu
		if (menu.active) {
			menu.draw(g);
			if (menu.show) {
				menu.drawChooseLevel(g);
				if (menu.showAgain) {
					menu.drawChooseColor(g);
					if (menu.showStart) {
						menu.drawStartGame(g);
					}
				}
			}
		} else if (inGame) {
			food.draw(g);
			snake.draw(g, menu.snakeColor);
			wall.draw(g);
			Toolkit.getDefaultToolkit().sync();
		} else
			endGame(g);

	}

	void initializeGame() {
		menu = new MainMenu(this);

		menu.active = true;
		snake.setJoints(3);
		this.foodEaten = 0;
		for (int i = 0; i < snake.getJoints(); i++) {
			snake.setSnakeX(this.startX);
			snake.setSnakeY(this.startY);
		}

		snake.setMovingRight(true);
		food.createFood();
	}

	public synchronized void start() {
		inGame = true;
		Thread gameThread = new Thread() {
			public void run() {
				while (inGame) {
					isRunning();
					repaint();
					try {
						Thread.sleep(3600 / speed);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		gameThread.start();
	}

	void endGame(Graphics g) {
		String message = "Game over, you eat " + (this.foodEaten);
		String message1 = "Press enter to restart, x to exit";
		Font font = new Font("Times New Roman", Font.BOLD, 21);
		Font font1 = new Font("Calibri", Font.ITALIC, 14);
		FontMetrics metrics = getFontMetrics(font);
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString(message, (BOARDWIDTH - metrics.stringWidth(message)) / 2, BOARDHEIGHT / 2);
		g.setFont(font1);
		g.drawString(message1, (BOARDWIDTH - metrics.stringWidth(message1)) / 2 + 45, 3 * BOARDHEIGHT / 5);
	}

	public void isRunning() {

		wall.levelWall(menu.level);
		food.levelFood(menu.level);

		if (inGame == true) {
			if (!menu.active) {
				if (snake.foodCollision(food))
					this.foodEaten++;
				if (snake.collide(inGame, wall, food) == true) {
					inGame = false;
				}
				snake.move();
			}
			repaint();
		}
	}

	private class Keys extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!snake.isMovingRight())) {
				snake.setMovingLeft(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			} else if ((key == KeyEvent.VK_RIGHT) && (!snake.isMovingLeft())) {
				snake.setMovingRight(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			} else if ((key == KeyEvent.VK_UP) && (!snake.isMovingDown())) {
				snake.setMovingUp(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			} else if ((key == KeyEvent.VK_DOWN) && (!snake.isMovingUp())) {
				snake.setMovingDown(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			}
			if ((key == KeyEvent.VK_ENTER) && (inGame == false)) {
				reset();
				repaint();
				start();
			} else if ((key == KeyEvent.VK_X) && (inGame == false)) {
				snake.setMovingDown(false);
				snake.setMovingLeft(false);
				snake.setMovingUp(false);
				snake.setMovingRight(false);
				System.exit(0);
			}
		}
	}

	void reset() {
		this.foodEaten = 0;
		snake.setJoints(3);
		snake.setSnakeX(150);
		snake.setSnakeY(150);
		snake.setMovingDown(false);
		snake.setMovingLeft(false);
		snake.setMovingUp(false);
		snake.setMovingRight(true);
		food.createFood();
	}

	public static int getAllDots() {
		return TOTALPIXELS;
	}

	public static int getDotSize() {
		return PIXELSIZE;
	}

}
