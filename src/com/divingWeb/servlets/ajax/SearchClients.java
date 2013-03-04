package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.elememts.Cliente;
import com.google.gson.Gson;

/**
 * Servlet implementation class ListClients
 */
public class SearchClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClients() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String termino = request.getParameter("termino").trim();
		
		List<Cliente> lClientes = ClientDAO.obtenerListaClientes(termino);
		
		Gson gson = new Gson();
		String jsonOutput = gson.toJson(lClientes);
		
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objListaClientes\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
	}

}
