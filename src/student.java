import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;

public class student implements ActionListener
{
	public static String id;
	public static String getid()
	{
		return id;
	}
	
	JFrame s;
	JButton login,back;
	JTextField n1;
	JPasswordField p1;
	
	
	student()
	{
		s = new JFrame("Student Login");
		s.setVisible(true);
		login = new JButton("Login");
		back =new JButton("Back");
		JLabel n = new JLabel("Student ID");
		JLabel p = new JLabel("Password");
		s.setLayout(null);
		n1= new JTextField(10);
		p1=new JPasswordField(10);
	
		s.setSize(750,500);
		s.add(n);
		s.add(n1);
		s.add(p);
		s.add(p1);
		s.add(login);
		s.add(back);
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
		String user = n1.getText();
		id=user;
		if(e.getSource()==login)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("SELECT student_id, password FROM students Where student_id="+user+";");
				if(rs.next())
				{
				if(user.equals((rs.getString(1)))&&pass.equals(rs.getString(2)))
				{
					s.setVisible(false);
					new studhome();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Credentials", " ", JOptionPane.WARNING_MESSAGE);
				}
				con.close();
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		else
		{
			s.setVisible(false);
			new home();
		}
	}
}

/*
 * if(n1.getText().equals("241531")&&pass.equals("universe1"))
			{
				s.setVisible(false);
				new studhome();
			}
			else
			{
				new invalidlogin();
				n1.setText(" ");
				p1.setText("");
				declare a strung id public static just after declare class, 
			}
*/
