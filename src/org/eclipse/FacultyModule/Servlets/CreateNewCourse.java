package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.SSLSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.AddCourseToDB;
import org.eclipse.FacultyModule.Entity.AddInstructorToDB;
import org.eclipse.FacultyModule.Entity.Course;
import org.eclipse.FacultyModule.Entity.CourseDAO;

/**
 * Servlet implementation class CreateNewCourse
 */
@WebServlet("/CreateNewCourse")

public class CreateNewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCourse() {
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
		//request.getParameter()
		
		HttpSession ses = request.getSession();
		
		
		String id = request.getParameter("courseid");
		String name = request.getParameter("coursetitle");
		String desc = request.getParameter("coursedesc");
		int insId = (int) ses.getAttribute("insId");
			
		Course course = new Course();
		course.setCourseName(name);
		course.setCourseExplanation(desc);
		course.setCourseId(id);
		course.setIns(insId);
		
		
		ses.setAttribute("courseId", id);
		ses.setAttribute("courseName", name);
		
		CourseDAO cdao = new CourseDAO();
		cdao.AddCourse(course);
		
			PrintWriter out = response.getWriter();
	      out.println("<script type=\"text/javascript\">");
		   out.println("alert('Course Created Sucessfully');");
		   out.println("location='InstructorDashboard.jsp';");
		   out.println("</script>");
		  
		   
		   //response.sendRedirect("Login.jsp");
		
		
		response.sendRedirect("InstructorDashboard.jsp");
		
	}

}
