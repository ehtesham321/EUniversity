package org.eclipse.FacultyModule.Servlets;


import java.lang.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Controllers.LoginValidation;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final HttpSession String = null;
	private String user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		if( request.getParameter("newUser") != null){
			response.sendRedirect("InstructorRegistration.jsp");
		}else{
			
			
		    String user = request.getParameter("username");
			String pass = request.getParameter("password"); 
			String type = request.getParameter("usertype");
			
			System.out.println("type is : " + type+user+pass);
			
			int insId = LoginValidation.LoginValidate(user, pass,type);
			
			System.out.println("hhhh"+insId);
			if (insId != 0){
				sess.setAttribute("insId", insId);
				sess.setAttribute("username", user);
				if(type.equals("Instructor")){
					response.sendRedirect("InstructorDashboard.jsp");
				}else{
					response.sendRedirect("StudentDashboard.jsp");
				}
				
			}else {
				//response.sendRedirect("Login.jsp");
				// Set response content type
				  PrintWriter out = response.getWriter();
			      out.println("<script type=\"text/javascript\">");
				   out.println("alert('Login Credentials wrong');");
				   out.println("location='Login.jsp';");
				   out.println("</script>");
				
			}
			
		}
		
		
	}

}
