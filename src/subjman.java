import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;


public class subjman implements ActionListener{

JFrame sm;
JButton submit;
JTextField t1 = new JTextField(20);
JTextField t2 = new JTextField(20);


subjman()
{
	sm=new JFrame("Subject Manager");
	sm.setSize(750, 750);
	sm.setVisible(true);
	sm.setLayout(null);
	
	JLabel sid = new JLabel("Subject ID:");
	JLabel sname = new JLabel("Subject Name : ");	
	submit = new JButton("Submit");
	JButton back = new JButton("Back");
	
	sm.add(t1);
	sm.add(t2);

	sm.add(sid);
	sm.add(sname);
	sm.add(submit);
	sm.add(back);
	
	t1.setBounds(300,100,100,40);
	t2.setBounds(300,150,100,40);

	sid.setBounds(200,100,100,40);
	sname.setBounds(200,150,100,40);
	
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
		PreparedStatement st = con.prepareStatement("Insert into subjects Values("+t1.getText()+",'"+t2.getText()+"');");
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






