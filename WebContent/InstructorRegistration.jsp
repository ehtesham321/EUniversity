<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InstructorRegistration" method="post">

<fieldset>

<!-- Form Name -->
<legend>User Registration</legend>

<div class="form-group">
  <label class="col-md-4 control-label" for="username">User Name</label>  
  <div class="col-md-5">
  <input id="username" name="username" type="text" placeholder="Username" class="form-control input-md">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="fname">First Name</label>  
  <div class="col-md-5">
  <input id="fname" name="fname" type="text" placeholder="First" class="form-control input-md">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="lname">Last Name</label>  
  <div class="col-md-5">
  <input id="lname" name="lname" type="text" placeholder="Last" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password </label>
  <div class="col-md-5">
    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="type">User Type</label>
  <div class="col-md-5">
    <select id="type" name="type" class="form-control">
      <option value="instructor">Student</option>
      <option value="student">Instructor</option>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="dept">Department</label>
  <div class="col-md-5">
    <select id="dept" name="dept" class="form-control">
      <option value="cs">CS</option>
      <option value="it">IT</option>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="dob">Date Of Birth</label>  
  <div class="col-md-5">
  <input id="dob" name="dob" type="text" placeholder="MM/DD/YYYY" class="form-control input-md">
    
  </div>
</div>

<div class="form-group">
  <label class="phone" for="phone">Phone</label>  
  <div class="phone">
  <input id="phone" name="phone" type="text" placeholder="Phone" class="phone">
    
  </div>
</div>

<!-- Multiple Checkboxes -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sex">Sex</label>
  <div class="col-md-4">
  <div class="checkbox">
    <label for="sex-0">
      <input type="checkbox" name="sex" id="sex-0" value="m">
      Male
    </label>
	</div>
  <div class="checkbox">
    <label for="sex-1">
      <input type="checkbox" name="sex" id="sex-1" value="f">
      Female
    </label>
	</div>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="address" name="address">Address</textarea>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary">submit</button>
  </div>
</div>

</fieldset>
</form>



</body>
</html>