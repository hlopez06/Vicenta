<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String msjError = "";
	if (request.getAttribute("msjError") != null){
		msjError = (String)request.getAttribute("msjError");
	}
%>

<div id="loginForm">
	<% if ( !msjError.equals("")){ out.println("<div id=\"msjError\">" + msjError + "</div>"); }%>
	<form action="login" method="POST">
		<table>
			<ul>
				<li>usuario</li>
				<li><input name="user" value="hernan"/></li>
			</ul>
			<ul>
				<li>contrase�a</li>
				<li><input name="password" value="hernan"/></li>
			</ul>
			<ul>
				<li><input type="submit" value="entrar"/></li>
				<li><a>No recuerda la contrase�a</a></li>
			</ul>
		</table>
	</form>
</div>