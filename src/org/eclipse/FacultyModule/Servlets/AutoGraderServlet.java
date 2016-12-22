package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.AssignmentDAO;

/**
 * Servlet implementation class AutoGraderServlet
 */
@WebServlet("/AutoGraderServlet")
public class AutoGraderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoGraderServlet() {
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

		String[] cb1 =  request.getParameterValues("checkbox1");
		String[] cb2 =  request.getParameterValues("checkbox2");
		String courseid = request.getParameter("courseid");
		String assid = request.getParameter("assid");
		String insId = request.getParameter("insId");
		
		String que1 = request.getParameter("que1");
		String ans1 = request.getParameter("ans1");
		String que2 = request.getParameter("que2");
		String ans2 = request.getParameter("ans2");
		
		String Fans1 = request.getParameter("Fans1");
		String Fans2 = request.getParameter("Fans2");
		HttpSession sess = request.getSession();
		String Fans11 =  (String) sess.getAttribute("Fans1");
		String Fans22 = (String) sess.getAttribute("Fans2");
		int marks = 0;
		String cb11="";
		String cb22="";
		for(int i=0;i< cb1.length;i++){
			cb11=cb11+cb1[i];

		}
		for(int i=0;i< cb2.length;i++){
			cb22=cb22+cb2[i];

		}
		
		if(cb11.equals(Fans11)){
			marks = marks + 50;
		}
		if(cb22.equals(Fans22)){
			marks = marks + 50;
		}
		int insId1 =  (int) sess.getAttribute("insId");
		String courseid1 = (String) sess.getAttribute("courseid");
		
		System.out.println(marks+assid+insId1+courseid);
		
		AssignmentDAO adao = new AssignmentDAO();
		adao.setgrade(marks,assid,insId1,courseid1);
		
		response.sendRedirect("StudentDashboard.jsp");
	}

}
