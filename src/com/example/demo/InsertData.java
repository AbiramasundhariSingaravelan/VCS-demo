package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			//Register the Driver
			//oracle.jdbc.driver.OracleDrivr
			Class.forName("com.mysql.jdbc.Driver");
			//Create a Connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsbatch","root","arthi");
			PreparedStatement pstmt=c.prepareStatement("insert into student values(?,?,?,?,?)");
			pstmt.setInt(1,4);
			pstmt.setInt(2, 104);
			pstmt.setString(3, "Sangavi");
			pstmt.setInt(4, 100);
			pstmt.setString(5, "Hyderabad");
			int i=pstmt.executeUpdate();
			System.out.println(i+ " Rows Inserted");
			PreparedStatement update=c.prepareStatement("update student set marks=? where sid=?");
			update.setInt(1, 98);
			update.setInt(2, 103);
			int updateCount=update.executeUpdate();
			System.out.println(updateCount+" rows updated");
			PreparedStatement delete=c.prepareStatement("delete from student where sid=?");
			delete.setInt(1, 102);
			int deleteCount=delete.executeUpdate();
			System.out.println(deleteCount+" rows deleted");
			c.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
