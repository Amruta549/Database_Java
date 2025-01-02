package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Name");
		String name=sc.next();
		
		System.out.println("Enter Roll Numnber");
		String rollno=sc.next();
		
		System.out.println("Enter Branch");
		String branch=sc.next();
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter gender");
		String gender=sc.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driver class Successfully loaded");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","amruta123");
		//PreparedStatement p=conn.prepareStatement("insert into student values('rita','101','CSE','rita@gmail.com','female')");
		// giving variable as input
		//PreparedStatement p=conn.prepareStatement("insert into student values('"+name+"','"+rollno+"','"+branch+"','"+email+"','"+gender+"')");
		PreparedStatement p=conn.prepareStatement("insert into student values(?,?,?,?,?)");
		
		// positional parameters used 
		p.setString(1, name);
		p.setString(2, rollno);
		p.setString(3, branch);
		p.setString(4, email);
		p.setString(5, gender);
		
		int val=p.executeUpdate();
		
		if(val>0)
		{
			System.out.println("Success");	
		}
		else
		{
			System.out.println("Fail");
		}
	}

}
