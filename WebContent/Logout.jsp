<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
<script type="javascript/text">
alert("logout sucessful");

</script>
<%	out.println("<script type=\"javacript/text\";");
	out.println("alert(\"Logout sucessful\")");
	out.println("</script>");
	//session.setAttribute("comments",null);
	HttpSession sess = request.getSession();
	sess.invalidate();

	response.sendRedirect("Login.jsp");
%>
</body>
</html>