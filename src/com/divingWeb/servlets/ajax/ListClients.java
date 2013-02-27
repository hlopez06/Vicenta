package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.search.SearchClients;
import com.google.gson.Gson;

/**
 * Servlet implementation class ListClients
 */
public class ListClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String termino = request.getParameter("termino").trim();
		
		LinkedList<Cliente> lClientes = SearchClients.SearchClients(termino);
		
		Gson gson = new Gson();
		String jsonOutput = gson.toJson(lClientes);
		
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objListaClientes\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
	}

}
