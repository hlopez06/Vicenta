<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String titulo_html = (String)request.getAttribute("titulo_html");
	String titulo_error = (String)request.getAttribute("titulo_error");
	String detalle_error = (String)request.getAttribute("detalle_error");
	String oculto_error = (String)request.getAttribute("oculto_error");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=titulo_html%></title>
</head>
<body>
<h1><%=titulo_error%></h1>
<h3><%=detalle_error%></h3>
<div id=detalle style="display:none;"><%=oculto_error%></div>
</body>
</html>