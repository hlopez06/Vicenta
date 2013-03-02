package com.divingWeb.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.facturador.Factura;

public class ModeFacturador extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				RequestDispatcher disp;
				
				request.setAttribute("documento", "factura");
				request.setAttribute("titulo_html", "Vicenta - Factura");
				request.setAttribute("titulo_mainContent", "Factura");
				request.setAttribute("pane_rigth", false);
				
				HttpSession session = request.getSession();
				session.setAttribute("documento", new Factura());
				
				disp = getServletContext().getRequestDispatcher("/JSP/templates/general.jsp");
				
				disp.forward(request, response);
	}

}
