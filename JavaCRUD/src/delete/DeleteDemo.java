package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the ID to be deleted");
		String email=sc.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","amruta123");
		PreparedStatement p=conn.prepareStatement("delete from student where rollno=?");
		p.setString(1,email);
		int cnt= p.executeUpdate();
		//System.out.println(cnt);
		if(cnt>0)
		{
			System.out.println("Deletion Successfull");
		}
		else
		{
			System.out.println("Deletion Failed");
		}
	}

}




	
		
		
		