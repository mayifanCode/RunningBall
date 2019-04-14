package com.myf.runball1031;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import com.myf.gobang1026.Shape;

public class Mouse implements MouseMotionListener, MouseListener, ActionListener {
	private Graphics g;
	private BallJpanel cp;
	private Ball[] arrayball;
	private int index = 0;
	private int x;
	private int y;
	private int vx;
	private int vy;
	private int random=1;
	private Color color=Color.black;
	private ThreadBall tb;
    private  Mouse mouse;
    public int selfFlag=0;
    public void setmouse(Mouse mouse)
    {
    	this.mouse= mouse;
    }
    
	public void setarrayball(Ball[] arrayball) {
		this.arrayball = arrayball;
	}

	public void setg(Graphics g) {
		this.g = g;
	}

	public void setcp(BallJpanel cp) {
		this.cp = cp;
	}

	public void actionPerformed(ActionEvent e) {
		
		if ("添加".equals(e.getActionCommand())) {
			System.out.println("添加");
			if (tb == null) {
				// 创建线程对象
				tb = new ThreadBall();
				tb.setcp(cp);
				tb.setarrayball(arrayball);
				tb.setg(g);
				tb.start();
				tb.setmouse(mouse);
			}
			tb.stopFlag=0;
			addBall();
			
		}
		if ("暂停".equals(e.getActionCommand())) {
			
				if(tb!=null)
				{
					if(tb.stopFlag==0)
					{
					    tb.stopFlag=1;
					    System.out.println("暂停");
					}
					else 
					{
						tb.stopFlag=0;
						 System.out.println("开始");
					}
				}
			
		}
		if ("清除".equals(e.getActionCommand())) {
			tb.stopFlag=1;
			cp.paint1(g);
			index=0;
			System.out.println("清除");
		}
		if ("自动添加".equals(e.getActionCommand())){
			if(selfFlag==0)
				{selfFlag=1;System.out.println("自动添加打开");}
			else
				{selfFlag=0;System.out.println("自动添加关闭");}			
		}		
		
		
		
		if("".equals(e.getActionCommand())){
			JButton jbu=(JButton)e.getSource();
			color=jbu.getBackground();
			g.setColor(color);				
		}

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void addBall() {
		x = 500;
		y = 500;
		random=1+(int)(Math.random()*4);
		switch(random)
		{
		case 1:
			vx=5;
			vy=5;
			break;
		case 2:
			vx=-5;
			vy=-5;			
			break;
		case 3:
			vx=5;
			vy=-5;			
			break;
		case 4:
			vx=-5;
			vy=5;			
			break;		
		}
		Ball ball = new Ball(x, y,vx , vy, color);		
		arrayball[index++] = ball;
	}

}
