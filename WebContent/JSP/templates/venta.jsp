<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%;">
<head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type">
        <title>Proyecto 01 - Facturador</title>
		
		<link href="../css/layout.css" rel="stylesheet" type="text/css">
		<link href="../css/style.css" rel="stylesheet" type="text/css">
		
		
		<script type="text/javascript" src="../JS/jQuery/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="../JS/facturador.js"></script>	
			
</head>

<body role="application">


<jsp:include page="tools/temp-head.jsp"></jsp:include>

<!-- Cuerpo -->

<!-- panel contenido principal( semillas + izquierdo + central + derecho) -->
<div id="outer-center" class="outer-center pane pane-center">

	<div id="mainContent" class="pane pane-center" style="overflow:visible; position: absolute; left: 240px; display: block; width: auto; visibility: visible;">                            
	    <div class="content" id="docContent" style="position: relative; visibility: visible;">
	<!-- panel contenido principal(central) -->  
	        <div class="layout-content" id="ui-layout-content">
	<!--cuerpo -->
			
				<div id="cabCentral" class="cabCentral" >
					<div style="font-size: 2.4em; margin-bottom: 0.25em; font-family: Arial,Helvetica,sans-serif; font-weight: bold;" id="titulo-pag">
					   Facturador
					</div>
				</div>
				
<!-- 				formulario de facturacion -->
				<div id="formularioDeVentas">
					<form action="/mode/facturador" method="POST" name="venta">
						<div id="clientes" >
							<ul class="formFactura">
								<li>
									<span>Nombre de cliente</span>
									<input type="text" disabled="disabled" size="20" name="cl-nombre" value=""/>
								</li>
								<li>
									<span>Apellido</span>
									<input type="text" disabled="disabled" size="20" name="cl-apellido" value=""/>
								</li>
								<li>
									<span>Tipo</span>
									<input type="text" disabled="disabled" size="20" name="cl-tipo" value=""/>
								</li>
								<li>
									<span>RS &nbsp;</span>
									<input type="text" disabled="disabled" size="20" name="cl-razonSocial" value=""/>
								</li>
								<li>
									<span>Credito &nbsp;</span>
									<input type="text" disabled="disabled" size="20" name="cl-credito" value=""/>
								</li>
							</ul>
						</div>
						
						<div id="info" style="display:none;">
							<ul  class="formFactura">
								<li>
									<span>Dia</span>
									<input type="text" maxlength="20" size="20" name="inf-dia" value="06/05/1985"/>
								</li>
								<li>
									<span>Hora</span>
									<input type="text" maxlength="20" size="20" name="inf-hora" value="19:00"/>
								</li>
								<li>
									<span>Tipo</span>
									<input type="text" maxlength="20" size="20" name="inf-nose" value="nose"/>
								</li>
							</ul>
						</div>
						
						<div id="productos">
						<a>Lista de productos</a>
							<ul id=listaProductos></ul>
											
							<ul class="formFactura ">
								<li>
										<a>Id de Producto</a>
										<input id="idProducto" type="text" step="1" maxlength="10" size="15" name="idProducto" value="1234"/>
								<li>
										<a>Cantidad </a>
										<input id="cantidad" type="text" step="2" maxlength="7" size="15" name="cantidad" value="2"/>
								</li>
								<li>
										<a type="button" size="4" name="cargar" step="3" value="cargar" href="javascript:Factura.addProduct();">CARGAR</a>
								</li>
							</ul>
						</div>
						
						<div id="totalFactura" style="">

						</div>
						<input id="btnFacturar" type="Button" name="Facturar" value="Facturar">
					</form>
				</div>
				
	        </div>
			
			<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		
		</div>
	</div>
            
            
                           
<!-- panel contenido principal(izquierdo) -->  
                   
    <div id="panel-izquierdo" class="ui-layout-west pane pane-west" style="position: absolute; right: auto; top: 72px; height: 500px; z-index: 1; width: 239px; visibility: visible; display: block;">
		<span id="west-closer" class="button-close button-close-west" title="Cerrar panel">&nbsp;</span>
		<div id="westheader" class="header" ></div>
		<div id="westcontent" class="content" style="position: relative; visibility: visible;">
							    	
			<div id="subpanel-terminos-buscados" class="subpanel">
				<h3 class="titulo-subpanel">
					<a href="javascript:">Buscar Cliente</a>
				</h3>

				<div id="formBuscaCliente">
				    <input id="searchClientes" type="text" value="Buscar cliente..." name="searchClientes" size="25" maxlength="10"
				   			onblur="if(this.value=='') this.value='Buscar cliente...';" 
				   			onfocus="if(this.value=='Buscar cliente...') this.value='';"
				   			 onkeypress="Clientes.searchClientsKeyEnter(event, this)"/>
					<a id="lupaSearchCliente" href="javascript:Clientes.searchClients();">
						<img src="../images/magnifier.png" alt="Lupa" title="Lupa">
					</a>
				   	<a id="searchingClients" style="display: none;">
						<img src="../images/progress.gif" title="buscando...">
					</a>
				</div>
				
				<div id="listClientsSearched" style="display:none;"></div>

				<div id="crearCliente">
					<h3 class="titulo-subpanel">
						<a href="javascript:">Agendar cliente</a>
					</h3>
					
				</div>
			</div>

		</div>
    </div>
				                 
<!-- panel contenido principal(derecho) -->         
    <div id="panel-derecho" class="ui-layout-east pane pane-east" style="position: absolute; margin: 0px; left: auto; right: 0px; top: 34px; bottom: 0px; height: 258px; z-index: 1; width: 239px; visibility: visible; display:none;">
		<div class="header" id="eastheader">
			<span id="east-closer" class="button-close button-close-east" title="Cerrar panel">&nbsp;</span>
		</div>
        <div class="content" id="eastcontent" style="position: relative; height: 236px; visibility: visible;">
			<h3 class="titulo-panel"><span><img title="Cerrar correctamente la sesión" class="salir" alt="" src="../images/page_white_stack.png">Relacionados</span></h3>	
	
			<div id="relatedDocs">		
				<div id="cargando" style="display: none;">
					<img title="Cargando..." alt="Cargando..." src="../images/progress.gif"> Cargando...
				</div>
				<ul id="relatedDocsList">		
				</ul>
			</div>	
        </div>
    </div>
    
    
    
</div>

</body>
</html>