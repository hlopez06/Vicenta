package com.divingWeb.conexionDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Usuario;

public class UserDAO extends ConexionDAO{
	
	public static long nuevoUsuario(Usuario usuario){
		Long id = null;
		
		try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(usuario); 
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
	public static Usuario buscarCliente(int idUsuario){
		
		Usuario us = null;
		
		try 
        { 
            iniciaOperacion(); 
            us = (Usuario)sesion.get(Usuario.class, (long)idUsuario);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return us;
	}
	
	public static List<Usuario> obtenerListaClientes(String termino){
		
		List<Usuario> lResultados = null;

		try 
        { 
            iniciaOperacion(); 

    		Criteria criterio = sesion.createCriteria(Usuario.class);
    		criterio.add(Restrictions.like("nombre",termino + "%"));

    		lResultados = criterio.list();
            
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
