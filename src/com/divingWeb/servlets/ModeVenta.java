package com.divingWeb.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModeVenta extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				RequestDispatcher disp;
				
				disp = getServletContext().getRequestDispatcher("/JSP/templates/venta.jsp");
				
				disp.forward(req, resp);
	}

}
