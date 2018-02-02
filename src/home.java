import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;   
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class home implements ActionListener
{
	JButton teacher;
	JButton student;
	JButton admin;
	JFrame h;
	
home()
{
	h = new JFrame("Home - College Database");
	h.setVisible(true);
	h.setSize(750, 500);
	h.setLayout(null);
	JLabel choose = new JLabel("Choose the mode:");
	choose.setFont(new Font("Comic Sans", Font.BOLD, 20));
	
	teacher = new JButton("Teacher");
	student = new JButton("Student");
	admin = new JButton("Admin");
	teacher.setBounds(300,250,100,40);
	student.setBounds(300,300,100,40);
	admin.setBounds(300,200,100,40);
	choose.setBounds(100,10,200,40);
	
	h.add(teacher);
	h.add(student);
	h.add(admin);
	h.add(choose);
	
	admin.addActionListener(this);
	student.addActionListener(this);
	teacher.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==teacher)
	{
		h.setVisible(false);
		new Teacher();
	}
	else if(e.getSource()==student)
	{
		h.setVisible(false);
		new student();
	}
	else if(e.getSource()==admin)
	{
		h.setVisible(false);
		new admin();
	}
}	
public static void main(String args[])
{
	new home();
}
}

