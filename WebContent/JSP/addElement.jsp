<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String documento = (String)request.getAttribute("documento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
    
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
<!-- 						</form> -->
					</div>
				</div>

			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

</div>

</body>
</html>