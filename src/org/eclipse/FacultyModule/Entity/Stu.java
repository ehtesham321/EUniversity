package org.eclipse.FacultyModule.Entity;

public class Stu implements user{
	 private String username;
	   private String fname;
	   private String lname;
	   private String pass;
	   private String type="Student";
	   private String dept;
	   private String dob;
	   private String phone;
	   private String sex;
	   private String address;
	   
	   
	   public void initialize(String username,String fname, String lname, String pass, String type, String dept, String dob, String phone,
				String sex, String address) {
		   	  this.username = username;
			  this.fname = fname;
		      this.lname = lname;
		      this.pass = pass;
		      //this.type = type;
		      this.dept = dept;
		      this.dob = dob;
		      this.phone = phone;
		      this.sex = sex;
		      this.address = address;

			
		}
	public void userDTO(String fname, String lname, String pass, String type, String dept, String dob, String phone,
			String sex, String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public String getFname() {
		// TODO Auto-generated method stub
		return fname;
	}
	public String getLname() {
		// TODO Auto-generated method stub
		return lname;
	}
	public String getPass() {
		// TODO Auto-generated method stub
		return pass;
	}
	public String getSex() {
		// TODO Auto-generated method stub
		return sex;
	}
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getFame() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
