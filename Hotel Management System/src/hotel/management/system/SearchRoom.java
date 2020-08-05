package hotel.management.system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener
{
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	SearchRoom()
	{
		JLabel l1=new JLabel("SEARCH FOR ROOM");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2=new JLabel("Room Bed Type");
		l2.setBounds(50,100,200,20);
		add(l2);
		
		c1=new JComboBox(new String[] {"Single","Double"});
		c1.setBounds(150,100,100,25);
		c1.setBackground(Color.white);
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
		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(10,170,150,30);
		add(l3);
		
		JLabel l4=new JLabel("Availability");	
		l4.setBounds(230,170,120,30);
		add(l4);
		
		JLabel l5=new JLabel("Clean Status");
		l5.setBounds(380,170,150,30);
		add(l5);
		
		JLabel l6=new JLabel("Price");		
		l6.setBounds(500,170,100,30);
		add(l6);
		
		JLabel l7=new JLabel("Bed Type");	
		l7.setBounds(650,170,150,30);
		add(l7);
		
		
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
				String str="select * from room where bed_type='"+c1.getSelectedItem()+"' ";
				String str2="select * from room where availability='Available' AND bed_type='"+c1.getSelectedItem()+"'";
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
		
		new SearchRoom();
	}

}
