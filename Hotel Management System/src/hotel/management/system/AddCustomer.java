package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class AddCustomer extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	JComboBox c1,c3;
	Choice c2;
	JRadioButton r1,r2;
	
	AddCustomer()
	{
		JLabel l1=new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100,20,300,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		l1.setForeground(Color.blue);
		add(l1);
		
		JLabel l2=new JLabel("ID TYPE");
		l2.setBounds(35,80,100,20);
		add(l2);
		
		c1=new JComboBox(new String[] {"Passport","Votor-ID Card","Driving License","Aadhar Card"});
		c1.setBounds(200,80,150,25);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel l3=new JLabel("NUMBER");
		l3.setBounds(35,120,100,20);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200,120,150,25);
		add(t1);
		
		JLabel l4=new JLabel("NAME");
		l4.setBounds(35,160,100,20);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(200,160,150,25);
		add(t2);
		
		JLabel l5=new JLabel("GENDER");
		l5.setBounds(35,200,100,20);
		add(l5);
		
		r1=new JRadioButton("Male");
		r1.setBackground(Color.white);
		r1.setBounds(200,200,60,25);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBackground(Color.white);
		r2.setBounds(270,200,80,25);
		add(r2);
		
		JLabel l6=new JLabel("COUNTRY");
		l6.setBounds(35,240,100,20);
		add(l6);
		
		t3=new JTextField();
		t3.setBounds(200,240,150,25);
		add(t3);
		
		JLabel l7=new JLabel("ALLOCATED ROOM NO.");
		l7.setBounds(35,280,150,20);
		add(l7);
		
		c2=new Choice();
		try
		{
			conn c=new conn();
			String str="select * from room";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next())
			{
				c2.add(rs.getString("room_number"));
			}
			
		}catch(Exception e) {}
		c1.setBackground(Color.white);
		c2.setBounds(200,280,150,25);
		add(c2);
		
		JLabel l8=new JLabel("CHECKED STAUTS");
		l8.setBounds(35,320,150,20);
		add(l8);
		
		c3=new JComboBox(new String[] {"CheckedIn","Not CheckedIn"});
		c3.setBounds(200,320,150,25);
		c3.setBackground(Color.white);
		add(c3);
		
		JLabel l9=new JLabel("DEPOSIT");
		l9.setBounds(35,360,100,20);
		add(l9);
		
		t4=new JTextField();
		t4.setBounds(200,360,150,25);
		add(t4);
		
		b1=new JButton("Add Customer");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(50,410,120,25);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(200,410,120,25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
		Image i2=i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel img=new JLabel(i3);
		img.setBounds(400,50,300,400);
		add(img);
		
		
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,700,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String id=(String)c1.getSelectedItem();
			String number=t1.getText();
			String name=t2.getText();
			String gender=null;
			if(r1.isSelected())
				gender="Male";
			else if(r2.isSelected())
				gender="Female";
			String country=t3.getText();
			String room=(String)c2.getSelectedItem();
			String status=(String)c3.getSelectedItem();
			String deposit=t4.getText();
			
			String str="insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
			String str2="update room set availability='Occupied' where room_number='"+room+"'";
			
			try
			{
				conn c=new conn();
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "New Customer Added");
				new Reception().setVisible(true);
				this.setVisible(false);
			
			}catch(Exception e) 
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
		
		new AddCustomer();
	}

}
