package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.AddInstructorToDB;
import org.eclipse.FacultyModule.Entity.DAOs;
import org.eclipse.FacultyModule.Entity.Stu;
import org.eclipse.FacultyModule.Entity.user;
import org.eclipse.FacultyModule.Entity.userFactory;

/**
 * Servlet implementation class InstructorRegistration
 */
@WebServlet("/InstructorRegistration")
public class InstructorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorRegistration() {
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
		
		String type = request.getParameter("type");
		
		userFactory userFactory = new userFactory();

	    //get an object of Circle and call its draw method.
	    user user1 = userFactory.getUser(type);
	  
	    
	    Stu stud = new Stu();
	    
	    String username = request.getParameter("username");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String pass = request.getParameter("password");
		String type1 = request.getParameter("type");
		String dept = request.getParameter("dept");
		String dob = request.getParameter("dob");
		String phone = request.getParameter("phone");
		//int phone = Integer.parseInt(phone1);
		//int phone = (int) request.getAttribute("phone");
		//double d = Double.parseDouble(aString);
		System.out.println("The phone is: "+phone);
		//int phone = 0;
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		//userDTO user = new userDTO();
		
		
		if(username.equals("") || pass.equals("") || lname.equals("")){
			 	PrintWriter out = response.getWriter();
			 	response.sendRedirect("InstructorRegistration.jsp");
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Username,lname or password cannot be left blank');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
			   
			
		}
		else{
			
		
		stud.initialize(username,fname, lname, pass, type1, dept, dob, phone, sex, address);
		user1.initialize(fname, lname, pass,  type1,  dept,  dob, address, phone, sex, address);
		
		
		System.out.println(stud.getUsername());
		System.out.println(stud.getFname());
		System.out.println(stud.getLname());
		System.out.println(stud.getPass());
		
		DAOs daos = new  DAOs();
		boolean bool = daos.CheckUser(stud);
		
		System.out.println(bool);
		
		if(bool == false){
			DAOs dao = new DAOs();
			dao.AddUser(stud);
			
			PrintWriter out = response.getWriter();
		      out.println("<script type=\"text/javascript\">");
			   out.println("alert('User registration successful');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
			   response.sendRedirect("Login.jsp");
			
		}else{
			response.setContentType("text/html");
		      String message = "User already has registerd, please login";
		      // Actual logic goes here.
		      PrintWriter out = response.getWriter();
		      out.println("<script type=\"text/javascript\">");
			   out.println("alert('User already has registerd, please login');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
		    
			
		}
		
		
		
		}
		//AddInstructorToDB.AddInstructorToDb(user1);
		
	}

}
