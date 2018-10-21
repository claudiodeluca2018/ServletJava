package com.ctr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.Calcular;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer idSrl = 0; 

    public Controlador() {
        super();
    }

    
    
	@Override
	public void init() throws ServletException {
		super.init();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calcular cal;
		/*PrintWriter pw = response.getWriter();
		pw.println("Controlador");*/
		this.idSrl++;
		System.out.println("entro al metodo POST");
		response.setContentType("text/html ; charset=UTF-8");
		
		Calcular calcular = new Calcular();
		calcular.setNombre(request.getParameter("usuario"));
		calcular.setDireccion(request.getParameter("direccion"));

		
		 if (request.getParameter("idSrl") == "")
			calcular.setidSrl(0);
		else
			calcular.setidSrl(Integer.parseInt(request.getParameter("idSrl")));
		
		
		//calcular.setidSrl(this.idSrl);
		
		if (request.getParameter("dias") == "")
			calcular.setDiasTrabajados(0);
		else
			calcular.setDiasTrabajados(Integer.parseInt(request.getParameter("dias")));
		
		if (request.getParameter("valor") == "")
			calcular.setValor(0.0);
		else
				calcular.setValor(Double.parseDouble(request.getParameter("valor")));				
		calcular.CalcularSalario();
		
		request.setAttribute("calcular", calcular);
		
		/*ServletContext aplicacion= request.getServletContext();
		aplicacion.setAttribute("variableAplicacion", "SoyVariableAplicacion:" + calcular.getNombre());
		aplicacion.setAttribute("variableAplicacion2", "SoyVariableAplicacion2:" + calcular.getDireccion());
		HttpSession session=request.getSession(true);
		session.setAttribute("variableSession", "SoyVariableSession:" + calcular.getSalario());*/
		
		HttpSession session = request.getSession(true);
		session.setAttribute("obj", calcular);
		/*primero introducir datos para mostrar luego como anterior*/
		cal = (Calcular)session.getAttribute("calcularAntSV");
		if (cal != null) {
			//System.out.println("calcular " + calcular.getidSrl());
			//System.out.println("cal " + cal.getidSrl());
			
			String strCalcular = calcular.getNombre().trim();
			String strCal = cal.getNombre().trim();
			if (!strCalcular.equals(strCal)) {
				System.out.println("son distintos, calcular: " + strCalcular);
			}
			
			if (!strCalcular.equals(strCal)) {
				session.setAttribute("calcularAnt", (Calcular)session.getAttribute("calcularAntSV"));
				System.out.println("el nombre es distinto, calcular: " + calcular.getNombre());
				System.out.println("el nombre es distinto, cal: " + cal.getNombre());
			}
		}
		//System.out.println("se cargo calcularAntSV " + calcular.getidSrl());
		session.setAttribute("calcularAntSV", calcular);
			 
		
		request.setAttribute("variablePeticion", "SoyVariablePeticion:" + calcular.getValor());
	
		//pageContext.setAttribute("UName", id, PageContext.SESSION_SCOPE);

		
		//getServletInfo()
		//response.sendRedirect("http://localhost:8080/AppWeb/Index.jsp");
		
			
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	}

}
