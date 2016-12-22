package org.eclipse.FacultyModule.Entity;

public class Assignment {
	
	
	private String courseId;
	private String maxPoints;
	private String assignmentId;
	private String question;
	private String answer;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	
	public void setCourseId(String newCourseId){
		courseId = newCourseId;
	}
	public void setAssignmentId(String newAssignmentId){
		assignmentId = newAssignmentId;
	}
		
	
	//Getters
	public String getCourseId(){
		return courseId;
	}
	public String getAssignmentId(){
		return assignmentId;
	}

}
