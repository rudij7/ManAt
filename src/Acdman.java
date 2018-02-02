import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;


public class Acdman implements ActionListener
{
	public static String id;
	public static String subj;
	public static String getid()
	{
		return id;
	}
	public static String getsub()
	{
		return subj;
	}
JFrame ac;
JButton submit;
JTextField t1 = new JTextField(20);
JTextField t2= new JTextField(20);

Acdman()
{
	ac=new JFrame("Enter Student Academics");
	ac.setSize(750, 750);
	ac.setVisible(true);
	ac.setLayout(null);
	
	JLabel sid = new JLabel("Student ID:");
	JLabel subid= new JLabel("Subject ID:");
	
	
	submit = new JButton("Submit");
	JButton back = new JButton("Back");
	
	ac.add(t1);
	ac.add(t2);
	ac.add(subid);
	ac.add(sid);
	ac.add(submit);
	ac.add(back);
	
	t1.setBounds(300,100,100,40);
	t2.setBounds(300,260,100,40);
	
	sid.setBounds(200,100,100,40);
	subid.setBounds(200,260,100,40);
	back.setBounds(10,50,100,60);
	submit.setBounds(250,600,100,40);
	
	back.addActionListener(this);
	submit.addActionListener(this);
	
}
public void actionPerformed(ActionEvent e)
{
	String stud = t1.getText();
	String subs=t2.getText();
	id=stud;
	subj=subs;
	if(e.getSource()==submit)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			ResultSet rs=st.executeQuery("SELECT student_id FROM students Where students.student_id="+stud+";");
			ResultSet rs2=st1.executeQuery("SELECT subject_id FROM subjects Where subject_id="+subs+";");
			rs.next();
			rs2.next();
			if(stud.equals((rs.getString(1)))&&(subs.equals(rs2.getString(1))))
			{
				ac.setVisible(false);
				new enteracd();
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
		ac.setVisible(false);
		new teachhome();
	}
}
}





