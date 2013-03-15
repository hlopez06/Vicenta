package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.conexionDAO.ProviderDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.Proveedor;
import com.google.gson.Gson;

/**
 * Servlet implementation class NewElement
 */
public class NewElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewElement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String elemento = request.getParameter("elemento").trim();
		
		String resEstado = "error";
		String resDetalles = "Parametro elemento invalido.";
		
		if (elemento.contains("producto")){
			String nombre = request.getParameter("nombre").trim();
			String detalle = request.getParameter("detalle").trim();
			int categoria = Integer.parseInt( request.getParameter("categoria").trim() );
			int precio = Integer.parseInt( request.getParameter("precio").trim() );
			
			Producto producto = new Producto(nombre, detalle, categoria, precio);
			
			ProductDAO.nuevoProducto(producto);
			
			resEstado = "ok";
			resDetalles = "Salio todo ok.";
			
		} else if (elemento.contains("cliente")){
			
			String nombre = request.getParameter("nombre").trim();
			String apellido = request.getParameter("apellido").trim();
			String razonSocial = request.getParameter("razonSocial").trim();
			String direccion = request.getParameter("direccion").trim();
			String tipo = request.getParameter("tipo").trim();
			int credito = Integer.parseInt( request.getParameter("credito").trim() );
			
			Cliente cliente = new Cliente(nombre, apellido, razonSocial, direccion, tipo, credito);
			
			ClientDAO.nuevoCliente(cliente);
			
			resEstado = "ok";
			resDetalles = "Salio todo ok.";
		} else if (elemento.contains("proveedor")){
			
			String nombre = request.getParameter("nombre").trim();
			String razonSocial = request.getParameter("razonSocial").trim();
			String direccion = request.getParameter("direccion").trim();
			String tipo = request.getParameter("tipo").trim();
			
			Proveedor proveedor = new Proveedor(nombre, direccion, razonSocial, tipo);
			
			ProviderDAO.nuevoProveedor(proveedor);
			
			resEstado = "ok";
			resDetalles = "Salio todo ok.";
		} else {
			resEstado = "error";
			resDetalles = "El nombre del \"elemento\" no es correcto.";
		}
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objNewElement\":{\"estado\":\""+ resEstado + "\",\"msj\":\"" + resDetalles + "\"}}");
		
		pw.flush();
		
		pw.close();

	}

}
