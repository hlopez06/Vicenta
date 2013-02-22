package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		RequestDispatcher disp;
		
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			//response(resp, "login ok");
			disp = getServletContext().getRequestDispatcher("/JSP/templates/inicio.jsp");
			
		} else {
			//response(resp, "invalid login");
			disp = getServletContext().getRequestDispatcher("/JSP/login/noLogin.jsp");
		}
		
		disp.forward(req, resp);
	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
			             
	}
}
