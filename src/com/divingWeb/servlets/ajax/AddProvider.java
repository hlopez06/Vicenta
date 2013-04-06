package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.documents.Remito;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddProvider
 */
public class AddProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProvider() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		int idPersona = Integer.parseInt( request.getParameter("idProveedor").trim() );
		
		if ( idPersona > 0 ) {
			
			Remito documento = (Remito)request.getSession().getAttribute("documento");
			
			documento.setRemitentePorID(idPersona);
			
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
