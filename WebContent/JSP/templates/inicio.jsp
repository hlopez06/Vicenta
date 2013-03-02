<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html style="height: 100%; overflow: hidden;">
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type">
<title>Proyecto 01</title>

<link href="css/layout.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<body role="application"
	style="position: relative; height: 100%; overflow: hidden; margin: 0px; padding: 0px; border: medium none; cursor: auto;">

	<div id="ui-layout-north" class="ui-layout-north pane pane-north"
		style="position: absolute; margin: 0px; top: 0px; bottom: auto; left: 0px; right: 0px; width: auto; z-index: 1; height: 72px; visibility: visible; display: block;">

		<h1 style="display: none;">
			<a href="index.jsp" tabindex="1"> <img
				src="images/logo_Proyecto_01.png" alt="Proyecto01"
				title="Proyecto 01">
			</a>
		</h1>

		<ul class="menuSup">

			<li><a href="mode/facturador"
				title="Ver carpetas y documentos guardados" alt="Hacer facturas">Factura</a>
			</li>
			<li><a href="mode/notaCredito"
				title="Ver/recuperar últimas sesiones" alt="Hacer nota de credito">Nota
					de credito</a></li>
			<li><a href="mode/remito" title="Ver/recuperar últimas sesiones"
				alt="Hacer remitos">Remito</a></li>

			<li id="HistorialDesplegable"><a class="abreDesplegable"
				title="Historico de movimientos" href="#">Historial</a>
				<ul class="menuDesplegable oculto">

					<li><a class="historico-ventas-basicos"
						href="mode/historico-ventas">de Ventas</a></li>
					<li><a class="historico-notacredito-basicos"
						href="mode/historico-notaCredito">de Nota de credito</a></li>
					<li><a id="historico-remitos-basicos"
						href="mode/historico-remitos">de Remitos</a></li>
					<li><a class="historico-otros-basicos" href=mode/otros">otros</a>
					</li>
				</ul></li>

			<li><a href="#" title="Seleccionar idioma, configuración..."
				alt="Seleccionar idioma, configuración..." id="preferences-link">Personalizar</a>
			</li>

		</ul>

		<a href="desloguear" class="salir"
			title="Cerrar correctamente la sesión"
			alt="Cerrar correctamente la sesión">Salir</a>


		<% if (false) { %>
		<jsp:include page="tools/cajaBuscador.jsp"></jsp:include>
		<% } %>


	</div>
	<!-- fin de panel superior -->
	<!-- panel contenido principal( semillas + izquierdo + central + derecho) -->
	<div class="outer-center pane pane-center" id="outer-center"
		style="position: absolute; margin: 0px; left: 0px; right: 0px; top: 72px; bottom: 0px; height: 293px; width: 1366px; z-index: 1; visibility: visible; display: block; overflow: hidden;">

		<!-- panel semillas -->
		<div class="ui-layout-north pane pane-north" id="ui-layout-semillas"
			style="position: absolute; margin: 0px; top: 0px; bottom: auto; left: 0px; right: 0px; width: auto; z-index: 1; height: 34px; visibility: visible; display: block;">
			<ul class="breadCrumbs" id="crumbsNav">
				<li class="first">Está en:</li>
				<li><a title="Ir a Inicio" href="">Inicio</a></li>
			</ul>
		</div>

		<!-- panel contenido principal(central) -->
		<div class="pane pane-center" id="mainContent"
			style="position: absolute; margin: 0px; left: 240px; right: 0px; top: 34px; bottom: 0px; height: 259px; width: 1126px; z-index: 1; visibility: visible; display: block;">
			<div class="content" id="docContent"
				style="position: relative; height: 259px; visibility: visible;">
				<!-- panel contenido principal(central) -->
				<div class="layout-content" id="ui-layout-content">

					<!--cuerpo -->

					<div class="cabCentral" id="cabCentral">
						<div
							style="font-size: 2.4em; margin-bottom: 0.25em; font-family: Arial, Helvetica, sans-serif; font-weight: bold;"
							id="titulo-pag">Facturador</div>
					</div>


				</div>

				<!-- panel contenido principal(pie) -->
				<div id="pie">
					<ul>
						<li><a href="divingWeb/index.html" id="abre-copyright">DivingWeb
								&copy;</a></li>
						<li><a href="divingWeb.html" target="_blank">Ayuda</a></li>
						<li>Att. cliente: <a
							title="Contactar con Centro de atención al cliente"
							href="mailto:hernan.h.lopez@hotmail.com?subject=Atension al cliente">email</a></li>
						<li><a title="Ayúdenos a mejorar"
							href="mailto:hernan.h.lopez@hotmail.com?subject=Sugerencia sobre Proyecto 01">Mi
								Opinión</a></li>

					</ul>
				</div>

			</div>
		</div>

		<!-- panel contenido principal(izquierdo) -->
		<div class="ui-layout-west pane pane-west" id="layout-west"
			style="position: absolute; right: auto; top: 34px; height: auto; z-index: 1; width: 239px; visibility: visible; display: block;">
			<span id="west-closer" class="button-close button-close-west"
				title="Cerrar panel">&nbsp;</span>
			<div class="header" id="westheader"></div>
			<div class="content" id="westcontent"
				style="position: relative; visibility: visible;">

				<div id="subpanel-terminos-buscados" class="subpanel">
					<h3 class="titulo-subpanel">
						<a href="#" id="TermBus" class="opened"><img title="Lupa"
							alt="Lupa" src="images/magnifier.png"> Términos Buscados</a>
					</h3>
					<div class="conTermBus contenido-subpanel">
						<ul class="listado-terminos">
							<li><span class="SearchTerm SearchTermRel">----------</span></li>
							<li><span class="field">Filtro</span> : <span
								class="SearchTerm">Todas</span></li>
						</ul>
						<div class="acciones-subpanel">
							<span class="guardar-alerta-left"> <img
								title="Guardar búsqueda como Alerta"
								alt="Guardar búsqueda como Alerta"
								src="images/guardaralerta.png"> <a
								alt="Guardar búsqueda como Alerta"
								title="Guardar búsqueda como Alerta" class="saveSearchAlert">Guardar</a>
							</span>
						</div>
					</div>
				</div>

				<!--#subpanel-terminos-buscados-->
				<div class="subpanel" id="subpanel-resultados">
					<h3 class="titulo-subpanel">
						<a class="opened" id="Result" href="#">Buscar en los
							resultados</a>
					</h3>
					<div class="conResults contenido-subpanel"></div>
				</div>

				<!--#subpanel-resultados-->

				<div class="subpanel" id="subpanel-resultados-clasificados">
					<h3 class="titulo-subpanel">
						<a class="opened" id="Buscar" href="#"><img title="Etiqueta"
							alt="Etiqueta" src="images/tag_blue.png">Resultados
							clasificados</a>
					</h3>
					<div class="contenido-subpanel"></div>
				</div>

				<!--#subpanel-resultados-->
				<div class="subpanel" id="subpanel-resultados">
					<h3 class="titulo-subpanel">
						<a class="opened" id="Result" href="#"><img
							title="Lista de resultados" alt="Lista de resultados"
							src="images/text_list_bullets.png"> Resultados</a>
					</h3>
					<div class="conResults contenido-subpanel">
						<p class="cont">
							<a href=""> <span class="content">--------------</span> <span
								class="num">1</span>
							</a>
						</p>
					</div>
				</div>

			</div>
		</div>

		<!-- panel contenido principal(derecho) -->
		<div class="ui-layout-east pane pane-east" id="layout-east"
			style="position: absolute; margin: 0px; left: auto; right: 0px; top: 34px; bottom: 0px; height: 258px; z-index: 1; width: 239px; visibility: visible; display: block;">
			<div class="header" id="eastheader">
				<span id="east-closer" class="button-close button-close-east"
					title="Cerrar panel">&nbsp;</span>
			</div>
			<div class="content" id="eastcontent"
				style="position: relative; height: 236px; visibility: visible;">
				<h3 class="titulo-panel">
					<span><img title="Cerrar correctamente la sesión"
						class="salir" alt="" src="images/page_white_stack.png">Relacionados</span>
				</h3>

				<div id="relatedDocs">
					<div id="cargando" style="display: none;">
						<img title="Cargando..." alt="Cargando..."
							src="images/progress.gif"> Cargando...
					</div>
					<ul id="relatedDocsList">
					</ul>
				</div>
			</div>
		</div>
	</div>

	<strong>...........................</strong>
	<h2>
		<%
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			out.println("login ok");
		} else {
			out.println("invalid login");
		}
	%>
	</h2>

</body>
</html>