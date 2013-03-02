package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.facturador.Documento;
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
		
		if ( idProducto > 0 && cantidad > 0 ) {
			
			Gson gson = new Gson();
			String jsonOutput;
			
			Documento documento = (Documento)request.getSession().getAttribute("documento");
			
			PrintWriter pw = response.getWriter();

			if(documento.addProducto(idProducto, cantidad) != null){				
				jsonOutput = gson.toJson(documento);
				System.out.println(jsonOutput);
				pw.print("{\"estado\":\"ok\",\"objDocumento\":" + jsonOutput + "}");
			}else{
				pw.print("{\"estado\":\"error\",\"msjError\":\"Error al ingresar el producto\"}");
			}
						
			pw.flush();
			
			pw.close();

			
		} else {
			response.getWriter().print("invalid");
		}
		
	}

}