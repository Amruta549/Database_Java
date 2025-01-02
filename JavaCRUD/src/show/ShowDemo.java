package show;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("hello");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","amruta123");
		PreparedStatement p=conn.prepareStatement("select * from student");
		
		ResultSet rs=p.executeQuery();
		
		System.out.println("Enter the detail to be displayed [name,rollno,email,branch]");
		String str=sc.next();
		
		int count=0;
		while(rs.next())
		{
//			String name=rs.getString("name");
			System.out.println(rs.getString(str));
			count++;
		}
		System.out.println("Total no.of Students :"+count);
		conn.close();
	}

}
