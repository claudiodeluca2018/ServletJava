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
 * Servlet implementation class CicloVida
 */
@WebServlet(
		urlPatterns = { "/CicloVida" }, 
		initParams = { 
				@WebInitParam(name = "contador", value = "6", description = "Contador")
		})
public class CicloVida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0 ; 
	
	
	public CicloVida() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		contador = Integer.parseInt(config.getInitParameter("contador"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.println(Integer.toString(contador));
		pw.close();
		contador++;
	}


}
