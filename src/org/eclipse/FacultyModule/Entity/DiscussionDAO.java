package org.eclipse.FacultyModule.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DiscussionDAO {
public Connection getCon() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
	}
	
	
	public void getInstructorDTO(String insId){
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
			Connection myCon = getCon();
			//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			ResultSet myRes = myStat.executeQuery("Select * from Instructor where insName=\""+insId+"\" ");
			
			
			//4. Process the result set
			Instructor ins = new Instructor();
			while (myRes.next()){
				System.out.println(myRes.getString("insId") + "|"+ myRes.getString("insName") );
			}
			
			myCon.close();
			myStat.close();
			myRes.close();

		}catch (Exception exp){
			exp.printStackTrace();
		}
		
	}


	public void addQueToDB(String question, int insId, String courseid) {
		String str = "insert into test1.dissque(question,userid,courseid) values(?,?,?)";
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
			Connection myCon = getCon();
				
				//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
				
				//Statement myStat = myCon.createStatement();
				//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";
				
			PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);
			
				
				
				myStat1.setString(1,question);
				myStat1.setInt(2,insId);
				myStat1.setString(3,courseid);
				

				myStat1.execute();
				
				
				myStat1.close();
				myCon.close();
				//myRes.close();

			}catch (Exception exp){
				exp.printStackTrace();
			}finally {
				
				
			}
			return;
		}


	public void addAnsToDB(String answer, int insId, String courseid, int questionid) {
		// TODO Auto-generated method stub
		String str = "insert into test1.dissans(answer,userid,courseid,queid) values(?,?,?,?)";
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
			Connection myCon = getCon();
				
				//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
				
				//Statement myStat = myCon.createStatement();
				//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";
				
			PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);
			
				
				
				myStat1.setString(1,answer);
				myStat1.setInt(2,insId);
				myStat1.setString(3,courseid);
				myStat1.setInt(4,questionid);
				

				myStat1.execute();
				
				
				myStat1.close();
				myCon.close();
				//myRes.close();

			}catch (Exception exp){
				exp.printStackTrace();
			}finally {
				
				
			}
			return;
	}
		
	}

