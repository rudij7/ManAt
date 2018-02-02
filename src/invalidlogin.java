import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
public class invalidlogin implements ActionListener
{
	JFrame il;
	JButton b;
	invalidlogin()
	{
		il = new JFrame("Invalid Login");
		il.setSize(400, 200);
		il.setVisible(true);
		il.setLayout(null);
		JLabel inv = new JLabel("Invalid Login");
		b= new JButton("Retry");		
		il.add(inv);
		il.add(b);
		inv.setBounds(100,50,100, 40);
		b.setBounds(100,100,75,50);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			il.setVisible(false);
		}
	}
}
