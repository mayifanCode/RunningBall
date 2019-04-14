package com.myf.runball1031;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BallJpanel extends JPanel {

	
	 private Ball[] arrayball;
	
	public void setarrayball(Ball[] arrayball)
	{
		this.arrayball=arrayball;
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);	
		for(int i=0;i<arrayball.length;i++)
		{
			if(arrayball[i]==null)
			{
				break;			
			}
			Ball ball=arrayball[i];
			g.setColor(ball.color);
			g.fillOval(ball.x-ball.size/2, ball.y-ball.size/2, ball.size, ball.size);
		}
	}
	
	public void paint1(Graphics g)
	{
		super.paint(g);	
		for(int i=0;i<arrayball.length;i++)
		{
			if(arrayball[i]==null)
			{
				break;			
			}
			arrayball[i]=null;			
		}
	}	
	
	
}
