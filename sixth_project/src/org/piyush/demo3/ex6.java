package org.piyush.demo3;
import java.sql.*;

public class ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		
//		this statement interface is used to perform 
		Statement stmt=null;
		
		
//		-----------------------------insert data into the table-------------------
//		String str1="insert into piyushdb2.tata values(20123, 'suraj', 38000, 'ai_programmer')";
//		String str2="insert into piyushdb2.tata values(20124, 'sikendar', 25000, 'car_designer')";
//		String str3="insert into piyushdb2.tata values(20125, 'piyush', 35000, 'manager')";
		
//		-----------------------------update data into the table
		String upd1="update piyushdb2.tata set emp_name='kundan' where emp_id=20124 ";
		
//		----------------------------------delete column into the table-----------------
		String del1="delete piyushdb2.tata where id=20124" ;
		
		try {
//			--------------------------1. load and register class-----------------------------
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class is loaded");
			
//			-----------------2. setting the connection with database server---------------------
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("connecting to database server");
			
//			----------------------3. creating statement or platform so that we can work with SQL command----------
			stmt=con.createStatement();
			System.out.println("statement created");
			
//			--------------------------------------performing CURD operations--------------------------
//			stmt.executeUpdate(str1);
//			stmt.executeUpdate(str2);
//			stmt.executeUpdate(str3);	
			
			stmt.executeUpdate(upd1);
			
			stmt.executeUpdate(del1);
			
			
			System.out.println("record inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
//		------------------------------close all the costly resources------------------------
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			if(con!=null)
			{
				try {
					con.close();
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
			System.out.println("all costaly resources are closed");
		}

	}

}
