package org.eclipse.FacultyModule.Entity;



public interface user{


	   void userDTO(String fname,String lname,String pass, String type, String dept,String dob,String phone,String sex,String address);

	   public String getFame();

	   public void setName(String name);



	   public void setType(String type);

	   void initialize(String username,String fname,String lname,String pass, String type, String dept,String dob,String phone,String sex,String address);
	public String getUsername();
	public String getFname();
	public String getLname();
	public String getPass();
	public String getSex();
	public String getAddress();
	public String getType();
	}

