package org.piyush.demo4;
import java.sql.*;
import java.util.Scanner;

public class input_userid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		String qry="select * from piyushdb2.tata where emp_id=?";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter employee id");
		int emp_id=sc.nextInt();
		
		sc.close();
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Driver class is loaded");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
//			System.out.println("connecting with database");
			
			
			pstmt=con.prepareStatement(qry);
			
//			set data from placeholder 
			pstmt.setInt(1, emp_id);
//			executing sql query
            rs=pstmt.executeQuery();
            
            if(rs.next())
            {
            	String emp_name=rs.getString(2);
            	double emp_salary=rs.getDouble(3);
            	String emp_work=rs.getString(4);
            	
            	System.out.println("name="+emp_name);
            	System.out.println("Salary="+emp_salary);
            	System.out.println("work="+emp_work);
            	
            	
            	System.out.println("data fetched");
            	
            	
            }
            
            else {
            	System.err.println("no data found for id= "+ emp_id);
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
