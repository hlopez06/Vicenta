package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.facturador.Factura;
import com.divingWeb.facturador.Facturador;
import com.google.gson.Gson;

/**
 * Servlet implementation class Facturar
 */
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facturar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		Gson gson = new Gson();
		String jsonOutput;
		
		int idCliente = Integer.parseInt( request.getParameter("cl-id").trim() );
//		int precio = Integer.parseInt( request.getParameter("precio").trim() );
		
		Factura factura = (Factura)request.getAttribute("factura");

		if (factura.getCliente().getId() == idCliente){
			Facturador.facturar(factura);
			
			jsonOutput = gson.toJson(factura);
			
		}else{
			jsonOutput = "Error";
		}
		
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objFactura\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
		
	}

}
