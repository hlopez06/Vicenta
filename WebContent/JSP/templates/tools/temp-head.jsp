<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div  id="ui-layout-north" class="ui-layout-north pane pane-north" style="">  

	<h1>
		<a href="index.jsp" tabindex="1">
<!-- 			<img src="../images/logo_Proyecto_01.png" alt="Vicenta" title="Vicenta"> -->
		</a>
	</h1>

	<ul class="menuSup">

		<li>		<a href="facturador" title="Ver carpetas y documentos guardados" alt="Hacer facturas">Factura</a>   			 	</li>
		<li>		<a href="notaCredito" title="Ver/recuperar últimas sesiones" alt="Hacer nota de credito">Nota de credito</a>		</li>
		<li>		<a href="remito" title="Ver/recuperar últimas sesiones" alt="Hacer remitos">Remito</a>						</li>
		
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

    