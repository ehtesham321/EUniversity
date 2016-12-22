package org.eclipse.FacultyModule.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddCourseToDB {

	public static void AddcourseToDb(String id, String name) {
		// TODO Auto-generated method stub
		try{
			//1. Get a connection to the database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			//2. Create a statement
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			String query = "Insert into Course values("+id+","+name+")";
			
			ResultSet myRes = myStat.executeQuery(query);
			 
			//4. Process the result set
			
			while (myRes.next()){
			//	System.out.println(myRes.getString("insId") + " |"+ myRes.getString("insName") );
			}
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		
	}

}
