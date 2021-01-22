package com.snake3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends MouseAdapter {

	public boolean active; // true if main menu is displaying
	public boolean show; // true if main menu is displaying
	public boolean showAgain; // true if main menu is displaying
	public boolean showStart; // true if main menu is displaying
	public int level; // true if main menu is displaying
	
	public Color snakeColor;
	// Play button
	private Rectangle playBtn; // Play Button
	private String playTxt = "Play";
	private boolean pHighlight = false; // true if the mouse hovered over the Play button

	// Quit button
	private Rectangle quitBtn;
	private String quitTxt = "Quit";
	private boolean qHighlight = false;

	// extra button
	private Rectangle lvl0Rec;
	private String lvl0Txt = "NOOB";
	private boolean lvl0H = false;

	private Rectangle lvl1Rec;
	private String lvl1Txt = "EASY";
	private boolean lvl1H = false;

	private Rectangle lvl2Rec;
	private String lvl2Txt = "NORMAL";
	private boolean lvl2H = false;

	private Rectangle lvl3Rec;
	private String lvl3Txt = "HARD";
	private boolean lvl3H = false;

	private Rectangle lvl4Rec;
	private String lvl4Txt = "EXPERT";
	private boolean lvl4H = false;
	
	private Rectangle col1Rec;
	private String col1Txt = ".";
	private boolean col1H = false;
	
	private Rectangle col2Rec;
	private String col2Txt = ".";
	private boolean col2H = false;
	
	private Rectangle col3Rec;
	private String col3Txt = ".";
	private boolean col3H = false;

	private Rectangle startRec;
	private String startTxt = "START";
	private boolean startH = false;
	
	private Rectangle chooseColorRec;
	private String chooseColorTxt = "Choose Your Fighter";
	
	private Font font;
	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	
	int strWidth, strHeight;
	/**
	 * constructor
	 * 
	 * @param game - the Game object
	 */
	public MainMenu(Board board) {
		// public MainMenu() {
		active = true;
		show = false;
		showAgain = false;

		// position and dimensions of each button
		int x, y, w, h;

		w = 250;
		h = 150;

		y = Board.BOARDHEIGHT / 2 - h / 2;

		x = Board.BOARDWIDTH / 4 - w / 2;
		playBtn = new Rectangle(x, y / 4, 300, h);

		x = Board.BOARDWIDTH * 3 / 4 - w / 2;
		quitBtn = new Rectangle(x, y / 4, 300, h);

		x = Board.BOARDWIDTH / 4 - w / 2 + 100;
		lvl0Rec = new Rectangle(x, y, w, h / 2);

		lvl1Rec = new Rectangle(x, 4 * y / 3, w, h / 2);

		lvl2Rec = new Rectangle(x, 5 * y / 3, w, h / 2);

		lvl3Rec = new Rectangle(x, 2 * y, w, h / 2);

		lvl4Rec = new Rectangle(x, 7 * y / 3, w, h / 2);
		
		x = Board.BOARDWIDTH / 4 - 15 ;
		y = y + 100;
		col1Rec = new Rectangle(4 * x - 290,  y , w/3, h / 2);
		
		col2Rec = new Rectangle(4 * x - 200,  y , w/3, h / 2);
		
		col3Rec = new Rectangle(4 * x - 110,  y , w/3, h / 2);

		startRec = new Rectangle(4 * x - 240, y + 200 , 2 * w / 3, h / 2);
		
		chooseColorRec = new Rectangle(4 * x - 260, y - 70 ,  w, h / 2);

		font = new Font("Roboto", Font.PLAIN, 100);
		font1 = new Font("Arial", Font.CENTER_BASELINE, 50);
		font2 = new Font("bodoni mt", Font.CENTER_BASELINE, 200);
		font3 = new Font("Cambria", Font.CENTER_BASELINE, 50);
		font4 = new Font("Chiller", Font.CENTER_BASELINE, 50);
		board.start();

	}


	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g.setFont(font);

		g.setColor(Color.black);
		if (pHighlight)	g.setColor(Color.white);
		g2d.fill(playBtn);

		g.setColor(Color.black);
		if (qHighlight)	g.setColor(Color.white);
		g2d.fill(quitBtn);

		int strWidth, strHeight;

		strWidth = g.getFontMetrics(font).stringWidth(playTxt);
		strHeight = g.getFontMetrics(font).getHeight();

		g.setColor(Color.green);
		g.drawString(playTxt, (int) (playBtn.getX() + playBtn.getWidth() / 2 - strWidth / 2),
				(int) (playBtn.getY() + playBtn.getHeight() / 2 + strHeight / 4));

		g.setColor(Color.red);
		g.drawString(quitTxt, (int) (quitBtn.getX() + quitBtn.getWidth() / 2 - strWidth / 2),
				(int) (quitBtn.getY() + quitBtn.getHeight() / 2 + strHeight / 4));

	}

	public void drawChooseLevel(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		if (lvl0H) g.setColor(Color.white);
		g2d.fill(lvl0Rec);

		g.setColor(Color.black);
		if (lvl1H) g.setColor(Color.white);
		g2d.fill(lvl1Rec);

		g.setColor(Color.black);
		if (lvl2H) g.setColor(Color.white);
		g2d.fill(lvl2Rec);

		g.setColor(Color.black);
		if (lvl3H)	g.setColor(Color.white);
		g2d.fill(lvl3Rec);
		
		g.setColor(Color.black);
		if (lvl4H) g.setColor(Color.white);
		g2d.fill(lvl4Rec);
	
		g.setFont(font1);
		strWidth = g.getFontMetrics(font1).stringWidth(lvl2Txt);
		strHeight = g.getFontMetrics(font1).getHeight();

		g.setColor(Color.blue);

		// Level 0 Button text
		g.drawString(lvl0Txt, (int) (lvl0Rec.getX() + lvl0Rec.getWidth() / 2 - strWidth / 2),
				(int) (lvl0Rec.getY() + lvl0Rec.getHeight() / 2 + strHeight / 4));

		// Level 1 Button text
		g.drawString(lvl1Txt, (int) (lvl1Rec.getX() + lvl1Rec.getWidth() / 2 - strWidth / 2),
				(int) (lvl1Rec.getY() + lvl1Rec.getHeight() / 2 + strHeight / 4));

		// Level 2 Button text
		g.drawString(lvl2Txt, (int) (lvl2Rec.getX() + lvl2Rec.getWidth() / 2 - strWidth / 2),
				(int) (lvl2Rec.getY() + lvl2Rec.getHeight() / 2 + strHeight / 4));

		// Level 3 Button text
		g.drawString(lvl3Txt, (int) (lvl3Rec.getX() + lvl3Rec.getWidth() / 2 - strWidth / 2),
				(int) (lvl3Rec.getY() + lvl3Rec.getHeight() / 2 + strHeight / 4));

		// Level 4 Button text
		g.drawString(lvl4Txt, (int) (lvl4Rec.getX() + lvl4Rec.getWidth() / 2 - strWidth / 2),
				(int) (lvl4Rec.getY() + lvl4Rec.getHeight() / 2 + strHeight / 4));

	}
	
	public void drawChooseColor(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		if (col1H) g.setColor(Color.white);
		g2d.fill(col1Rec);

		g.setColor(Color.black);
		if (col2H) g.setColor(Color.white);
		g2d.fill(col2Rec);
		
		g.setColor(Color.black);
		if (col3H) g.setColor(Color.white);
		g2d.fill(col3Rec);
		

		g.setFont(font2);
		strWidth = g.getFontMetrics(font2).stringWidth(col1Txt);
		strHeight = g.getFontMetrics(font3).getHeight();

		g.setColor(Color.cyan);
		g.drawString(col1Txt, (int) (col1Rec.getX() + col1Rec.getWidth() / 2 - strWidth / 2),
				(int) (col1Rec.getY() + col1Rec.getHeight() / 2 + strHeight / 4));

		g.setColor(Color.pink);
		g.drawString(col2Txt, (int) (col2Rec.getX() + col2Rec.getWidth() / 2 - strWidth / 2),
				(int) (col2Rec.getY() + col2Rec.getHeight() / 2 + strHeight / 4));

		g.setColor(Color.yellow);
		g.drawString(col3Txt, (int) (col3Rec.getX() + col3Rec.getWidth() / 2 - strWidth / 2),
				(int) (col3Rec.getY() + col3Rec.getHeight() / 2 + strHeight / 4));
		
		
		g.setFont(font4);
		strWidth = g.getFontMetrics(font4).stringWidth(chooseColorTxt);
		strHeight = g.getFontMetrics(font4).getHeight();
		
		g.setColor(Color.gray);
		g.drawString(chooseColorTxt, (int) (chooseColorRec.getX() + chooseColorRec.getWidth() / 2 - strWidth / 2),
				(int) (chooseColorRec.getY() + chooseColorRec.getHeight() / 2 + strHeight / 4));
	}

	public void drawStartGame(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	
		g.setColor(Color.white);
		if (startH) g.setColor(Color.black);
		g2d.fill(startRec);

		g.setFont(font3);
		strWidth = g.getFontMetrics(font3).stringWidth(startTxt);
		strHeight = g.getFontMetrics(font3).getHeight();
		
		g.setColor(Color.green);
		g.drawString(startTxt, (int) (startRec.getX() + startRec.getWidth() / 2 - strWidth / 2),
				(int) (startRec.getY() + startRec.getHeight() / 2 + strHeight / 4));
	}
	
	public void mouseClicked(MouseEvent e) {

		Point p = e.getPoint();

		if (playBtn.contains(p)) {
			show = true;
		} else if (lvl0Rec.contains(p)) {
			level = 0;
			showAgain = true;
		} else if (lvl1Rec.contains(p)) {
			level = 1;
			showAgain = true;
		} else if (lvl2Rec.contains(p)) {
			level = 2;
			showAgain = true;
		} else if (lvl3Rec.contains(p)) {
			level = 3;
			showAgain = true;
		} else if (lvl4Rec.contains(p)) {
			level = 4;
			showAgain = true;
		} else if (col1Rec.contains(p)) {
			snakeColor = Color.CYAN;		
			showStart = true;
		} else if (col2Rec.contains(p))  {
			snakeColor = Color.pink;
			showStart = true;
		} else if (col3Rec.contains(p))  {
			snakeColor = Color.yellow;
			showStart = true;
		} else if (startRec.contains(p)) {
			active = false;
			show = false;
			showAgain = false;
			showStart = false;
		} else if (quitBtn.contains(p)) {
			System.exit(0);
		} 
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		Point p = e.getPoint();

		pHighlight = playBtn.contains(p);
		qHighlight = quitBtn.contains(p);
		lvl0H = lvl0Rec.contains(p);
		lvl1H = lvl1Rec.contains(p);
		lvl2H = lvl2Rec.contains(p);
		lvl3H = lvl3Rec.contains(p);
		lvl4H = lvl4Rec.contains(p);
		col1H = col1Rec.contains(p);
		col2H = col2Rec.contains(p);
		col3H = col3Rec.contains(p);
		startH = startRec.contains(p);
	}
}
