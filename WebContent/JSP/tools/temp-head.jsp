<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<div id="ui-layout-north" class="ui-layout-north pane pane-north">

	<h1>
		<a href="index.jsp" tabindex="1"> <!-- 			<img src="../images/logo_Proyecto_01.png" alt="Vicenta" title="Vicenta"> -->
		</a>
	</h1>

	<ul class="menuSup">

		<li><a href="facturador"
			title="Ver carpetas y documentos guardados" alt="Hacer facturas">Factura</a>
		</li>
		<li><a href="notaCredito" title="Ver/recuperar últimas sesiones"
			alt="Hacer nota de credito">Nota de credito</a></li>
		<li><a href="remito" title="Ver/recuperar últimas sesiones"
			alt="Hacer remitos">Remito</a></li>
		<li><a href="stock" title="Ver stock"
			alt="Ver stock">Stock</a></li>	
			
		<li><a id="AltaDesplegable" onclick="menu.altaDespAbre()" class="abreDesplegable"
			title="Alta de movimientos" href="#">Alta</a>
			<ul id="menuDespAlta" class="menuDesplegable oculto">

				<li><a href="elementFactory?element=producto">de producto</a></li>
				<li><a href="elementFactory?element=cliente">de cliente</a></li>
				<li><a href="elementFactory?element=proveedor">de proveedor</a></li>
				<li><a href="elementFactory?element=usuario">de usuario</a></li>
			</ul>
		</li>	

		<li><a id="HistorialDesplegable" onclick="menu.historialDespAbre()" class="abreDesplegable"
			title="Historico de movimientos" href="#">Historial</a>
			<ul id="menuDespHisto" class="menuDesplegable oculto">

				<li><a href="historico-ventas">de Ventas</a></li>
				<li><a href="historico-notaCredito">de Nota de credito</a></li>
				<li><a href="historico-remitos">de Remitos</a></li>
				<li><a href="otros">otros</a>
				</li>
			</ul>
		</li>

		<li><a href="#" title="Seleccionar idioma, configuración..."
			alt="Seleccionar idioma, configuración..." id="preferences-link">Personalizar</a>
		</li>

	</ul>

	<a href="desloguear" class="salir"
		title="Cerrar correctamente la sesión"
		alt="Cerrar correctamente la sesión">Salir</a>


	<% if (false) { %>
	<jsp:include page="cajaBuscador.jsp"></jsp:include>
	<% } %>


</div>
<!-- fin de panel superior -->

