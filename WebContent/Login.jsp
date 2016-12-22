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

<div style="margin-left:0%">
<header class="w3-container w3-teal">
  <h1>Login</h1>
</header>

<div>

<div class="container" >

<form action="Login" method="post">
<fieldset>

<br/>
  <label class="col-md-4 control-label" for="textinput">Username</label>  
  <input id="username" name="username" type="text" placeholder="Username" class="form-control input-md" required=""> 
<br/>

  <label class="col-md-4 control-label" for="password">Password  </label>
    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
<br/> 


  <label class="col-md-4 control-label" for="usertype">User Type</label>
    <select id="usertype" name="usertype" class="form-control">
      <option value="Student">Student</option>
      <option value="Instructor">Instructor</option>
    </select>
<br/>

  <label class="col-md-4 control-label" for="login"></label>
    <button id="login" name="login" class="btn btn-primary">Login</button>
<br/><br/>




</fieldset>
</form>
<form action="InstructorRegistration.jsp" method="post">
New User??
  <label class="col-md-4 control-label" for="New User"></label>
    <button id="newUser" name="newUser" class="btn btn-primary">Register</button>
  </div>
  
</form>
 

</div>



 
 
</div>
</div>
 
</body>
</html>
