package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletInicio
 */
@WebServlet("/servletInicio")
public class servletInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<body>");
		
		for(int i = 0 ; i < 10 ; i++)
			pw.println("<p>Claudio esta probando un servlet</p>");
		
		pw.println("</body>");
		pw.println("</html>");		
	}


}
