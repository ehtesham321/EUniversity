package org.eclipse.FacultyModule.Entity;

public class Course {
	private String courseId;
	private String courseName;
	private int insId;
	private String courseSem;
	private String courseDesc;

	// Setters
	public void setCourseId(String newCourseId){
		courseId = newCourseId;
	}
	public void setCourseName(String newCourseName){
		courseName = newCourseName;
	}
	public void setCourseExplanation(String newCourseExplanation){
		courseDesc = newCourseExplanation;
	}
	public void setIns(int cinsId) {
		insId = cinsId;
		
	}

		
	
	//Getters
	public String getCourseId(){
		return courseId;
	}
	public String getCourseName(){
		return courseName;
	}
	public String getCourseExplanation(){
		return courseDesc;
	}
	public int getInsId(){
		return insId;
	}
	
	

}
