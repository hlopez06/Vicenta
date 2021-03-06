package com.divingWeb.conexionDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Cliente;

public class ClientDAO extends ConexionDAO {

	public static long nuevoCliente(Cliente cliente){
		Long id = null;
		
		try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(cliente); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  
		
		return id;
	}
	public static Cliente buscarCliente(long idCliente){
		
		Cliente cl = null;
		
		try 
        { 
            iniciaOperacion(); 
            cl = (Cliente)sesion.get(Cliente.class, (long)idCliente);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return cl;
	}
	
	public static List<Cliente> obtenerListaClientes(String termino){
		
		List<Cliente> lResultados = null;

		try 
        { 
            iniciaOperacion(); 

    		Criteria criterio = sesion.createCriteria(Cliente.class);
    		criterio.add(Restrictions.like("nombre","%" + termino + "%"));

    		lResultados = (List<Cliente>) criterio.list();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return lResultados;
	}
	
	
}
