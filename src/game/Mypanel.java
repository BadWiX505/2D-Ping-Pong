package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Mypanel extends JPanel implements ActionListener,KeyListener{
        int maxwidth = 700;
        int maxheight= 500;
        int zidheight = 3;
        int zidwidth = 3;
        Timer timer;
        int x=100;
        int y=0;
        int leftrecheight = 250;
        int rightrecheight = 250;
        int leftscore=0,rightscore=0;
      Mypanel(){    
    	  this.setBackground(Color.black);
    	  this.setPreferredSize(new Dimension(700,500));	
    	  this.addKeyListener(this);
    	  this.setFocusable(true);
    	  timer = new Timer(1,this);
    	  timer.start();
      }
      public void paint(Graphics g) {
    	  super.paint(g);
    	  Graphics2D g2D = (Graphics2D) g;
    	  g2D.setPaint(Color.white);
    	  g2D.fillOval(x,y,20,20);
    	  g2D.drawLine(350,0,350,500);
    	  g2D.fillRect(0,leftrecheight,10,70);
    	  g2D.fillRect(690,rightrecheight,10,70);
    	  g2D.setFont(new Font("Poppins",Font.BOLD,30));
    	  g2D.drawString(Integer.toString(leftscore),290,30);
    	  g2D.drawString(Integer.toString(rightscore),390,30);
      }
      int n=0,i=0;
	public void actionPerformed(ActionEvent e) {
		if(x>=(700-20) || x<0) {
			zidwidth = zidwidth*-1;
		}
	    x = x + zidwidth;
	    if(y>=(500-20) || y<0) {
			zidheight = zidheight*-1;
		}
	    y = y + zidheight;
	    repaint();
	    if(y==0 || y==480) {
	    	try {
				playsound("pop.wav");
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	    if(x==1 || x==679) {
	    	try {
				playsound("ta9ma9.wav");
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    if(x==1){
	    	if(y>=(leftrecheight-18) && y<=(leftrecheight+70)) {
	    		 System.out.println("great");
	    		 zidwidth = zidwidth*-1;
	    	}
	    	else { System.out.println("oops");rightscore++;n=1;}
	    }
	    if(x==679) {
	    if(y>=(rightrecheight-18) && y<=(rightrecheight+70)) {
   		 System.out.println("great");
   		 zidwidth = zidwidth*-1;
   	}
   	else { System.out.println("oops");leftscore++;n=1;}
   }
	    if(n==1) {
	     y=0;x=250;
	     n=0;
	    }
	    }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(i==0) {
		switch(e.getKeyChar()) {
		case 'w' : leftrecheight-=15;break;
		case 's' : leftrecheight+=15;break;
		}
		
		switch(e.getKeyCode()) {
		case 38 : rightrecheight-=20;break;
		case 40 : rightrecheight+=20;break;
		}
		}
		if(e.getKeyCode()==10) {
			if(i==0) {
			timer.stop();i=1;}
			else {i=0; timer.start();}
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	void playsound(String path) throws LineUnavailableException {
		File file = new File(path);
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(sound);
			clip.start();
			} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
      } 
