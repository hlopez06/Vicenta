<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Boolean pane_left_client = (Boolean) request.getAttribute("pane_left_client");
	Boolean pane_left_provider = (Boolean) request.getAttribute("pane_left_provider");
	Boolean pane_left_product = (Boolean) request.getAttribute("pane_left_product");
%>    
<div id="panel-izquierdo" class="ui-layout-west pane pane-west">


<% if (pane_left_client){ %>
		<div id="subpanel-termBuscados-client" class="subpanel">
			<h3 class="titulo-subpanel">
				<a>Buscar Cliente</a>
			</h3>

			<div id="formBuscaCliente">
				<input id="searchClients" type="text" value="Buscar cliente..."
					name="searchClients" size="25" maxlength="20"
					onblur="if(this.value=='') this.value='Buscar cliente...';"
					onfocus="if(this.value=='Buscar cliente...') this.value='';"
					onkeypress="Menu.keyEnter(event, this, Client.searchClients)" /> <a
					id="lupaSearchCliente"
					href="javascript:Client.searchClients();"> <img
					src="../images/magnifier.png" title="Buscar">
				</a> <a id="searchingClients" style="display: none;"> <img
					src="../images/progress.gif" title="buscando...">
				</a>
			</div>
			<div id="listClientsSearched" style="display: none;"></div>
		</div>
		
		<div id="crearCliente" class="subpanel">
			<h3 class="titulo-subpanel">
					<a href="elementFactory?element=cliente">Agendar cliente</a>
			</h3>
		</div>
<% }if (pane_left_provider){ %>
		<div id="subpanel-termBuscados-provider" class="subpanel">
			<h3 class="titulo-subpanel">
				<a>Buscar Proveedor</a>
			</h3>

			<div id="formBuscaProveedor">
				<input id="searchProviders" type="text" value="Buscar proveedor..."
					name="searchProviders" size="25" maxlength="20"
					onblur="if(this.value=='') this.value='Buscar proveedor...';"
					onfocus="if(this.value=='Buscar proveedor...') this.value='';"
					onkeypress="Menu.keyEnter(event, this, Provider.searchProviders)" /> <a
					id="lupaSearchProviders"
					href="javascript:Provider.searchProviders();"> <img
					src="../images/magnifier.png" title="Buscar">
				</a> <a id="searchingProviders" style="display: none;"> <img
					src="../images/progress.gif" title="buscando...">
				</a>
			</div>
			<div id="listProvidersSearched" style="display: none;"></div>
		</div>
		
		<div id="crearProveedor" class="subpanel">
			<h3 class="titulo-subpanel">
					<a href="elementFactory?element=proveedor">Agendar proveedor</a>
			</h3>
		</div>
<% }if (pane_left_product){ %>
		<div id="subpanel-termBuscados-product" class="subpanel">
			<h3 class="titulo-subpanel">
				<a>Buscar Producto</a>
			</h3>

			<div id="formBuscaProducto">
				<input id="searchProdTermino" type="text" value="Buscar productos..."
					name="searchProdTermino" size="25" maxlength="20"
					onblur="if(this.value=='') this.value='Buscar productos...';" 
					onfocus="if(this.value=='Buscar productos...') this.value='';"
					onkeypress="Menu.keyEnter(event, this, Product.searchProducts)" />
				
				<a title="Busqueda extendida" class="abreDesplegable" onclick="Menu.display('especificSearch')" href="#">Mas</a>
				<div id="especificSearch" style="display:none">
						<div>
							<a>Nombre </br></a>
							<input id="searchProdNombre" type="text"
							name="searchProdNombre" size="25" maxlength="20"/>
						</div>
						<div>
							<a>Detalle  </br></a>
							<input id="searchProdDetalle" type="text"
							name="searchProdDetalle" size="25" maxlength="20"/>
						</div>
						<div>
							<a>Categoria  </br></a>
							<input id="searchProdCategoria" type="text"
							name="searchProdCategoria" size="25" maxlength="20"/>
						</div>
				</div>
				
				<a id="lupaSearchProduct" href="javascript:Product.searchProducts();">
					<img src="../images/magnifier.png" title="Buscar">	</a>
				<a id="searchingProducts" style="display: none;"> <img
					src="../images/progress.gif" title="buscando...">
				</a>
			</div>
			<div id="listProductsSearched" style="display: none;"></div>
			<div id="lineMax" value="10"></div>
		</div>
<% } %>
</div>