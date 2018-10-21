package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class servletFormulario
 */
/*
@WebServlet("/servletFormulario")

@WebServlet(
		urlPatterns = { "/prueba" }, 
		initParams = { 
				@WebInitParam(name = "cantidad", value = "5", description = "Cantidades de Tiempo")
		})
*/
@WebServlet( 
		urlPatterns = {"/servletFormulario"},
		initParams = { 
				@WebInitParam(name="cantidad", value="5", description="Cantidad de tiempo")
		})
public class servletFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int cantidad = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		cantidad = Integer.parseInt(config.getInitParameter("cantidad"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("Nombre: <i>" + request.getParameter("nombre") + "</i>");
		pw.println("Edad: <i>" + request.getParameter("edad") + "</i>");
		pw.println("<p><h>Cantidad: " + Integer.toString(cantidad) + "</h></p>");		
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("http://http://localhost:8080/AppWeb/Formulario.html");
		//String dir = "http://localhost:8080/AppWeb/Formulario.html";
		PrintWriter pw = response.getWriter();

	    //out.println("<p><a href=\"http://validator.w3.org/check?uri=referer\">");
		
		
		pw.println("<a href = \"http://localhost:8080/AppWeb/Formulario.html\">Link a Formulario</a>");

		//pw.close();
        /*http://localhost:8080/AppWeb/servletFormulario
		String message = "Hello World";
        request.setAttribute("message", message); // This will be available as ${message}
        request.getRequestDispatcher("/WEB-INF/Formulario.html").forward(request, response);
        */
		
		
		/*PrintWriter pw = response.getWriter();
		pw.println("");
		pw.println('<!DOCTYPE html><html><head><meta charset="ISO-8859-1"<title>Insert title here</title>');
		pw.println('</head><body><form action="servletFormulario" method="post">');
		pw.println('Nombre: <input type="text" name="nombre"/>Edad: <input type="text" name="edad"/>');
		pw.println('<input type="submit"/>');
		pw.println('</form></body></html>');
		pw.close();*/
		
	}	

}
