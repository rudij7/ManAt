import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;


public class studman implements ActionListener{

JFrame sm;
JButton submit;
JTextField t1 = new JTextField(20);
JTextField t2 = new JTextField(20);
JTextField t3 = new JTextField(20);
JTextField t4 = new JTextField(20);
JTextField t6 = new JTextField(20);
JTextField t5 = new JTextField(20);
JTextField t7 = new JTextField(20);


studman()
{
	sm=new JFrame("Student Manager");
	sm.setSize(750, 750);
	sm.setVisible(true);
	sm.setLayout(null);
	
	JLabel sid = new JLabel("Student ID:");
	JLabel fname = new JLabel("First Name:");
	JLabel mname = new JLabel("Middle Name:");
	JLabel lname = new JLabel("Last Name:");
	JLabel year = new JLabel("Year:");
	JLabel branch = new JLabel("Branch:");
	JLabel pass = new JLabel("Password:");
	
	
	submit = new JButton("Submit");
	JButton back = new JButton("Back");
	
	sm.add(t1);
	sm.add(t2);
	sm.add(t3);
	sm.add(t4);
	sm.add(t5);
	sm.add(t6);
	sm.add(t7);
	sm.add(sid);
	sm.add(fname);
	sm.add(mname);
	sm.add(lname);
	sm.add(year);
	sm.add(branch);
	sm.add(pass);
	sm.add(submit);
	sm.add(back);
	
	t1.setBounds(300,100,200,40);
	t2.setBounds(300,150,200,40);
	t3.setBounds(300,200,200,40);
	t4.setBounds(300,250,200,40);
	t6.setBounds(300,300,200,40);
	t5.setBounds(300,350,200,40);
	t7.setBounds(300,400,200,40);

	sid.setBounds(200,100,100,40);
	fname.setBounds(200,150,100,40);
	mname.setBounds(200,200,100,40);
	lname.setBounds(200,250,100,40);
	year.setBounds(200,300,100,40);
	branch.setBounds(200,350,100,40);
	pass.setBounds(200,400,100,40);
	
	back.setBounds(10,50,100,60);
	submit.setBounds(250,600,100,40);
	
	back.addActionListener(this);
	submit.addActionListener(this);
	
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()== submit)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
		PreparedStatement st = con.prepareStatement("Insert into students Values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t6.getText()+"','"+t5.getText()+"','"+t7.getText()+"');");
		st.executeUpdate();
		JOptionPane.showMessageDialog(null, "Done!", " ", JOptionPane.INFORMATION_MESSAGE);
		con.close();
		sm.setVisible(false);
		new adminhome();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	else
	{
		sm.setVisible(false);;
		new adminhome();
	}
	}
}





