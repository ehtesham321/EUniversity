<%@page import="org.eclipse.FacultyModule.Entity.AssignmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.eclipse.FacultyModule.Entity.DAOs"%>
<%@ page import="org.eclipse.FacultyModule.Entity.Stu"%>
<%@ page import="org.eclipse.FacultyModule.Entity.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="stylesheet.css">
<body>
<nav class="w3-sidenav w3-light-grey w3-card-2" style="width:20%" style="height:100%">
    <a href="Logout.jsp">Logout</a>
   <a href="StudentAssignmentCenter.jsp"> <- Back</a> 
  <br/><br/><br/>
  <a href="DiscussionBoard.jsp">Discussion Board</a> 
  <div class="w3-dropdown-hover">
    <a href="#">Course  <i class="fa fa-caret-down"></i></a>
    <div class="w3-dropdown-content w3-white w3-card-4">
      <a href="StudentSeeCourses.jsp">See Courses</a>
      <a href="StudentAssignmentCenter.jsp">Assignment Center</a>
    </div>
  </div> 
  <a href="StudentGradeCenter.jsp">Grade Center</a> 
</nav>

<%  
	String que1 = (String) request.getAttribute("que1");
	String ans1 = (String) request.getAttribute("ans1");
	String que2 = (String) request.getAttribute("que2");
	String ans2 = (String) request.getAttribute("ans2");
	
	String[] parts_ans1 = ans1.split("=");
	String[] parts_ans2 = ans2.split("=");
	
	String[] ran_parts_ans1 = AssignmentDAO.Randomize(parts_ans1);
	String[] ran_parts_ans2 = AssignmentDAO.Randomize(parts_ans2);
	
	String Fans1="";
	String Fans2="";
	
	for(int i=0; i < ran_parts_ans1.length ; i++){
		if(ran_parts_ans1[i].split("-")[1].equals("t")){
			int j = i+1;
			Fans1=Fans1+"a"+j;
		}
	}
	for(int i=0; i < ran_parts_ans2.length ; i++){
		if(ran_parts_ans2[i].split("-")[1].equals("t")){
			int j = i+1;
			Fans2=Fans2+"b"+j;
		}
	}
	
	System.out.println("Fans1"+Fans1);
	System.out.println("Fans2"+Fans2);
	HttpSession sess = request.getSession();
	sess.setAttribute("Fans1", Fans1);
	sess.setAttribute("Fans2", Fans2);
	
	//request.setAttribute("Fans1", Fans1);
	//request.setAttribute("Fans2", Fans2);
	
	
%>

<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Assignment</h1>
</header>

<div>



<h3>Assignment</h3>

<div class="container" >
<form action="AutoGraderServlet" method="post">
<fieldset>
<p  class="que1"><b>QUESTION 1:</b> <%= que1 %></p>
<input type="checkbox" name="checkbox1" value="a1"> <%=ran_parts_ans1[0].split("-")[0] %><br>
<input type="checkbox" name="checkbox1" value="a2"> <%=ran_parts_ans1[1].split("-")[0] %><br>
<input type="checkbox" name="checkbox1" value="a3"> <%=ran_parts_ans1[2].split("-")[0] %><br>
<input type="checkbox" name="checkbox1" value="a4"> <%=ran_parts_ans1[3].split("-")[0] %><br>
<hr/>
<p  class="que2"><b>QUESTION 2:</b> <%= que2 %> </p>
<input type="checkbox" name="checkbox2" value="b1"> <%=ran_parts_ans2[0].split("-")[0] %><br>
<input type="checkbox" name="checkbox2" value="b2"> <%=ran_parts_ans2[1].split("-")[0] %><br>
<input type="checkbox" name="checkbox2" value="b3"> <%=ran_parts_ans2[2].split("-")[0] %><br>
<input type="checkbox" name="checkbox2" value="b4"> <%=ran_parts_ans2[3].split("-")[0] %><br>
<hr/>
<input type="submit" value="submit"/>
</fieldset>
</form>
</div>
</div>
</div>
 
</body>
</html>
