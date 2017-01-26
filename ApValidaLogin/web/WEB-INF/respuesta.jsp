<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp?pagOrigen=respuesta.jsp"%>    
<%@ page import="beans.Usuario" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>La respuesta</title>
</head>
<body>
<%
Usuario usr=(Usuario)request.getAttribute("modelo");
%>
<p>Su login : <%=usr.getLogin() %></p>
<p>Su clave : <%=usr.getClave() %></p>
<p>Su nombre : <%=usr.getNombre() %></p>
</body>
</html>