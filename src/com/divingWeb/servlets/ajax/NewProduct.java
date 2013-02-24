package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.facturador.Factura;
import com.google.gson.Gson;

/**
 * Servlet implementation class NewProduct
 */
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewProduct() {

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		int idProducto = Integer.parseInt (req.getParameter("idProducto").trim() );
		int cantidad = Integer.parseInt( req.getParameter("cantidad").trim() );
		
		if ( idProducto > 0 ) {
			
			Factura factura = (Factura)req.getSession().getAttribute("factura");
			
			factura.setProduct(idProducto, cantidad);
			
			Gson gson = new Gson();
			String jsonOutput = gson.toJson(factura);
			
			System.out.println(jsonOutput);
					
			PrintWriter pw = resp.getWriter();
			
			pw.print("{\"objFactura\":".concat(jsonOutput).concat("}"));
			
			pw.flush();
			
			pw.close();

			
		} else {
			resp.getWriter().print("invalid");
		}
		
	}

}
