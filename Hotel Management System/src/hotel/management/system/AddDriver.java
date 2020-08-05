package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1,b2;
	
	public AddDriver()
	{
		JLabel title=new JLabel("ADD DRIVER");
		title.setBounds(150,10,150,30);
		title.setFont(new Font("Tahoma",Font.BOLD,15));
		add(title);
		JLabel name=new JLabel("Name");
		name.setBounds(60,70,100,30);
		name.setFont(new Font("Tahoma",Font.BOLD,14));
		add(name);
		t1=new JTextField();
		t1.setBounds(200,70,150,30);
		add(t1);
		
		
		JLabel age=new JLabel("Age");
		age.setBounds(60,110,100,30);
		age.setFont(new Font("Tahoma",Font.BOLD,14));
		add(age);
		t2=new JTextField();
		t2.setBounds(200,110,150,30);
		add(t2);
		
		JLabel gender=new JLabel("Gender");
		gender.setBounds(60,150,100,30);
		gender.setFont(new Font("Tahoma",Font.BOLD,14));
		add(gender);
		c1=new JComboBox(new String[] {"Male","Female"});
		c1.setBackground(Color.white);
		c1.setBounds(200,150,150,30);
		add(c1);
		
		
		
		JLabel car=new JLabel("Car Company");
		car.setBounds(60,190,100,30);
		car.setFont(new Font("Tahoma",Font.BOLD,14));
		add(car);
		t3=new JTextField();
		t3.setBounds(200,190,150,30);
		add(t3);
		
		JLabel model=new JLabel("Car Model");
		model.setBounds(60,230,100,30);
		model.setFont(new Font("Tahoma",Font.BOLD,14));
		add(model);
		t4=new JTextField();
		t4.setBounds(200,230,150,30);
		add(t4);
		
		
		JLabel available=new JLabel("Available");
		available.setBounds(60,270,100,30);
		available.setFont(new Font("Tahoma",Font.BOLD,14));
		add(available);
		c2=new JComboBox(new String[] {"Available","Busy"});
		c2.setBackground(Color.white);
		c2.setBounds(200,270,150,30);
		add(c2);
		
		JLabel location=new JLabel("Location");
		location.setBounds(60,310,100,30);
		location.setFont(new Font("Tahoma",Font.BOLD,14));
		add(location);
		t5=new JTextField();
		t5.setBounds(200,310,150,30);
		add(t5);
		
		b1=new JButton("Add Driver");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(60,370,130,30);
		add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(200,370,130,30);
		add(b2);
		b2.addActionListener(this);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
		Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(400,80,500,300);
		add(l1);
		
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(200,100,960,450);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String name=t1.getText();
			String age=t2.getText();
			String gender=(String)c1.getSelectedItem();
			String company=t3.getText();
			String brand=t4.getText();
			String available=(String)c2.getSelectedItem();
			String location=t5.getText();
			
			conn c=new  conn();
			String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
			try
			{
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver Added");
				this.setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) 
	{
		new AddDriver();
	}
}
