package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.documents.Factura;
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
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		Gson gson = new Gson();
		String jsonOutput;
		
		long idCliente = Integer.parseInt( request.getParameter("cl-id").trim() );
		
		Factura factura = (Factura)request.getAttribute("documento");

		if (factura.getCliente().getId() == idCliente){
			factura.ejecutate(idCliente);
			
			jsonOutput = gson.toJson(factura);
			
		}else{
			jsonOutput = "error";
		}
		
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objFactura\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
		
	}

}
