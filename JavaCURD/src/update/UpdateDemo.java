package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Rollno :");
		String rollno=sc.next();
		
		System.out.println("Enter the email for updation");
		String email=sc.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","amruta123");
		
		PreparedStatement p=conn.prepareStatement("update student set  email=? where rollno=? ");
		
		p.setString(1, email);
		p.setString(2, rollno);
		
		int cnt=p.executeUpdate();
		if(cnt>0)
		{
			System.out.println("Updated Succesfully");
		}
		else
		{
			System.out.println("Updation Failed");
		}
		conn.close();
		
}

}
