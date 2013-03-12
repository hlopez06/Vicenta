<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String elemento = (String)request.getAttribute("elemento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	String claseJS = (String)request.getAttribute("claseJS");
	String actionName = (String)request.getAttribute("actionName");
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

<body>

	<jsp:include page="tools/temp-head.jsp"></jsp:include>

	<div id="outer-center"  class="pane">

		<div id="mainContent">
			<div class="content" id="docContent">
				<!-- panel contenido principal(central) -->
					<!--cuerpo -->
					
					<div id="titulo-pag"><%=titulo_mainContent%></div>

					<!-- formulario de Remito -->
<% if ( elemento.contains("producto") ){ %>
					<div id="formFactoryElem">
							<a>Formulario para ingreso de productos</a>
						<form action="elementFactory/newProduct"  method="GET">
					
							<ul id="formElem">
								<li>
									<ul class="formElem">
										<li><span>Nombre de producto</span></li>
										<li><input type="text" size="20" name="pr-nombre" class="inputProducto" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Detalles</span></li>
										<li><input type="text" size="20" name="pr-detalle" class="inputProducto" value="" /></li>
									</ul>	
								</li>	
								<li>
									<ul class="formElem">
										<li><span>Categoria</span></li>
										<li><input type="text" size="20" name="pr-categoria" class="inputProducto" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Precio</span></li>
										<li><input type="text" size="20" name="pr-precio" class="inputProducto" value="" /></li>
									</ul>	
								</li>

							</ul>
							<input type="hidden" name="pr-id" value="0" />
							<input type="hidden" name="elemento" value="<%=elemento%>"/>
		
							<input id="btn-<%=actionName%>" type="submit" value="<%=actionName%>" name="<%=actionName%>"/>
						</form>
					</div>
<% } else if (elemento.contains("cliente")){ %>
					<div id="formFactoryElem">
							<a>Formulario para ingreso de clientes</a>
						<form action="elementFactory/newClient" method="GET">
							<ul id="formElem">
								<li>
									<ul class="formElem">
										<li><span>Nombre de cliente</span></li>
										<li><input type="text" size="20" name="cl-nombre" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Detalles</span></li>
										<li><input type="text" size="20" name="cl-detalle" value="" /></li>
									</ul>	
								</li>	
								<li>
									<ul class="formElem">
										<li><span>Categoria</span></li>
										<li><input type="text" size="20" name="cl-categoria" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Precio</span></li>
										<li><input type="text" size="20" name="cl-precio" value="" /></li>
									</ul>	
								</li>
							</ul>
							<input type="hidden" size="20" name="cl-id"	value="0" />
							<input type="hidden" name="elemento" value="<%=elemento%>"/>
		
							<input id="btn-<%=actionName%>" type="submit" value="<%=actionName%>" name="<%=actionName%>"/>
						</form>
					</div>
<% } else if (elemento.contains("proveedor")){ %>
		<div > proveedor no cargado</div>
<% } else if (elemento.contains("usuario")){ %>
		<div > usuario no cargado</div>
<% } else { %>
		<div > No cargado</div>
<% } %>
			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

</div>

</body>
</html>