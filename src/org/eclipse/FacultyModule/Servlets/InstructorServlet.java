package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.FacultyModule.Entity.Course;

/**
 * Servlet implementation class InstructorServlet
 */
@WebServlet("/InstructorServlet")
public class InstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorServlet() {
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

		
		String bt = request.getParameter("createNewCourse"); 
		String bt1 = request.getParameter("gradeCenter"); 
		String bt2 = request.getParameter("manageCourses"); 
		
		if(bt != null){
			response.sendRedirect("CreateNewCourse.jsp");
		}
		else if(bt1 != null){
			response.sendRedirect("GradeCenter.jsp");
		}
		else if(bt2 != null){
			response.sendRedirect("ManageCourses.jsp");
		}
		else{
			response.sendRedirect("");
		}
		
		
		
		
		
	}

}
