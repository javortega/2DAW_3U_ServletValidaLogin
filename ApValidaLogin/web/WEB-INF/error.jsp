<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.ExcepcionAp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Errores</title>
</head>
<body>
<%
	ExcepcionAp err = (ExcepcionAp) request.getAttribute("error");
	
%> 
Se ha producido un error.<br>
El mensaje de la excepción es: <%=err.getMensajeError()%> <br>
El código de error es:<%=err.getCodError() %><br>
</body>
</html>