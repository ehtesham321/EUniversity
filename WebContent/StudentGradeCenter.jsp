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
 
  <a href="DiscussionBoard.jsp">Discussion Board</a> 
  <div class="w3-dropdown-hover">
    <a href="#">Course  <i class="fa fa-caret-down"></i></a>
    <div class="w3-dropdown-content w3-white w3-card-4">
      <a href="StudentSeeCourses.jsp">See Courses</a>
      <a href="StudentAssignmentCenter.jsp"> Assignment</a>
      
    </div>
  </div> 
  <a href="GradeCenter.jsp">Grade Center</a> 
</nav>

<%    HttpSession sess = request.getSession();
String query = "select courseid,grade from studenttakes where studentid=?;";
    String cs = (String) request.getAttribute("courseid");
    int insId = (Integer) sess.getAttribute("insId");
    //String courseid = sess.getAttribute("courseid");
    
    
    //int insId = (Integer) sess.getAttribute("insId");
    
    Class.forName("com.mysql.jdbc.Driver").newInstance();
      
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

        Statement statement = myCon.createStatement();
      
      
      String query1 = "select distinct studenttakes.courseid,gradecenter.grade from studenttakes left join gradecenter on studenttakes.courseid=gradecenter.courseid and gradecenter.studentid=? ";
     // String query = "select gradecenter.courseid,gradecenter.grade from studenttakes left join gradecenter on studenttakes.courseid=gradecenter.courseid AND studenttakes.studentid=gradecenter.studentid AND gradecenter.studentid=? ";
     
      
      //2. Create a statement
      PreparedStatement myStat = myCon.prepareStatement(query);
      System.out.println(insId);
      myStat.setInt(1,insId);
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
    out.println("Sorry, could not find any grades for you");
}else{ %>
<div>
<TABLE BORDER="1">
            <TR>
                <TH>Course</TH>
            	<TH>Grade</TH>
            </TR>
            <TR><%
            	myRes.first();
            	String grade1=""; 	
            	grade1 = myRes.getString("grade");
            	if( grade1 == null){
            	grade1 = "-";}%>
             <TD> <%= myRes.getString("courseid") %></TD>
             <TD> <%= grade1 %></TD>
            </TR>
            
            <%	
             
            	while(myRes.next()){
            	String grade=""; 	
            	grade = myRes.getString("grade");
            	if( myRes.getString("grade")==null){
            	grade = "-";}
            	
            %>
            <TR>
                <TD> <%= myRes.getString("courseid") %></TD>
                <TD> <%= grade %></TD>
               
            </TR>
            <% }}%>
        </TABLE>   
<div class="container" >

</div>


</div>
</div>
 
</body>
</html>
