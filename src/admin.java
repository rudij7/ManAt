import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class admin implements ActionListener
{
	JFrame a;
	JButton login,back;
	JTextField n1;
	JPasswordField p1;
	admin()
	{
		a = new JFrame("Admin Login");
		a.setVisible(true);
		login = new JButton("Login");
		back =new JButton("Back");
		JLabel n = new JLabel("Username");
		JLabel p = new JLabel("Password");
		a.setLayout(null);
		n1= new JTextField(10);
		p1=new JPasswordField(10);
		
		a.setSize(750,500);
		a.add(n);
		a.add(n1);
		a.add(p);
		a.add(p1);
		a.add(login);
		a.add(back);
		n.setBounds(200,100,80,40);
		n1.setBounds(300,100,100,40);
		p.setBounds(200,200,80,40);
		p1.setBounds(300,200,100,40);
		login.setBounds(200,300,80,50);
		back.setBounds(300,300,80,50);
		login.addActionListener(this);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String pass = new String(p1.getPassword());
		if(e.getSource()==login)
		{
			if(n1.getText().equals("admin")&&pass.equals("admin"))
			{
				a.setVisible(false);
				new adminhome();
			}
			else
			{
				new invalidlogin();
				n1.setText(" ");
				p1.setText("");
			}
		}
		else
		{
			a.setVisible(false);
			new home();
		}
	}
}
