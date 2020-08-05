package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	public AddRooms()
	{
		JLabel l1=new JLabel("ADD ROOMS");
		l1.setFont(new Font("Tahoma",Font.BOLD,17));
		l1.setBounds(150,20,130,20);
		add(l1);
		
		JLabel room=new JLabel("Room Number");
		room.setFont(new Font("Tahoma",Font.BOLD,15));
		room.setBounds(60,80,120,30);
		add(room);
		t1=new JTextField();
		t1.setBounds(200,80,150,30);
		add(t1);
		
		JLabel available=new JLabel("Available");
		available.setFont(new Font("Tahoma",Font.BOLD,15));
		available.setBounds(60,130,120,30);
		add(available);
		c1=new JComboBox(new String[] {"Available","Occupied"});
		c1.setBackground(Color.white);
		c1.setBounds(200,130,150,30);
		add(c1);
		
		JLabel status=new JLabel("Cleaning Status");
		status.setFont(new Font("Tahoma",Font.BOLD,15));
		status.setBounds(60,180,120,30);
		add(status);
		
		c2=new JComboBox(new String[] {"Clean","Dirty"});
		c2.setBackground(Color.white);
		c2.setBounds(200,180,150,30);
		add(c2);
		
		JLabel price=new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.BOLD,15));
		price.setBounds(60,230,120,30);
		add(price);
		
		t2=new JTextField();
		t2.setBounds(200,230,150,30);
		add(t2);
		
		JLabel type=new JLabel("Bed Type");
		type.setFont(new Font("Tahoma",Font.BOLD,15));
		type.setBounds(60,280,120,30);
		add(type);
		
		c3=new JComboBox(new String[] {"Single","Double"});
		c3.setBackground(Color.white);
		c3.setBounds(200,280,150,30);
		add(c3);
		
		
		b1=new JButton("Add Room");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(60,350,130,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(220,350,130,30);
		add(b2);
		b2.addActionListener(this);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
		JLabel l2=new JLabel(i1);
		l2.setBounds(380,30,500,350);
		add(l2);
		
		
		getContentPane().setBackground(Color.white);
		
		setBounds(200,100,920,470);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==b1)
		{
			
			String room=t1.getText();
			String available=(String)c1.getSelectedItem();
			String status=(String)c2.getSelectedItem();
			String price=t2.getText();
			String type=(String)c3.getSelectedItem();
			conn c=new conn();
			try
			{
				String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
				c.s.executeUpdate(str);		
				JOptionPane.showMessageDialog(null, "Room Added");
				this.setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
	}

	public static void main(String[] args) 
	{
		new AddRooms();

	}

}
