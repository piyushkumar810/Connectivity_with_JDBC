package com.piyush.car;
import java.sql.*;


public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class loaded and register");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
            System.out.println("connecting with database");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
		finally {
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
			System.out.println("close costely resources");
	}

	}
}
