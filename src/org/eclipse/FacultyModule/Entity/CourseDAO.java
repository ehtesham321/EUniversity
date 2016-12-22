package org.eclipse.FacultyModule.Entity;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class CourseDAO {
	
	
	public Connection getCon() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
	}
	
	public void insertContentToDB(String courseId, int insId2, String contentTitle, String instructions, InputStream fileContent) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
	Connection myCon = getCon();
	
	//String filePath = "D:/Photos/Tom.jpg";
	
	//InputStream inputStream = new FileInputStream(new File(filePath));
	System.out.println("courseId");
	System.out.println(courseId);
	//System.out.println(fileContent);

	
	String sql = "INSERT INTO coursecontent (courseid,insId,contenttitle,instruction,content2) values (?,?,?,?,?)";
	
	PreparedStatement statement = (PreparedStatement) myCon.prepareStatement(sql);
	statement.setString(1, courseId);
	statement.setInt(2, insId2);
	statement.setString(3,contentTitle);
	statement.setString(4, instructions);
	statement.setBlob(5, fileContent);
	
	statement.execute();
	
	myCon.close();
	statement.close();
	return;
	
	}
	
	public void AddStudentToCourse(String courseId, int insId2) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Connection myCon = getCon();
		
		//String filePath = "D:/Photos/Tom.jpg";
		
		//InputStream inputStream = new FileInputStream(new File(filePath));
		System.out.println("courseId");
		System.out.println(courseId);
		//System.out.println(fileContent);

		
		String sql = "INSERT INTO studenttakes (courseid,studentid) values (?,?)";
		
		PreparedStatement statement = (PreparedStatement) myCon.prepareStatement(sql);
		statement.setString(1, courseId);
		statement.setInt(2, insId2);
		
		statement.execute();
		
		myCon.close();
		statement.close();
		return;
		
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
		return;
		
		
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


	public void AddCourse(Course course) {
		
		String str = "insert into test1.course(courseid,coursetitle,coursedesc,insId) values(?,?,?,?)";
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
			Connection myCon = getCon();
				
			PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);
		
				myStat1.setString(1,course.getCourseId());
				myStat1.setString(2,course.getCourseName());
				myStat1.setString(3,course.getCourseExplanation());
				myStat1.setInt(4,course.getInsId());
				
				
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
	

