<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.eclipse.FacultyModule.Entity.DAOs"%>
<%@ page import="org.eclipse.FacultyModule.Entity.Stu"%>
<%@ page import="org.eclipse.FacultyModule.Entity.user"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


<html>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="stylesheet.css">
<body>
<nav class="w3-sidenav w3-light-grey w3-card-2" style="width:20%" style="height:100%">
    <a href="Logout.jsp">Logout</a>
   <a href="GradeCenter.jsp"> <- Back</a> 
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

<%    HttpSession sess = request.getSession();
    
    String cs = (String) request.getAttribute("courseid");
    
    //String courseid = sess.getAttribute("courseid");
    
    
    //int insId = (Integer) sess.getAttribute("insId");
    
    Class.forName("com.mysql.jdbc.Driver").newInstance();
      
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

        Statement statement = myCon.createStatement();
      
      //String query = "select studentid,grade from gradecenter where courseid=?;";
      String query = "select studentid,fname,lname,courseid,grade from gradecenter,user where gradecenter.studentid=user.id AND courseid=? ORDER BY studentid ASC;";
      //2. Create a statement
      PreparedStatement myStat = myCon.prepareStatement(query);
      
      myStat.setString(1,cs);
      //myStat.setString(1,sess.getAttribute("courseid"));
      
      ResultSet myRes = myStat.executeQuery();
    
            
              //while (myRes.next()){
            //System.out.println(myRes.getString("studentid") +"|"+ myRes.getString("grade"));
  
%>
<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Grade Center</h1>
</header>
<%if(!myRes.next()) {
    out.println("Sorry, could not find any grades for this course");
}else{ %>
<div>
<TABLE BORDER="1">
            <TR>
                <TH>ID</TH>
                <TH>Grade</TH>
                <TH>First</TH>
                <TH>Last</TH>
                <TH>Course</TH>
            
            </TR>
            <TR><% myRes.first(); %>
            <TD> <%= myRes.getString("studentid") %></td>
                <TD> <%= myRes.getString("grade") %></TD>
                <TD> <%= myRes.getString("fname") %></td>
                <TD> <%= myRes.getString("lname") %></TD>
                <TD> <%= myRes.getString("courseid") %></TD>
           
            </TR>
            
            <% while(myRes.next()){ %>
            <c:forEach items="${styles}" var="style">
  		
 			
            <display:table name="gradetable" sort="external" defaultsort="1" id="element">
  			<display:column property="id" title="ID" sortable="true" sortName="id" value=<%= myRes.getString("studentid") %> />
  			<display:column property="firstName" sortable="true" sortName="firstName" title=<%= myRes.getString("fname") %> />
 			<display:column property="lastName" sortable="true" sortName="lastName" title="Last Name" />
 			<display:column property="address" sortable="true" sortName="address" title="Email Address"/>
			</display:table>
			 </c:forEach>
            <TR>
                <TD> <%= myRes.getString("studentid") %></td>
                <TD> <%= myRes.getString("grade") %></TD>
                <TD> <%= myRes.getString("fname") %></td>
                <TD> <%= myRes.getString("lname") %></TD>
                <TD> <%= myRes.getString("courseid") %></TD>
               
            </TR>
            <% }}%>
        </TABLE>   
<div class="container" >

</div>


</div>
</div>
 
</body>
</html>
