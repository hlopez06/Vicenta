<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.divingWeb.tools."%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String elemento = (String)request.getAttribute("elemento");
	String titulo = (String)request.getAttribute("titulo_html");
	String titulo_mainContent = (String)request.getAttribute("titulo_mainContent");
	String claseJS = (String)request.getAttribute("claseJS");
	String actionName = (String)request.getAttribute("actionName");
	String formName = (String)request.getAttribute("formName");
	List<InputWeb> lColum = (List<InputWeb>)request.getAttribute("colum");
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

					<div id="bodyList">
						<a><%=formName %></a>
<!-- 					<form action=""> -->

						<ul id="formElem">
<%
	Iterator<InputWeb> iLColum = lColum.iterator(); 
	while( iLColum.hasNext() ) {
		InputWeb colum = (InputWeb) iLColum.next();
%>
							<li>
								<ul class="<%=colum.getClassName()%>">
									<li><span><%=colum.getTitulo() %></span></li>
									<li><input type="<%=colum.getType() %>" size="<%=colum.getSize()%>"
									 name="<%=colum.getName()%>" value="<%=colum.getValue()%>" /></li>
								</ul>	
							</li>
<% 	} %>

						</ul>
						<input type="hidden" size="20" name="cl-id"	value="0" />
						<input type="hidden" name="elemento" value="<%=elemento%>"/>
		
						<button id="btn-List<%=elemento%>" href="#" onclick=""
						 title="<%=actionName%>"><%=actionName%></button>
<!-- 					</form> -->
					</div>

			</div>
				<jsp:include page="tools/temp-pie.jsp"></jsp:include>
		</div>

</div>

</body>
</html>