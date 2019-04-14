package com.myf.runball1031;

import java.awt.Graphics;

public class ThreadBall extends Thread {
	private Graphics g;
	private BallJpanel cp;
	private Ball[] arrayball;
	public  int stopFlag=0;
	private int add=0;
	private Mouse mouse;
	public void setmouse(Mouse mouse)
	{
		this.mouse=mouse;
	}
	
	
	public void setcp(BallJpanel cp) {
		this.cp = cp;  
	}

	public void setg(Graphics g)
	{
		this.g=g;
	}
	
	
	public void setarrayball(Ball[] arrayball) {
		this.arrayball = arrayball;
	}

	/**
	 * 启动线程执行的方法
	 */
	public void run() {

		while (true) {
           if(stopFlag==0)
           {
					for (int i = 0; i < arrayball.length; i++) 
					{
						if(arrayball[i]==null)
							break;				
						    Ball ball = arrayball[i];						        
					        ball.setarrayball(arrayball);			        
							ball.setcp(cp);
							ball.ballMove(g);									
					}			
					cp.paint(g);
					add++;
					if(add==5000)
						add=0;
					if(add%50==0&&mouse.selfFlag==1)
						mouse.addBall();
           }
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
          
		}
	}

}
