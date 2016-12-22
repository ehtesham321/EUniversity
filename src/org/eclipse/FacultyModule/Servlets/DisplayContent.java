package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.FacultyModule.Entity.DAOs;

/**
 * Servlet implementation class DisplayContent
 */
@WebServlet("/DisplayContent")
public class DisplayContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contentid = request.getParameter("contentid");
		//String abc = request.getParameter("actionsend");
		byte[] buffer = null;
		//if (abc.equals(abc)){
		HttpSession sess = request.getSession();
		request.setAttribute("contentid", contentid);
		ServletOutputStream file = response.getOutputStream();
		DAOs daos = new DAOs();
		try {
			buffer = daos.getContent(contentid);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "inline; filename="+contentid+".pdf");
		file.write(buffer);
		//request.getRequestDispatcher("DisplayContent.jsp").forward(request, response);
		//response.sendRedirect("DisplayContent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
