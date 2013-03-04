package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			response(response, "login ok");
		} else {
			response(response, "invalid login");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		RequestDispatcher disp;
		
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			
			request.setAttribute("documento", "facturador");
			request.setAttribute("titulo_html", "Vicenta - Facturador");
			request.setAttribute("titulo_mainContent", "Facturador");
			request.setAttribute("pane_left", true);
			request.setAttribute("pane_rigth", false);
			request.setAttribute("form_client", true);
			request.setAttribute("form_provider", false);
			request.setAttribute("pane_left_client", true);
			request.setAttribute("pane_left_provider", false);
			
			disp = getServletContext().getRequestDispatcher("/JSP/templates/general.jsp");
			
		} else {
			//response(request, "invalid login");
			disp = getServletContext().getRequestDispatcher("/JSP/login/noLogin.jsp");
		}
		
		disp.forward(request, response);
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
