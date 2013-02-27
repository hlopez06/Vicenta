package com.divingWeb.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.LinkedMap;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.hibernate.HibernateUtil;
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
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		String termino = request.getParameter("termino").trim();
		
		List<Cliente> lClientes = obtenerListaClientes(termino);
		
		Gson gson = new Gson();
		String jsonOutput = gson.toJson(lClientes);
		
		System.out.println(jsonOutput);
				
		PrintWriter pw = response.getWriter();
		
		pw.print("{\"objListaClientes\":".concat(jsonOutput).concat("}"));
		
		pw.flush();
		
		pw.close();
	}
	
	private List<Cliente> obtenerListaClientes(String termino){
		
		List<Cliente> lResultados = null;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criterio = session.createCriteria(Cliente.class);
		criterio.add(Restrictions.like("nombre",termino + "%"));

		lResultados = criterio.list();
		/*Query query = session.createQuery("FROM producto WHERE %".concat(termino).concat("%"));
		
		lResultados = (List<Cliente>)query.list();
		*/
		transaction.commit();
		session.close();
		
		return lResultados;
	}

}
