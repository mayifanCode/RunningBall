package com.myf.runball1031;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public int size = 200; // 小球的直径
	public int x = 500; // 小球所在的x坐标
	public int y = 500; // 小球所在的y坐标
	public int vx = 5;
	public int vy = 5;
	public BallJpanel cp;
	public Color color = Color.BLACK;
	public int max_x, max_y, Min_x, Min_y;
	private Ball[] arrayball;

	public void setcp(BallJpanel cp) {
		this.cp = cp;
	}

	public void setarrayball(Ball[] arrayball) {
		this.arrayball = arrayball;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int setY() {
		return y;
	}

	public Ball(int x, int y, int vx, int vy, Color color) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
	}

	public void ballMove(Graphics g) {

		x += vx;
		y += vy;

		max_y = cp.getHeight();
		max_x = cp.getWidth();

		if (x <= size / 2) {
			x = size / 2;
			vx = -vx;
		}
		if (y <= size / 2) {
			y = size / 2;
			vy = -vy;
		}
		if (x + size / 2 >= max_x) {
			x = max_x - size / 2;
			vx = -vx;
		}
		if (y + size / 2 >= max_y) {
			y = max_y - size / 2;
			vy = -vy;
		}
		for (int i = 0; i < arrayball.length; i++) 
		{
			if (arrayball[i] == null)
				break;
			Ball ball = arrayball[i];
			if (this.equals(ball))
				continue;
			if ((ball.x - this.x) * (ball.x - this.x) + (ball.y - this.y) * (ball.y - this.y) <= size * size)
			{
				int tempvx = this.vx;
				int tempvy = this.vy;
				this.vx = ball.vx;
				this.vy = ball.vy;
				ball.vx = tempvx;
				ball.vy = tempvy;
				while ((ball.x - this.x) * (ball.x - this.x) + (ball.y - this.y) * (ball.y - this.y) <= size * size)
				{
					this.x +=  this.vx;
					this.y +=  this.vy;
					System.out.println("等待");

				}
			}

		}
	}

}
