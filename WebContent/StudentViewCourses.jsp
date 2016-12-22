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
   <a href="StudentDashboard.jsp"> <- Back</a> 
  <br/><br/><br/>
  <a href="StudentViewCourses.jsp">View Courses</a> 
  <a href="DiscussionBoard.jsp">Discussion Board</a> 
  <div class="w3-dropdown-hover">
    <a href="#">Course  <i class="fa fa-caret-down"></i></a>
    <div class="w3-dropdown-content w3-white w3-card-4">
      <a href="StudentSeeCourses.jsp">Your Courses</a>
      <a href="StudentAssignment.jsp">Assignment Center</a>
    <!--   <a href="UploadCourseContent.jsp">Upload Course Content</a> --> 
    </div>
  </div> 
  <a href="GradeCenter.jsp">Grade Center</a> 
</nav>

 
<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Enroll Courses</h1>
</header>

<div>

<div class="container" >

<h3>Courses Available to Enroll</h3>
<br/>
<%      HttpSession sess = request.getSession();

        int insId = (Integer) sess.getAttribute("insId");
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

            Statement statement = myCon.createStatement();
            
            String query = "select courseid,coursetitle,insId,coursedesc from course where NOT EXISTS (Select courseid from studenttakes where course.courseid=studenttakes.courseid AND studentid=\""+insId+"\" )";
           // String query = "select courseid,coursetitle,insId,coursedesc from course";
            //String query = "Select courseid from studenttakes where studentid=\""+insId+"\" ";
            //2. Create a statement
           	//PreparedStatement myStat = myCon.prepareStatement(query);,coursetitle,insId,coursedesc
            Statement stmt = myCon.createStatement();
            //myStat.setInt(1,insId);
            ResultSet myRes = stmt.executeQuery(query);
            
            //ResultSet myRes = myStat.executeQuery();
           
    
%>

<% if(!myRes.next()) {
    out.println("Sorry, could not find any courses to enroll");
}else{%>

<table class="node" id="node" style="width:100%">
<%
	 myRes.first();
	 DAOs daos = new DAOs();
	 String insname = daos.getUserName(myRes.getString("insId"));  %>
	 
  	<tr>
    <td><%=myRes.getString("courseid")%></td>
    <td><%=myRes.getString("coursetitle")%></td> 
    <td><%=insname%></td>
    <td ><a class="button1" href="StudentEnrollCourseServlet?courseid=<%=myRes.getString("courseid")%>">Enroll</a></td> 
  </tr>
  <tr>
    <td colspan="4"><i><%=myRes.getString("coursedesc")%></i></td>
  </tr>
 </table>
	
<% 	 myRes.first();
	DAOs daos1 = new DAOs();
	
	while (myRes.next()){
	String insname1 = daos.getUserName(myRes.getString("insId"));
    System.out.println(myRes.getString("courseid") +"|"+ myRes.getString("coursetitle")); %>
    <table class="node" id="node" style="width:100%">
	<tr>
    <td><%=myRes.getString("courseid")%></td>
    <td><%=myRes.getString("coursetitle")%></td> 
    <td><%=insname1%></td>
	 <td ><a class="button1" href="StudentEnrollCourseServlet?courseid=<%=myRes.getString("courseid")%>">Enroll</a></td>    
  </tr>
  <tr>
    <td colspan="4"><i><%=myRes.getString("coursedesc")%></i></td>
  </tr>  
 
<% }   %>
<% } %>
</table>
</div>


</div>
</div>
 
</body>
</html>
