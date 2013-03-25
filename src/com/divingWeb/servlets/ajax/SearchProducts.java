package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Producto;
import com.divingWeb.tools.InputWeb;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchProducts
 */
public class SearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String termino = request.getParameter("termino").trim();
		
		int codigo = 0;
		if (request.getParameter("codigo") != null && request.getParameter("codigo") != "")
			codigo = Integer.parseInt( request.getParameter("codigo") );
		
		String nombre = request.getParameter("nombre");
		String detalle = request.getParameter("detalle");
		String categoria = request.getParameter("categoria");
		
		String deposito = request.getParameter("deposito").trim();
//		String fuente = request.getParameter("fuente").trim();
		
		Gson gson = new Gson();
		String jsonOutput = "";
		if (codigo == 0 ){
			List<Producto> lProductos = ProductDAO.buscarProductos(termino, nombre, detalle, categoria);
			
			jsonOutput = gson.toJson(lProductos);
		} else {
			Producto producto = ProductDAO.buscarProducto(codigo);
			
			jsonOutput = gson.toJson(producto);
		}
				
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"estado\":\"ok\", \"msj\":\"Todo salio OK\", \"objList\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
	}

}
