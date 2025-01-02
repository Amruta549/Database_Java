package showall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("hello");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","amruta123");
		
		PreparedStatement p=conn.prepareStatement("select * from student");
		
		ResultSet rs=p.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Name : "+rs.getString("name"));
			System.out.println("RollNo : "+rs.getString("rollno"));
			System.out.println("Branch : "+rs.getString("branch"));
			System.out.println("Email : "+rs.getString("email"));
			System.out.println("Gender : "+rs.getString("gender"));
			System.out.println(".....................................");
		}
		
		conn.close();
	}

}
