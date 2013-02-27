package com.divingWeb.search;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.hibernate.HibernateUtil;

public class SearchClients {
	
	
	public static LinkedList<Cliente> SearchClients(String strCliente){
		
		LinkedList<Cliente> lClientes = null;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.createQuery("");
		
		transaction.commit();
		session.close();
		
		return lClientes;
	}
	
	
}
