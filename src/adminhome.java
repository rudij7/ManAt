import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class adminhome implements ActionListener
{
	JFrame ah;
	JButton studman, teaman, back,subman;
	
	adminhome()
	{
		ah = new JFrame("Admin Home");
		ah.setVisible(true);
		
		back=new JButton("Back");
		studman = new JButton("Student Manager");
		teaman = new JButton("Teacher Manager");
		subman=new JButton("Subject Manager");
		ah.setLayout(null);
		ah.setSize(750,500);
		ah.add(back);
		ah.add(studman);
		ah.add(teaman);
		ah.add(subman);
		studman.setBounds(250,250,200,60);
		teaman.setBounds(250,180,200,60);
		subman.setBounds(250,320,200,60);
		back.setBounds(50,50,100,60);
		back.addActionListener(this);
		studman.addActionListener(this);
		teaman.addActionListener(this);
		subman.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==studman)
		{
			ah.setVisible(false);
			new studman();
		}
		
		else if(e.getSource()==teaman)
		{
			ah.setVisible(false);
			new teachman();
		}
		else if(e.getSource()==back)
		{
			ah.setVisible(false);
			new admin();
		}
		else if(e.getSource()==subman)
		{
			ah.setVisible(false);
			new subjman();
		}
		
	}	
}
