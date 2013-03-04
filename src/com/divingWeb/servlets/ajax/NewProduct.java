package com.divingWeb.servlets.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Producto;

/**
 * Servlet implementation class NewProduct
 */
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre").trim();
		String detalle = request.getParameter("detalle").trim();
		int categoria = Integer.parseInt( request.getParameter("categoria").trim() );
		int precio = Integer.parseInt( request.getParameter("precio").trim() );
		
		int cantidad;
		
		if(request.getAttribute("cantidad") == null){
			cantidad = 1;
		}else{
			cantidad = Integer.parseInt( request.getParameter("cantidad").trim() );
		}

		Producto producto = new Producto(nombre, detalle, categoria, precio, cantidad);
		
		ProductDAO.nuevoProducto(producto);

		if ( request.getParameter("comp") != null && request.getParameter("comp").trim().equals("true") )
		{
			Producto producto1 = new Producto("producto 1", "detalles del producto 1", 1, 100, 1);
			Producto producto2 = new Producto("producto 2", "detalles del producto 2", 2, 150, 1);
			Producto producto3 = new Producto("producto 3", "detalles del producto 3", 1, 300, 1);
			Producto producto4 = new Producto("producto 4", "detalles del producto 4", 2, 350, 1);
			
			ProductDAO.nuevoProducto(producto1);
			ProductDAO.nuevoProducto(producto2);
			ProductDAO.nuevoProducto(producto3);
			ProductDAO.nuevoProducto(producto4);
		}
	}

}
