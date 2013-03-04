package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		request.setAttribute("documento", "remito");
		request.setAttribute("titulo_html", "Vicenta - Remito");
		request.setAttribute("titulo_mainContent", "Remito");
		request.setAttribute("pane_left", true);
		request.setAttribute("pane_rigth", false);
		request.setAttribute("form_client", false);
		request.setAttribute("form_provider", true);
		request.setAttribute("pane_left_client", true);
		request.setAttribute("pane_left_provider", true);
		
		HttpSession session = request.getSession();
		session.setAttribute("documento", new Remito());
		
		disp = getServletContext().getRequestDispatcher("/JSP/templates/general.jsp");
		
		disp.forward(request, response);

	}

}
