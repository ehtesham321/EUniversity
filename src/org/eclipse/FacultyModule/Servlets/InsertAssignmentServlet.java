package org.eclipse.FacultyModule.Servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.FacultyModule.Entity.AssignmentDAO;

/**
 * Servlet implementation class InsertAssignmentServlet
 */
@WebServlet("/InsertAssignmentServlet")
public class InsertAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAssignmentServlet() {
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
		
		System.out.println(request.getAttributeNames());
		
		Enumeration attrs =  request.getAttributeNames();
		while(attrs.hasMoreElements()) {
		    System.out.println(attrs.nextElement());
		}

		
		String[] cb1 =  request.getParameterValues("checkboxes");
		String[] cb2 =  request.getParameterValues("checkboxes2");
		String courseid = request.getParameter("courseid");
		String assid = request.getParameter("assid");
		
		String que1 = request.getParameter("que1");
		String que1opt1;
		String que1opt2;
		String que1opt4;
		String que1opt3;
		
		if(Arrays.asList(cb1).contains("a1")){
			que1opt1 = request.getParameter("que1opt1")+"-t";
 
		}else{
			que1opt1 = request.getParameter("que1opt1")+"-f";
 
		}
		
		if(Arrays.asList(cb1).contains("a2")){
			que1opt2 = request.getParameter("que1opt2")+"-t";
	 
		}else{
			que1opt2 = request.getParameter("que1opt2")+"-f";
		 
		}
		
		if(Arrays.asList(cb1).contains("a3")){
			que1opt3 = request.getParameter("que1opt3")+"-t";
 
		}else{
			que1opt3 = request.getParameter("que1opt3")+"-f";
	 
		}
		
		if(Arrays.asList(cb1).contains("a4")){
			que1opt4 = request.getParameter("que1opt4")+"-t";
 
		}else{
			que1opt4 = request.getParameter("que1opt4")+"-f";
		}
		
		String que2 = request.getParameter("que2");
		String que2opt1;
		String que2opt2;
		String que2opt4;
		String que2opt3;
		
		if(Arrays.asList(cb2).contains("b1")){
			que2opt1 = request.getParameter("que2opt1")+"-t";
 
		}else{
			que2opt1 = request.getParameter("que2opt1")+"-f";
 
		}
		
		if(Arrays.asList(cb2).contains("b2")){
			que2opt2 = request.getParameter("que2opt2")+"-t";
	 
		}else{
			que2opt2 = request.getParameter("que2opt2")+"-f";
		 
		}
		
		if(Arrays.asList(cb2).contains("b3")){
			que2opt3 = request.getParameter("que2opt3")+"-t";
 
		}else{
			que2opt3 = request.getParameter("que2opt3")+"-f";
	 
		}
		
		if(Arrays.asList(cb2).contains("b4")){
			que2opt4 = request.getParameter("que2opt4")+"-t";
 
		}else{
			que2opt4 = request.getParameter("que2opt4")+"-f";
		}
		
		String Ans1 = que1opt1+"="+que1opt2+"="+que1opt3+"="+que1opt4;
		String Ans2 = que2opt1+"="+que2opt2+"="+que2opt3+"="+que2opt4;
		
		System.out.println("Ans1"+Ans1);
		System.out.println("Ans2"+Ans2);
		
		String string = Ans1;
		String[] parts = string.split("=");
		String part1 = parts[0]; 
		String part2 = parts[1]; 

		
		
		AssignmentDAO adao = new AssignmentDAO();
		adao.enterAssignment(courseid,assid,que1,Ans1,Ans2,que1opt3,que1opt4,que2,que2opt1,que2opt2,que2opt3,que2opt4);
		
		for(String cbs : cb1){
			
			System.out.println(cbs);
		}
		
		
		

		
	}

}
