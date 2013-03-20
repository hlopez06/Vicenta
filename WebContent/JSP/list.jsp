<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="com.divingWeb.elememts.StockProducto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String documento = (String)request.getAttribute("documento");
	String claseJS = (String)request.getAttribute("claseJS");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	Boolean pane_rigth = (Boolean) request.getAttribute("pane_rigth");
	Boolean pane_left = (Boolean) request.getAttribute("pane_left");
	int lineMax = (Integer) request.getAttribute("lineMax");
	
 	List<StockProducto> stock = (List<StockProducto>) request.getAttribute("stock");
 	int cantidadProductos = stock.size();
 	float hojas = cantidadProductos / lineMax;
 	if (cantidadProductos % lineMax > 0)
 		++hojas;
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%;">
<head>
	<meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type">
	<title><%=titulo%></title>
	
	<link href="../css/layout.css" rel="stylesheet" type="text/css">
	<link href="../css/style.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="../JS/jQuery/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="../JS/document.js"></script>

</head>

<body onload="List.callStock()">

	<jsp:include page="tools/temp-head.jsp"></jsp:include>

	<div id="outer-center"  class="pane">

		<div id="mainContent">
			<div class="content" id="docContent">
				<!-- panel contenido principal(central) -->
					<!--cuerpo -->
					
					<div id="titulo-pag"><%=titulo_mainContent%></div>

					<!-- formulario de Remito -->

					<div id="bodyList">
						<h3>cargando los datos...</h3>
					</div>
					<div id="lineMax" value="<%=lineMax %>"></div>

			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

</div>

</body>
</html>