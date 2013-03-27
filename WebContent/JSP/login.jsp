<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String msj = "";
	if (request.getAttribute("msj") != null){
		msj = (String)request.getAttribute("msj");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="../css/login.css" rel="stylesheet" type="text/css">
<script src="../JS/login.js" type="text/javascript" ></script>

<title>Vicenta-Login</title>
</head>
<body>
	<div id="tituloLogin">
		<h1>Form login</h1>
	</div>
	
	<div id="loginContent">
		<jsp:include page="login/formLogin.jsp"/>
	</div>
</body>
</html>