package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.conexionDAO.UserDAO;
import com.divingWeb.documents.Factura;
import com.divingWeb.elememts.Deposito;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		RequestDispatcher disp;
	
//		long idUsuario = UserDAO.getIdUsuario(user, pass);
		
		if ("hernan".equals(user) && "hernan".equals(pass)) {
			
			HttpSession session = request.getSession();
			
//			session.setAttribute("usuario", UserDAO.buscarCliente(idUsuario));
			
			session.setAttribute("documento", new Factura());
			Deposito deposito = new Deposito();
			deposito.setId(1);
			session.setAttribute("deposito", new Deposito());
			
			request.setAttribute("documento", "factura");
			request.setAttribute("claseJS", "Factura");
			request.setAttribute("titulo_html", "Vicenta - Facturador");
			request.setAttribute("titulo_mainContent", "Facturador");
			request.setAttribute("pane_left", true);
			request.setAttribute("pane_rigth", false);
			request.setAttribute("form_client", true);
			request.setAttribute("form_provider", false);
			request.setAttribute("pane_left_client", true);
			request.setAttribute("pane_left_provider", false);
			request.setAttribute("actionBool", true);
			request.setAttribute("actionName", "Ejecutar");
			
			disp = getServletContext().getRequestDispatcher("/JSP/general.jsp");
			
		} else {
			
			disp = getServletContext().getRequestDispatcher("/JSP/login/noLogin.jsp");
		}
		
		disp.forward(request, response);
	}

}
