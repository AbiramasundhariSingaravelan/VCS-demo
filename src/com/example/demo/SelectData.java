package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Register the Driver
			//oracle.jdbc.driver.OracleDrivr
			Class.forName("com.mysql.jdbc.Driver");
			//Create a Connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsbatch","root","arthi");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println("SNO: "+rs.getInt(1)+"--SID: " +rs.getInt(2)+"--"+"SNAME: "+rs.getString(3)+"--MARKS: "+rs.getInt(4)+"--ADDRESS: "+rs.getString(5));
			}
			c.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}

}
