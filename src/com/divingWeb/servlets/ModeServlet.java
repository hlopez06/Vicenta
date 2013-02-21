package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		RequestDispatcher disp;
		
		if (true) {

			if ( req.getParameter("mode").equals("venta") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/venta.jsp");
				
			}else if( req.getParameter("mode").equals("notaCredito") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/notacredito.jsp");
				
			}else if( req.getParameter("mode").equals("remito") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/remito.jsp");
				
			}else if( req.getParameter("mode").equals("historial") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/inicio.jsp");
			
			}else if( req.getParameter("mode").equals("historico-ventas") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/inicio.jsp");
				
			}else if( req.getParameter("mode").equals("historico-notaCredito") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/inicio.jsp");
				
			}else if( req.getParameter("mode").equals("historico-remitos") ){
				disp = getServletContext().getRequestDispatcher("/JSP/templates/inicio.jsp");
				
			} else {
				disp = getServletContext().getRequestDispatcher("/JSP/inicio.jsp");
				
			}   
			
		} else {
			
			disp = getServletContext().getRequestDispatcher("/JSP/inicio.jsp");
			
		}
		
		disp.forward(req, resp);
	}
}
