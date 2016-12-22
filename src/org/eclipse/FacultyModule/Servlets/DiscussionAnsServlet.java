package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.DiscussionDAO;

/**
 * Servlet implementation class DiscussionAnsServlet
 */
@WebServlet("/DiscussionAnsServlet")
public class DiscussionAnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussionAnsServlet() {
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
		
		DiscussionDAO dd = new DiscussionDAO();
		HttpSession sess = request.getSession();
		
		String questionid = request.getParameter("queid");
		int queid = Integer.parseInt(questionid);
		
		int insId= (int) sess.getAttribute("insId");;
		String question = request.getParameter("ans");
		String courseid = (String) sess.getAttribute("courseid");
		System.out.println(courseid);
		dd.addAnsToDB(question,insId,courseid,queid);
		
		request.getRequestDispatcher("DiscussionBoard.jsp").forward(request, response);
		
		
		
	}

}
