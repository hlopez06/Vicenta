package com.divingWeb.servlets.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.hibernate.HibernateUtil;

/**
 * Servlet implementation class NewClient
 */
public class NewClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre").trim();
		String apellido = request.getParameter("apellido").trim();
		String razonSocial = request.getParameter("razonSocial").trim();
		String tipo = request.getParameter("tipo").trim();
		int credito = Integer.parseInt( request.getParameter("credito").trim() );

		Cliente cliente = new Cliente(nombre, apellido, razonSocial, tipo, credito);
		

		Cliente cliente1 = new Cliente("matias", "di Natale", "Matias corporation", "capo", 1000);
		Cliente cliente2 = new Cliente("Martin", "garga", "garga nation", "gilun", 200);
		Cliente cliente3 = new Cliente("Sebastian", "Checho", "Checho android", "gilun", 300);
		Cliente cliente4 = new Cliente("Mago", "Coperfi", "Pedro gil", "gilun", 200);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(cliente);
		session.save(cliente1);
		session.save(cliente2);
		session.save(cliente3);
		session.save(cliente4);
		
		transaction.commit();
		session.close();
		
	}

}
