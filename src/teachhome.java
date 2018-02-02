import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;

public class teachhome implements ActionListener
{
	JFrame th;
	JButton back, marks;
	
	teachhome()
	{
		String teaid=Teacher.getid();
		JLabel lid = new JLabel(teaid);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manattDB","root","universe1");
		Statement st;
		st = con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM teachers Where teacher_id="+teaid+";");
		rs.next();
		JLabel lname = new JLabel("Name: "+rs.getString(4)+" "+rs.getString(2)+" "+rs.getString(3));
		th = new JFrame("Teacher Home");
		th.setVisible(true);
		back =new JButton("Log Out");
		marks =new JButton("Enter Academics");
		th.setLayout(null);
		th.setSize(750,500);
		th.add(back);
		th.add(marks);
		th.add(lid);
		th.add(lname);
		lid.setBounds(300, 100, 500, 60);
		lname.setBounds(200, 150, 500, 60);
		back.setBounds(10,50,100,60);
		marks.setBounds(200,230,500,60);
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		marks.addActionListener(this);
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			th.setVisible(false);
			new Teacher();
		}
		else if(e.getSource()==marks)
		{
			th.setVisible(false);
			new Acdman();
		}
		
	}
}
