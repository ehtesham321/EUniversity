package org.eclipse.FacultyModule.Entity;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class DAOs {
	
	
	public Connection getCon() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
	}
	
	public byte[] getContent(String contentid) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
				
	        
				//String cs = (String) request.getAttribute("contentid");
	        
		byte[] buffer = null;
	       		 try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				
	            //Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
	        	Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

	       		 Statement statement = myCon.createStatement();
	            
	            
	            String query = "select contenttitle,instruction,content2 from coursecontent where contentid=?;";
	           
	            PreparedStatement myStat = (PreparedStatement) myCon.prepareStatement(query);
	            myStat.setString(1,contentid);
	            //myStat.setString(1,sess.getAttribute("courseid"));
	            
	            ResultSet myRes = myStat.executeQuery();
	           
	           	myRes.first();
	           	
	           	
	           	buffer = myRes.getBytes("content2");
	            
	       
	     myCon.close();
			 myRes.close();
	     
	     //System.out.println(input.toString());
	    // System.out.println(pdfContent.length);
	    
	     }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
				return buffer;
		
		
		 
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
		
		public String getUserName(String insId){
		String insname = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
			Connection myCon = getCon();
			
			//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			ResultSet myRes = myStat.executeQuery("Select * from user where id=\""+insId+"\" ");
			//String fname = myRes.getString("fname");
			//String lname = myRes.getString("lname");
			//insname = fname + " " + lname;
			//4. Process the result set
			Instructor ins = new Instructor();
			while (myRes.next()){
				String fname = myRes.getString("fname");
				String lname = myRes.getString("lname");
				insname = fname;
				//System.out.println(myRes.getString("insId") + "|"+ myRes.getString("insName") );
			}
			
			myCon.close();
			myStat.close();
			myRes.close();

		}catch (Exception exp){
			exp.printStackTrace();
		}
		return insname;
		
	}
	public void getCourseForInstructor(String insId){
		try{
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			
			ResultSet myRes = myStat.executeQuery("Select courseId,courseName from Courses where insName=\""+insId+"\" ");
			
			
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
	//1. Get a connection to the database
	//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");


	public void AddUser(Stu user1) {
		
		String str = "insert into test1.user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?,?)";
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
			Connection myCon = getCon();
				
				//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
				
				//Statement myStat = myCon.createStatement();
				//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";
				
			PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);
			
				
				
				myStat1.setString(1,user1.getUsername());
				myStat1.setString(2,user1.getPass());
				myStat1.setString(3,user1.getType());
				myStat1.setString(4,"CS");
				myStat1.setString(5,user1.getFname());
				myStat1.setString(6,user1.getLname());
				myStat1.setInt(7,973874456);
				myStat1.setString(8,user1.getSex());
				myStat1.setString(9,"10/10/1991");
				myStat1.setString(10,user1.getAddress());
	
				
				
				System.out.println(user1.getAddress());
				System.out.println(user1.getPass());
				
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


	public boolean CheckUser(Stu stud) {
		try{
			
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
			
			
			Statement myStat = myCon.createStatement();
			
			//3. Execute the query
			
			ResultSet myRes = myStat.executeQuery("Select * from user where username=\""+stud.getUsername()+"\" ");
			
			
			//4. Process the result set
			
			//Instructor ins = new Instructor();
			
			while (myRes.next()){
				return true;
			}
			
			myCon.close();
			myStat.close();
			myRes.close();

		}catch (Exception exp){
			exp.printStackTrace();
		}
		return false;
	}


	
		
	}
	

