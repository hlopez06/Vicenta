package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.documents.Documento;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddClient
 */
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClient() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		
		long idCliente = Integer.parseInt( request.getParameter("idCliente").trim() );
		
		if ( idCliente > 0 ) {
			
			Documento documento = (Documento)request.getSession().getAttribute("documento");
			
			documento.setCliente(ClientDAO.buscarCliente(idCliente));
			
			Gson gson = new Gson();
			String jsonOutput = gson.toJson(documento);
			
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
