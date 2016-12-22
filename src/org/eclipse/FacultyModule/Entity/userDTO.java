package org.eclipse.FacultyModule.Entity;

	public class userDTO {
		   private String fname;
		   private String lname;
		   private String pass;
		   private String type;
		   private String dept;
		   private String dob;
		   private int phone;
		   private String sex;
		   private String address;

		   userDTO(String fname,String lname,String pass, String type, String dept,String dob,int phone,String sex,String address){
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

		   public String getFame() {
		      return fname;
		   }

		   public void setName(String name) {
		      this.fname = name;
		   }

		   public String getType() {
		      return type;
		   }

		   public void setType(String type) {
		      this.type = type;
		   }
		}

