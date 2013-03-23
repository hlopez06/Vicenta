package com.divingWeb.servlets.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.DepositoDAO;
import com.divingWeb.documents.Factura;
import com.divingWeb.documents.Remito;

/**
 * Servlet implementation class ActionFactura
 */
public class ServletActionFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActionFactura() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String msj = "no msj. ";
		
		long idCliente = Long.parseLong( request.getParameter("idCliente").trim() );
		
		Factura factura = (Factura)request.getSession().getAttribute("documento");
		
		PrintWriter pw = response.getWriter();

		if (factura.getIdCliente() == idCliente){
			
			factura.action(idCliente);			
			
			pw.print("{\"objDocumento\":{\"estado\":\"ok\",\"msj\":\"ninguno\"}}");
		
		} else {
			msj = "El id de cliente es invalido. ";
			pw.print("{\"objDocumento\":{\"estado\":\"error\",\"msj\":\"" + msj + "\"}}");					
		}
		
		
		pw.flush();
		
		pw.close();
	}

}
