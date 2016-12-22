<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.eclipse.FacultyModule.Entity.DAOs"%>
<%@ page import="org.eclipse.FacultyModule.Entity.Stu"%>
<%@ page import="org.eclipse.FacultyModule.Entity.user"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grade Center</title>

</head>
<body>
<h1>GRADE CENTER</h1>

<% 		HttpSession sess = request.getSession();

		int insId = (Integer) sess.getAttribute("insId");
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","password");

            Statement statement = myCon.createStatement();
			
			String query = "select courseid,coursetitle from course where insId=?;";
			
			//2. Create a statement
			PreparedStatement myStat = myCon.prepareStatement(query);
			
			myStat.setInt(1,1);
			
			ResultSet myRes = myStat.executeQuery();
			/*
			while (myRes.next()){
				if(pass.equals(myRes.getString("password"))){
					retString=myRes.getInt("id");
				}
				else{
					retString=(Integer) null;
				}
			*/
            if(!myRes.next()) {
                out.println("Sorry, could not find any courses for you");
            }else{
            	while (myRes.next()){
    				System.out.println(myRes.getString("courseid") +"|"+ myRes.getString("coursetitle"));
	
%>

<table border="1">
<tr><a href="GradeCenterServlet?courseid=<%=myRes.getString("courseid")%>&action=actionsend1"><%=myRes.getString("coursetitle")%></a></tr>
<br/> 
             
<% }  	myRes.first();%>
 <tr><a href="GradeCenterServlet?courseid=<%=myRes.getString("courseid")%>&action=actionsend1"><%=myRes.getString("coursetitle")%></a></tr> 
<%      	} %>
</table>


</body>
</html>