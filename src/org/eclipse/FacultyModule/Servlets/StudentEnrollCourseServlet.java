package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.CourseDAO;

/**
 * Servlet implementation class StudentEnrollCourseServlet
 */
@WebServlet("/StudentEnrollCourseServlet")
public class StudentEnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseid = request.getParameter("courseid");
		//String abc = request.getParameter("actionsend");
		 
		//if (abc.equals(abc)){
		HttpSession sess = request.getSession();
		request.setAttribute("courseid", courseid);
		int studentid = (int) sess.getAttribute("insId");
		
		CourseDAO cdao = new CourseDAO();
		try {
			cdao.AddStudentToCourse(courseid,studentid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.getRequestDispatcher("Grade.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
	      out.println("<script type=\"text/javascript\">");
		   out.println("alert('Course added Sucessfully');");
		   out.println("location='StudentDashboard.jsp';");
		   out.println("</script>");
		response.sendRedirect("StudentDashboard.jsp");
		// TODO Auto-generated method stub
		
		
	}

	private void AddStudentToCourse(String courseid, int studentid) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
