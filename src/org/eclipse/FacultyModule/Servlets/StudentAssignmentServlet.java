package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.AssignmentDAO;

/**
 * Servlet implementation class StudentAssignmentServlet
 */
@WebServlet("/StudentAssignmentServlet")
public class StudentAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseid = request.getParameter("courseid");
		System.out.println("check 1");
		HttpSession sess = request.getSession();
		sess.setAttribute("courseid", courseid);
		String ass="";
		AssignmentDAO adao = new AssignmentDAO();
		ass = adao.getAssignment(courseid);
		
		
		if(ass.equals("")){
			System.out.println("ass2");

		}
		try{
			

		String string = ass;
		
		String[] parts = ass.split("&");
		
		String que1 = parts[0];
		String ans1 = parts[1]; 
		String que2 = parts[2]; 
		String ans2 = parts[3];
		
		System.out.println("que1 "+que1+" ans1 "+ans1+" que2 "+que2+" ans2 "+ans2);
		
		
		
		request.setAttribute("que1", que1);
		request.setAttribute("que2", que2);
		request.setAttribute("ans1", ans1);
		request.setAttribute("ans2", ans2);
		request.setAttribute("courseid", courseid);
		
		
		request.getRequestDispatcher("StudentAssignment.jsp").forward(request, response);
		//response.sendRedirect("grade.jsp");
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		

	}

}
