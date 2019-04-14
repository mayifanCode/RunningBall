package com.myf.runball1031;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Jframe {

	private Ball[] arrayball = new Ball[100];

	public static void main(String[] args) {
		Jframe frame = new Jframe();
		frame.showUI();
	}

	public void showUI() {

		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setSize(1000, 1000);
		jf.getContentPane().setBackground(Color.WHITE);
		jf.setTitle("С��");
		jf.setDefaultCloseOperation(3);
		// ���þ�����ʾ
		jf.setLocationRelativeTo(null);

		JPanel jp1 =new JPanel();
		
		JButton jb1 = new JButton("���");
		jp1.add(jb1);
		// jb1.setBounds(100,50, 40, 20);
		JButton jb2 = new JButton("��ͣ");
		jp1.add(jb2);
		// jb1.setBounds(200,50, 40, 20);
		JButton jb3 = new JButton("���");
		jp1.add(jb3);
		// jb1.setBounds(300,50, 40, 20);
		JButton jb4 = new JButton("�Զ����");
		jp1.add(jb4);
		
		jf.add(jp1,BorderLayout.NORTH);
		
        Mouse mouse = new Mouse();
        
		Color[] color = {Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.YELLOW};
		for(int i=0;i<color.length;i++){
			JButton jbu = new JButton();
			jbu.setBackground(color[i]);
			jbu.setPreferredSize(new Dimension(30, 30));
			jp1.add(jbu);
			jbu.addActionListener(mouse);
		}
		
		jb1.addActionListener(mouse);
		jb2.addActionListener(mouse);
		jb3.addActionListener(mouse);
		jb4.addActionListener(mouse);
		jf.addMouseListener(mouse);
		jf.addMouseMotionListener(mouse);

		BallJpanel cp = new BallJpanel();	
		cp.setBackground(Color.WHITE);
		jf.add(cp,BorderLayout.CENTER);
		jf.setVisible(true);
         
		Graphics g = cp.getGraphics();
		mouse.setcp(cp);		
		mouse.setg(g);
		mouse.setarrayball(arrayball);
		mouse.setmouse(mouse);
		cp.setarrayball(arrayball);
		
	}

}
