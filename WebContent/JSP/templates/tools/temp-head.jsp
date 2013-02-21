<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <html style="height: 100%; overflow: hidden;">
<head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type">
        <title>Proyecto 01</title>
		
		<link href="../css/layout.css" rel="stylesheet" type="text/css">
		<link href="../css/style.css" rel="stylesheet" type="text/css">
	
</head>

<body role="application" style="position: relative; height: 100%; overflow: hidden; margin: 0px; padding: 0px; border: medium none; cursor: auto;">

<div  id="ui-layout-north" class="ui-layout-north pane pane-north" style="position: absolute; margin: 0px; top: 0px; bottom: auto; left: 0px; right: 0px; width: auto; z-index: 1; height: 72px; visibility: visible; display: block;">  

	<h1>
		<a href="index.jsp" tabindex="1">
			<img src="../images/logo_Proyecto_01.png" alt="Proyecto01" title="Proyecto 01">
		</a>
	</h1>

	<ul class="menuSup">

		<li>		<a href="mode/venta" title="Ver carpetas y documentos guardados" alt="Hacer facturas">Factura</a>   			 	</li>
		<li>		<a href="mode/notaCredito" title="Ver/recuperar últimas sesiones" alt="Hacer nota de credito">Nota de credito</a>		</li>
		<li>		<a href="mode/remito" title="Ver/recuperar últimas sesiones" alt="Hacer remitos">Remito</a>						</li>
		
		<li id="HistorialDesplegable">
			<a class="abreDesplegable" title="Historico de movimientos" href="#">Historial</a>
			<ul class="menuDesplegable oculto">

				<li>
					<a class="historico-ventas-basicos" href="mode/historico-ventas">de Ventas</a>
				</li>
				<li>
					<a class="historico-notacredito-basicos" href="mode/historico-notaCredito">de Nota de credito</a>
				</li>
				<li>
					<a id="historico-remitos-basicos" href="mode/historico-remitos">de Remitos</a>
				</li>
				<li>
					<a class="historico-otros-basicos" href=mode/otros">otros</a>
				</li>
			</ul>
		</li>
        
        <li>
			<a href="#" title="Seleccionar idioma, configuración..." alt="Seleccionar idioma, configuración..." id="preferences-link">Personalizar</a>
		</li>
		
	</ul>

<a href="desloguear" class="salir" title="Cerrar correctamente la sesión" alt="Cerrar correctamente la sesión">Salir</a>


<% if (false) { %> <jsp:include page="cajaBuscador.jsp"></jsp:include> <% } %>  

	
</div>
<!-- fin de panel superior -->

    