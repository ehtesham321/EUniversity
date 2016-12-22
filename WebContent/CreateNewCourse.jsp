<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>create course</title>
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

 

<div style="margin-left:20%">
<header class="w3-container w3-teal">
  <h1>Create Course</h1>
</header>

<div>

<div class="container" >

<form action="CreateNewCourse" method="post">
<fieldset>


<legend>Create Course</legend>


<div class="form-group">
  <label class="col-md-4 control-label" for="courseid">Course ID</label>  
  <div class="col-md-5">
  <input id="courseid" name="courseid" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Eg. CS##</span>  
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="coursetitle">Course Title</label>  
  <div class="col-md-5">
  <input id="coursetitle" name="coursetitle" type="text" placeholder="Title" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="coursedesc">Course Description</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="coursedesc" name="coursedesc">Course Description</textarea>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">Submit</button>
  </div>
</div>

</fieldset>
</form>

</div>

 
</div>
</div>
 
</body>
</html>
