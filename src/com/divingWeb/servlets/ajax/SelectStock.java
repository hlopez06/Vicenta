package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.conexionDAO.DepositoDAO;
import com.divingWeb.documents.Documento;
import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.StockProducto;
import com.google.gson.Gson;

/**
 * Servlet implementation class SelectStock
 */
public class SelectStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStock() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		int lineMax = 20;
		
		if( request.getParameter("lineMax") != null )
			lineMax = Integer.parseInt( request.getParameter("lineMax") );
		
		if ( request.getParameter("other") != null ){
			int other = Integer.parseInt( request.getParameter("other") );
		}
		
		if ( true ) {
						
			List<StockProducto> stock = DepositoDAO.SelectStock(lineMax);
			
			Gson gson = new Gson();
			String jsonOutput = gson.toJson(stock);
			
			System.out.println(jsonOutput);
					
			PrintWriter pw = response.getWriter();
			
			pw.print("{\"objStock\":".concat(jsonOutput).concat("}"));
			
			pw.flush();
			
			pw.close();
			
		} else {
			response.getWriter().print("invalid");
		}
	}

}
