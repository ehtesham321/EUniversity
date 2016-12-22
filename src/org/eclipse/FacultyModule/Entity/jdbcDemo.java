package org.eclipse.FacultyModule.Entity;
import java.sql.*;

public class jdbcDemo {

	public jdbcDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//1. Get a connection to the database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			
			
			//2. Create a statement
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			
			ResultSet myRes = myStat.executeQuery("Select * from auth where userName=\"syed\" ");
			 
			//4. Process the result set
			
			while (myRes.next()){
				System.out.println(myRes.getString("password") + "|||"+ myRes.getString("insId") );
			}
			
			myCon.close();
			myStat.close();
			myRes.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
