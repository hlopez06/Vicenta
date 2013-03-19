package com.divingWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.DepositoDAO;
import com.divingWeb.elememts.StockProducto;

/**
 * Servlet implementation class ModeStock
 */
public class ModeStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeStock() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lineMax = 20;
		RequestDispatcher disp;
		
		request.setAttribute("documento", "stock");
		request.setAttribute("claseJS", "Stock");
		request.setAttribute("titulo_html", "Vicenta - Stock");
		request.setAttribute("titulo_mainContent", "Stock de productos");
		request.setAttribute("lineMax", lineMax);
		request.setAttribute("pane_left", true);
		request.setAttribute("pane_rigth", false);
		
		List<StockProducto> stock = DepositoDAO.SelectStock(lineMax);
		request.setAttribute("stock", stock);

		disp = getServletContext().getRequestDispatcher("/JSP/list.jsp");
		
		disp.forward(request, response);
	}

}
