package org.eclipse.FacultyModule.Servlets;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.FacultyModule.Entity.CourseDAO;

/**
 * Servlet implementation class UploadContent
 */
@WebServlet("/UploadContent")
public class UploadContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession sess = request.getSession();
		
		//String courseId = request.getParameter("courseid");
		//String contentTitle = request.getParameter("contenttitle");
		//String instructions = request.getParameter("contentdesc");
		int insId = (int) sess.getAttribute("insId");

		
		//System.out.println("courseId");
		//System.out.println(courseId);
		
		String phile = request.getParameter("file");
		System.out.println(phile);
		
		String philes = request.getParameter("filess");
		System.out.println(philes);
		
		Part filePart = request.getPart("file"); 
		
		// Retrieves <input type="file" name="file">
		System.out.println(filePart);
	 
	    InputStream ehtesham = null;
	    String courseId=null;
	    String contentTitle = null;
		String instructions = null;
	    try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	            	//String courseId = item.getFieldName();
	        		//String contentTitle = request.getParameter("contenttitle");
	        		//String instructions = request.getParameter("contenttitle");
	            
	            	
	                String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                if(fieldName.equals("courseid")){
	                	courseId=fieldValue;
	                }else if(fieldName.equals("contenttitle")){
	                	contentTitle=fieldValue;
	                }else if(fieldName.equals("contentdesc")){
	                	instructions=fieldValue;
	                }
	                
	                System.out.println(fieldName);
	            	System.out.println(fieldValue);
	       
	            } else {

	                String fieldName = item.getFieldName();
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContents = item.getInputStream();
	                ehtesham = item.getInputStream();
	        
	            }
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    }
	
	    
	    //System.out.println("courseId");
		//System.out.println(courseId);
	    CourseDAO cdao = new CourseDAO();
	    try {
			//cdao.insertContentToDB(courseId,insId,contentTitle,instructions,ehtesham);
	
	    	 cdao.insertContentToDB(courseId,insId,contentTitle,instructions,ehtesham);
	    	  PrintWriter out = response.getWriter();
		      out.println("<script type=\"text/javascript\">");
			   out.println("alert('Content added sucessfully');");
			   out.println("location='InstructorDashboard.jsp';");
			   out.println("</script>");
			   //response.sendRedirect("Login.jsp");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//InputStream inputStream = new FileInputStream(new File(filePath));
	}

}
