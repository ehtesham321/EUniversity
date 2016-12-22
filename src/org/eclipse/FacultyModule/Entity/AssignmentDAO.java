package org.eclipse.FacultyModule.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.mysql.jdbc.PreparedStatement;

public class AssignmentDAO {
	
	public Connection getCon() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
	}
	
	public void enterAssignment(String courseid, String assid, String que1, String que1opt1, String que1opt2,
			String que1opt3, String que1opt4, String que2, String que2opt1, String que2opt2, String que2opt3,
			String que2opt4) {
		
			
			String str = "insert into test1.assignment(insId,courseid,que1,que2,opt1que1,opt2que1) values(?,?,?,?,?,?)";
			try{
				//Class.forName("com.mysql.jdbc.Driver").newInstance();
					
				Connection myCon = this.getCon();
					
					//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
					
					//Statement myStat = myCon.createStatement();
					//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";
					
				PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);
				
				
					myStat1.setInt(1,6);
					myStat1.setString(2,courseid);
					//myStat1.setInt(3,0);
					myStat1.setString(3,que1);
					myStat1.setString(4,que2);
					myStat1.setString(5,que1opt1);
					myStat1.setString(6,que1opt2);
					/*
					myStat1.setString(8,user1.getSex());
					myStat1.setString(9,"10/10/1991");
					myStat1.setString(10,user1.getAddress());
		
					*/
					
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
		// TODO Auto-generated method stub
	public static String[] Randomize(String[] arr) {
	    String[] randomizedArray = new String[arr.length];
	    System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
	    Random rgen = new Random();

	    for (int i = 0; i < randomizedArray.length; i++) {
	        int randPos = rgen.nextInt(randomizedArray.length);
	        String tmp = randomizedArray[i];
	        randomizedArray[i] = randomizedArray[randPos];
	        randomizedArray[randPos] = tmp;
	    }

	    return randomizedArray;
	}
	
	public String getAssignment(String courseid) {
		String Assign = null;
		
		String str = "select que1,que2,opt1que1,opt2que1 from assignment where courseid=?";
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				Connection myCon = this.getCon();
				
				//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
				
				//Statement myStat = myCon.createStatement();
				//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";

				Statement myStat = myCon.createStatement();
				//System.out.println("Did this really come here??");
				//3. Execute the query
				ResultSet myRes = myStat.executeQuery("select assid,que1,que2,opt1que1,opt2que1 from assignment where courseid=\""+courseid +"\" ");
				
				
				myRes.first();
				Assign = myRes.getString("que1")+"&"+myRes.getString("opt1que1")+"&"+myRes.getString("que2")+"&"+myRes.getString("opt2que1");
				System.out.println(Assign);
				//4. Process the result set
				//Instructor ins = new Instructor();
				while (myRes.next()){
					String Assign1 = myRes.getString("que1")+"&"+myRes.getString("opt1que1")+"&"+myRes.getString("que2")+"&"+myRes.getString("opt2que1");
					System.out.println(Assign1);
					//System.out.println(myRes.getString("insId")+"|"+myRes.getString("insName") );
				}
				
		
				
				
				myStat.close();
				myCon.close();
				//myRes.close();

			}catch (Exception exp){
				exp.printStackTrace();
			}finally {
				
				
			}
			return Assign;
		}

		public void setgrade(int marks, String assid, int insId, String courseid) {
		// TODO Auto-generated method stub
				
				String str = "insert into test1.gradecenter(grade,studentid,courseid,assignmentid) values(?,?,?,?)";
				//UPDATE components SET Quantity=x WHERE components.sno='y';
				String str1 = "UPDATE test1.studenttakes SET grade=? where studentid=\""+insId+"\" AND courseid=\""+courseid+"\"";
				try{
					//Class.forName("com.mysql.jdbc.Driver").newInstance();
						
					Connection myCon = getCon();
						
						//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
						System.out.println(str1);
						//Statement myStat = myCon.createStatement();
						//String str = "insert into user(username,password,type,dept,fname,lname,phone,sex,dob,address) values(?,?,?,?,?,?,?,?,?.?)";
						PreparedStatement myStat2 = (PreparedStatement) myCon.prepareStatement(str1);	
						
						myStat2.setInt(1,marks);
						//myStat2.setInt(2,insId);
						//myStat2.setString(3,courseid);
						
						myStat2.execute();
						
						PreparedStatement myStat1 = (PreparedStatement) myCon.prepareStatement(str);					
						myStat1.setInt(1,marks);
						myStat1.setString(3,courseid);
						//myStat1.setInt(3,0);
						myStat1.setString(4,assid);
						myStat1.setInt(2,insId);
				
						
						myStat1.execute();
						
						myStat2.close();
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
		
		
		


