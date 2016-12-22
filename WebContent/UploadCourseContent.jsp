<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>upload content</title>
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
  <h1>Upload Content</h1>
</header>

<div>

<div class="container" >

<form class="UploadContent" action="UploadContent" method="post" enctype="multipart/form-data">
<fieldset>
<legend>Upload Content</legend>
<br/>
<div class="form-group">
  <label class="col-md-4 control-label" for="courseid">Course ID</label>  
  <div class="col-md-5">
  <input id="courseid" name="courseid" type="text" placeholder="" class="form-control input-md" required="">
    
  </div>
</div>
<br/>
<div class="form-group">
  <label class="col-md-4 control-label" for="contenttitle">Content Title</label>  
  <div class="col-md-5">
  <input id="contenttitle" name="contenttitle" type="text" placeholder="Title" class="form-control input-md" required="">
    
  </div>
</div>
<br/>
<div class="form-group">
  <label class="col-md-4 control-label" for="file">Upload Material</label>
  <div class="col-md-4">
    <input id="file" name="filess" class="input-file" type="file">
  </div>
</div>
<br/><br/>

<div class="form-group">
  <label class="col-md-4 control-label" for="contentdesc">Instructions</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="contentdesc" name="contentdesc" ></textarea>
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
