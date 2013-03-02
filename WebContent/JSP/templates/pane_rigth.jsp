<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

		<!-- panel contenido principal(derecho) -->
		<div id="panel-derecho" class="ui-layout-east pane pane-east">
			<div class="header" id="eastheader">
				<span id="east-closer" class="button-close button-close-east"
					title="Cerrar panel">&nbsp;</span>
			</div>
			<div class="content" id="eastcontent"
				style="position: relative; height: 236px; visibility: visible;">
				<h3 class="titulo-panel">
					<span><img title="Cerrar correctamente la sesión"
						class="salir" alt="" src="../images/page_white_stack.png">Relacionados</span>
				</h3>

				<div id="relatedDocs">
					<div id="cargando" style="display: none;">
						<img title="Cargando..." alt="Cargando..."
							src="../images/progress.gif"> Cargando...
					</div>
					<ul id="relatedDocsList">
					</ul>
				</div>
			</div>
		</div>
