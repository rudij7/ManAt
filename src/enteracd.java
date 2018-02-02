import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;


public class enteracd implements ActionListener{

JFrame ed;
JButton submit,back;
JTextField t2 = new JTextField(20);
JTextField t3 = new JTextField(20);
String stid,subid;
enteracd()
{
	stid= Acdman.getid();
	subid=Acdman.getsub();
	JLabel lid = new JLabel(stid);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
		Statement st,st1;
		st = con.createStatement();
		st1=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM students Where student_id="+stid+";");
		ResultSet rs2=st1.executeQuery("Select name from subjects where subject_id="+subid+";");
		rs.next();
		rs2.next();
		JLabel lname = new JLabel("Name: "+rs.getString(4)+" "+rs.getString(2)+" "+rs.getString(3));
		JLabel lclass = new JLabel("Class: "+rs.getString(6)+" "+rs.getString(5));
		JLabel sub = new JLabel("Subject :   " +rs2.getString(1));
		ed=new JFrame("Student Manager");
		ed.setVisible(true);
		back =new JButton("Log Out");
		ed.setLayout(null);
		ed.setSize(750,550);
		ed.add(lname);
		ed.add(lclass);

		lname.setBounds(200, 150, 500, 60);
		lclass.setBounds(200, 200, 500, 60);
		back.setBounds(10,50,100,60);
		
		
		
		JLabel sid = new JLabel("Student ID:");
		JLabel att = new JLabel("Marks:");
		JLabel marks = new JLabel("Attendance:");		
		submit = new JButton("Submit");
		JButton back = new JButton("Back");
		
		ed.add(t2);
		ed.add(t3);
		ed.add(sid);
		ed.add(marks);
		ed.add(att);
		ed.add(sub);
		ed.add(submit);
		ed.add(back);
		ed.add(lid);
		
		t2.setBounds(300,360,100,40);
		t3.setBounds(300,420,100,40);

		lid.setBounds(300,50,500,40);
		sub.setBounds(200,290,500,60);
		att.setBounds(200,350,100,40);
		marks.setBounds(200,410,100,40);
		
		back.setBounds(10,50,100,60);
		submit.setBounds(500,400,100,40);
		
		
		back.addActionListener(this);
		submit.addActionListener(this);
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	

	
	
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()== submit)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
		PreparedStatement st = con.prepareStatement("Insert into academics Values("+stid+",'"+subid+"','"+t2.getText()+"','"+t3.getText()+"');");
		st.executeUpdate();
		JOptionPane.showMessageDialog(null, "Done!", " ", JOptionPane.INFORMATION_MESSAGE);
		con.close();
		ed.setVisible(false);
		new Acdman();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	else
	{
		ed.setVisible(false);;
		new Acdman();
	}
	}
}





