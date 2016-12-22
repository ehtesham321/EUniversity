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

        int insId = (Integer) sess.getAttribute("insId");
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

            Statement statement = myCon.createStatement();
            
            String query = "select courseid,coursetitle from course where insId=?;";
            
            //2. Create a statement
            PreparedStatement myStat = myCon.prepareStatement(query);
            
            myStat.setInt(1,insId);
            
            ResultSet myRes = myStat.executeQuery();
               
    
%>

<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Grade Center</h1>
</header>

<div>

<% if(!myRes.next()) {
    out.println("Sorry, could not find any courses for you");
}else{%>
<h3>Select Course</h3>
<%
	 myRes.first();%>
	  <tr><a href="GradeCenterServlet?courseid=<%=myRes.getString("courseid")%>&action=actionsend1"><%=myRes.getString("coursetitle")%></a></tr> 
	 <br/>
	
<% 	while (myRes.next()){
    System.out.println(myRes.getString("courseid") +"|"+ myRes.getString("coursetitle")); %>

<tr><a href="GradeCenterServlet?courseid=<%=myRes.getString("courseid")%>&action=actionsend1"><%=myRes.getString("coursetitle")%></a></tr>
<br/>    
<% }   %>
<% } %>
</table>
<div class="container" >

</div>
</div>
</div>
 
</body>
</html>
