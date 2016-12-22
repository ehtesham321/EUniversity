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
   <a href="InstructorDashboard.jsp"> <- Back</a> 
  <br/><br/><br/>
  <a href="CreateNewCourse.jsp">Create New Course</a> 
  <a href="DiscussionBoard.jsp">Discussion Board</a> 
  <div class="w3-dropdown-hover">
    <a href="#">Course  <i class="fa fa-caret-down"></i></a>
    <div class="w3-dropdown-content w3-white w3-card-4">
      <a href="SeeCourses.jsp">See Courses</a>
      <a href="CreateAssignment.jsp">Upload Assignment</a>
      <a href="UploadCourseContent.jsp">Upload Course Content</a>
    </div>
  </div> 
  <a href="GradeCenter.jsp">Grade Center</a> 
</nav>

<%      HttpSession sess = request.getSession();
		
		String courseId = (String) request.getAttribute("courseid");
		
		
        int insId = (Integer) sess.getAttribute("insId");
        sess.setAttribute("courseid", courseId);
        sess.setAttribute("insId", insId);
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

            Statement statement = myCon.createStatement();
            
            String query = "select queid,userid,question,uploadtime from dissque where courseid=?;";
            
            //2. Create a statement
            PreparedStatement myStat = myCon.prepareStatement(query);
            
            myStat.setString(1,courseId);
            
            ResultSet myRes = myStat.executeQuery();
               
            //System.out.println("5z55555555555555555555");
%>

<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Discussion Center</h1>
</header>
<h3>Discussion</h3>
<div>


<form class="" action="DiscussionQueServlet" method="post">

  <label class="col-md-4 control-label" for="que">Question</label>  
  <div class="col-md-8">
  <input id="que" name="que" type="text" placeholder="Question" class="form-control input-md">
  </div>
</div>


  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">Post Question</button>
  </div>


</form>
 
	
<% 	while (myRes.next()){%>
	<table style="width:100%" BORDER="1">
		  <tr>
		    <th colspan="3">Question</th>
		    <th >By</th>
		    <th >Time</th>
		  </tr>
		  <tr>
		    <th colspan="3"><%=myRes.getString("question")%></th>
		    <th ><%=myRes.getString("userid")%></th>
		    <th ><%//myRes.getString("uploadtime")%></th>
		  </tr>
	
	</table>

<form class="abc" action="DiscussionAnsServlet" method="post">
	<input type="hidden" name="queid" value="<%= myRes.getString("queid") %>">
  <input id="ans" name="ans" type="text" placeholder="Answer" class=""/>
   <button id="submit" name="submit" class="btn btn-primary">Answer Question</button>

</form>


		  <table style="width:100%" BORDER="1">
		  <tr>
		    <th colspan="3">Answers</th>
		    <th >By</th>
		    <th >Time</th>
		  </tr>
		  </table>
<%      
            String query1 = "select userid,answer,uploadtime from dissans where courseid=? AND queid=?;";
            
            //2. Create a statement
            PreparedStatement myStat1 = myCon.prepareStatement(query1);
            myStat1.setString(1,courseId);
            myStat1.setString(2,myRes.getString("queid"));
            
            ResultSet myRes1 = myStat1.executeQuery();
            while (myRes1.next()){
    
%>
<table style="width:100%" BORDER="1">
		  <tr>
		  
		    <th colspan="3"><%=myRes1.getString("answer")%></th>
		    <th ><%=myRes1.getString("userid")%></th>
		    <th ><%//myRes1.getString("uploadtime")%></th>
		  </tr>
		  </table>   
<% }  } %>

</table>
<div class="container" >
</div>
</div>
</div>
</div>
</body>
</html>
