package hotel.management.system;
import javax.swing.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener
{
	JTextField t1,t2,t3;
	Choice c1;
	JButton b1,b2,b3;
	UpdateRoom()
	{
		JLabel l1,l2,l3,l4,l5;
		l1=new JLabel("UPDTAE ROOM STATUS");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.blue);
		l1.setBounds(30,30,250,30);
		add(l1);
		
		l2=new JLabel("Guest ID");
		l2.setBounds(30,90,120,20);
		add(l2);
		
		c1=new Choice();
		try
		{
			conn c=new conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(200,80,150,25);
		add(c1);
		
		l3=new JLabel("Room Number");
		l3.setBounds(30,130,120,20);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200,130,150,25);
		add(t1);
		
		l4=new JLabel("Availability");
		l4.setBounds(30,180,120,20);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(200,180,150,25);
		add(t2);
		
		l3=new JLabel("Clean Status");
		l3.setBounds(30,230,120,20);
		add(l3);
		
		t3=new JTextField();
		t3.setBounds(200,230,150,25);
		add(t3);
		
		
		b1=new JButton("Check");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(130,300,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Update");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(40,350,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.white);
		b3.setForeground(Color.black);
		b3.setBounds(220,350,120,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
		Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel  img=new JLabel(i3);
		img.setBounds(400,10,500,400);
		add(img);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(200,100,950,450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String s1=c1.getSelectedItem();
			String room=null;
			try 
			{
				conn c=new conn();
				ResultSet rs=c.s.executeQuery("select * from customer where number ='"+s1+"'");
				
				while(rs.next())
				{
					t1.setText(rs.getString("room_number"));
					room=rs.getString("room_number");
				}	
				ResultSet rs2=c.s.executeQuery("select * from room where room_number ='"+room+"'");
				while(rs2.next())
				{
					t2.setText(rs2.getString("availability"));
					t3.setText(rs2.getString("clean_status"));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			try
			{
				conn c=new conn();
				String room=t1.getText();
				String available=t2.getText();
				String status=t3.getText();
				
				String str="update room set availability='"+available+"',clean_status='"+status+"' where room_number='"+room+"'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Room Updated Sucessfully");
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b3)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String[] args) 
	{
		
		new UpdateRoom();
	}

}
