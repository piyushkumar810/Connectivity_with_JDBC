package org.piyush.demo4;
import java.sql.*;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		Statement stmt=null;
		String qry="insert into piyushdb1.school values(58, 'piyush', 456, 'bca')";
		String qry1="insert into piyushdb1.school values(48, 'siku', 495, 'mba')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
            System.out.println("connecting with database");
            
            stmt=con.createStatement();
            System.out.println("Statement created");
            
            stmt.executeUpdate(qry);
            stmt.executeUpdate(qry1);
            System.out.println("record inserted");
		}
		catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			if(con!=null)
			{
				try {
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("close All costely resources");
	}
	}
}
