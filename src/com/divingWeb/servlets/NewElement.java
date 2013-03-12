package com.divingWeb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Producto;

/**
 * Servlet implementation class NewElement
 */
public class NewElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewElement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String elemento = request.getParameter("elemento").trim();
		
		String titulo_html = "Vicenta";
		String titulo_mainContent = "Vicenta";
		Boolean resEstado = false;
		String resDetalles = "error";
		
		
		if (elemento.contains("producto")){
			int id = Integer.parseInt( request.getParameter("pr-id").trim() );			
			String nombre = request.getParameter("pr-nombre").trim();
			String detalle = request.getParameter("pr-detalle").trim();
			int categoria = Integer.parseInt( request.getParameter("pr-categoria").trim() );
			int precio = Integer.parseInt( request.getParameter("pr-precio").trim() );
			
			Producto producto = new Producto(nombre, detalle, categoria, precio);
			
			ProductDAO.nuevoProducto(producto);
			
			resEstado = true;
			resDetalles = "Salio todo ok.";
			
		} else if (elemento.contains("cliente")){
			
			String nombre = request.getParameter("cl-nombre").trim();
			String apellido = request.getParameter("cl-apellido").trim();
			String razonSocial = request.getParameter("cl-razonSocial").trim();
			String tipo = request.getParameter("cl-tipo").trim();
			int credito = Integer.parseInt( request.getParameter("cl-credito").trim() );
			
			Cliente cliente = new Cliente(nombre, apellido, razonSocial, tipo, credito);
			
			ClientDAO.nuevoCliente(cliente);
		} else {
			
		}
		
		
		
		request.setAttribute("titulo_html", titulo_html);
		request.setAttribute("titulo_mainContent", titulo_mainContent);
		request.setAttribute("estado", resEstado);
		request.setAttribute("respueta_detalles", resDetalles);
		
		RequestDispatcher disp;
		
		disp = getServletContext().getRequestDispatcher("/JSP/elementFactoryResponse.jsp");
		
		disp.forward(request, response);

	}

}
