package org.eclipse.FacultyModule.Entity;

public class userFactory {
	
	   //use getShape method to get object of type shape 
	   public user getUser(String userType){
		   if(userType == null){
			   return null;
		   }
		   else if(userType.equalsIgnoreCase("Instructor")){
			   return new Ins();
		   }
		   else if(userType.equalsIgnoreCase("Student")){
			   return new Stu();
		   }
		   return null;
	   }
}
