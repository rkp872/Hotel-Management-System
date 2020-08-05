package hotel.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PickUp extends JFrame implements ActionListener
{
	Choice c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	PickUp()
	{
		JLabel l1=new JLabel("PICKUP SERVICE");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setBounds(300,30,200,30);
		add(l1);
		
		JLabel l2=new JLabel("Car Type");
		l2.setBounds(50,100,100,20);
		add(l2);
		
		c1= new Choice();
		try
		{
			conn c=new conn();
			ResultSet rs=c.s.executeQuery("select * from driver ");
			while(rs.next())
			{
				c1.add(rs.getString("brand"));
			}
		}
		catch(Exception e)
		{
			
		}
		c1.setBounds(170,100,200,25);
		add(c1);

		
		c2=new JCheckBox("Only display Available");
		c2.setBackground(Color.white);
		c2.setBounds(500,100,150,25);
		add(c2);
		
		t1=new JTable();
		t1.setBounds(3,200,800,250);
		add(t1);
		
		b1=new JButton("Submit");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(270,460,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(510,460,120,30);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l3=new JLabel("Name");
		l3.setBounds(30,160,100,20);
		add(l3);
		
		JLabel l4=new JLabel("Age");
		l4.setBounds(150,160,100,20);
		add(l4);
		
		JLabel l5=new JLabel("Gender");
		l5.setBounds(270,160,100,20);
		add(l5);
		
		JLabel l6=new JLabel("Company");
		l6.setBounds(370,160,100,20);
		add(l6);
		
		JLabel l7=new JLabel("Brand");
		l7.setBounds(490,160,100,20);
		add(l7);
		
		JLabel l8=new JLabel("Availability");
		l8.setBounds(580,160,100,20);
		add(l8);
		
		JLabel l9=new JLabel("Location");
		l9.setBounds(700,160,100,20);
		add(l9);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,803,570);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		conn c=new conn();
		if(ae.getSource()==b1)
		{
			try
			{
				String str="select * from driver where brand='"+c1.getSelectedItem()+"' ";
				String str2="select * from driver where available='Available' AND brand='"+c1.getSelectedItem()+"'";
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				if(c2.isSelected())
				{
					ResultSet rs2=c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs2));
				}
			}
			catch(Exception e)
			{
				
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
		
		new PickUp();
	}

}
