<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto 01 - Facturador</title>
</head>
<body>

<jsp:include page="tools/temp-head.jsp"></jsp:include>

<!-- Cuerpo -->

<!-- panel contenido principal( semillas + izquierdo + central + derecho) -->
<div id="outer-center" class="outer-center pane pane-center" style="position: absolute; top: 72px; bottom: 0px; width: 1366px; z-index: 1; visibility: visible; display: block; overflow: hidden;">

	<div id="mainContent" class="pane pane-center" style="position: absolute; left: 240px; top: 34px; bottom: 0px; width: 1126px; z-index: 1; visibility: visible; display: block;">                            
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
					<form action="mode/venta/facturar" method="POST" name="venta">
						<div id="clientes" >
							<ul class="formFactura">
								<li>
									<span>Nombre de cliente:</span>
									<input type="text" maxlength="20" size="20" name="cl-nombre" value="cliente 01"/>
								</li>
								<li>
									<span>Tipo:</span>
									<input type="text" maxlength="20" size="20" name="cl-tipo" value="S.A."/>
								</li>
								<li>
									<span>RS :</span>
									<input type="text" maxlength="20" size="20" name="cl-RS" value="cliente 01"/>
								</li>
								<li>
									<span>Credito: $</span>
									<input type="text" maxlength="4" size="4" name="cl-credito" value="200"/>
								</li>
							</ul>
						</div>
						
						<div id="info" style="">
							<ul  class="formFactura">
								<li>
									<span>Dia:</span>
									<input type="text" maxlength="20" size="20" name="inf-dia" value="06/05/1985"/>
								</li>
								<li>
									<span>Hora:</span>
									<input type="text" maxlength="20" size="20" name="inf-hora" value="19:00"/>
								</li>
								<li>
									<span>Tipo:</span>
									<input type="text" maxlength="20" size="20" name="inf-nose" value="nose"/>
								</li>
							</ul>
						</div>
						
						<div id="productos">
						<a>Lista de productos</a>
							<ul id=listaProductos>
								
								
							</ul>
											
							<ul class="formFactura ">
								<li>
								<a>Id de Producto:</a>
								<input type="text" maxlength="10" size="10" name="idProducto" value="1234"/>
								<a>Cantidad:</a>
								<input type="text" maxlength="3" size="1" name="cantidad" value="2"/>
								<input type="Button" size="4" name="cargar" value="cargar"/>
								</li>
							</ul>
						</div>
						
						<div id="total" style="">
							<ul  class="formFactura">
								<li></li>
							</ul>
						</div>
						<input type="Button" name="Facturar" value="Facturar">
					</form>
				</div>
				
	        </div>
			
			<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		
		</div>
	</div>
            
            
                           
<!-- panel contenido principal(izquierdo) -->  
                   
    <div class="ui-layout-west pane pane-west" id="layout-west" style="position: absolute; right: auto; top: 34px; height: 500px; z-index: 1; width: 239px; visibility: visible; display: block;">
		<span id="west-closer" class="button-close button-close-west" title="Cerrar panel">&nbsp;</span>
		<div id="westheader" class="header" ></div>
		<div id="westcontent" class="content" style="position: relative; visibility: visible;">
							    	
			<div id="subpanel-terminos-buscados" class="subpanel">
				<h3 class="titulo-subpanel">
					<a id="TermBus" class="opened" href="#">
						<img title="Lupa" alt="Lupa" src="../images/magnifier.png">
						Buscar Cliente
						</a>
				</h3>
				<div class="conClientBus contenido-subpanel" style="display: none;">
					<ul class="listado-terminos"> 
						<li><span class="SearchTerm SearchTermRel">----------</span></li>
					</ul>
					<div class="acciones-subpanel">  
						<span class="guardar-alerta-left" title="Guardar búsqueda" alt="Guardar búsqueda" ><img src="../images/guardaralerta.png">
							<a>Usar</a>
						</span>
					</div>  
				</div>
			</div>

		</div>
    </div>
				                 
<!-- panel contenido principal(derecho) -->         
    <div class="ui-layout-east pane pane-east" id="layout-east" style="position: absolute; margin: 0px; left: auto; right: 0px; top: 34px; bottom: 0px; height: 258px; z-index: 1; width: 239px; visibility: visible; display:block;">
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