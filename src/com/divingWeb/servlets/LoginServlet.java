package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		RequestDispatcher disp;
		
		disp = getServletContext().getRequestDispatcher("/JSP/login.jsp");
		
		disp.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher disp;
		
		if (request.getParameter("user") != null){
			String user = request.getParameter("user");
			String pass = request.getParameter("password");
		
			Object[] lresponse = UserDAO.getIdUsuario(user, pass);
		
			if (lresponse != null) {
				long idUsuario = ((BigInteger) lresponse[0]).longValue();

				int estado = (Integer) lresponse[1];
				if (estado == 1){
				
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
					request.setAttribute("pane_left_product", true);
					request.setAttribute("actionBool", true);
					request.setAttribute("actionName", "Ejecutar");
					
					disp = getServletContext().getRequestDispatcher("/JSP/general.jsp");
				} else {
					request.setAttribute("msjError", "Usuario inhabilitado.</br>Contacte a un administrador.");
					
					disp = getServletContext().getRequestDispatcher("/JSP/login.jsp");
				}	
			} else {
				
				request.setAttribute("msjError", "Usuario o password incorrecto.");
				
				disp = getServletContext().getRequestDispatcher("/JSP/login.jsp");
			}
		} else {
			disp = getServletContext().getRequestDispatcher("/JSP/login.jsp");
		}		
		
		disp.forward(request, response);
	}

}
