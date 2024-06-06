package org.piyush.project1;
import java.sql.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver class loaded and register");
            con=DriverManager.getConnection("URL");
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
			System.out.println("close costely resources")
		}

	}

}
