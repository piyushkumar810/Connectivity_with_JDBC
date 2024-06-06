package org.piyush.demo4;

import java.sql.*;
import java.util.Scanner;

public class getting_withName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String qry="select * from piyushdb2.tata where emp_name=?";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter employee name");
		String emp_name=sc.nextLine();
		
		sc.close();
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Driver class is loaded");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
//			System.out.println("connecting with database");
			
			
			pstmt=con.prepareStatement(qry);
			
//			set data from placeholder 
			pstmt.setString(1, emp_name);
//			executing sql query
            rs=pstmt.executeQuery();
            
            if(rs.next())
            {
            	int emp_id=rs.getInt(1);
            	double emp_salary=rs.getDouble(3);
            	String emp_work=rs.getString(4);
            	
            	System.out.println("name="+emp_id);
            	System.out.println("Salary="+emp_salary);
            	System.out.println("work="+emp_work);
            	
            	
            	System.out.println("data fetched");
            	
            	
            }
            
            else {
            	System.err.println("no data found for name= "+ emp_name);
            }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
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
//			System.out.println("close All costely resources");
	}

	}

}
