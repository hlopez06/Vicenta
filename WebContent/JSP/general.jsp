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

<body onload="Menu.init()">

	<jsp:include page="tools/temp-head.jsp"></jsp:include>

	<!-- Cuerpo -->

	<!-- panel contenido principal( semillas + izquierdo + central + derecho) -->
	<div id="outer-center"  class="pane">

		<div id="mainContent">
			<div id="docContent">
				<!-- panel contenido principal(central) -->
				<div id="ui-layout-content">
					<!--cuerpo -->
					
					<div id="titulo-pag"><%=titulo_mainContent%></div>

					<!-- formulario de Remito -->
					<div id="formDocument">
<!-- 						<form action="" method="POST" name="formPrincipal"> -->
							<div id="frPersons" class="formDocument">
								<% if (form_client){ %><jsp:include page="templates/form_client.jsp"></jsp:include><% }%>
								<% if (form_provider){ %><jsp:include page="templates/form_provider.jsp"></jsp:include><% }%>
							</div>
							<% if (documento.contains("ar")){ %>
							<div id="frTools" class="formDocument">
								<div id="tipoMovimiento">
										<input type="radio" name="rm-tipoMovimiento" value="ingreso"
										onclick="Remito.selectMovimiento(event, this)"> Ingreso </input>
										<input type="radio" name="rm-tipoMovimiento" value="egreso" 
										onclick="Remito.selectMovimiento(event, this)"> Egreso </input>
								</div>
							</div>
							<%} %>
							
							<div id="frListaProductos" class="formDocument">
								<a>Lista de productos</a>
								<div id="listaProductos"></div>
							
								<% if (documento.contains("factura")){ %>
									<div id="totalFactura" class="formTotal"></div>
								<%} else if (documento.contains("remito")){ %>
									<div id="totalRemito" class="formTotal"></div>
								<%} %>
							</div>
								
							
							<div id="frNewProduct" class="formDocument">
								<ul class="formFactura ">
									<li><a>Id de Producto</a> <input id="inputCodProducto"
										type="text" step="1" maxlength="10" size="15"
										name="idProducto" value="1" onkeypress="Menu.keyEnter(event, this, Product.addProduct)"/>
									<li><a>Cantidad </a> <input id="cantidad" type="text"
										step="2" maxlength="7" size="15" name="cantidad" value="1" />
									</li>
									<li><a type="button" size="4" name="cargar" step="3"
										value="cargar" href="javascript:Product.addProduct();">CARGAR</a>
									</li>
								</ul>
							<% if (actionBool){ %>
							<div id="frBtnAction" style="display: none;">
								<a id="btn-<%=actionName%>" class="boton" onclick="<%=claseJS%>.action()"><%=actionName%></a>
							</div>	
							<%} %>
							</div>

		<!-- 						</form> -->
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