import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;

public class studhome implements ActionListener
{
	JFrame sh;
	JButton back;
	
	studhome()
	{
		String studid=student.getid();
		JLabel lid = new JLabel(studid);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
		Statement st,st2,st3;
		st = con.createStatement();
		st2= con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM students Where student_id="+studid+";");
		if(rs.next())
		{
			ResultSet rs2=st2.executeQuery("Select subject_id, name, marks, attendance from subjects,academics where subject_id in(select subj from academics where stud="+studid+");");
			if(rs2.next())
			{
			JLabel lname = new JLabel("Name: "+rs.getString(4)+" "+rs.getString(2)+" "+rs.getString(3));
			JLabel lclass = new JLabel("Class: "+rs.getString(6)+" "+rs.getString(5));
			JLabel subject= new JLabel("Subject ID : " + rs2.getString(1)+"\t Subject Name : "+rs2.getString(2) +"  Marks : " + rs2.getString(3)+"  Attendance : "+ rs2.getString(4));
			sh = new JFrame("Student Home");
			sh.setVisible(true);
			back =new JButton("Log Out");
			sh.setLayout(null);
			sh.setSize(750,500);
			sh.add(back);
			sh.add(lid);
			sh.add(lname);
			sh.add(lclass);
			sh.add(subject);
			lid.setBounds(300, 100, 500, 60);
			lname.setBounds(200, 150, 500, 60);
			lclass.setBounds(200, 200, 500, 60);
			subject.setBounds(100,300,500,60);
			back.setBounds(10,50,100,60);
			}
			else
			{
				
			}
		}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			sh.setVisible(false);
			new student();
		}
		
	}	
}
