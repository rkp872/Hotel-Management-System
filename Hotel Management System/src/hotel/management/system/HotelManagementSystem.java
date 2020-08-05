package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener
{
	HotelManagementSystem()
	{
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
		JLabel l1=new JLabel(i1);
		l1.setBounds(0,0,1200,565);
		add(l1);
		
		JLabel l2=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l2.setBounds(50,450,1000,70);
		
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif",Font.BOLD,40));
		l1.add(l2);
		
		JButton b1=new JButton("NEXT");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1070,490,100,30);
		l1.add(b1);
		
		b1.addActionListener(this);
		
		setSize(1200,565);
		setLayout(null);
		setLocation(50,100);
		setVisible(true);
		
		while(true)
		{
			l2.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				
			}
			l2.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e) 
			{
				
			}
			
		}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		new Login().setVisible(true);
		this.setVisible(false);
	}
	public static void main(String args[]) 
	{
		new HotelManagementSystem();
	}
}
