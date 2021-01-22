package com.snake3;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame {
	
	public int type;
		
	Game(){
		add(new Board(0));
	}
	

	public static void main(String[] args) {

	    // Creates a new thread so our GUI can process itself
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {	        	
	            JFrame frame = new Game();
	    	    frame.setResizable(false);
	    	    frame.pack();

	    	    frame.setTitle("Snake A Noki");
	    	    frame.setLocationRelativeTo(null);
	    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
	            
	    		ImageIcon image = new ImageIcon("games.png");
	    		frame.setIconImage(image.getImage());
	        }
	    });
	}

}
