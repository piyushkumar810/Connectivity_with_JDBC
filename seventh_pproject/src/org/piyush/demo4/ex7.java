package org.piyush.demo4;

import java.sql.*;

public class ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String qry="select * from piyushdb2.tata";//dql
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
            System.out.println("connecting with database");
            
            pstmt=con.prepareStatement(qry);
            rs=pstmt.executeQuery();
            
            while(rs.next())
            {
            	int id=rs.getInt(1);
            	String name=rs.getString(2);
            	int marks=rs.getInt(3);
            	String cource=rs.getString(4);
            }
            
		}
		catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
		finally {
			
			if(rs!=null)
			{
				try {
					rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
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
