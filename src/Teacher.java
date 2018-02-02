import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;

public class Teacher implements ActionListener
{
	public static String id;
	public static String getid()
	{
		return id;
	}
	
	JFrame t;
	JButton login,back;
	JTextField n1;
	JPasswordField p1;
	
	
	Teacher()
	{
		t = new JFrame("Teacher Login");
		t.setVisible(true);
		login = new JButton("Login");
		back =new JButton("Back");
		JLabel n = new JLabel("Teacher ID");
		JLabel p = new JLabel("Password");
		t.setLayout(null);
		n1= new JTextField(10);
		p1=new JPasswordField(10);
	
		t.setSize(750,500);
		t.add(n);
		t.add(n1);
		t.add(p);
		t.add(p1);
		t.add(login);
		t.add(back);
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
				ResultSet rs=st.executeQuery("SELECT teacher_id, password FROM teachers Where teacher_id="+user+";");
				rs.next();
				if(user.equals((rs.getString(1)))&&pass.equals(rs.getString(2)))
				{
					t.setVisible(false);
					new teachhome();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Credentials", " ", JOptionPane.WARNING_MESSAGE);
				}
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		else
		{
			t.setVisible(false);
			new home();
		}
	}
}

