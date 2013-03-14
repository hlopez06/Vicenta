package com.divingWeb.servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divingWeb.documents.ElementHistory;
import com.divingWeb.elememts.Usuario;
import com.divingWeb.tools.InputWeb;

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

			LinkedList<InputWeb> lInputs = new LinkedList<InputWeb>();

			if (elemento.equals("producto")){
				request.setAttribute("elemento", "producto");
				request.setAttribute("titulo_html", "Vicenta - Crear producto");
				request.setAttribute("titulo_mainContent", "Crear un producto nuevo");
				request.setAttribute("claseJS", "producto");
				request.setAttribute("actionName", "Alta producto");
				request.setAttribute("formName", "Formulario para ingreso de productos");
				
				lInputs.add(new InputWeb("Nombre del producto","nombre","pr"));
				lInputs.add(new InputWeb("Detalle","detalle","pr"));
				lInputs.add(new InputWeb("Categoria","categoria","pr"));
				lInputs.add(new InputWeb("Precio","precio","pr"));
		
			} else if (elemento.equals("cliente")){
				request.setAttribute("elemento", "cliente");
				request.setAttribute("titulo_html", "Vicenta - Crear cliente");
				request.setAttribute("titulo_mainContent", "Crear un cliente nuevo");
				request.setAttribute("claseJS", "cliente");
				request.setAttribute("actionName", "Alta cliente");
				request.setAttribute("formName", "Formulario para ingreso de clientes");
				
				lInputs.add(new InputWeb("Nombre del cliente","nombre","cl"));
				lInputs.add(new InputWeb("Apellido","apellido","cl"));
				lInputs.add(new InputWeb("Razon Social","razonSocial","cl"));
				lInputs.add(new InputWeb("Direccion","direccion","cl"));
				lInputs.add(new InputWeb("Tipo","tipo","cl"));
				
			} else if (elemento.equals("proveedor")){
				request.setAttribute("elemento", "proveedor");
				request.setAttribute("titulo_html", "Vicenta - Crear proveedor");
				request.setAttribute("titulo_mainContent", "Crear un proveedor nuevo");
				request.setAttribute("claseJS", "proveedor");
				request.setAttribute("actionName", "Alta proveedor");
				request.setAttribute("formName", "Formulario para ingreso de proveedores");
				
				lInputs.add(new InputWeb("Nombre del proveedor","nombre","pv"));
				lInputs.add(new InputWeb("Razon Social","razonSocial","pv"));
				lInputs.add(new InputWeb("Direccion","direccion","pv"));
				lInputs.add(new InputWeb("Tipo","tipo","pv"));
				
			
			} else if (elemento.equals("usuario") && objUsuario.isAdministrador()){
				request.setAttribute("elemento", "usuario");
				request.setAttribute("titulo_html", "Vicenta - Crear usuario");
				request.setAttribute("titulo_mainContent", "Crear un usuario nuevo");
				request.setAttribute("claseJS", "usuario");
				request.setAttribute("actionName", "Alta usuario");
				request.setAttribute("formName", "Formulario para ingreso de usuarios");
				
				lInputs.add(new InputWeb("Nombre del usuario","nombre","us"));
				lInputs.add(new InputWeb("Razon Social","razonSocial","us"));
				lInputs.add(new InputWeb("Direccion","direccion","us"));
				lInputs.add(new InputWeb("Tipo","tipo","us"));
				
			} else {
				request.setAttribute("titulo_html", "Vicenta - error");
				request.setAttribute("titulo_mainContent", "error 404");
			}

			request.setAttribute("inputs", lInputs);
	
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
