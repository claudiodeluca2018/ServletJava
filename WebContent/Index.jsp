<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.modelo.Calcular"%>

<%
/*
${applicationScope.variableAplicacion}<br/>
${sessionScope.variableSession}<br/>
${requestScope.variablePeticion}<br/>
${pageScope.variablePagina}<br/>

//variable de aplicacion
//accedo asi
	${pageContext.servletContext.getAttribute("variableAplicacion2")}</br>  
//o asi
	${applicationScope.variableAplicacion}
*/
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!	
private Calcular calc; 
private Calcular calcAnt;

%>
<%
	calcAnt = (Calcular)session.getAttribute("calcularAnt");
	calc = (Calcular)request.getAttribute("calcular");
%>
<form action="Controlador" method="post">
<input type="hidden" value="${requestScope.calcular.getidSrl()}" name="idSrl"/>
<table>
<tr>
	<td>Nombre</td><td> <input type="text" value="${requestScope.calcular.getNombre()}" name="usuario"/></td>   
</tr>
<tr>
	<td>Direccion:</td><td> <input type="text"  value="${requestScope.calcular.getDireccion()}" name="direccion"/></td>
</tr>
<tr>
	<td>Dias Trabajados:</td><td> <input type="text"  value="${requestScope.calcular.getDiasTrabajados()}" name="dias"/></td>
</tr>
<tr>
	<td>Valor dia:</td><td> <input type="text"  value="${requestScope.calcular.getValor()}" name="valor"/></td>
</tr>
<tr>
	<td><button type="submit">Calcular</button></td>
</tr>
</table>

<%

	if (calc != null)
	{
		out.println("<p><strong>Salario: " + calc.getSalario() + "</strong></p>");
	}
	System.out.println("Antes de null");
	if ( (calc != null) && (calcAnt != null) )
	{
		//out.println("no estan en null");
		System.out.println("calc y calcAnt no estan en null");
		if (calc.getNombre() != calcAnt.getNombre())
		{
			System.out.println("Los nombres son: " + calc.getNombre() + " " + calcAnt.getNombre());
			out.println("<h>Usuario Anterior</h>");
			out.println("<p>Nombre:" + calcAnt.getNombre() + "</p>");
			out.println("<p>Direccion:" + calcAnt.getDireccion() + "</p>");
			out.println("<p>Dias:" + calcAnt.getDiasTrabajados() + "</p>");
			out.println("<p>Valor dia:" + calcAnt.getValor() + "</p>");
			out.println("<p>Salario:" + calcAnt.getSalario() + "</p>");
			//out.println("Id:" + calcAnt.getidSrl());
		}
	}
%>

</form>

<% 
	if (1 != 1) { %> 
		<a href = "http://localhost:8080/AppWeb/Index.jsp\">Link a Index 1</a>
		<p>nombre:${sessionScope.obj.getNombre()}</p>
		<p>direccion:${requestScope.calcular.getDireccion()}</p>
		<p>nombre:<%= calc.getNombre() %></p>
 <% } %>
	
		
</body>
</html>