package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.facturador.Factura;

/**
 * Servlet implementation class NewProduct
 */
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewProduct() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idProducto = Integer.parseInt (req.getParameter("idProducto").trim() );
		int cantidad = Integer.parseInt( req.getParameter("cantidad").trim() );
		
		if (idProducto > 0 && cantidad > 0) {
			
			Factura factura = (Factura)req.getSession().getAttribute("factura");
			
			
			factura.setProduct(idProducto, cantidad);
			
			
			
			responseJson(resp, "save ok");
			
		} else {
			responseJson(resp, "invalid");
		}
		
		
	}
	
	private void responseJson(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
			             
	}


}
