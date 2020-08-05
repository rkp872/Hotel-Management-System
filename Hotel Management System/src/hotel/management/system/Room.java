package hotel.management.system;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	
	Room()
	{
		t1=new JTable();
		t1.setBounds(0,40,500,400);
		add(t1);
		
		JLabel l2=new JLabel("ROOM NUMBER");
		l2.setBounds(8,10,100,20);
		add(l2);
		
		JLabel l3=new JLabel("AVAILABILITY");
		l3.setBounds(110,10,100,20);
		add(l3);
		
		JLabel l4=new JLabel("CLEAN STATUS");
		l4.setBounds(200,10,100,20);
		add(l4);
		
		JLabel l5=new JLabel("PRICE");
		l5.setBounds(310,10,100,20);
		add(l5);
		
		JLabel l6=new JLabel("BED TYPE");
		l6.setBounds(420,10,100,20);
		add(l6);
		
		b1=new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBounds(100,460,120,30);
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(250,460,120,30);
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2=i1.getImage().getScaledInstance(470, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(420,10,650,490);
		add(l1);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,1000,550);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				conn c=new conn();
				String str="select * from room";
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args) 
	{
		
		new Room();
	}

}
