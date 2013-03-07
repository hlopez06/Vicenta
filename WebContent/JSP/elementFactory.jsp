<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String documento = (String)request.getAttribute("documento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
    
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

					<div id="formFactoryElem">
							<a>Formulario para ingreso de productos</a>
						<form action="">
					
							<ul id="formElem">
								<li>
									<ul class="formElem">
										<li><span>Nombre de producto</span></li>
										<li><input type="text" size="20" name="pr-nombre" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Detalles</span></li>
										<li><input type="text" size="20" name="pr-detalles" value="" /></li>
									</ul>	
								</li>	
								<li>
									<ul class="formElem">
										<li><span>Categoria</span></li>
										<li><input type="text" size="20" name="pr-categoria" value="" /></li>
									</ul>	
								</li>
								<li>
									<ul class="formElem">
										<li><span>Precio</span></li>
										<li><input type="text" size="20" name="pr-precio" value="" /></li>
									</ul>	
								</li>

							</ul>
							<input type="hidden" size="20" name="pr-id"
								value="" />
		
						</form>
					</div>

			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

</div>

</body>
</html>