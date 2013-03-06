package com.divingWeb.conexionDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Usuario;

public class UserDAO extends ConexionDAO{
	
	public static long getIdUsuario(String usuario, String pass){
		
		long id = 1;
		
		try 
        { 
            iniciaOperacion(); 

            Criteria criterio = sesion.createCriteria(Usuario.class);
    		criterio.add(Restrictions.like("usuario",usuario));
    		criterio.add(Restrictions.like("pass",pass));
    		
    		Usuario objUsuario = (Usuario) criterio.uniqueResult();
    		id = objUsuario.getId();
            
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
	public static Usuario buscarCliente(long idUsuario){
		
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

    		lResultados = (List<Usuario>) criterio.list();
            
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
