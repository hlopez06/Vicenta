<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%	
	String documento = (String)request.getAttribute("documento");
	String claseJS = (String)request.getAttribute("claseJS");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	Boolean pane_rigth = (Boolean) request.getAttribute("pane_rigth");
	Boolean pane_left = (Boolean) request.getAttribute("pane_left");
	Boolean form_client = (Boolean) request.getAttribute("form_client");
	Boolean form_provider = (Boolean) request.getAttribute("form_provider");
	Boolean actionBool = (Boolean) request.getAttribute("actionBool");
	String actionName = (String)request.getAttribute("actionName");
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

<body>

	<jsp:include page="tools/temp-head.jsp"></jsp:include>

	<!-- Cuerpo -->

	<!-- panel contenido principal( semillas + izquierdo + central + derecho) -->
	<div id="outer-center"  class="pane">

		<div id="mainContent">
			<div class="content" id="docContent">
				<!-- panel contenido principal(central) -->
				<div id="ui-layout-content">
					<!--cuerpo -->
					
					<div id="titulo-pag"><%=titulo_mainContent%></div>

					<!-- formulario de Remito -->
					<div id="formDocument">
<!-- 						<form action="" method="POST" name="formPrincipal"> -->
							
							<% if (form_client){ %><jsp:include page="templates/form_client.jsp"></jsp:include><% }%>
							<% if (form_provider){ %><jsp:include page="templates/form_provider.jsp"></jsp:include><% }%>
							
							<% if (documento.contains("remito")){ %>
							<div id="tipoMovimiento">
									<input type="radio" name="rm-tipoMovimiento" value="ingreso"> Ingreso </input>
									<input type="radio" name="rm-tipoMovimiento" value="egreso"> Egreso </input>
							</div>
							<%} %>
							
							<div id="productos">
								<a>Lista de productos</a>
								<ul id=listaProductos></ul>

								<ul class="formFactura ">
									<li><a>Id de Producto</a> <input id="inputIdProducto"
										type="text" step="1" maxlength="10" size="15"
										name="idProducto" value="1" />
									<li><a>Cantidad </a> <input id="cantidad" type="text"
										step="2" maxlength="7" size="15" name="cantidad" value="2" />
									</li>
									<li><a type="button" size="4" name="cargar" step="3"
										value="cargar" href="javascript:Product.addProduct();">CARGAR</a>
									</li>
								</ul>
							</div>
							<% if (documento.contains("factura")){ %>
								<div id="totalFactura"></div>
							<%} %>
							

		<!-- 						</form> -->
							<% if (actionBool){ %>
								<button id="btn-<%=actionName%>" onclick="<%=claseJS%>.action()"><%=actionName%></button>
							<%} %>
					</div>
				</div>

			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

		<!-- panel contenido principal(izquierdo) -->
		
		<% if (pane_left){ %><jsp:include page="templates/pane_left.jsp"></jsp:include><% }%>

		<% if (pane_rigth){ %><jsp:include page="templates/pane_rigth.jsp"></jsp:include><% }%>
	</div>

</body>
</html>