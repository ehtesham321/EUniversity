<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <a href="#"> <- Back</a> 
  <br/><br/><br/>
  <a href="StudentViewCourses.jsp">View Courses</a> 
  <a href="StudentDiscussionBoard.jsp">Discussion Board</a> 
  <div class="w3-dropdown-hover">
    <a href="#">Course  <i class="fa fa-caret-down"></i></a>
    <div class="w3-dropdown-content w3-white w3-card-4">
      <a href="StudentSeeCourses.jsp">Your Courses</a>
      <a href="StudentAssignmentCenter.jsp">Assignment Center</a>
    <!--   <a href="UploadCourseContent.jsp">Upload Course Content</a> --> 
    </div>
  </div> 
  <a href="StudentGradeCenter.jsp">Grade Center</a> 
</nav>

 
<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Welcome ${username}</h1>
</header>

<div>

<div class="container" >

</div>


</div>
</div>
 
</body>
</html>
