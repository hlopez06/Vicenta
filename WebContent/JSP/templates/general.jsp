<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%	
	String documento = (String)request.getAttribute("documento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	Boolean pane_rigth = (Boolean) request.getAttribute("pane_rigth");
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

<body role="application">

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
						<form action="/mode/facturador/facturar" method="POST" name="venta">
							<div id="clientes">
								<ul class="formFactura">
									<li><span>Nombre de cliente</span><input type="text"
										disabled="disabled" size="20" name="cl-nombre" value="" /></li>
									<li><span>Apellido</span> <input type="text"
										disabled="disabled" size="20" name="cl-apellido" value="" /></li>
									<li><span>Tipo</span> <input type="text"
										disabled="disabled" size="20" name="cl-tipo" value="" /></li>
									<li><span>RS &nbsp;</span> <input type="text"
										disabled="disabled" size="20" name="cl-razonSocial" value="" />
									</li>
									<li><span>Credito &nbsp;</span> <input type="text"
										disabled="disabled" size="20" name="cl-credito" value="" /></li>
								</ul>
								<input type="hidden" disabled="disabled" size="20" name="cl-id"
									value="" />
							</div>

							<div id="productos">
								<a>Lista de productos</a>
								<ul id=listaProductos></ul>

								<ul class="formFactura ">
									<li><a>Id de Producto</a> <input id="idProducto"
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

						</form>
					</div>

				</div>


			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

		<!-- panel contenido principal(izquierdo) -->

		<div id="panel-izquierdo" class="ui-layout-west pane pane-west">

				<div id="subpanel-terminos-buscados" class="subpanel">
					<h3 class="titulo-subpanel">
						<a href="javascript:">Buscar Cliente</a>
					</h3>

					<div id="formBuscaCliente">
						<input id="searchClientes" type="text" value="Buscar cliente..."
							name="searchClientes" size="25" maxlength="10"
							onblur="if(this.value=='') this.value='Buscar cliente...';"
							onfocus="if(this.value=='Buscar cliente...') this.value='';"
							onkeypress="Client.searchClientsKeyEnter(event, this)" /> <a
							id="lupaSearchCliente"
							href="javascript:Client.searchClients();"> <img
							src="../images/magnifier.png" title="Lupa">
						</a> <a id="searchingClients" style="display: none;"> <img
							src="../images/progress.gif" title="buscando...">
						</a>
					</div>
					<div id="listClientsSearched" style="display: none;"></div>
				</div>
				
				<div id="crearCliente" class="subpanel">
					<h3 class="titulo-subpanel">
							<a href="javascript:">Agendar cliente</a>
					</h3>
				</div>
		</div>
		<% if (pane_rigth){ %><jsp:include page="pane_rigth.jsp"></jsp:include><% }%>
	</div>

</body>
</html>