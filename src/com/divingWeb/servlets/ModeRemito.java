package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.facturador.Factura;
import com.divingWeb.facturador.Remito;

/**
 * Servlet implementation class ModeRemito
 */
public class ModeRemito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeRemito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp;
		
		HttpSession session = request.getSession();
		session.setAttribute("documento", new Remito());
		
		disp = getServletContext().getRequestDispatcher("/JSP/templates/remito.jsp");
		
		disp.forward(request, response);

	}

}
