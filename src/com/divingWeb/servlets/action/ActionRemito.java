package com.divingWeb.servlets.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.TransactionDAO;
import com.divingWeb.documents.Documento;
import com.divingWeb.documents.Remito;
import com.google.gson.Gson;

/**
 * Servlet implementation class ActionRemito
 */
public class ActionRemito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionRemito() {
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
		
		String tipoMovimiento = request.getParameter("tipoMovimiento").trim();
		
		Remito remito = (Remito)request.getSession().getAttribute("documento");
		
		remito.setTipoMovimiento(tipoMovimiento);
		
		TransactionDAO.remitoAction(remito);
		
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objDocumento\":{\"estado\":\"ok\",\"msj\":\"ninguno\"}}");
		
		pw.flush();
		
		pw.close();
		
	}

}
