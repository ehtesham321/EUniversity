package org.eclipse.FacultyModule.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddInstructorToDB {

	public static void AddInstructorToDb(String id, String name, String pass) {
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			//1. Get a connection to the database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			//2. Create a statement
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			String query = "Insert into auth values("+name+","+pass+","+id+")";			
			
			boolean myRes = myStat.execute("Insert into Instructor values(\"007\",\"dada\")");
			
			
			
			System.out.println("added to DB");
			myCon.close();
			myStat.close();
			//myRes.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

	public static void AddInstructorToDb(user user1) {
		System.out.println(user1.toString());
		
		// TODO Auto-generated method stub
		
	}

	

	
		

}
