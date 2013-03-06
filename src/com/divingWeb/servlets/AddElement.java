package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.documents.ElementFactory;
import com.divingWeb.elememts.Usuario;

/**
 * Servlet implementation class AddIdentity
 */
public class AddElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddElement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identity = request.getParameter("identity").trim();
		
		RequestDispatcher disp;		

		if (identity.contains("producto") || identity.contains("cliente") || identity.contains("proveedor"))
		{
	
			HttpSession session = request.getSession();
			Usuario objUsuario = (Usuario) session.getAttribute("usuario");
			
			if (identity.equals("producto")){
				request.setAttribute("titulo_html", "Vicenta - Crear producto");
				request.setAttribute("titulo_mainContent", "Crear un producto nuevo");
				
			} if (identity.equals("cliente")){
				request.setAttribute("titulo_html", "Vicenta - Crear producto");
				request.setAttribute("titulo_mainContent", "Crear un producto nuevo");
				
			} if (identity.equals("proveedor")){
				request.setAttribute("titulo_html", "Vicenta - Crear producto");
				request.setAttribute("titulo_mainContent", "Crear un producto nuevo");
			
			} if (identity.equals("usuario") && objUsuario.isAdministrador()){
				request.setAttribute("titulo_html", "Vicenta - Crear usuario");
				request.setAttribute("titulo_mainContent", "Crear un usuario nuevo");
					
			} else {
				request.setAttribute("titulo_html", "Vicenta - error");
				request.setAttribute("titulo_mainContent", "error 404");
				
			}
	
			session.setAttribute("identity", new ElementFactory(identity, objUsuario));
	
			disp = getServletContext().getRequestDispatcher("/JSP/addElement.jsp");
		} else {
			request.setAttribute("titulo_html", "Vicenta - Error");
			request.setAttribute("titulo_error", "Error acceder a la carga de elementos.");
			request.setAttribute("detalle_error", "Error acceder a la carga de elementos.");
			request.setAttribute("oculto_error", "Error acceder a la carga de elementos. No se reconoce el parametro:" + identity);
			
			disp = getServletContext().getRequestDispatcher("/JSP/errorPage.jsp");
		}
		
		
		disp.forward(request, response);
	}

}
