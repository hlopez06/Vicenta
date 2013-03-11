package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.documents.ElementHistory;
import com.divingWeb.elememts.Usuario;

/**
 * Servlet implementation class AddIdentity
 */
public class ElementFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElementFactory() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String elemento = request.getParameter("element").trim();
		
		RequestDispatcher disp;		

		if (elemento.contains("producto") || elemento.contains("cliente") || elemento.contains("proveedor"))
		{
	
			HttpSession session = request.getSession();
			Usuario objUsuario = (Usuario) session.getAttribute("usuario");

			if (elemento.equals("producto")){
				request.setAttribute("elemento", "producto");
				request.setAttribute("titulo_html", "Vicenta - Crear producto");
				request.setAttribute("titulo_mainContent", "Crear un producto nuevo");
				request.setAttribute("claseJS", "producto");
				request.setAttribute("actionName", "Alta producto");
				
//				request.setAttribute("nombreDepositoDefault", "no hay deposito asignado");			
//				long idDepositoDefault = objUsuario.getIdDepositoDefault();
//				request.setAttribute("idDepositoDefault", String.valueOf(idDepositoDefault));
//
//				String nombreDepositoDefault = objUsuario.getNombreDepositoDefault();
//				if (idDepositoDefault > 0 && nombreDepositoDefault != null)					
//						request.setAttribute("nombreDepositoDefault", nombreDepositoDefault);
		
			} else if (elemento.equals("cliente")){
				request.setAttribute("elemento", "cliente");
				request.setAttribute("titulo_html", "Vicenta - Crear cliente");
				request.setAttribute("titulo_mainContent", "Crear un cliente nuevo");
				request.setAttribute("claseJS", "cliente");
				request.setAttribute("actionName", "Alta cliente");
				
			} else if (elemento.equals("proveedor")){
				request.setAttribute("elemento", "cliente");
				request.setAttribute("titulo_html", "Vicenta - Crear proveedor");
				request.setAttribute("titulo_mainContent", "Crear un proveedor nuevo");
				request.setAttribute("claseJS", "proveedor");
				request.setAttribute("actionName", "Alta proveedor");
			
			} else if (elemento.equals("usuario") && objUsuario.isAdministrador()){
				request.setAttribute("elemento", "usuario");
				request.setAttribute("titulo_html", "Vicenta - Crear usuario");
				request.setAttribute("titulo_mainContent", "Crear un usuario nuevo");
				request.setAttribute("claseJS", "usuario");
				request.setAttribute("actionName", "Alta usuario");
					
			} else {
				request.setAttribute("titulo_html", "Vicenta - error");
				request.setAttribute("titulo_mainContent", "error 404");
			}
	
			session.setAttribute("elemento", new ElementHistory(elemento, objUsuario));
	
			disp = getServletContext().getRequestDispatcher("/JSP/elementFactory.jsp");
		} else {
			request.setAttribute("titulo_html", "Vicenta - Error");
			request.setAttribute("titulo_error", "Error acceder a la carga de elementos.");
			request.setAttribute("detalle_error", "Error acceder a la carga de elementos.");
			request.setAttribute("oculto_error", "Error acceder a la carga de elementos. No se reconoce el parametro:" + elemento);
			
			disp = getServletContext().getRequestDispatcher("/JSP/errorPage.jsp");
		}
		
		
		disp.forward(request, response);
	}

}
