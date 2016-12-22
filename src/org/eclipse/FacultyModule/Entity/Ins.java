package org.eclipse.FacultyModule.Entity;

public class Ins implements user {

	private String fname;
	private String lname;
	   private String pass;
	   private String type="Instructor";
	   private String dept;
	   private String dob;
	   private String phone;
	   private String sex;
	   private String address;
	
	public void initialize(String fname, String lname, String pass, String type, String dept, String dob, String phone,
			String sex, String address) {
		this.fname = fname;
	      this.lname = lname;
	      this.pass = pass;
	      this.type = type;
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
	public String getFame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize(String username, String fname, String lname, String pass, String type, String dept,
			String dob, String phone, String sex, String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
