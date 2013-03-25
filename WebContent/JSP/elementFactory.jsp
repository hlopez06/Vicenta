<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.divingWeb.tools.InputWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String elemento = (String)request.getAttribute("elemento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	String claseJS = (String)request.getAttribute("claseJS");
	String actionName = (String)request.getAttribute("actionName");
	String formName = (String)request.getAttribute("formName");
	Boolean pane_rigth = (Boolean) request.getAttribute("pane_rigth");
	Boolean pane_left = (Boolean) request.getAttribute("pane_left");
	Boolean form_client = (Boolean) request.getAttribute("form_client");
	Boolean form_provider = (Boolean) request.getAttribute("form_provider");
	List<InputWeb> lInputs = (List<InputWeb>)request.getAttribute("inputs");
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

<body onload="Menu.init();">

	<jsp:include page="tools/temp-head.jsp"></jsp:include>

	<div id="outer-center"  class="pane">

		<div id="mainContent">
			<div id="docContent" class="contentOnly" >
						<!--cuerpo -->
						
						<div id="titulo-pag"><%=titulo_mainContent%></div>
	
						<!-- formulario de Remito -->
	
						<div id="formFactoryElem">
							<a><%=formName %></a>
	<!-- 					<form action=""> -->
	
							<ul id="formElemFactory">
	<%
		Iterator<InputWeb> iLInputs = lInputs.iterator(); 
		while( iLInputs.hasNext() ) {
			InputWeb input = (InputWeb) iLInputs.next();
	%>
								<li class="formElemFactory">
									<ul class="<%=input.getClassName()%>">
										<li><span><%=input.getTitulo() %></span></li>
										<li><input type="<%=input.getType() %>" size="<%=input.getSize()%>"
										 name="<%=input.getName()%>" value="<%=input.getValue()%>" /></li>
									</ul>	
								</li>
	<% 	} %>
	
							</ul>
							<input type="hidden" size="20" name="cl-id"	value="0" />
							<input type="hidden" name="elemento" value="<%=elemento%>"/>
			
							<h3><a id="btn-Alta<%=elemento%>" class="boton" onclick="ElementFactory.<%=elemento%>Action()"
							 title="<%=actionName%>"><%=actionName%></a></h3>
	<!-- 					</form> -->
						</div>
			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>
		<!-- panel contenido principal(izquierdo) -->
		
		<% if (pane_left){ %><jsp:include page="templates/pane_left.jsp"></jsp:include><% }%>

		<% if (pane_rigth){ %><jsp:include page="templates/pane_rigth.jsp"></jsp:include><% }%>

</div>

</body>
</html>