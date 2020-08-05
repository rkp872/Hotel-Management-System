package hotel.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener
{
	JButton b1,b2;
	JTable t1;
	Department()
	{
		JLabel l1=new JLabel("DEPARTMENT");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setBounds(150,5,200,30);
		add(l1);
	
		
		t1=new JTable();
		t1.setBounds(0,100,500,300);
		add(t1);
		
		b1=new JButton("Submit");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(100,430,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(300,430,120,30);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l3=new JLabel("Department");
		l3.setBounds(80,70,100,20);
		add(l3);
		
		JLabel l4=new JLabel("Budget");
		l4.setBounds(330,70,100,20);
		add(l4);
		
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,500,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		conn c=new conn();
		if(ae.getSource()==b1)
		{
			try
			{
				String str="select * from department ";
				
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
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
		
		new Department();
	}

}
