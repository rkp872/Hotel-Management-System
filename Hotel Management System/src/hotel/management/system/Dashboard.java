package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{
	
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	Dashboard()
	{
		mb=new JMenuBar();
		add(mb);
		
		
		m1=new JMenu("HOTEL MANAGEMENT");
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2=new JMenu("ADMIN");
		m2.setForeground(Color.BLUE);
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2=new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3=new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4=new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1280,30);
		
		ImageIcon im=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
		JLabel l1=new JLabel(im);
		l1.setBounds(0,0,1280,665);
		add(l1);		
		
		JLabel l2=new JLabel("THE TAJ GROUP WELCOMES YOU");
		l2.setBounds(400,30,1000,30);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma",Font.BOLD,30));
		l1.add(l2);
		
		
		setLayout(null);
		setBounds(0,0,1280,685);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().contentEquals("RECEPTION")) {
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().contentEquals("ADD EMPLOYEE"))
		{
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().contentEquals("ADD ROOMS"))
		{
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().contentEquals("ADD DRIVERS"))
		{
			new AddDriver().setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		new Dashboard().setVisible(true);
	}

}
