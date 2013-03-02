<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="fondoCab" class="fondoCab">

	<div class="CajaBuscador">

		<form class="formbuscar all" method="post"
			onsubmit="maf.template.populateSubsearchTextoFields"
			action="/maf/app/search/run/multi" id="searchForm">
			<fieldset>
				<legend>Caja de búsqueda</legend>
				<input type="hidden" value="true" name="multisearch"
					id="multisearch">

				<div id="desplegable-ultimasbusquedas" class="desplegable">
					<a id="despliega-ultimasbusquedas" href="#"
						title="Ver/recuperar mis últimas búsquedas"
						alt="Ver/recuperar mis últimas búsquedas"><img
						src="images/ico.lupa.png"
						alt="Ver/recuperar mis últimas búsquedas"
						title="Ver/recuperar mis últimas búsquedas"></a>
					<div id="capa-desplegable-ultimasbusquedas"
						class="caja-desplegable oculto">
						<a href="#" class="cierra-ultimasbusquedas boton-cerrar"><img
							src="images/cancel.png" alt="Cerrar" title="Cerrar"></a>
						<p class="titulo-desplegable">Últimas búsquedas</p>
						<ul>
							<div id="loadingSearchs" style="display: none;">
								<p>
									<img src="images/progress.gif" alt="animated progress image"
										title="animated progress image">Cargando...
								</p>
							</div>
							<li><a href="">busquedas anteriores</a></li>
						</ul>
					</div>
				</div>

				<input type="text"
					class="largotexto input-operadores ui-autocomplete-input"
					title="Buscar en todo el Servicio"
					value="escriba lo que desea buscar..." maxlength="255" size="45"
					id="texto" name="texto"
					onblur="if(this.value=='') this.value='escriba lo que desea buscar...';"
					onfocus="if(this.value=='escriba lo que desea buscar...') this.value='';">

				<input type="submit" id="buttonSearch" value="Buscar"
					name="buttonSearch" class="botServ"
					onclick="maf.template.errorSinPalabrasUniversal();"> <a
					href="#" id="busqueda-operadores" class="busqueda-operadores"
					title="Utilizar para la búsqueda" alt="Utilizar para la búsqueda">Búsqueda
					asistida</a> <br> <a href="#" id="busqueda-filtro"
					class="busqueda-filtro" title="Utilizar para la búsqueda"
					alt="Utilizar para la búsqueda">Búsqueda con filtros</a>

			</fieldset>
		</form>
	</div>
</div>