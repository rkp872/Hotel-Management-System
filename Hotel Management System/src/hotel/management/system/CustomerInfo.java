package hotel.management.system;

import java.awt.Color;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	CustomerInfo()
	{
		t1=new JTable();
		t1.setBounds(0,40,1000,400);
		add(t1);
		
		JLabel l1=new JLabel("ID TYPE");
		l1.setBounds(40,10,70,20);
		add(l1);
		
		JLabel l2=new JLabel("NUMBER");
		l2.setBounds(170,10,70,20);
		add(l2);
		
		JLabel l3=new JLabel("NAME");
		l3.setBounds(290,10,70,20);
		add(l3);
		
		JLabel l4=new JLabel("GENDER");
		l4.setBounds(400,10,90,20);
		add(l4);
		
		
		JLabel l5=new JLabel("COUNTRY");
		l5.setBounds(540,10,70,20);
		add(l5);
		
		JLabel l6=new JLabel("ROOM NUMBER");
		l6.setBounds(650,10,90,20);
		add(l6);
		
		JLabel l7=new JLabel("CHECKED STATUS");
		l7.setBounds(760,10,120,20);
		add(l7);
		
		JLabel l8=new JLabel("DEPOSIT");
		l8.setBounds(910,10,70,20);
		add(l8);
		
		b1=new JButton("Load Data");
		b1.setBounds(350,450,120,30);
		b1.addActionListener(this);
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(500,450,120,30);
		b2.addActionListener(this);
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		add(b2);
		
		
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
				String str="select * from customer ";
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
		new CustomerInfo();

	}

}
