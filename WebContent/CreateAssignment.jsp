<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Create Assignment</title>
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
  <h1>Create Assignment</h1>
</header>

<div>

<div class="container" >

<form class="form-horizontal" action="InsertAssignmentServlet" method="post" >
<fieldset>


<legend>Create Assignment</legend>


<div class="form-group">
  <label class="col-md-4 control-label" for="assid">Assignment ID</label>  
  <div class="col-md-5">
  <input id="assid" name="assid" type="text" placeholder="Assignment ID" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="courseid">Course ID</label>  
  <div class="col-md-5">
  <input id="courseid" name="courseid" type="text" placeholder="Course ID" class="form-control input-md">
    
  </div>
</div>
<hr/><hr/>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="que1">Question 1</label>  
  <div class="col-md-8">
  <input id="que1" name="que1" type="text" placeholder="Que 1" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="q1opt1">Option 1</label>  
  <div class="col-md-6">
  <input id="que1opt1" name="que1opt1" type="text" placeholder="Option 1" class="form-control input-md">
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 2</label>  
  <div class="col-md-6">
  <input id="textinput" name="que1opt2" type="text" placeholder="Option 2" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 3</label>  
  <div class="col-md-6">
  <input id="textinput" name="que1opt3" type="text" placeholder="Option 3" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 4</label>  
  <div class="col-md-6">
  <input id="textinput" name="que1opt4" type="text" placeholder="Option 4" class="form-control input-md">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="checkboxes">Correct options for Que 1</label>
  <div class="col-md-4">
  <div class="checkbox">
    <label for="checkboxes-0">
      <input type="checkbox" name="checkboxes" id="checkboxes-0" value="a1">
      Option one
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes-1">
      <input type="checkbox" name="checkboxes" id="checkboxes-1" value="a2">
      Option two
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes-2">
      <input type="checkbox" name="checkboxes" id="checkboxes-2" value="a3">
      Option three
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes-3">
      <input type="checkbox" name="checkboxes" id="checkboxes-3" value="a4">
      Option four
    </label>
  </div>
  </div>
</div>
<hr/><hr/>


<div class="form-group">
  <label class="col-md-4 control-label" for="que1">Question 2</label>  
  <div class="col-md-8">
  <input id="que1" name="que2" type="text" placeholder="Que 2" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="q1opt1">Option 1</label>  
  <div class="col-md-6">
  <input id="que2opt1" name="que2opt1" type="text" placeholder="Option 1" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 2</label>  
  <div class="col-md-6">
  <input id="textinput" name="que2opt2" type="text" placeholder="Option 2" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 3</label>  
  <div class="col-md-6">
  <input id="textinput" name="que2opt3" type="text" placeholder="Option 3" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Option 4</label>  
  <div class="col-md-6">
  <input id="textinput" name="que2opt4" type="text" placeholder="Option 4" class="form-control input-md">
    
  </div>
</div>



<!-- Multiple Checkboxes -->
<div class="form-group">
  <label class="col-md-4 control-label" for="checkboxes2">Correct options for Que 2</label>
  <div class="col-md-4">
  <div class="checkbox">
    <label for="checkboxes2-0">
      <input type="checkbox" name="checkboxes2" id="checkboxes2-0" value="b1">
      Option one
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes2-1">
      <input type="checkbox" name="checkboxes2" id="checkboxes2-1" value="b2">
      Option two
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes2-2">
      <input type="checkbox" name="checkboxes2" id="checkboxes2-2" value="b3">
      Option three
    </label>
  </div>
  <div class="checkbox">
    <label for="checkboxes2-3">
      <input type="checkbox" name="checkboxes2" id="checkboxes2-3" value="b4">
      Option four
    </label>
  </div>
  </div>
</div>



<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
  </div>
</div>

</fieldset>
</form>


</div>
 
</div>
</div>
 
</body>
</html>
