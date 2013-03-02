package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.facturador.Factura;
import com.google.gson.Gson;

/**
 * Servlet implementation class NewProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddProduct() {

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		int idProducto = Integer.parseInt (request.getParameter("idProducto").trim() );
		int cantidad = Integer.parseInt( request.getParameter("cantidad").trim() );
		
		if ( idProducto > 0 ) {
			
			Factura factura = (Factura)request.getSession().getAttribute("factura");
			
			factura.addProductos(idProducto, cantidad);
			
			Gson gson = new Gson();
			String jsonOutput = gson.toJson(factura);
			
			System.out.println(jsonOutput);
					
			PrintWriter pw = response.getWriter();
			
			pw.print("{\"objFactura\":".concat(jsonOutput).concat("}"));
			
			pw.flush();
			
			pw.close();

			
		} else {
			response.getWriter().print("invalid");
		}
		
	}

}
