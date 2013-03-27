package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.documents.Remito;

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
		
		String tipoMovimiento = request.getParameter("tm" ).trim();
		
		if ( tipoMovimiento.contains("egreso") ){
			request.setAttribute("documento", "remito");
			request.setAttribute("claseJS", "Remito");
			request.setAttribute("tipoRemito", "egreso");
			request.setAttribute("titulo_html", "Vicenta - Remito");
			request.setAttribute("titulo_mainContent", "Remito de egreso");
			request.setAttribute("pane_left", true);
			request.setAttribute("pane_rigth", false);
			request.setAttribute("form_client", true);
			request.setAttribute("form_provider", false);
			request.setAttribute("pane_left_client", true);
			request.setAttribute("pane_left_provider", false);
			request.setAttribute("pane_left_product", true);
			request.setAttribute("actionBool", true);
			request.setAttribute("actionName", "Ejecutar");
		} else {
			request.setAttribute("documento", "remito");
			request.setAttribute("claseJS", "Remito");
			request.setAttribute("tipoRemito", "ingreso");
			request.setAttribute("titulo_html", "Vicenta - Remito");
			request.setAttribute("titulo_mainContent", "Remito de ingreso");
			request.setAttribute("pane_left", true);
			request.setAttribute("pane_rigth", false);
			request.setAttribute("form_client", false);
			request.setAttribute("form_provider", true);
			request.setAttribute("pane_left_client", false);
			request.setAttribute("pane_left_provider", true);
			request.setAttribute("pane_left_product", true);
			request.setAttribute("actionBool", true);
			request.setAttribute("actionName", "Ejecutar");
		}
		HttpSession session = request.getSession();
		session.setAttribute("documento", new Remito());
		
		disp = getServletContext().getRequestDispatcher("/JSP/general.jsp");
		
		disp.forward(request, response);

	}

}
