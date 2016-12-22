package org.eclipse.FacultyModule.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

public class LoginValidation {
	public static int LoginValidate(String user, String pass,String type) {
		// TODO Auto-generated method stub
		int retString = 0;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

			//3. Execute the query
			String query = "select id,username,type,password from user where username=?;";
			
			//2. Create a statement
			PreparedStatement myStat = myCon.prepareStatement(query);
			
			myStat.setString(1,user);
			
			ResultSet myRes = myStat.executeQuery();
			
			//4. Process the result set
			
			
			
			while (myRes.next()){
				//if(pass.equals(myRes.getString("password")) && type.toLowerCase().equals(myRes.getString("type"))){
				if(pass.equals(myRes.getString("password"))){
					retString=myRes.getInt("id");
					System.out.println("login sucessful");
				}
				else{
					retString=0;
				}


				
			//	System.out.println(myRes.getString("insId") + " |"+ myRes.getString("insName") );
			}
			myCon.close();
			myStat.close();
			myRes.close();
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		return retString;
}
	

}
